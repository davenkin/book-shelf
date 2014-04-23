package davenkin;

import org.apache.commons.dbcp.BasicDataSource;

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
        BasicDataSource datasource = new BasicDataSource();
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/BOOKSHELF");
        datasource.setUsername("root");
        datasource.setPassword("");
        servletContext.setAttribute("datasource", datasource);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
