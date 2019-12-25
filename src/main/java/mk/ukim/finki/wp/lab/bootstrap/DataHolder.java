package mk.ukim.finki.wp.lab.bootstrap;


import lombok.Data;
import mk.ukim.finki.wp.lab.model.Pizza;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class DataHolder {

    private List<Pizza> pizzas = new ArrayList<>();

    @PostConstruct
    public void init() {
        pizzas.add(new Pizza("Margherita", "tomato sauce, mozzarella"));
        pizzas.add(new Pizza("Carbonara", "fresh cream, mozzarella, bacon"));
        pizzas.add(new Pizza("Vegetariana", "tomato sauce, mushrooms"));
        pizzas.add(new Pizza("Calzone", "Pizza dough, ricotta, pepperoni, pizza sauce, olive oil"));
        pizzas.add(new Pizza("Cheddar", "cheddar, tomato sauce"));
        pizzas.add(new Pizza("Capricciosa", "tomato sauce, cheese, ham"));
        pizzas.add(new Pizza("Burger Classic", "barbecue sauce, beef, mozzarella, onions"));
        pizzas.add(new Pizza("Boston Barbecue", "ham, chicken meat, onions"));
        pizzas.add(new Pizza("Pepperoni", "tomato sauce, mozzarella, sausage"));
        pizzas.add(new Pizza("Detroit", "pepperoni, brick cheese, tomato sauce"));
    }
}
