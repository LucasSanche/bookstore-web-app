<%-- 
    Document   : UserForm
    Created on : 4 de mai de 2022, 08:51:33
    Author     : devsys-b
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="styles.jsp"/>


        <jsp:include page="./Contents/headerTags.jsp"/>
        <title>Aplicação Books Store</title>
        
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





            <div align="left">
                <c:if test="${userForm != null}">
                    <form action="update" method="post">
                    </c:if>
                    <c:if test="${userForm == null}">
                        <form action="insert" method="post">
                        </c:if>

                        <div class="table-responsive"> 
                            <table class="table"
                                   <caption>
                                <h2>
                                    <c:if test="${userForm != null}">
                                        Editar Usuário
                                    </c:if>
                                    <c:if test="${userForm == null}">
                                        Adicionar novo Usuário
                                    </c:if>
                                </h2>
                                </caption>
                                <c:if test="${userForm != null}">
                                    <input type="hidden" name="formId" value="<c:out 
                                               value='${userForm.id}' />" />
                                </c:if> 
                                <tr>
                                    <th>Email: </th>
                                    <td>
                                        <input type="text" name="formEmail" size="45"
                                               value="<c:out value='${userForm.email}' />"
                                               />
                                    </td>
                                </tr>
                                <tr>
                                    <th>Password: </th>
                                    <td>
                                        <input type="text" name="formPassword" size="45"
                                               value="<c:out value='${userForm.password}' />"
                                               />
                                    </td>
                                </tr>
                                <tr>
                                    <th>FullName: </th>
                                    <td>
                                        <input type="text" name="formFullName" size="45"
                                               value="<c:out value='${userForm.fullName}' />"
                                               />
                                    </td>
                                </tr>
                                <tr>
                                    <td id="enviar" colspan="2" align="center">
                                        <input  type="submit" value="Enviar" />
                                    </td>
                                </tr>
                            </table>
                    </form>
            </div> 
        </div> 
        <jsp:include page="./Contents/rodape.jsp"/>
    </div>
</body>
</html>
