package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PizzaRepository extends JpaRepository<Pizza, UUID> {

    List<Pizza> findAllByIngredientsContaining(Ingredient ingredient);

    List<Pizza> findDistinctByIngredients_SpicyIsTrue();

    @Query("select p from pizzas p where p.ingredients.size <= :totalIngredients")
    List<Pizza> findAllWithIngredientsLessThan(int totalIngredients);

}