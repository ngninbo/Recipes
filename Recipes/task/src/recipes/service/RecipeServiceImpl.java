package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.dto.RecipeDto;
import recipes.mapper.RecipeMapper;
import recipes.model.Recipe;
import recipes.persistance.RecipeRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

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
        return recipeMapper.toList(recipes);
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
    public List<RecipeDto> findByCategory(String category) {
        return recipeMapper.toList(recipeRepository.findByCategoryIgnoreCaseOrderByDateDesc(category));
    }

    @Override
    public List<RecipeDto> findByName(String name) {
        return recipeMapper.toList(recipeRepository.findByNameIgnoreCaseOrderByDateDesc(name));
    }
}
