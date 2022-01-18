package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.dto.RecipeDto;
import recipes.mapper.RecipeMapper;
import recipes.model.Recipe;
import recipes.persistance.RecipeRepository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;
    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    @Override
    public List<RecipeDto> findAll() {
        List<Recipe> recipes = recipeRepository.findAll();
        return recipeMapper.recipeListToRecipeDtoList(recipes);
    }

    @Override
    public Map<String, Long> save(Recipe recipeToSave) {
        recipeToSave.setDate(LocalDateTime.now());
        Recipe recipe = recipeRepository.save(recipeToSave);
        return Collections.singletonMap("id", recipe.getId());
    }

    @Override
    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Recipe recipe) {
        recipe.setId(id);
        recipe.setDate(LocalDateTime.now());
        recipeRepository.save(recipe);
    }

    @Override
    public List<RecipeDto> searchByCategory(String category) {
        return recipeMapper.recipeListToRecipeDtoList(recipeRepository.findByCategoryIgnoreCaseOrderByDateDesc(category));
    }

    @Override
    public List<RecipeDto> searchByName(String name) {
        return recipeMapper.recipeListToRecipeDtoList(recipeRepository.findByNameIgnoreCaseOrderByDateDesc(name));
    }

    @Override
    public boolean isAuthor(Recipe recipe, String username) {
        return recipe.getAuthor().getEmail().equalsIgnoreCase(username);
    }
}
