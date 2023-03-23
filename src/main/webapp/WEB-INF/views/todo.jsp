<%--
  Created by IntelliJ IDEA.
  User: Developer
  Date: 3/22/2023
  Time: 3:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Todo</title>
</head>
<body>
<div class="container">

    <form:form method="post" commandName="todo">
        <fieldset class="form-group">
            <form:label path="desc">Description</form:label>
            <form:input path="desc" type="text" class="form-control"
                        required="required"/>
            <form:errors path="desc" cssClass="text-warning" />

        </fieldset>
        <button type="submit" class="btn btn-success">Add</button>
    </form:form>
</div>

</body>
</html>
