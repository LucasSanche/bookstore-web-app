<%-- 
    Document   : cabecalho
    Created on : 25 de abr de 2022, 13:50:47
    Author     : KGe
--%>

<!-- Inicio cabecalho-->
<div id="header" class="jumbotron"><h1>BookStoreWeb</h1></div>





<p>
    <a href="<%=request.getContextPath()%>/bstore/new" id="btnAdicionar" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus"></span>Adicionar novo Livro</a>

        <a href="<%=request.getContextPath()%>/bstore/list" id="btnListar"class="btn btn-default">
        <span class="glyphicon glyphicon-th-list"></span>
        Lista todos Livros</a>
        
        
        <a href="<%=request.getContextPath()%>/bsuser/list" id="btnListar"class="btn btn-default">
        <span class="glyphicon glyphicon-th-list"></span>
        Lista de Usuários</a>
        
        
        <a href="<%=request.getContextPath()%>/logout" id="btnSair" class="btn btn-default">
        <span class="	glyphicon glyphicon-off"></span>

        Sair</a>
</p>

<!-- Fim cabecalho-->
