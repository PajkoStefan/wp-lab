package mk.ukim.finki.wp.lab.bootstrap;


import lombok.Data;
import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.repository.IngredientsRepository;
import mk.ukim.finki.wp.lab.repository.PizzaRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;



@Component
@Data
public class DataHolder {

    private static List<Pizza> pizzas = new ArrayList<>();

    private static List<Ingredient> ingredients = new ArrayList<>();

    private final IngredientsRepository ingredientsRepository;

    private final PizzaRepository pizzaRepository;

    public DataHolder(IngredientsRepository ingredientsRepository, PizzaRepository pizzaRepository) {
        this.ingredientsRepository = ingredientsRepository;
        this.pizzaRepository = pizzaRepository;
    }

    @PostConstruct
    public void init(){

        ingredients.add(new Ingredient("tomato sauce", false, 3, false));
        ingredients.add(new Ingredient("mozzarella", false, 4, false));
        ingredients.add(new Ingredient("fresh cream", false, 2, false));
        ingredients.add(new Ingredient("bacon", false, 5, false));
        ingredients.add(new Ingredient("mushrooms", true, 3, true));
        ingredients.add(new Ingredient("pizza dough", false, 3, false));
        ingredients.add(new Ingredient("ricotta", true, 4, false));
        ingredients.add(new Ingredient("pepperoni", false, 2, true));
        ingredients.add(new Ingredient("olive oil", false, 1, false));
        ingredients.add(new Ingredient("cheddar", false, 4, false));
        ingredients.add(new Ingredient("cheese", false, 4, false));
        ingredients.add(new Ingredient("ham", false, 4, false));
        ingredients.add(new Ingredient("barbecue sauce", false, 1, false));
        ingredients.add(new Ingredient("beef", false, 5, false));
        ingredients.add(new Ingredient("onions", false, 2, true));
        ingredients.add(new Ingredient("chicken meat", false, 6, false));
        ingredients.add(new Ingredient("sausage", false, 3, false));
        ingredients.add(new Ingredient("brick cheese", false, 3, false));
        ingredients.add(new Ingredient("turmeric", true, 1, true));
        ingredients.add(new Ingredient("chili", true, 1, true));
        ingredients.add(new Ingredient("ginger", true, 1, true));



        this.ingredientsRepository.saveAll(ingredients); // save to db

        pizzas.add(new Pizza("Margherita", "tomato sauce, mozzarella",
                ingredients.subList(0,1), true));
        pizzas.add(new Pizza("Carbonara", "fresh cream, mozzarella, bacon",
                ingredients.subList(1,3), false));
        pizzas.add(new Pizza("Vegetariana", "tomato sauce, mushrooms",
                ingredients.subList(1,4), true));
        pizzas.add(new Pizza("Calzone", "Pizza dough, ricotta, pepperoni, pizza sauce, olive oil",
                ingredients.subList(5,8), true));
        pizzas.add(new Pizza("Cheddar", "cheddar, tomato sauce",
                ingredients.subList(9,10), true));
        pizzas.add(new Pizza("Capricciosa", "tomato sauce, cheese, ham",
                ingredients.subList(10,12), true));
        pizzas.add(new Pizza("Burger Classic", "barbecue sauce, beef, mozzarella, onions",
                ingredients.subList(13,14), true));
        pizzas.add(new Pizza("Boston Barbecue", "ham, chicken meat, onions",
                ingredients.subList(13,15), true));
        pizzas.add(new Pizza("Pepperoni", "tomato sauce, mozzarella, sausage",
                ingredients.subList(12,14), true));
        pizzas.add(new Pizza("Detroit", "pepperoni, brick cheese, tomato sauce",
                ingredients.subList(13,14), true));

        this.pizzaRepository.saveAll(pizzas); // save to db
    }
}
