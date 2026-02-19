<!DOCTYPE html>
<html lang="en">
<head>
    <title>UniX Login</title>
</head>
<body>
    <h2>UniX Login</h2>

    <%@ page import="seng2050.Enrollment, seng2050.Course, java.util.*" %>

<%
    Enrollment enrollment = (Enrollment) request.getAttribute("enrollment");
%>

<h2>Enrollment Successful</h2>

Student: <%= enrollment.getStudent().getUsername() %><br/>
Semester: <%= enrollment.getSemester() %><br/>

Courses:
<ul>
<%
    for (Course c : enrollment.getCourses()) {
%>
    <li><%= c.getCourseCode() %></li>
<%
    }
%>
</ul>

</body>
</html>