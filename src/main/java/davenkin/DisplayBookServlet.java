package davenkin;

import davenkin.domain.Book;
import org.apache.commons.dbcp.BasicDataSource;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/BOOKSHELF");
            dataSource.setUsername("root");
            dataSource.setPassword("");

            connection = dataSource.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM BOOK");
            ArrayList<Book> books = new ArrayList<Book>();
            while(resultSet.next())
            {
                int isbn = resultSet.getInt("ISBN");
                String name = resultSet.getString("NAME");
                double price = resultSet.getDouble("PRICE");
                String author = resultSet.getString("AUTHOR");
                books.add(new Book(isbn, name, price, author));
            }

            request.setAttribute("books",books);
            request.getRequestDispatcher("jsp/display.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
