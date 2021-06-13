<%--<%@ page isELIgnored="false" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Usuwanie książki</title>
</head>
<body>
<form method="post" action="">
    <p>Czy usunąć książkę ${book.title} (id = ${book.id})?</p>
    <p>
        <input type="hidden" name="id" value="${book.id}"/>
        <a href="/books/all">Nie</a><button type="submit">Tak</button>
    </p>
</form>
</body>
</html>