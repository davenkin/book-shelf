package davenkin;

import davenkin.domain.Book;
import org.springframework.context.ApplicationContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by twer on 4/23/14.
 */
public class DisplayBookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        Connection connection = null;
        Statement statement = null;
        try {
            ApplicationContext context = (ApplicationContext) getServletContext().getAttribute("SPRING_CONTEXT");
            DataSource dataSource = (DataSource) context.getBean("datasource");

            connection = dataSource.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM BOOK");
            ArrayList<Book> books = new ArrayList<Book>();
            while (resultSet.next()) {
                int isbn = resultSet.getInt("ISBN");
                String name = resultSet.getString("NAME");
                double price = resultSet.getDouble("PRICE");
                String author = resultSet.getString("AUTHOR");
                books.add(new Book(isbn, name, price, author));
            }

            request.setAttribute("books", books);
            request.getRequestDispatcher("jsp/display.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
