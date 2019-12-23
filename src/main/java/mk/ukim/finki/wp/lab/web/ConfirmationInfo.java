package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.model.Order;
import mk.ukim.finki.wp.lab.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="confirmation-info-servlet", urlPatterns = "/ConfirmationInfo.do")
public class ConfirmationInfo extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final OrderService orderService;

    public ConfirmationInfo(SpringTemplateEngine springTemplateEngine, OrderService orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        WebContext webContext = new WebContext(request, response, request.getServletContext());
        HttpSession session = request.getSession();

        String name = request.getParameter("clientName");
        String address = request.getParameter("clientAddress");


        Order orderFromSession = (Order) session.getAttribute("order");

        Order createOrder = orderService.placeOrder(orderFromSession.getPizzaType(),
                orderFromSession.getPizzaSize(), name, address);

        session.setAttribute("order", createOrder);
        webContext.setVariable("order", createOrder);
        webContext.setVariable("clientBrowser", request.getHeader("User-Agent"));
        webContext.setVariable("clientIPAddress", request.getRemoteAddr());

        this.springTemplateEngine.process("confirmationInfo", webContext, response.getWriter());
    }
}
