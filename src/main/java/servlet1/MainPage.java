package servlet1;

import fileManager.model.User;
import fileManager.repository.repo.UserRepo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Simple class that extends {@link HttpServlet}.
 *
 * @author Eugene Suleimanov
 */
public class MainPage extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        message = "This is simple servlet message";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String title = "File Manager";
        PrintWriter writer = response.getWriter();
        String docType = "<!DOCTYPE html>";

        PrintWriter messageWriter = response.getWriter();
        messageWriter.println("<h1>" + message + "<h1>");

        writer.println("<html>" +
                "<head><title>" + title + "</title></head>\n" +
                "<body>" +
                "<h2>User Name: </h2>" + request.getParameter("name") +
                "</body>" +
                "</html>");
        System.out.println(request.getParameter("name"));

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        User user = new User();
        user.setName(name);
        UserRepo userRepo = new UserRepo();
        userRepo.createUser(user);

        doGet(request, response);
    }

    public void destroy() {

    }

}