package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
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
}
