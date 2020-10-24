<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add new customer form</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/add-customer-style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relation Manager</h2>
        </div>
    </div>

    <div id="container">
        <h3>Add Customer</h3>
        <form:form action="addCustomer" modelAttribute="customer" method="POST">
            <form:hidden path="id" />
            <table>
                <tbody>
                <tr>
                    <td><lable>First name:</lable></td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td><lable>Last name:</lable></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td><lable>Email:</lable></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><lable></lable></td>
                    <td><input type="submit" value="Save" class="save" /></td>
                </tr>
                </tbody>
            </table>
        </form:form>
        <div style="clear; both;"></div>
        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
        </p>
    </div>
</body>
</html>
