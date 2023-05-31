<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SISPRO - Cadastrar matricula</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <%@include file="menu.jsp"%>

        <div class="container bg-light ">
            <div class="mt-4 p-5 bg-primary text-white rounded">
                <h1>.: Cadastro de matricula</h1>
            </div>

            <form action="matricula" method="POST">
                <div class="mb-3 mt-3">
                    <label for="txtIdAluno" class="form-label">Nome do aluno</label>
                    <select>
                        <c:forEach items="${aluno}" var="alu">
                            <option value="${alu.idAluno}">${alu.nome}</option>
                        </c:forEach>
                    </select>
                    
                </div>
                <div class="mb-3 mt-3"> 
                    <label for="txtIdTurma" class="form-label">Turma:</label>
                    <select>
                        <c:forEach items="${turma}" var="turma">
                            <option value="${turma.idTurma}">${turma.codigo}</option>
                        </c:forEach>
                    </select>

                </div>
                <div class="mb-3">
                    <label for="txtValor" class="form-label">Valor:</label>
                    <input type="text" class="form-control" id="valor" placeholder="Enter cell" name="txtValor">
                </div>
                <div class="mb-3">
                    <input type="hidden" value="cadastrar" name="acao">
                </div> 
                <button type="submit" class="btn btn-primary">Enviar dados</button>
                <button type="reset" class="btn btn-danger">Limpar dados</button>
            </form>
        </div>
    </body>
</html>
