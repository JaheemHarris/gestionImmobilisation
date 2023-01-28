<%-- 
    Document   : test
    Created on : May 24, 2022, 12:56:45 PM
    Author     : jaheem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Article</h1>
        <form method="POST" action="article">
            <input type="text" name="idArticle" />
            <input type="text" name="idTypeAmmortissement" />
            <input type="number" name="prixAcquisition" />
            <input type="number" name="dureeAmmortissement" />
            <input type="submit" value="Ok" />
        </form>
    </body>
</html>
