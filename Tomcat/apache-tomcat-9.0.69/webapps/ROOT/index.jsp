<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<a href="ManageProduct.jsp">Click here</a>
<h1>Add New Product</h1>
<form action="ProductServlet" method="get">
    <input type="hidden" name="action" value="add">
    <table>
        <tr>
            <td>Name</td>
            <td><label>
                <input type="text" name="name">
            </label></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><label>
                <input type="text" name="price">
            </label></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><label>
                <input type="text" name="quantity">
            </label></td>
        </tr>
        <tr><td colspan="2"><input type="submit" value="Save Product"></td></tr>
    </table>
</form>
<a href="${pageContext.request.contextPath}/ProductServlet?action=view">View Products</a>
</body>
</html>