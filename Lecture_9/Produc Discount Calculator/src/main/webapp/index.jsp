<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        *{
            box-sizing: border-box;
            margin: 3px;
            padding: 3px;
        }
        #box{
            width: 200px;
            border: solid 1px gray;
            padding: 5px;
            background-color: gray;
        }
    </style>
</head>
<body>
<form method="post" action="discountCalculator">
    <div id="box">
        <h4>Product Description</h4>
        <input type="text" name="product">
        <h4>List Price</h4>
        <input type="text" name="price">
        <h4>Discount</h4>
        <input type="text" name="discount">
        <input type="submit">
    </div>


    </form>
    </body>
    </html>
    </label>