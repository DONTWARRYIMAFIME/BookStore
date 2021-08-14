<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Admin panel</title>
</head>
<body>
    <jsp:directive.include file="header.jsp"/>

    <div align="center">
        <h2>Administration Dashboard</h2>
    </div>

    <div align="center">
        <hr width="60%"/>
        <h2>Quick Actions</h2>
        <b>
        <a href="create_book">New book</a> |
        <a href="create_user">New User</a> |
        <a href="create_category">New Category</a> |
        <a href="create_customer">New Customer</a>
        </b>
    </div>

    <div align="center">
        <hr width="60%"/>
        <h2>Recent Sales:</h2>
    </div>

    <div align="center">
        <hr width="60%"/>
        <h2>Recent Reviews:</h2>
    </div>

    <div align="center">
        <hr width="60%"/>
        <h2>Statistics:</h2>
    </div>

    <jsp:directive.include file="footer.jsp"/>
</body>
</html>
