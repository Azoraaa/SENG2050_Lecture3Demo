package seng2050;

import java.io.Serializable;

public class Course {
    private String courseCode;
    private String courseName;
    private int units;

    public Course(String code, String name) {
        this.courseCode = code;
        this.courseName = code;
        this.units = units; // For now all courses will be 10 units
    }
    
    public String getCourseCode() {
        return courseCode;
    }
    public String getCourseName() {
        return courseName;
    }
    public int getUnits() {
        return units;
    }
}
