package mk.ukim.finki.wp.lab.service.implementation;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.model.exceptions.*;
import mk.ukim.finki.wp.lab.repository.IngredientsRepository;
import mk.ukim.finki.wp.lab.repository.PizzaRepository;
import mk.ukim.finki.wp.lab.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PizzaServiceImpl implements PizzaService {

    private PizzaRepository pizzaRepository;
    private final IngredientsRepository ingredientsRepository;

    //DI
    public PizzaServiceImpl(PizzaRepository pizzaRepository, IngredientsRepository ingredientsRepository) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public List<Pizza> getAll() {
        return this.pizzaRepository.findAll();
    }

    @Override
    public Pizza create(String pizzaType, String description){
        return this.pizzaRepository.save(new Pizza(pizzaType, description));
    }

    @Override
    public Pizza create(String pizzaType, String description, boolean veggie, List<UUID> ingredientsIds) {
        List<Ingredient> ingredients = this.ingredientsRepository.findAllById(ingredientsIds);
        if(veggie)
            this.allVeggieIngredientsCheck(ingredients);
        return this.pizzaRepository.save(new Pizza(pizzaType, description, ingredients, veggie));
    }

    private void allVeggieIngredientsCheck(List<Ingredient> ingredients){
        if(!ingredients.stream().allMatch(Ingredient::isVeggie))
            throw new VeggiePizzaException();
    }

    @Override
    public List<Pizza> getAllContainingIngredient(UUID ingredientId) {
        Ingredient ingredient = this.ingredientsRepository.findById(ingredientId).orElseThrow(InvalidIngredientIdException::new);
        return this.pizzaRepository.findAllByIngredientsContaining(ingredient);
    }

    @Override
    public Pizza putUpdate(UUID id, String pizzaType, String description, boolean veggie, List<UUID> ingredientsIds) {
        Pizza toEdit = this.pizzaRepository.findById(id).orElseThrow(InvalidPizzaIdException::new);
        List<Ingredient> ingredients = this.ingredientsRepository.findAllById(ingredientsIds);
        if(veggie)
            this.allVeggieIngredientsCheck(ingredients);
        toEdit.setName(pizzaType);
        toEdit.setDescription(description);
        toEdit.setVeggie(veggie);
        toEdit.setIngredients(ingredients);
        return this.pizzaRepository.save(toEdit);
    }

    @Override
    public void delete(UUID id) {
        this.pizzaRepository.deleteById(id);
    }

    @Override
    public Pizza getById(UUID id) {
        return this.pizzaRepository.findById(id).orElseThrow(InvalidPizzaIdException::new);
    }

    @Override
    public List<Pizza> getAllWithIngredientsCountLessThan(int totalIngredients) {
        return this.pizzaRepository.findAllWithIngredientsLessThan(totalIngredients);
    }

    @Override
    public List<Pizza> getAllWithSpicyIngredient() {
        return this.pizzaRepository.findDistinctByIngredients_SpicyIsTrue();
    }
}
