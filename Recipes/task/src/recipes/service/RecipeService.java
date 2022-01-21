package recipes.service;

import recipes.dto.RecipeDto;
import recipes.model.Recipe;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface RecipeService {

    List<RecipeDto> findAll();
    Map<String, Long> save(Recipe recipe);
    Optional<Recipe> findById(Long id);
    void deleteById(Long id);
    void update(Long id, Recipe recipe);
    List<RecipeDto> searchByCategory(String category);
    List<RecipeDto> searchByName(String name);
}
