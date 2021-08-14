<%--@elvariable id="message" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Error message</title>
</head>
<body>
    <jsp:directive.include file="header.jsp"/>

    <div align="center">
        <h3>${message}</h3>
    </div>

    <jsp:directive.include file="footer.jsp"/>
</body>
</html>
