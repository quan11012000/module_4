<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/15/2025
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Lỗi 500 - Lỗi máy chủ</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    body {
      background: radial-gradient(circle at center, #fceabb, #f8b500);
      font-family: 'Segoe UI', sans-serif;
      height: 100vh;
      margin: 0;
      overflow: hidden;
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .error-container {
      text-align: center;
      position: relative;
      z-index: 1;
    }

    .error-code {
      font-size: 9rem;
      font-weight: bold;
      background: linear-gradient(90deg, #d63031, #fdcb6e, #e17055);
      background-size: 300% 300%;
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
      animation: rainbow 4s ease infinite, shake 0.8s infinite;
    }

    .error-message {
      font-size: 1.7rem;
      color: #2d3436;
      margin-top: -20px;
      animation: fadeIn 2s ease-in;
    }

    .btn-home {
      margin-top: 30px;
      padding: 12px 30px;
      font-size: 1.1rem;
      border-radius: 30px;
      background-color: #d63031;
      color: white;
      border: none;
      transition: 0.3s;
    }

    .btn-home:hover {
      background-color: #b71540;
    }

    .smoke {
      position: absolute;
      width: 100px;
      height: 100px;
      background: radial-gradient(circle, #ffffff40, #ffffff00);
      animation: floatSmoke 5s ease-in-out infinite;
      border-radius: 50%;
      opacity: 0.3;
      z-index: 0;
    }

    .smoke1 { top: 10%; left: 20%; animation-delay: 0s; }
    .smoke2 { top: 30%; left: 70%; animation-delay: 1s; }
    .smoke3 { top: 60%; left: 50%; animation-delay: 2s; }

    @keyframes floatSmoke {
      0% { transform: translateY(0) scale(1); opacity: 0.3; }
      50% { transform: translateY(-50px) scale(1.2); opacity: 0.1; }
      100% { transform: translateY(0) scale(1); opacity: 0.3; }
    }

    @keyframes rainbow {
      0% { background-position: 0% 50%; }
      50% { background-position: 100% 50%; }
      100% { background-position: 0% 50%; }
    }

    @keyframes shake {
      0%, 100% { transform: translateX(0); }
      25% { transform: translateX(-4px); }
      50% { transform: translateX(4px); }
      75% { transform: translateX(-2px); }
    }

    @keyframes fadeIn {
      from { opacity: 0; transform: translateY(30px); }
      to { opacity: 1; transform: translateY(0); }
    }
  </style>
</head>
<body>
<div class="error-container">
  <div class="error-code">500</div>
  <div class="error-message">Ối! Có lỗi xảy ra từ phía máy chủ 😓</div>
  <a href="/" class="btn btn-home mt-4">⬅️ Quay lại trang chủ</a>
</div>

<!-- Khói nền mờ mờ -->
<div class="smoke smoke1"></div>
<div class="smoke smoke2"></div>
<div class="smoke smoke3"></div>

</body>
</html>
