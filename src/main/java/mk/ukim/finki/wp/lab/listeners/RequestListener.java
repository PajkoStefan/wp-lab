package mk.ukim.finki.wp.lab.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent event){
//      HttpServletRequest request = (HttpServletRequest) event.getServletRequest(); ako ima potreba
        String methodName = ((HttpServletRequest) event.getServletRequest()).getMethod();
//        System.out.println("[WP-LOG] {requestInitialized(ServletRequestEvent event)}");
        System.out.println("[WP-LOG] Request : {Method Name : {" + methodName + "} }");
    }
}

