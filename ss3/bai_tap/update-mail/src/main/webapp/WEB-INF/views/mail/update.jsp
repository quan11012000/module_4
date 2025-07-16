<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Mail Settings</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4 text-primary">Cập nhật cấu hình hộp thư</h2>
    <form:form modelAttribute="email" action="/email/update" method="post" class="card p-4 shadow rounded-3 bg-light">

        <!-- Language -->
        <div class="mb-3">
            <label for="language" class="form-label">Ngôn ngữ:</label>
            <form:select path="language" cssClass="form-select">
                <form:options items="${languages}" />
            </form:select>
        </div>

        <!-- Page Size -->
        <div class="mb-3">
            <label for="pageSize" class="form-label">Số email/trang:</label>
            <form:select path="pageSize" cssClass="form-select">
                <form:options items="${pageSizes}" />
            </form:select>
        </div>

        <!-- Spams Filter -->
        <div class="mb-3 form-check">
            <form:checkbox path="spamsFilter" cssClass="form-check-input" id="spamCheck"/>
            <label class="form-check-label" for="spamCheck">Bật bộ lọc thư rác</label>
        </div>

        <!-- Signature -->
        <div class="mb-3">
            <label for="signature" class="form-label">Chữ ký:</label>
            <form:textarea path="signature" rows="3" cssClass="form-control"/>
        </div>

        <!-- Submit Buttons -->
        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-success">Cập nhật</button>
            <a href="/email/detail" class="btn btn-secondary">Xem chi tiết</a>
        </div>
    </form:form>
</div>
</body>
</html>
