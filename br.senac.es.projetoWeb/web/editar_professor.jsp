<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de professor</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>

    </head>
    <body>

        <%@include file="menu.jsp"%>

        <div class="container bg-light ">
            <div class="mt-4 p-5 bg-primary text-white rounded">
                <h1>.: Cadastro de professor</h1>
            </div>

            <form action="professor" method="POST">
                <div class="mb-3 mt-3">
                    <label for="txtNome" class="form-label">Nome:</label>
                    <input value="${professor.nome}" type="text" class="form-control" id="nome" placeholder="Enter nome" name="txtNome" required>
                </div>                
                <div class="mb-3 mt-3">
                    <label for="txtArea" class="form-label">Área:</label>
                    <input value="${professor.area}" type="text" class="form-control" id="area" placeholder="Enter area" name="txtArea" required> 
                </div>
                <div class="mb-3 mt-3">
                    <label for="txtEmail" class="form-label">E-mail:</label>
                    <input value="${professor.email}" type="text" class="form-control" id="email" placeholder="Enter email" name="txtEmail" required>
                </div>
                <div class="mb-3">
                    <label for="txtTelefone" class="form-label">Telefone:</label>
                    <input value="${professor.telefone}" type="text" class="form-control" id="telefone" placeholder="Enter cell" name="txtTelefone">
                </div>
                <div class="mb-3">
                    <label for="txtFormacao" class="form-label">Formação:</label>
                    <input value="${professor.formacao}" type="text" class="form-control" id="formacao" placeholder="Enter formação" name="txtFormacao" required>
                </div>
                <div class="mb-3">
                    <input type="hidden" value="${professor.idProfessor}" name="idTxt">
                </div> 
                <div class="mb-3">
                    <input type="hidden" value="editar" name="acao">
                </div> 
                <button type="submit" class="btn btn-primary">Enviar dados</button>
                <button type="reset" class="btn btn-warning">Limpar dados</button>
            </form>
        </div>
    </body>
</html>

