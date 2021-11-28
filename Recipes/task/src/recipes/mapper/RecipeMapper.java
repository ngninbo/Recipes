package recipes.mapper;

import org.springframework.stereotype.Component;
import recipes.dto.RecipeDto;
import recipes.model.Recipe;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeMapper {

    public Optional<RecipeDto> recipeToRecipeDto(Recipe recipe) {
        RecipeDto dto;
        if (recipe != null) {
            dto = new RecipeDto(recipe.getName(), recipe.getCategory(), recipe.getDate(), recipe.getDescription(),
                    recipe.getIngredients(), recipe.getDirections());
            return Optional.of(dto);
        }

        return Optional.empty();
    }

    public List<RecipeDto> recipeListToRecipeDtoList(List<Recipe> recipes) {
        List<RecipeDto> recipeDtoList = new LinkedList<>();

        if (recipes != null) {
            recipes.forEach(recipe -> recipeDtoList.add(new RecipeDto(recipe.getName(), recipe.getCategory(),
                    recipe.getDate(), recipe.getDescription(), recipe.getIngredients(), recipe.getDirections())));
            return recipeDtoList;
        } else {
            return List.of();
        }
    }
}
