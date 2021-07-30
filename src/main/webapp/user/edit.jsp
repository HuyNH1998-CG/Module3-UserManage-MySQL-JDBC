<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Edit User</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron text-center">
    <h1>User Management</h1><br>
    <h2>
        <a href="/?action=user" class="btn btn-primary">List All Users</a>
    </h2>
</div>
<div class="container">
    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <form method="post">
                <table class="container">
                    <h2>Editing New User</h2>
                    <c:if test="${user!=null}">
                        <input type="hidden" name="id" value="${user.id}">
                    </c:if>
                    <tr>
                        <th>Username:</th>
                        <td><input type="text" name="username" id="username" size="45" value="${user.username}"></td>
                    </tr>
                    <tr>
                        <th>Password:</th>
                        <td><input type="password" name="password" id="password" size="45" value="${user.password}">
                        </td>
                    </tr>
                    <tr>
                        <th>Email:</th>
                        <td><input type="text" name="email" id="email" size="45" value="${user.email}"></td>
                    </tr>
                    <tr>
                        <th>Country:</th>
                        <td><input type="text" name="country" id="country" size="45" value="${user.country}"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="col-sm-2"></div>
    </div>
</div>
</body>
</html>
