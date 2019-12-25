package mk.ukim.finki.wp.lab.service.implementation;

import mk.ukim.finki.wp.lab.model.Ingredient;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.model.exceptions.*;
import mk.ukim.finki.wp.lab.repository.IngredientsRepository;
import mk.ukim.finki.wp.lab.repository.PizzaRepository;
import mk.ukim.finki.wp.lab.service.IngredientsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    private final IngredientsRepository ingredientsRepository;
    private final PizzaRepository pizzaRepository;

    public IngredientsServiceImpl(IngredientsRepository ingredientsRepository, PizzaRepository pizzaRepository) {
        this.ingredientsRepository = ingredientsRepository;
        this.pizzaRepository = pizzaRepository;
    }


    private void ingredientConstraintsCheck(String name, boolean spicy){
        this.nameConstraintCheck(name);
        this.spicyConstraintCheck(spicy);
    }

    private void nameConstraintCheck(String name){
        if(this.ingredientsRepository.existsByName(name))
            throw new IngredientNameException(name);
    }

    private void spicyConstraintCheck(boolean spicy){
        if(spicy && this.ingredientsRepository.countAllBySpicyIsTrue() == 3)
            throw new SpicyIngredientException();
    }

    @Override
    public Ingredient create(String name, boolean spicy, float amount, boolean veggie) {
        this.ingredientConstraintsCheck(name, spicy);
        return this.ingredientsRepository.save(new Ingredient(name, spicy, amount, veggie));
    }
    @Override
    public Ingredient patchUpdate(UUID id, Optional<String> name, Optional<Boolean> spicy, Optional<Float> amount, Optional<Boolean> veggie) {
        Ingredient toEdit = this.ingredientsRepository.findById(id).orElseThrow(InvalidIngredientIdException::new);

        name.ifPresent(this::nameConstraintCheck);
        spicy.ifPresent(this::spicyConstraintCheck);

        name.ifPresent(toEdit::setName);
        spicy.ifPresent(toEdit::setSpicy);
        amount.ifPresent(toEdit::setAmount);
        veggie.ifPresent(toEdit::setVeggie);

        return this.ingredientsRepository.save(toEdit);
    }

    @Override
    public void delete(UUID id) {
        this.ingredientsRepository.deleteById(id);
    }

    @Override
    public Page<Ingredient> getAll(int page, int size) {
        if(size > 10)
            throw new InvalidPageException();
        return this.ingredientsRepository.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    @Override
    public Ingredient getById(UUID id) {
        return this.ingredientsRepository.findById(id).orElseThrow(InvalidIngredientIdException::new);
    }

    @Override
    public Page<Ingredient> getSpicy() {
        int size = this.ingredientsRepository.countAllBySpicyIsTrue();
        return this.ingredientsRepository.findAllBySpicyIsTrue(PageRequest.of(0, size, Sort.by("name")));
    }


    @Override
    public List<Ingredient> getVeggie() {
        return this.ingredientsRepository.findAllByVeggieIsTrue();
    }


    @Override
    public List<Ingredient> getCommonIngredientsBetween(UUID pizza1Id, UUID pizza2Id) {
        Pizza p1 = this.pizzaRepository.findById(pizza1Id).orElseThrow(InvalidPizzaIdException::new);
        Pizza p2 = this.pizzaRepository.findById(pizza2Id).orElseThrow(InvalidPizzaIdException::new);
        return this.ingredientsRepository.findAllByPizzasContainsAndPizzasContains(p1, p2);
    }
}
