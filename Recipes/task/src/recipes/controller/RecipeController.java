package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import recipes.dto.RecipeDto;
import recipes.mapper.RecipeMapper;
import recipes.model.Recipe;
import recipes.model.User;
import recipes.service.RecipeService;
import recipes.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.IntPredicate;

@RestController
@Validated
public class RecipeController {

    private final RecipeService recipeService;
    private final UserService userService;
    private final RecipeMapper mapper;
    private final IntPredicate isNumberOfParamWrong = number -> number == 0 || number > 1;
    private final BiFunction<String, String, Boolean> isAuthor = String::equals;

    @Autowired
    public RecipeController(RecipeService recipeService, UserService userService, RecipeMapper mapper) {
        this.recipeService = recipeService;
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping("/api/recipe/new")
    public ResponseEntity<Map<String, Long>> save(@AuthenticationPrincipal UserDetails userDetails,
                                                  @Valid @RequestBody Recipe recipe) {
        if (!userDetails.isEnabled()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            Optional<User> user = userService.findByEmail(userDetails.getUsername());
            recipe.setAuthor(user.orElseThrow());
            Map<String, Long> result = recipeService.save(recipe);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

    }

    @GetMapping("/api/recipe")
    public ResponseEntity<List<RecipeDto>> findAll(@AuthenticationPrincipal UserDetails userDetails) {

        return !userDetails.isEnabled() ? new ResponseEntity<>(HttpStatus.UNAUTHORIZED) :
                new ResponseEntity<>(recipeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/recipe/{id}")
    public ResponseEntity<RecipeDto> findById(@AuthenticationPrincipal UserDetails userDetails,
                                              @PathVariable String id) {
        if (!userDetails.isEnabled()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            Optional<Recipe> recipe = recipeService.findById(Long.parseLong(id));
            if (recipe.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                Recipe value = recipe.get();
                return new ResponseEntity<>(mapper.toDto(value), HttpStatus.OK);
            }
        }
    }

    @DeleteMapping("/api/recipe/{id}")
    public ResponseEntity<RecipeDto> deleteById(@AuthenticationPrincipal UserDetails userDetails,
                                                @PathVariable String id) {
        if (!userDetails.isEnabled()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            Optional<Recipe> recipe = recipeService.findById(Long.parseLong(id));
            if (recipe.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                if (!isAuthor.apply(recipe.get().getAuthor().getEmail(), userDetails.getUsername())) {
                    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
                } else {
                    recipeService.deleteById(Long.parseLong(id));
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
            }
        }
    }

    @PutMapping("/api/recipe/{id}")
    public ResponseEntity<?> update(@AuthenticationPrincipal UserDetails userDetails,
                                    @PathVariable String id,
                                    @Valid @RequestBody Recipe recipe) {
        if (!userDetails.isEnabled()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            Optional<Recipe> recipeInRepo = recipeService.findById(Long.parseLong(id));
            if (recipeInRepo.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                if (!isAuthor.apply(recipeInRepo.get().getAuthor().getEmail(), userDetails.getUsername())) {
                    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
                } else {
                    Optional<User> user = userService.findByEmail(userDetails.getUsername());
                    recipe.setAuthor(user.orElseThrow());
                    recipeService.update(Long.parseLong(id), recipe);
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
            }
        }
    }

    @GetMapping(value = "/api/recipe/search")
    public ResponseEntity<List<RecipeDto>> search(@AuthenticationPrincipal UserDetails userDetails,
                                                  @RequestParam(required = false) Map<String, String> params) {
        if (!userDetails.isEnabled()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            int numParams = params.entrySet().size();

            if (isNumberOfParamWrong.negate().test(numParams)) {
                if (params.containsKey("category")) {
                    return new ResponseEntity<>(recipeService.findByCategory(params.get("category")), HttpStatus.OK);
                } else if (params.containsKey("name")) {
                    return new ResponseEntity<>(recipeService.findByName(params.get("name")), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }
}
