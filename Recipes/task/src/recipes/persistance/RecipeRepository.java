package recipes.persistance;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import recipes.model.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    @Query(value = "SELECT * FROM recipe r " +
            "       WHERE LOWER(r.NAME) LIKE CONCAT('%',LOWER(?1),'%') " +
            "       ORDER BY DATE DESC", nativeQuery = true)
    List<Recipe> findByNameIgnoreCaseOrderByDateDesc(String name);
    @Query(value = "SELECT * FROM recipe r " +
            "       WHERE LOWER(r.CATEGORY) = LOWER(?1) " +
            "       ORDER BY DATE DESC", nativeQuery = true)
    List<Recipe> findByCategoryIgnoreCaseOrderByDateDesc(String category);
    Optional<Recipe> findById(Long id);
}
