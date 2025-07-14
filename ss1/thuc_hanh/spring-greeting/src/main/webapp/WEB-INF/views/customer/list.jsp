<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 27/06/2025
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách học sinh</title>
    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <button class="btn btn-primary" onclick="window.location.href='/customer/create'">Thêm mới</button>
    <h2 class="mb-4 text-center">Danh sách học sinh</h2>

    <table class="table table-bordered table-hover table-striped align-middle">
        <thead class="table-primary">
        <tr class="text-center">
            <th scope="col">No</th>
            <th scope="col">Name</th>
            <th scope="col">Phone</th>
            <th scope="col">Accumulated Point</th>
            <th scope="col">Rank</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="customer" varStatus="temp">
            <tr>
                <td class="text-center">${temp.count}</td>
                <td>${customer.nameCus}</td>
                <td>${customer.phoneNumber}</td>
                <td class="text-end">${customer.accumulatedPoint}</td>
                <td>${customer.rankCus}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="alert alert-primary" role="alert" id="mess">
        ${mess}
    </div>
</div>
<script>
    setTimeout(function () {
        document.getElementById("mess").style.display = "none";
    },3000)
</script>
</body>
</html>
