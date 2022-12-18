package recipes.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@SequenceGenerator(name = "seq", sequenceName = "recipeSequence")
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User author;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Recipe recipe = (Recipe) o;
        return id != null && Objects.equals(id, recipe.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
