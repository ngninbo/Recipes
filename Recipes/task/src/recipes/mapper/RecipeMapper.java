package recipes.mapper;

import org.springframework.stereotype.Component;
import recipes.dto.RecipeDto;
import recipes.model.Recipe;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecipeMapper {

    /**
     * Map Recipe entity to DTO
     * @param recipe Recipe entity
     * @return Recipe DTO
     */
    public RecipeDto toDto(Recipe recipe) {
        return new RecipeDto(recipe.getName(), recipe.getCategory(), recipe.getDate(), recipe.getDescription(),
                recipe.getIngredients(), recipe.getDirections());
    }

    /**
     * Map Recipes entities to list of DTO
     * @param recipes List of recipes
     * @return List of Recipes DTO
     */
    public List<RecipeDto> toList(List<Recipe> recipes) {
        return recipes.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
