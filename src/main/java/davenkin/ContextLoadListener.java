package davenkin;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by twer on 4/23/14.
 */
public class ContextLoadListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        servletContext.setAttribute("SPRING_CONTEXT", context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
