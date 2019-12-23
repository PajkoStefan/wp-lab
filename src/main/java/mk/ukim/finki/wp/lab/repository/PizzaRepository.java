package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Pizza;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class PizzaRepository {

    private List<Pizza> listOfPizzas;

    public PizzaRepository() {
        this.listOfPizzas = new LinkedList<Pizza>();
        listOfPizzas.add(new Pizza("Margarita", "(tomato sauce, mozzarella)"));
        listOfPizzas.add(new Pizza("Carbonara", "(fresh cream, mozzarella, bacon)"));
        listOfPizzas.add(new Pizza("Vegetariana", "(tomato sauce, mushrooms)"));
        listOfPizzas.add(new Pizza("Calzone", "(Pizza dough, ricotta, pepperoni, pizza sauce, olive oil)"));
        listOfPizzas.add(new Pizza("Cheddar", "(cheddar, tomato sauce)"));
        listOfPizzas.add(new Pizza("Capricciosa", "(fresh cream, mozzarella, bacon)"));
        listOfPizzas.add(new Pizza("Burger Classic", "(barbecue sauce, beef, mozzarella, onions)"));
        listOfPizzas.add(new Pizza("Burger Barbecue", "(ham, chicken meat, onions)"));
        listOfPizzas.add(new Pizza("Pepperoni", "(tomato sauce, mozzarella, sausage)"));
        listOfPizzas.add(new Pizza("Quattro Formaggi", "(Taleggio, Mascarpone, Gorgonzola, Parmesan)"));
    }

    public List<Pizza> getAllPizzas() {
        return listOfPizzas;
    }

}
