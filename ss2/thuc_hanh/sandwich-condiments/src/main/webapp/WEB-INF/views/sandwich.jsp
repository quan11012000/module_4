<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/15/2025
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Các gia vị bạn đã chọn:</h2>
<ul>
  <c:forEach var="item" items="${selectedCondiments}">
    <li>${item}</li>
  </c:forEach>
</ul>

<a href="/">Quay lại</a>
</body>
</html>
