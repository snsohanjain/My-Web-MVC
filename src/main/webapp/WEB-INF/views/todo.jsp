
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Todo</title>
</head>
<body>
<%@include file="common/navigation.jspf"%>
<div class="container">
    <form:form method="post" commandName="todo">
        <form:hidden path="id"/>
        <fieldset class="form-group">
            <form:label path="desc">Description</form:label>
            <form:input path="desc" type="text" class="form-control"
                        required="required"/>
            <form:errors path="desc" cssClass="text-warning" />
        </fieldset>
        <fieldset class="form-group">
            <form:label path="targetDate">Target Date</form:label>
            <form:input path="targetDate" type="text" class="form-control"
                        required="required"/>
            <form:errors path="targetDate" cssClass="text-warning" />
        </fieldset>

        <button type="submit" class="btn btn-success">Add</button>
    </form:form>
</div>

</body>
</html>
