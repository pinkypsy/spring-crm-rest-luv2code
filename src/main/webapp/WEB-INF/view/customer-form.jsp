<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

    <link rel="stylesheet" type="text/css"
    <%--the proper app name in curly braces--%>
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link rel="stylesheet" type="text/css"
    <%--the proper app name in curly braces--%>
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

    <title>
        Manage Customer
    </title>
</head>
<body>

<div id = "wrapper">
    <div id = "header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id = "container">
    <div id = "content">

        <form:form action="saveCustomer" modelAttribute="customer" method="POST">

            <%--            associate data below with customer--%>
        <form:hidden path="id"/>

            <table>
                <tbody>

                <tr>
                    <td><label>First name:</label></td>
                    <td><form:input path="firstName"/></td>
                </tr>

                <tr>
                    <td><label>Last name:</label></td>
                    <td><form:input path="lastName"/></td>
                </tr>

                <tr>
                    <td><label>Email:</label></td>
                    <td><form:input path="email"/></td>
                </tr>

                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>

                </tbody>
            </table>

        </form:form>

    </div>
</div>

<a href="/customer/list">Back</a>

</body>
</html>