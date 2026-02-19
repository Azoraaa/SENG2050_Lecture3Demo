package seng2050;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

       // Hardcoded authentication check
        if ("test".equals(username) && "test".equals(password)) {
            HttpSession session = request.getSession();
            
            // Hardcoded Student object
            seng2050.Student student = new seng2050.Student();
            student.setUsername(username); 
            // Might hardcode more student info later
            session.setAttribute("student", student);
            session.setAttribute("username", username);

            response.sendRedirect("semester");  // Redirect to semester servlet
        } else {
            response.getWriter().println("<h3>Invalid Username or Password</h3>");
            request.getRequestDispatcher("login.html").include(request, response);
        }
    }
}