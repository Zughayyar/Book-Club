<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Share</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <h1>Welcome, ${sessionScope.loggedUser.name}</h1>
                <p>Books from everyone's shelves.</p>
            </div>
            <div class="col-md-4">
                <div class="my-nav-container">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/logout">Logout</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/books/new">+ Add a book to me shelf!</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <hr>
        <div class="row">
            <table class="table">
                <thead>
                <tr class="table-info">
                    <th scope="col">ID</th>
                    <th scope="col">Title</th>
                    <th scope="col">Author Name</th>
                    <th scope="col">Posted By</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <th scope="row">${book.id}</th>
                            <td><a href="/books/${book.id}">${book.title}</a></td>
                            <td>${book.author}</td>
                            <td>${book.user.name}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>



    <script src="/webjars/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script>
</body>
</html>

