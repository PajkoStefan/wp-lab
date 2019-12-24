package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.model.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
class PizzaTypeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (httpRequest.getRequestURI().equals("/")) {
            System.out.println("Route: " + httpRequest.getRequestURI() + " -> missing pizzaType");
            chain.doFilter(request, response);
        } else if (httpRequest.getRequestURI().equals("/selectPizza.do")) {
            if (httpRequest.getParameter("pizza") != null) {
                System.out.println("Route: " + httpRequest.getRequestURI() + " -> missing pizzaType");
                chain.doFilter(request, response);

            } else {
                System.out.println("Route: " + httpRequest.getRequestURI() + " -> missing pizzaType");
                httpResponse.sendRedirect("/");
            }
        } else {
            Order sessionOrder = (Order) httpRequest.getSession().getAttribute("order");
            if (sessionOrder != null && sessionOrder.getPizzaType() != null) {
                System.out.println("Route: " + httpRequest.getRequestURI() + " -> missing pizzaType");
                chain.doFilter(request, response);
            } else {
                System.out.println("Route: " + httpRequest.getRequestURI() + " -> missing pizzaType");
                httpResponse.sendRedirect("/");
            }
        }
    }

}
