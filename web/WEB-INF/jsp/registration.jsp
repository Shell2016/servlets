<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<img width="350px" height="700px" src="${pageContext.request.contextPath}/images/users/1.jpeg" alt="Image">
<form action="${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data">
    <label>Name:
        <input type="text" name="name" required>
    </label><br>
    <label>Birthday:
        <input type="date" name="birthday" required>
    </label><br>
    <label>Email:
        <input type="email" name="email" required>
    </label><br>
    <label for="imageId">Image:
        <input type="file" name="image" id="imageId">
    </label><br>
    <label>Password:
        <input type="password" name="password" required>
    </label><br>
    <select name="role" id="role">
        <option value="USER">user</option>
        <option value="ADMIN">admin</option>
    </select><br>
    <label>
        <input type="radio" name="gender" value="MALE" checked> Male
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
