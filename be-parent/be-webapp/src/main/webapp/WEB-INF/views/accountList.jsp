<!DOCTYPE html>
<%@include file="taglib.jsp" %>

<html>
<head>
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <%@ include file="deletion.jspf" %>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <title>Account Table</title>
</head>
<body>

<div class="col-sm-offset-1 col-sm-10">

    <legend>
        <spring:message code="table.account.title"/>
    </legend>

    <div id="accountFromResponse" style="color: green;"></div>
    <div>
        <table id="dataTable" class="table table-striped table-bordered">
            <thead>
            <tr>
                <%--<th><spring:message code="table.account.id"/></th>--%>
                <th><spring:message code="table.account.iban"/></th>
                <th><spring:message code="table.account.bic"/></th>
                <th></th>

            </tr>
            <thead>
            <tbody>
            <c:forEach var="acc" items="${accountsModel}">
            <tr>
                    <%--<td>${u.id}</td>--%>
                <td>${acc.iban}</td>
                <td>${acc.bic}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/accounts/delete/${acc.id}">Delete</a>
                    <a href="${pageContext.request.contextPath}/accounts/edit/${acc.id}">Edit</a><br/>

                </td>
            <tr>
            </c:forEach>
        </tbody>
        </table>
    </div>
    <a href="/accounts/add">Add account</a>
</div>
</body>
</html>