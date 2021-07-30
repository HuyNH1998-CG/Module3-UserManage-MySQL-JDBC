<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>User Managerment</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron text-center">
    <h1>User Management</h1><br>
    <h2>
        <a href="/?action=create" class="btn btn-primary">Add new</a>
    </h2>
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <table class="container">
                <h2>List of user</h2>
                <tr>
                    <th>ID</th>
                    <th>UserName</th>
                    <th>Password</th>
                    <th>Email</th>
                    <th>Country</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="user" items="${listUser}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.email}</td>
                        <td>${user.country}</td>
                        <td>
                            <a href="/?action=edit&id=${user.id}" class="btn btn-primary">Edit</a>
                            <a href="/?action=delete&id=${user.id}" class="btn btn-primary">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-sm-2"></div>
    </div>
</div>
</body>
</html>
