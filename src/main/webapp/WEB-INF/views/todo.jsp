<%--
  Created by IntelliJ IDEA.
  User: Developer
  Date: 3/22/2023
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo</title>
</head>
<body>
<h1>ADD TODO</h1>
<form action="/add-todo" METHOD="post">
    <input name="desc"  required="required" type="text"/>
    <input type="submit" value="Add">
</form>
</body>
</html>
