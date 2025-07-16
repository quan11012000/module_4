<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chi tiết cấu hình</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4 text-info">Chi tiết cấu hình hộp thư</h2>

    <!-- Hiển thị thông báo -->
    <c:if test="${not empty message}">
        <div class="alert alert-success">${message}</div>
    </c:if>

    <!-- Hiển thị thông tin cấu hình -->
    <c:if test="${not empty email}">
        <ul class="list-group">
            <li class="list-group-item"><strong>Ngôn ngữ:</strong> ${email.language}</li>
            <li class="list-group-item"><strong>Số email/trang:</strong> ${email.pageSize}</li>
            <li class="list-group-item"><strong>Bộ lọc thư rác:</strong> <c:choose>
                <c:when test="${email.spamsFilter}">Bật</c:when>
                <c:otherwise>Tắt</c:otherwise>
            </c:choose></li>
            <li class="list-group-item"><strong>Chữ ký:</strong> <pre>${email.signature}</pre></li>
        </ul>
    </c:if>

    <!-- Nút quay lại -->
    <a href="/email" class="btn btn-primary mt-4">Quay lại cập nhật</a>
</div>
</body>
</html>
