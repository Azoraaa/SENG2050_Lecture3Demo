package seng2050;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/courses")
public class CourseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Available courses hardcoded
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("SENG2050", "Web Engineering"));
        courses.add(new Course("COMP1010", "Intro to Programming"));
        courses.add(new Course("MATH1001", "Discrete Mathematics"));

        request.setAttribute("courseList", courses);

        // Retrieve selected courses from session if any
        HttpSession session = request.getSession();
        String[] selectedCourses = (String[]) session.getAttribute("selectedCourses");
        if (selectedCourses != null) {
            request.setAttribute("selectedCourses", selectedCourses);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("courses.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Store selected courses in session
        String[] selectedCourses = request.getParameterValues("courses");
        HttpSession session = request.getSession();
        session.setAttribute("selectedCourses", selectedCourses);

        // Redirect back to GET to show updated enrollment
        response.sendRedirect("courses");
    }
}