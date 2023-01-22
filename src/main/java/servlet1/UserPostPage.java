package servlet1;

import fileManager.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserPostPage extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        message = "This is simple servlet message";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        String title = "User Add Manager";
        String docType = "<!DOCTYPE html";

        User user = new User();
        user.setName(request.getParameter("name"));
        user.setId(777);

        writer.println("<html>" +
                "<head><title>" + title + "</title></head>\n" +
                "<body>" +
//                "<h2>Name: </h2>" + request.getParameter("name") +
                "<h2>Name: </h2>" + user +
                "</body>" +
                "</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void destroy() {

    }
}
