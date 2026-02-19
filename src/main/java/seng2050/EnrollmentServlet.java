package seng2050;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EnrollmentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Hardcoded student
        Student student = new Student("test", "test");  // username/password

        // Hardcoded semester
        String semester = "Fall 2026";

        // Hardcoded courses
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("SENG2050", "Web Engineering"));
        courses.add(new Course("COMP1010", "Intro to Programming"));

        Enrollment enrollment = new Enrollment(student, semester, courses);

        request.setAttribute("enrollment", enrollment);

        RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
        dispatcher.forward(request, response);
    }
}