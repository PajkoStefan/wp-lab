package mk.ukim.finki.wp.lab.web.controllers;


import mk.ukim.finki.wp.lab.service.PizzaService;
import org.springframework.stereotype.Controller;


@Controller
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }



}