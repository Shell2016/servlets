<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%@ include file="header.jsp" %>


<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="email"><fmt:message key="page.login.email"/>:</label>
    <input type="email" name="email" id="email" value="${param.email}" required><br>
    <label for="password"><fmt:message key="page.login.password"/>:</label>
    <input type="password" name="password" id="password" required><br>
    <button type="submit"><fmt:message key="page.login.submit.button"/></button>
    <a href="${pageContext.request.contextPath}/registration">
        <button type="button"><fmt:message key="page.login.register.button"/></button>
    </a>
    <c:if test="${param.error != null}">
        <div>
            <span style="color: orangered"><fmt:message key="page.login.error"/></span>
        </div>
    </c:if>
</form>
</body>
</html>
