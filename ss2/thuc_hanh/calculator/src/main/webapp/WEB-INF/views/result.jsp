<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Kết Quả Tính Toán</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <div class="card shadow-lg">
    <div class="card-header bg-info text-white text-center">
      <h3>Kết Quả</h3>
    </div>
    <div class="card-body text-center">
      <h4 class="text-success">Kết quả: <strong>${result}</strong></h4>
      <a href="/" class="btn btn-primary mt-3">Tính lại</a>
    </div>
  </div>
</div>
</body>
</html>
