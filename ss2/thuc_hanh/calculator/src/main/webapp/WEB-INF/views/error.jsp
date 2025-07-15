<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/15/2025
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Lỗi</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <div class="card shadow-lg">
    <div class="card-header bg-danger text-white text-center">
      <h3>Đã xảy ra lỗi</h3>
    </div>
    <div class="card-body text-center">
      <h4 class="text-danger">${error}</h4>
      <a href="/" class="btn btn-primary mt-3">Quay lại máy tính</a>
    </div>
  </div>
</div>
</body>
</html>
