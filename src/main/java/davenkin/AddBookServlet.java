package davenkin;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        PrintWriter writer = response.getWriter();
        writer.println(request.getParameter("name")+" added");
    }

}
