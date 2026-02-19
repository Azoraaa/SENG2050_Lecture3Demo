<!DOCTYPE html>
<html lang="en">
<head>
    <title>Course Selection</title>
</head>
<body>
    <h2>Course Selection</h2>

    <%@ page import="java.util.*" %>
<%@ page import="seng2050.Course" %>

<%
    List<Course> courses = (List<Course>) request.getAttribute("courseList");
    String[] selectedCourses = (String[]) request.getAttribute("selectedCourses");
%>

<h2>Select Courses</h2>
<form action="courses" method="post">
<%
    for (Course c : courses) {
        boolean checked = false;
        if (selectedCourses != null) {
            for (String s : selectedCourses) {
                if (s.equals(c.getCourseCode())) {
                    checked = true;
                    break;
                }
            }
        }
%>
    <input type="checkbox" name="courses" value="<%= c.getCourseCode() %>" <%= checked ? "checked" : "" %> />
    <%= c.getCourseCode() %> - <%= c.getCourseName() %><br/>
<%
    }
%>
    <input type="submit" value="Enroll">
</form>
<form action="semester.jsp" method="get" style="display:inline;">
    <button type="submit">Back</button>
    </form>

<%-- Display current enrollment below form --%>
<%
if (selectedCourses != null && selectedCourses.length > 0) {
%>
<h3>Current Enrollment:</h3>
<ul>
<%
    for (String code : selectedCourses) {
        for (Course c : courses) {
            if (c.getCourseCode().equals(code)) {
%>
    <li><%= c.getCourseCode() %> - <%= c.getCourseName() %></li>
<%
            }
        }
    }
%>
</ul>
<%
}
%>
</form>

</body>
</html>