<%-- 
    Document   : BookList
    Created on : 20 de abr de 2022, 09:44:17
    Author     : devsys-b
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" 
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html> 
<html>
    <head>
        <jsp:include page="styles.jsp"/>
        <jsp:include page="./Contents/headerTags.jsp"/>
        <title>Aplicação BookStoreWeb</title>
        
        <style>
    
    body{
        background-color: #BAB1A9;
    }
      
</style>
        
        
        
    </head>
    <body>
        <div id="NomeUser">
       <p>Usuário logado: <c:out value="${user.fullName}" /></p>
        </div>
        <div class="container">

            <jsp:include page="./Contents/cabecalho.jsp"/>




            <div class="table-responsive"> 
                
                <table class="table"
                    <caption><h2>List of Books</h2></caption>
                    <tr>
                        <th>ID</th>
                        <th>Titulo</th>
                        <th>Autor</th>
                        <th>Preco</th>
                        <th>Ações</th>
                    </tr>

                    <c:forEach var="book" items="${listaBook}">
                        <tr>
                            <td><c:out value="${book.id}" /></td>
                            <td><c:out value="${book.titulo}" /></td>
                            <td><c:out value="${book.autor}" /></td>
                            <td><c:out value="${book.preco}" /></td>
                            <td>
                                <a href="<%=request.getContextPath()%>/bstore/edit?id=<c:out 
                                       value='${book.id}' />">
                                    <span id="pencil" class="glyphicon glyphicon-pencil"></span>
                                </a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="<%=request.getContextPath()%>/bstore/delete?id=<c:out value='${book.id}' />">
                                    <span id="trash" class="glyphicon glyphicon-trash"></span>
                                </a>

                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <jsp:include page="./Contents/rodape.jsp"/>

        </div>
    </body>
</html>
