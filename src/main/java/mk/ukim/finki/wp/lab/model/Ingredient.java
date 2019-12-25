package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
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

}
