<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Managing user</title>
</head>
<body>
<jsp:directive.include file="header.jsp"/>
<%--@elvariable id="user" type="by.bookstore.entity.User"--%>
<div align="center">
    <h2>

        <c:if test="${user != null}">
            Edit user's information
        </c:if>
        <c:if test="${user == null}">
            Create a new user
        </c:if>
    </h2>
</div>

<div align="center">
    <form method="post"
          <c:if test="${user != null}">action="update_user"</c:if>
          <c:if test="${user == null}">action="create_user"</c:if>
    >

        <c:if test="${user != null}">
        <label for="id">User's id</label>
        <input id="id" name ="id" type="number" value="${user.userId}" readonly>
        <br />
        <br />
        </c:if>

        <label for="email">Enter email</label>
        <input id="email" name ="email" type="email" value="${user.email}">
        <br />
        <br />

        <label for="firstName">Enter First Name</label>
        <input id="firstName" name="firstName" type="text" value="${user.firstName}">
        <br />
        <br />

        <label for="lastName">Enter Last Name</label>
        <input id="lastName" name="lastName" type="text" value="${user.lastName}">
        <br />
        <br />

        <label for="phoneNumber">Enter phone number</label>
        <input id="phoneNumber" name="phoneNumber" type="tel" value="${user.phoneNumber}">
        <br />
        <br />

        <label for="dob">Enter Date of Birth</label>
        <input id="dob" name="dob" type="date" value="${user.dob}">
        <br />
        <br />

        <label for="password">Enter Password</label>
        <input id="password" name="password" type="password" value="${user.password}">
        <br />
        <br />

        <input type="submit" value="Save">
        <input type="reset" value="Cancel" onclick="history.go(-1)">
    </form>
</div>

<jsp:directive.include file="footer.jsp"/>
</body>
<script type="text/javascript" src="../js/script.js"></script>
</html>
