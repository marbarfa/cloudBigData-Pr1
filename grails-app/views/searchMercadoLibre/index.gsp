<%@ page import="cloudbigdata.pr1.SearchMercadoLibreController" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>

<body>
<g:form>
    <div id="status" style="text-align: center">
        <h1>Search in MercadoLibre:</h1><g:field type="string" name="query"/>
    <g:actionSubmit action="index" value="Buscar!"/>
    </div>

    <div id="content_info" style="text-align: center">
        <g:if test="${itemsList != null}">
                <h1>Items:</h1>
                <table>
                    <g:each in="${itemsList}" var="item">

                        <tr onclick="<g:remoteFunction controller='searchMercadoLibre' action='getVIPPage'
                                                       id='${item.id}' method='get' update="content_info"/>">
                            <td><g:img uri="${item.thumbnail}"/></td>
                            <td>${item.title}</td>
                            <td>$ ${item.price}</td>
                        </tr>
                    </g:each>
                </table>
        </g:if>
        <g:if test="${item != null}">
                <table>
                    <tr>
                        <td><g:img uri="${item.pictures[0].url}"/></td>
                    </tr>
                    <tr>
                        <td>Titulo</td>
                        <td>${item.title}</td>
                    </tr>
                    <tr>
                        <td>Precio</td>
                        <td>${item.price}</td>
                    </tr>
                    <tr>
                        <td>Vendidos</td>
                        <td>${item.sold_quantity}</td>
                    </tr>
                    <tr>
                        <td>Disponibles</td>
                        <td>${item.available_quantity}</td>
                    </tr>
                </table>
        </g:if>
    </div>
</g:form>
</body>
</html>
