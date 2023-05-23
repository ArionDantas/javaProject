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
                                <a class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal${pro.idProfessor}">Apagar</a>
                                <div class="modal fade" id="exampleModal${pro.idProfessor}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">Exclusão de professor</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                Deseja realmente excluir usuário?
                                            </div>
                                            <div class="modal-footer">
                                                <a href="professor?acao=apagar&id=${pro.idProfessor}" class="btn btn-primary">Sim</a>
                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Não</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>

    </body>
</html>
