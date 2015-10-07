<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add Entities</title>
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        function doAjaxPost() {
            var iban = $('#iban').val();
            var bic = $('#bic').val();

            $.ajax({
                type: "POST",
                url: "/accounts/add",
                data: "iban=" + iban + "&bic=" + bic,
                success: function (response) {
                    $('#info').html(response);
                    $('#iban').val('');
                    $('#bic').val('');
                },
                error: function (e) {
                    alert('Error: ' + e);
                }
            });
        }
    </script>
</head>
<body>
<h1>Add entity</h1>
<table>
    <tr>
        <td>International Bank Account Number :</td>
        <td><input type="text" id="iban" title="bic"><br/></td>
    </tr>
    <tr>
        <td>Business Identifier Code :</td>
        <td><input type="text" id="bic" title="iban"><br/></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="button" value="Add" onclick="doAjaxPost()">
            <br/></td>
    </tr>
    <tr>
        <td colspan="2">
            <div id="info" style="color: green;"></div>
        </td>
    </tr>
</table>
<a href="<c:url value="/accounts/list"/>">Show All</a>
</body>
</html>
