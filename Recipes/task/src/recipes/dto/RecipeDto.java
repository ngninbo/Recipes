package recipes.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class RecipeDto {

    private String name;
    private String category;
    private LocalDateTime date;
    private String description;
    private List<String> ingredients;
    private List<String> directions;

    public RecipeDto(String name, String description, List<String> ingredients, List<String> directions) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public RecipeDto(String name, String category, LocalDateTime date, String description,
                     List<String> ingredients, List<String> directions) {
        this(name, description, ingredients, directions);
        this.category = category;
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getDirections() {
        return directions;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeDto)) return false;
        RecipeDto recipeDto = (RecipeDto) o;
        return Objects.equals(getCategory(), recipeDto.getCategory()) && Objects.equals(getDate(), recipeDto.getDate()) && Objects.equals(getName(), recipeDto.getName()) && Objects.equals(getDescription(), recipeDto.getDescription()) && Objects.equals(getIngredients(), recipeDto.getIngredients()) && Objects.equals(getDirections(), recipeDto.getDirections());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategory(), getDate(), getName(), getDescription(), getIngredients(), getDirections());
    }

    @Override
    public String toString() {
        return "RecipeDto{" +
                "category='" + category + '\'' +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                ", directions=" + directions +
                '}';
    }
}
