package mk.ukim.finki.wp.lab.listeners;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionCreationListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("[WP-LOG] {Method Name: HttpSessionListener.sessionCreated()}");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("[WP-LOG] {Method Name: HttpSessionListener.sessionDestroyed()}");
    }
}