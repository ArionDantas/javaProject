<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SISPROWEB - Listar Alunos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <%@include file="./menu.jsp" %>

        <div class="container">
            <div class="mt-4 p-5 bg-primary text-white rounded">
                <h1>.: Listagem de Alunos</h1>
            </div>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOME</th>
                        <th>EMAIL</th>
                        <th>TELEFONE</th>
                        <th>IDADE</th>
                        <th>AÇÃO</th>
                    </tr>
                </thead>

                <tbody>

                    <c:forEach items="${alunos}" var="alu">
                        <tr>
                            <td>${alu.idAluno}</td>
                            <td>${alu.nome}</td>
                            <td>${alu.email}</td>
                            <td>${alu.telefone}</td>
                            <td>${alu.idade}</td>
                            <td>
                                <a href="aluno?acao=editar&id=${alu.idAluno}" class="btn btn-warning">Editar</a>
                                <a class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">Apagar</a>
                                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">Exclusão de usuário</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                Deseja realmente excluir usuário?
                                            </div>
                                            <div class="modal-footer">
                                                <a href="aluno?acao=apagar&id=${alu.idAluno}" class="btn btn-primary">Sim</a>
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
