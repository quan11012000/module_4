<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>404 - Trang không tồn tại</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(120deg, #e0f7fa, #fff);
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
            font-size: 10rem;
            font-weight: bold;
            background: linear-gradient(45deg, #ff6b6b, #feca57, #48dbfb, #1dd1a1, #5f27cd);
            background-size: 400% 400%;
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            animation: rainbow 6s ease infinite, bounce 1s ease-in-out infinite;
        }

        .error-message {
            font-size: 1.8rem;
            color: #444;
            margin-top: -20px;
            animation: fadeIn 2s ease-in;
        }

        .btn-home {
            margin-top: 30px;
            padding: 12px 30px;
            font-size: 1.1rem;
            border-radius: 30px;
            background-color: #007bff;
            color: white;
            border: none;
            transition: 0.3s;
        }

        .btn-home:hover {
            background-color: #0056b3;
        }

        .balloon {
            width: 50px;
            height: 70px;
            background: radial-gradient(circle at 30% 30%, #ff9f43, #e17055);
            border-radius: 50% 50% 50% 50% / 60% 60% 40% 40%;
            position: absolute;
            animation: floatBalloon 4s ease-in-out infinite;
            z-index: 0;
        }

        .balloon::after {
            content: '';
            position: absolute;
            bottom: -15px;
            left: 50%;
            transform: translateX(-50%);
            width: 2px;
            height: 25px;
            background-color: #555;
        }

        /* 4 vị trí bóng */
        .top-left    { top: 10px; left: 10px; animation-delay: 0s; }
        .top-right   { top: 10px; right: 10px; animation-delay: 1s; }
        .bottom-left { bottom: 10px; left: 10px; animation-delay: 2s; }
        .bottom-right{ bottom: 10px; right: 10px; animation-delay: 3s; }

        @keyframes rainbow {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        @keyframes bounce {
            0%, 100% { transform: translateY(0); }
            50% { transform: translateY(-20px); }
        }

        @keyframes floatBalloon {
            0%, 100% { transform: translateY(0); }
            50% { transform: translateY(-20px); }
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(30px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body>
<div class="error-container">
    <div class="error-code">404</div>
    <div class="error-message">Ôi không! Trang bạn yêu cầu không tồn tại 😥</div>
    <a href="/" class="btn btn-home mt-4">⬅️ Quay về trang chủ</a>
</div>

<!-- 4 quả bóng ở 4 góc -->
<div class="balloon top-left"></div>
<div class="balloon top-right"></div>
<div class="balloon bottom-left"></div>
<div class="balloon bottom-right"></div>

</body>
</html>
