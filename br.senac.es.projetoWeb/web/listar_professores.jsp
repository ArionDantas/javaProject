<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SISPROWEB - Listar Professor</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <%@include file="./menu.jsp" %>

        <div class="container">


            <div class="mt-4 p-5 bg-primary text-white rounded">
                <h1>.: Listagem de Professores</h1>
            </div>


            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOME</th>
                        <th>AREA</th>
                        <th>TELEFONE</th>
                        <th>EMAIL</th>
                        <th>FORMACAO</th>
                        <th>AÇÃO</th>
                    </tr>
                </thead>

                <tbody>

                    <c:forEach items="${professor}" var="pro">
                        <tr>
                            <td>${pro.idProfessor}</td>
                            <td>${pro.nome}</td>
                            <td>${pro.area}</td>
                            <td>${pro.telefone}</td>
                            <td>${pro.email}</td>
                            <td>${pro.formacao}</td>
                            <td>
                                <a href="professor?acao=editar&id=${pro.idProfessor}" class="btn btn-warning">Editar</a>
                                <a href="professor?acao=apagar&id=${pro.idProfessor}" class="btn btn-danger">Apagar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>

    </body>
</html>
