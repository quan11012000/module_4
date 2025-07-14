<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/14/2025
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Currency Converter</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
  <div class="card shadow-lg">
    <div class="card-header bg-success text-white text-center">
      <h3>Chuyển đổi tiền tệ (USD ⇄ VND)</h3>
    </div>
    <div class="card-body">
      <form method="post" action="">
        <div class="row mb-3">
          <div class="col-md-4">
            <label class="form-label">Số tiền</label>
            <input type="number" step="0.01" min="0" name="amount" class="form-control" required>
          </div>
          <div class="col-md-4">
            <label class="form-label">Từ</label>
            <select name="from" class="form-select" required>
              <option value="USD">USD</option>
              <option value="VND">VND</option>
            </select>
          </div>
          <div class="col-md-4">
            <label class="form-label">Sang</label>
            <select name="to" class="form-select" required>
              <option value="VND">VND</option>
              <option value="USD">USD</option>
            </select>
          </div>
        </div>
        <div class="text-center">
          <button class="btn btn-primary" type="submit">Chuyển đổi</button>
        </div>
      </form>

      <c:if test="${not empty result}">
        <div class="alert alert-info mt-4 text-center">
          <strong>Kết quả:</strong> ${result}
        </div>
      </c:if>
    </div>
  </div>
</div>

</body>
</html>

