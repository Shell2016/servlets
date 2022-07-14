<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/registration" method="post">
    <label>Name:
        <input type="text" name="name">
    </label><br>
    <label>Birthday:
        <input type="date" name="birthday">
    </label><br>
    <label>Email:
        <input type="email" name="email">
    </label><br>
    <label>Password:
        <input type="password" name="password">
    </label><br>
    <select name="role" id="role">
        <option value="USER">user</option>
        <option value="ADMIN">admin</option>
    </select><br>
    <label>
        <input type="radio" name="gender" value="MALE"> Male
    </label>
    <br>
    <label>
        <input type="radio" name="gender" value="FEMALE"> Female
    </label>
    <br>
    <button type="submit">Send</button>
    <c:if test="${not empty requestScope.errors}">
        <div style="color: orangered">
            <c:forEach var="error" items="${requestScope.errors}">
                <p>
                    ${error.message}
                </p>
            </c:forEach>
        </div>
    </c:if>
</form>

</body>
</html>
