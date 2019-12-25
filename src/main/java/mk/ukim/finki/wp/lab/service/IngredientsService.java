package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Ingredient;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IngredientsService {

    Ingredient create(String name, boolean spicy, float amount, boolean veggie);

    Ingredient patchUpdate(UUID id, Optional<String> name, Optional<Boolean> spicy, Optional<Float> amount, Optional<Boolean> veggie);

    void delete(UUID id);

    Page<Ingredient> getAll(int page, int size);

    Ingredient getById(UUID id);

    Page<Ingredient> getSpicy();

    List<Ingredient> getVeggie();

    List<Ingredient> getCommonIngredientsBetween(UUID pizza1Id, UUID pizza2Id);

}
