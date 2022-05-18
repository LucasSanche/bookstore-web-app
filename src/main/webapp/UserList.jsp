<%-- 
    Document   : UserList
    Created on : 4 de mai de 2022, 08:51:20
    Author     : devsys-b
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
   <head>
        <jsp:include page="styles.jsp"/>
        <jsp:include page="Contents/headerTags.jsp"/>
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

            <jsp:include page="./Contents/headerUser.jsp"/>




            <div class="table-responsive"> 
                
                <table class="table"
                    <caption><h2>List of Users</h2></caption>
                    <tr>
                        <th>ID</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th>FullName</th>
                        <th>Ações</th>
                    </tr>

                    <c:forEach var="user" items="${listaUser}">
                        <tr>
                            <td><c:out value="${user.id}" /></td>
                            <td><c:out value="${user.email}" /></td>
                            <td><c:out value="${user.password}" /></td>
                            <td><c:out value="${user.fullName}" /></td>
                            <td>
                                <a href="<%=request.getContextPath()%>/bsuser/edit?id=<c:out 
                                       value='${user.id}' />">
                                    <span id="pencil" class="glyphicon glyphicon-pencil"></span>
                                </a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="<%=request.getContextPath()%>/bsuser/delete?id=<c:out value='${user.id}' />">
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
