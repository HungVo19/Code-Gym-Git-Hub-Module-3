<%--
  Created by IntelliJ IDEA.
  User: votra
  Date: 11/28/2022
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Product Manager</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="list-product.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
            integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
<body>
<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6">
                    <h2>Manage <b>Products</b></h2>
                </div>
                <div class="col-sm-6">
                    <a href="#addProductModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                        <span>Add New Employee</span></a>
                    <%--                    <a href="#deleteProductModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i>--%>
                    <%--                        <span>Delete</span></a>--%>
                </div>

            </div>
        </div>
        <div class="row">
            <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/products?action=search"
                  method="post">
                <input class="form-control mr-sm-2" type="search" id="nameSearch" name="nameSearch"
                       placeholder="Search by Name" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Category</th>
                <th style="width: 150px">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="p">
                <tr>
                    <td><c:out value="${p.getId()}"/></td>
                    <td><c:out value="${p.getName()}"/></td>
                    <td><c:out value="${p.getPrice()}"/>$</td>
                    <td><c:out value="${p.getQuantity()}"/></td>
                    <td><c:out value="${p.getCategory().getName()}"/></td>
                    <td>
                        <a href="#${p.getId()}v" data-toggle="modal" >
                            <i class="material-icons" data-toggle="tooltip" title="Edit" style="color:cadetblue">&#xe8f4;</i></a>
                        <a href="#${p.getId()}e" class="edit" id="${p.getId()}"
                           data-toggle="modal">
                            <i class="material-icons" data-toggle="tooltip" title="View">&#xE254;</i></a>
                        <a href="#${p.getId()}d" class="delete"
                           data-toggle="modal">
                            <i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                    </td>
                    <div id="${p.getId()}d" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form action="${pageContext.request.contextPath}/products?action=delete" method="post">
                                    <input type="text" name="id" value="${p.getId()}">
                                    <div class="modal-header">
                                        <h4 class="modal-title">Delete Product</h4>
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    </div>
                                    <div class="modal-body">
                                        <p>Are you sure you want to delete this Product</p>
                                        <p class="text-warning"><small>This action cannot be undone.</small></p>
                                    </div>
                                    <div class="modal-footer">
                                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                        <input type="submit" class="btn btn-danger" value="Delete">
                                    </div>
                                </form>
                            </div>
                        </div>

                    </div>
                    <div id="${p.getId()}v" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="viewProductModalLabel"></h4>
                                <h3><c:out value="${p.getName()}"/></h3>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <label>ID</label>
                                    <label>
                                        <p><c:out value="${p.getId()}"/></p>
                                    </label>
                                </div>
                                <div class="form-group">
                                    <label>Name</label>
                                    <label>
                                        <p><c:out value="${viewedProduct.getName()}"/></p>
                                    </label>
                                </div>
                                <div class="form-group">
                                    <label>Price</label>
                                    <label>
                                        <p><c:out value="${viewedProduct.getPrice()}"/></p>
                                    </label>
                                </div>
                                <div class="form-group">
                                    <label>Quantity</label>
                                    <label>
                                        <p><c:out value="${viewedProduct.getQuantity()}"/></p>
                                    </label>
                                </div>
                                <div class="form-group">
                                    <label>Category</label>
                                    <label>
                                        <p><c:out value="${viewedProduct.getCategory().getName()}"/></p>
                                    </label>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" data-dismiss="modal" value="Close">
                            </div>
                        </div>
                    </div>
                </div>
                    <div id="${p.getId()}e" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <form action="${pageContext.request.contextPath}/products?action=edit" method="post">
                                    <div class="modal-header">
                                        <h4 class="modal-title">Update Product</h4>
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <label>Name</label>
                                            <input type="text" class="form-control" name="name" value="${p.getName()}" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Price</label>
                                            <input type="text" class="form-control" name="price" value="${p.getPrice()}" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Quantity</label>
                                            <input type="text" class="form-control" name="quantity" value="${p.getQuantity()}" required>
                                        </div>
<%--                                        <div class="form-group">--%>
<%--                                            <label>Address</label>--%>
<%--                                            <textarea class="form-control" required></textarea>--%>
<%--                                        </div>--%>
                                        <div class="form-group">
                                            <label>Category</label>
                                            <select name="category" class="form-control">
                                                <c:forEach items="${categories}" var="c">
                                                    <c:if test="${c.getId() != p.getCategory().getId()}">
                                                        <option value="${c.getId()}"><c:out value="${c.getName()}"/></option>
                                                    </c:if>
                                                    <c:if test="${c.getId() == p.getCategory().getId()}">
                                                        <option selected value="${c.getId()}"><c:out value="${c.getName()}"/></option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                        <input type="submit" class="btn btn-info" value="Save">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div id="addProductModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="${pageContext.request.contextPath}/products?action=create" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Add Products</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" name="name" required>
                    </div>
                    <div class="form-group">
                        <label>Price</label>
                        <input type="text" class="form-control" name="price" required>
                    </div>
                    <div class="form-group">
                        <label>Quantity</label>
                        <input type="text" class="form-control" name="quantity" required>
                    </div>
                    <div class="form-group">
                        <label>Category</label>
                        <select name="category" class="form-control">
                            <c:forEach items="${categories}" var="c">
                                <option id="${c.getId()}" value="${c.getId()}">${c.getName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
