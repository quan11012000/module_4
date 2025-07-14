<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 30/06/2025
  Time: 09:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Customer</title>
    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2 class="mb-4">Add New Customer</h2>
    <form action="/customer/create" method="post">
        <div class="mb-3">
            <label for="nameCus" class="form-label">Customer Name</label>
            <input type="text" class="form-control" id="nameCus" name="nameCus" required>
        </div>

        <div class="mb-3">
            <label for="phoneNumber" class="form-label">Phone Number</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" required>
        </div>

        <div class="mb-3">
            <label for="accumulatedPoint" class="form-label">Accumulated Points</label>
            <input type="number" class="form-control" id="accumulatedPoint" name="accumulatedPoint" min="0">
        </div>

        <div class="mb-3">
            <label for="rankCus" class="form-label">Customer Rank</label>
            <select class="form-select" id="rankCus" name="rankCus" required>
                <option value="" disabled>-- Select Rank --</option>
                <option value="Bronze" >Bronze</option>
                <option value="Silver">Silver</option>
                <option value="Gold">Gold</option>
                <option value="Platinum">Platinum</option>
<%--                 <c:forEach items="${ranks}" var="rank" varStatus="temp">--%>
<%--                <option value= "${rank.id}>${rank.name}</option>"--%>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Add Customer</button>
    </form>
</div>

</body>
</html>