<%@ page import="java.util.*" %>
<%@ page import="com.student.*" %>
<%@ page import="com.student.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
    <style>
        table, th, td { border: 1px solid black; border-collapse: collapse; padding: 5px; }
        th { background-color: #4F81BD; color: white; }
    </style>
</head>

<body>
    <h2>Welcome <%= session.getAttribute("userId") %></h2>
    <table>
        <tr>
            <th>Department</th>
            <th>Student ID</th>
            <th>Marks</th>
            <th>Pass %</th>
        </tr>
        <%
            List<Student> list = (List<Student>) request.getAttribute("studentList");
            Map<String, String> rates = (Map<String, String>) request.getAttribute("passRates");
            String lastDep = "";
        %>
        <% for (int i=0; i < list.size(); i++) {
            Student s = list.get(i);
        %>
        <tr>
            <% if (!s.getDepartment().equals(lastDep)) {
                int count = 0;
                for(Student temp : list) if(temp.getDepartment().equals(s.getDepartment())) count++;
            %>
            <td rowspan="<%= count %>"><%= s.getDepartment() %></td>
            <% } %>

            <td><a href="#" onclick="showName('<%= s.getStudentName() %>')"><%= s.getStudentId() %></a></td>
            <td><%= s.getMark() %></td>

            <% if (!s.getDepartment().equals(lastDep)) {
                int count = 0;
                for(Student temp : list) if(temp.getDepartment().equals(s.getDepartment())) count++;
            %>
            <td rowspan="<%= count %>"><%= rates.get(s.getDepartment()) %>%</td>
            <% } %>
        </tr>
        <% lastDep = s.getDepartment(); } %>
    </table>

    <script>
        function showName(name) {
            alert("Student Name: " + name);
        }
    </script>
</body>
</html>