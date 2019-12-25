package mk.ukim.finki.wp.lab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ingredient_id")
    private UUID id;

    @Column(name = "ingredient_name")
    private String name;

    @Column(name = "spicy")
    private boolean spicy;

    @Column(name = "ingredient_amount")
    private float amount;

    @Column(name = "veggie")
    private boolean veggie;

    @JsonIgnore // mora inaku dava error
    @ManyToMany(mappedBy = "ingredients")
    private List<Pizza> pizzas;

    public Ingredient(String name, boolean spicy, float amount, boolean veggie) {
        this.name = name;
        this.spicy = spicy;
        this.amount = amount;
        this.veggie = veggie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() { //hashiranje na id za vo tabeli da ne se chuva obicno id
        return Objects.hash(id);

    }
}
