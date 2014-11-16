<%--
  Created by IntelliJ IDEA.
  User: mbarreto
  Date: 11/13/14
  Time: 12:35 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>VIP</title>
    <style type="text/css" >
        table.VIP_TR {text-align: center}
    </style>
</head>

<body>
<div id="status" style="text-align: center">
    <table>
        <tr class="VIP_TR">
            <td><g:img uri="${item.pictures[0].url}"/></td>
        </tr>
        <tr class="VIP_TR">
            <td>Titulo</td>
            <td>${item.title}</td>
        </tr>
        <tr class="VIP_TR">
            <td>Precio</td>
            <td>${item.price}</td>
        </tr>
        <tr class="VIP_TR">
            <td>Vendidos</td>
            <td>${item.sold_quantity}</td>
        </tr>
        <tr class="VIP_TR">
            <td>Disponibles</td>
            <td>${item.available_quantity}</td>
        </tr>
    </table>
</div>
</body>
</html>