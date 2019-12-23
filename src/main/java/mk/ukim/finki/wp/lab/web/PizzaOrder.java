package mk.ukim.finki.wp.lab.web;

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

@WebServlet(name = "pizza-order-servlet", urlPatterns = "/PizzaOrder.do")
public class PizzaOrder extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    public PizzaOrder(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        WebContext webContext = new WebContext(request, response, request.getServletContext());

        Order order = (Order) session.getAttribute("order"); // mora cast, vraca String
        String selectedPizzaSize = request.getParameter("pizza_size");

        order.setPizzaSize(selectedPizzaSize);
        session.setAttribute("order", order);
        webContext.setVariable("pizzaType", order.getPizzaType());
        webContext.setVariable("pizzaSize", selectedPizzaSize);

        this.springTemplateEngine.process("deliveryInfo", webContext, response.getWriter());
    }
}
