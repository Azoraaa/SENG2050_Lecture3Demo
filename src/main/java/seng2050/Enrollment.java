package seng2050;

import java.util.List;
import java.io.Serializable;


public class Enrollment {
    private Student student;
    private String semester;
    private List<Course> courses;

    public Enrollment() {

    }

    public Enrollment(Student student, String semester, List<Course> courses) {
        this.student = student;
        this.semester = semester;
        this.courses = courses;
    }

    public Student getStudent() {
        return student;
    }

    public String getSemester() {
        return semester;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
