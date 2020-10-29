<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <link rel="stylesheet" type="text/css"
<%--the proper app name in curly braces--%>
          href="${pageContext.request.contextPath}/resources/css/style.css">
    <title>
        List Customers
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
        <input type="button" value="Add Customer"
        onclick="window.location.href = 'showFormForAdd'; return false"
        class="add-button">
    </div>

    <div id = "content2">
        <!--  add a search box -->
        <form:form action="search" method="GET">
            Search customer: <input type="text" name="theSearchName" />

            <input type="submit" value="Search" class="add-button" />
        </form:form>
    </div>

</div>


<table>
    <tr>
        <th>#</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>File</th>
        <th></th>
    </tr>

    <c:forEach var="customer" items="${customerList}">

<%--        construct an update link with customer id--%>
        <c:url var="updateLink" value="/customer/showFormUpdateCustomer">
            <c:param name="customerId" value="${customer.id}"/>
        </c:url>

        <c:url var="deleteLink" value="/customer/delete">
            <c:param name="customerId" value="${customer.id}"/>
        </c:url>

        <tr>
        <td>${customer.id}</td>
        <td>${customer.firstName}</td>
        <td>${customer.lastName}</td>
        <td>${customer.email}</td>
        <td>${customer.photo}</td>
        <td>
<%--            display the update link--%>
    <a href="${updateLink}">Update</a>
    |
    <a href="${deleteLink}"
       onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
        </td>
        </tr>
    </c:forEach>
</table>

</body>

</html>



<%--    <div id = "content1">--%>
<%--        Order by:--%>
<%--        <br>--%>
<%--        <form:form action="listCustomers" modelAttribute="customer">--%>
<%--&lt;%&ndash;        <form:form action="listCustomers" modelAttribute="customerService">&ndash;%&gt;--%>

<%--                <form:select path="orderBy">--%>
<%--&lt;%&ndash;            <form:options items="${orderByOptions}" />&ndash;%&gt;--%>
<%--            <form:options items="${orderByOptions}" />--%>
<%--        </form:select>--%>

<%--&lt;%&ndash;            <form:select path="orderBy" onchange="location.reload()">&ndash;%&gt;--%>
<%--&lt;%&ndash;                <form:options items="${orderByOptions}" />&ndash;%&gt;--%>
<%--&lt;%&ndash;            </form:select>&ndash;%&gt;--%>

<%--        </form:form>--%>
<%--        <br>--%>
<%--    </div>--%>