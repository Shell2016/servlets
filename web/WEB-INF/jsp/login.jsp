<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="email">Email:</label><input type="email" name="email" id="email" value="${param.email}" required><br>
    <label for="password">Password:</label><input type="password" name="password" id="password" required><br>
    <button type="submit">Login</button>
    <a href="${pageContext.request.contextPath}/registration">
        <button type="button">Register</button>
    </a>
    <c:if test="${param.error != null}">
        <div>
            <span style="color: orangered">Email or password is invalid!</span>
        </div>
    </c:if>
</form>
</body>
</html>
