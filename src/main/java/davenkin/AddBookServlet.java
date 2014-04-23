package davenkin;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by twer on 4/23/14.
 */
public class AddBookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Add Book</title></head>");
        out.println("<body>");
        out.println("<h1>Add a new book:</h1>");
        out.println("<form action=\"add\" method=\"post\">");
        out.println("ISBN: <input type=\"text\" name=\"isbn\"><br>");
        out.println("Name: <input type=\"text\" name=\"name\"><br>");
        out.println("Price: <input type=\"text\" name=\"price\"><br>");
        out.println("Author: <input type=\"text\" name=\"author\"><br>");
        out.println(" <input type=\"submit\"> ");
        out.println("</form");
        out.println("</body>");
        out.println("</html>");

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        Connection connection = null;
        Statement statement = null;
        try {
            DataSource dataSource = (DataSource) getServletContext().getAttribute("datasource");

            connection = dataSource.getConnection();
            statement = connection.createStatement();

            int isbn = Integer.parseInt(request.getParameter("isbn"));
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            String author = request.getParameter("author");

            statement.execute(String.format("INSERT INTO BOOK VALUES(%d,'%s',%d,'%s')", isbn, name, price, author));

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
