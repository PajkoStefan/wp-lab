package mk.ukim.finki.wp.lab.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="logout-servlet", urlPatterns = "/Logout.do")
public class Logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        request.getSession().invalidate();
        // Invalidate the session and removes any attribute related to it
        response.sendRedirect("/");
    }
}
