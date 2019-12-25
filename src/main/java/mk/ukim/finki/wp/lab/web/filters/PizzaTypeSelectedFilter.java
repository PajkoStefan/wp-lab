package mk.ukim.finki.wp.lab.web.filters;

import mk.ukim.finki.wp.lab.model.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class PizzaTypeSelectedFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String reqUrl = httpRequest.getRequestURI();
        if (!reqUrl.endsWith(".do")  ) {
            chain.doFilter(request, response);
        }
        else if (reqUrl.equals("/selectPizza.do")) {
            if (httpRequest.getParameter("pizza") != null) {
                chain.doFilter(request, response);

            } else {
                System.out.println("Route: " + httpRequest.getRequestURI() + " -> missing pizzaType");
                httpResponse.sendRedirect("/");
            }
        }
        else if(!reqUrl.equals("/h2")){ // ako go nema pravi problem conn so h2
            chain.doFilter(request, response);
        }
        else {
            Order sessionOrder = (Order) httpRequest.getSession().getAttribute("order");
            if (sessionOrder != null && sessionOrder.getPizzaType() != null) {
                chain.doFilter(request, response);
            } else {
                System.out.println("Route: " + httpRequest.getRequestURI() + " -> missing pizzaType");
                httpResponse.sendRedirect("/");
            }
        }

    }


}
