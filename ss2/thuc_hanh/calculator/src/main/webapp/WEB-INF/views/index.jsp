<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Máy Tính Cá Nhân</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="card shadow">
        <div class="card-header bg-primary text-white text-center">
            <h3>Máy Tính Cá Nhân</h3>
        </div>
        <div class="card-body">
            <form method="post" action="/calculate">
                <div class="row mb-3">
                    <div class="col-md-6">
                        <label class="form-label">Số thứ nhất:</label>
                        <input type="text" step="any" name="firstNumber" class="form-control" value="${calculator.firstNumber}" required>
                    </div>
                    <div class="col-md-6">
                        <label class="form-label">Số thứ hai:</label>
                        <input type="text" step="any" name="secondNumber" class="form-control" value="${calculator.secondNumber}" required>
                    </div>
                </div>
                <div class="mb-3">
                    <label class="form-label">Phép toán:</label>
                    <select name="operator" class="form-select" required>
                        <option value="+" ${calculator.operator == '+' ? 'selected' : ''}>Cộng (+)</option>
                        <option value="-" ${calculator.operator == '-' ? 'selected' : ''}>Trừ (-)</option>
                        <option value="*" ${calculator.operator == '*' ? 'selected' : ''}>Nhân (*)</option>
                        <option value="/" ${calculator.operator == '/' ? 'selected' : ''}>Chia (/)</option>
                    </select>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-success">Tính kết quả</button>
                </div>
            </form>

            <!-- Kết quả -->
            <c:if test="${not empty expression}">
                <div class="alert alert-success text-center mt-4">
                    <strong>Kết quả:</strong> ${expression}
                </div>
            </c:if>

            <c:if test="${not empty error}">
                <div class="alert alert-danger text-center mt-4">
                    <strong>Lỗi:</strong> ${error}
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
