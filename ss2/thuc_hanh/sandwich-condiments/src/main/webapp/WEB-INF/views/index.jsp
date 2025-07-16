<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form action="save" method="post">
  <c:forEach var="c" items="${condiments}">
    <input type="checkbox" name="condiment" value="${c}"> ${c} <br>
  </c:forEach>
  <br>
  <input type="submit" value="Save">
</form>
<c:if test="${not empty error}">
  <p style="color:red">${error}</p>
</c:if>

</body>
</html>