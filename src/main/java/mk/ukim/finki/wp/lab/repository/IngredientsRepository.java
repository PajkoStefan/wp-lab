package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IngredientsRepository extends JpaRepository<Ingredient, UUID> {

    Page<Ingredient> findAllBySpicyIsTrue(Pageable pageable);

    List<Ingredient> findAllByVeggieIsTrue();

    List<Ingredient> findAllByPizzasContainsAndPizzasContains(Pizza p1, Pizza p2);

    int countAllBySpicyIsTrue();

    boolean existsByName(String name);

}