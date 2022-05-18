<%-- 
    Document   : headerUser
    Created on : 18 de mai de 2022, 08:20:17
    Author     : devsys-b
--%>

<!-- Inicio cabecalho-->
<div id="header" class="jumbotron"><h1>BookStoreWeb</h1></div>





<p>
    <a href="<%=request.getContextPath()%>/bsuser/new" id="btnAdicionar" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus"></span>Adicionar novo Usuário</a>

        <a href="<%=request.getContextPath()%>/bsuser/list" id="btnListar"class="btn btn-default">
        <span class="glyphicon glyphicon-th-list"></span>
        Lista todos Usuários</a>
        
        
        <a href="<%=request.getContextPath()%>/bstore/list" id="btnSair" class="btn btn-default">
        <span class="	glyphicon glyphicon-off"></span>

        Voltar para lista de livros</a>
</p>

<!-- Fim cabecalho-->

