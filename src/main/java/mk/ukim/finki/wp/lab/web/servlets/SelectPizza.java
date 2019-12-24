package mk.ukim.finki.wp.lab.web.servlets;

import mk.ukim.finki.wp.lab.model.Order;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "select-pizza-servlet", urlPatterns = "/selectPizza.do")
public class SelectPizza extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    public SelectPizza(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        WebContext webContext = new WebContext(request, response, request.getServletContext());

        Order order = new Order();
        String selectedPizzaType = request.getParameter("pizza");

        order.setPizzaType(selectedPizzaType);
        session.setAttribute("order", order);
        webContext.setVariable("pizzaType", selectedPizzaType);
        System.out.println(response.getWriter());
        this.springTemplateEngine.process("selectPizzaSize", webContext, response.getWriter());
    }
}
