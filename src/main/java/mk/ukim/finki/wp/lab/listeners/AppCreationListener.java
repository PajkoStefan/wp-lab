package mk.ukim.finki.wp.lab.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppCreationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event){
        System.out.println("[WP-LOG] {Method Name: ServletContextListener.contextInitialized()}");
    }
    @Override
    public void contextDestroyed(ServletContextEvent event){
        System.out.println("[WP-LOG] {Method Name: ServletContextListener.contextDestroyed()}");
    }

}
