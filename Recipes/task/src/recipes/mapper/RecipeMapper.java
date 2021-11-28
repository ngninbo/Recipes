package recipes.mapper;

import org.springframework.stereotype.Component;
import recipes.dto.RecipeDto;
import recipes.model.Recipe;

import java.util.LinkedList;
import java.util.List;

@Component
public class RecipeMapper {

    public RecipeDto recipeToRecipeDto(Recipe recipe){
        return new RecipeDto(recipe);
    }

    public List<RecipeDto> recipeListToRecipeDtoList(List<Recipe> recipes) {
        List<RecipeDto> recipeDtoList = new LinkedList<>();

        if (recipes != null) {
            recipes.forEach(recipe -> recipeDtoList.add(new RecipeDto(recipe)));
            return recipeDtoList;
        } else {
            return List.of();
        }
    }
}
