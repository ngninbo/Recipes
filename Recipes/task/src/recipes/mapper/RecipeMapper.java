package recipes.mapper;

import org.springframework.stereotype.Component;
import recipes.dto.RecipeDto;
import recipes.model.Recipe;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecipeMapper {

    public RecipeDto recipeToRecipeDto(Recipe recipe){
        return new RecipeDto(recipe);
    }

    public List<RecipeDto> recipeListToRecipeDtoList(List<Recipe> recipes) {
        return recipes.stream().map(RecipeDto::new).collect(Collectors.toList());
    }
}
