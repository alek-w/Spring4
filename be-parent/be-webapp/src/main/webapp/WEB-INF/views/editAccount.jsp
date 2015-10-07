<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Edit</title>
    <link href="${pageContext.request.contextPath}/resources/stylesheets/styles.css" rel="stylesheet" type="text/css"/>
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <%@ include file="editing.jspf" %>


</head>
<body>
<div id="container">
    <h1>Edit Account</h1>

    <div id="aAccountFromResponse" style="color: green;">

    </div>
    <form:form id="editAccountForm" method="PUT" commandName="acc"
               action="${pageContext.request.contextPath}/accounts/edit/${acc.id}">
        <table>
            <tbody>
            <tr>
                <td>International Bank Account Number:</td>
                <td><form:input path="iban"/></td>
            </tr>
            <tr>
                <td>Business Identifier Code:</td>
                <td><form:input path="bic"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Save"/></td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <a href="/accounts/list">Show All</a>

</div>
</body>
</html>
