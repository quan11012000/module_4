<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Translate English to Vietnamese</title>
  <!-- Bootstrap 5 CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <h2 class="text-center mb-4">Translate English to Vietnamese</h2>
  <form action="${pageContext.request.contextPath}/translate" method="post" class="mb-4">
    <div class="mb-3">
      <label for="word" class="form-label">Enter English word:</label>
      <input type="text" id="word" name="word" class="form-control" placeholder="e.g., hello" required>
    </div>
    <button type="submit" class="btn btn-primary">Translate</button>
  </form>

  <c:if test="${not empty result}">
    <div class="alert alert-success">
      <strong>Result:</strong> ${result}
    </div>
  </c:if>
</div>
</body>
</html>
