package mk.ukim.finki.wp.lab.web.servlets;

import mk.ukim.finki.wp.lab.service.PizzaService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

//servlet
@WebServlet(name ="show-pizza-servlet", urlPatterns = "") // ne raboti samo so "/" ako ima urlPatterns = "/*"
public class ShowPizza extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final PizzaService pizzaService;


    public ShowPizza(SpringTemplateEngine springTemplateEngine, PizzaService pizzaService) {
        this.springTemplateEngine = springTemplateEngine;
        this.pizzaService = pizzaService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        WebContext webContext = new WebContext(request, response, request.getServletContext());
//      List<Pizza> pizzas = pizzaService.listPizzas(); II
        webContext.setVariable("pizzas", this.pizzaService.listPizzas()); // I "pizzas", pizzas
        response.setContentType("text/html; charset=UTF-8");
        this.springTemplateEngine.process("listPizzas", webContext, response.getWriter());
    }


}
