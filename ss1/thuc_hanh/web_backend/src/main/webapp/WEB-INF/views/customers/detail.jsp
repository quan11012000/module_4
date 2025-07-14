<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/14/2025
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Customer Detail</h2>
<ul>
  <li><strong>ID:</strong> ${customer.id}</li>
  <li><strong>Name:</strong> ${customer.name}</li>
  <li><strong>Email:</strong> ${customer.email}</li>
  <li><strong>Address:</strong> ${customer.address}</li>
</ul>
<a href="${pageContext.request.contextPath}/customers">Back to list</a>
