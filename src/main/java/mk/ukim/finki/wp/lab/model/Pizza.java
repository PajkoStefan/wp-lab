package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@Data
@Entity(name = "pizzas")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pizza_id")
    private UUID id;

    @Column(name = "pizza_name")
    private String name;

    @Column(name = "pizza_description")
    private String description;

    @Column(name = "veggie")
    private boolean veggie;

    @ManyToMany(targetEntity = Ingredient.class)
    private List<Ingredient> ingredients;


    public Pizza(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Pizza(String type, String description, List<Ingredient> ingredients, boolean veggie) {
        this.name = type;
        this.description = description;
        this.ingredients = ingredients;
        this.veggie = veggie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return id.equals(pizza.id);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
