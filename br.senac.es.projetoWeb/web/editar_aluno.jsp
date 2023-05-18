<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Aluno</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>

    </head>
    <body>

        <%@include file="menu.jsp"%>

        <div class="container bg-light ">

            <div class="mt-4 p-5 bg-primary text-white rounded">
                <h1>.: Editar Aluno</h1>
            </div>


            <form action="aluno" method="POST">
                <div class="mb-3 mt-3">
                    <label for="txtNome" class="form-label">Nome:</label>
                    <input type="text" class="form-control" id="nome" placeholder="Enter nome" name="txtNome" value="${aluno.nome}" required>
                </div>
                <div class="mb-3 mt-3">
                    <label for="txtEmail" class="form-label">E-mail:</label>
                    <input type="text" class="form-control" id="email" placeholder="Enter email" name="txtEmail" value="${aluno.email}">
                </div>
                <div class="mb-3">
                    <label for="txtTelefone" class="form-label">Telefone:</label>
                    <input type="text" class="form-control" id="telefone" placeholder="Enter cell" name="txtTelefone" value="${aluno.telefone}">
                </div>
                <div class="mb-3">
                    <label for="txtIdade" class="form-label">Idade:</label>
                    <input type="number" min="0" class="form-control" id="idade" placeholder="Enter old" name="txtIdade" value="${aluno.idade}" required>
                </div>
                <div class="mb-3">
                    <input value="${aluno.idAluno}" type="hidden" name="txtId">
                </div> 
                <div class="mb-3">
                    <input type="hidden" value="editar" name="acao">
                </div> 
                <button type="submit" class="btn btn-primary">Atualizar dados</button>
                <button type="reset" class="btn btn-danger">Limpar dados</button>
            </form>
        </div>
    </body>
</html>
