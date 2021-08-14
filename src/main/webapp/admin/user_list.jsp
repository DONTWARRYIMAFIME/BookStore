<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Manage Users</title>
</head>
<body>
    <jsp:directive.include file="header.jsp"/>

    <div align="center">
        <h2>Users Management</h2>
        <h3><a href="user_form.jsp">Create New User</a></h3>
    </div>

    <%--@elvariable id="message" type="java.lang.String"--%>
    <c:if test="${message != null}">
    <div align="center">
        <h4>${message}</h4>
    </div>
    </c:if>

    <div align="center">
        <table border="1">
            <tr>
                <th>Index</th>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>DOB</th>
                <th>Actions</th>
            </tr>
            <%--@elvariable id="users" type="java.util.List"--%>
            <c:forEach var="user" items="${users}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${user.userId}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.dob}</td>
                    <td>
                        <a href="edit_user?id=${user.userId}">Edit</a> &nbsp;
                        <a href="javascript:confirmDelete(${user.userId})">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <jsp:directive.include file="footer.jsp"/>
    <script src="../js/script.js"></script>
</body>
</html>
