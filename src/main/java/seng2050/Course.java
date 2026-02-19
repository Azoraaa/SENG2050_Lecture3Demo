package seng2050;

public class Course {
    private String code;
    private String name;
    private int units;

    public Course(String code, String name) {
        this.code = code;
        this.name = code;
        this.units = units; // For now all courses will be 10 units
    }
    
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public int getUnits() {
        return units;
    }
}
