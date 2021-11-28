package recipes.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@SequenceGenerator(name = "seq", sequenceName = "recipeSequence")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String category;
    @CreationTimestamp
    private LocalDateTime date;
    @NotBlank
    private String description;
    @NotEmpty
    @Size(min = 1)
    @ElementCollection
    @Column(name = "ingredient")
    @CollectionTable(name = "recipe_ingredient", joinColumns = @JoinColumn(name = "id"))
    private List<String> ingredients;
    @NotEmpty
    @Size(min = 1)
    @ElementCollection
    @Column(name = "direction")
    @CollectionTable(name = "recipe_direction", joinColumns = @JoinColumn(name = "id"))
    private List<String> directions;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;

    public Recipe() {
    }

    public Recipe(String name, String description, List<String> ingredients, List<String> directions) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public Recipe(String name, String category, LocalDateTime dateTime, String description,
                  List<String> ingredients, List<String> directions) {
        this(name, description, ingredients, directions);
        this.category = category;
        this.date = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(getId(), recipe.getId()) && Objects.equals(getName(), recipe.getName()) && Objects.equals(getCategory(), recipe.getCategory()) && Objects.equals(getDate(), recipe.getDate()) && Objects.equals(getDescription(), recipe.getDescription()) && Objects.equals(getIngredients(), recipe.getIngredients()) && Objects.equals(getDirections(), recipe.getDirections()) && Objects.equals(getAuthor(), recipe.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCategory(), getDate(), getDescription(), getIngredients(), getDirections(), getAuthor());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                ", directions=" + directions +
                ", author=" + author +
                '}';
    }
}
