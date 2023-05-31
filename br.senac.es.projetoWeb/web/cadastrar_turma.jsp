<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <%@include file="menu.jsp" %>

        <div class="container bg-light ">
            <div class="mt-4 p-5 bg-primary text-white rounded">
                <h1>.: Cadastro de turma</h1>
            </div>

            <form action="turma" method="POST">
                <div class="mb-3 mt-3">
                    <label for="txtCodigo" class="form-label">Código(nome):</label>
                    <input type="text" class="form-control" id="codigo" placeholder="Entre com o codigo(nome)" name="txtCodigo">
                </div>
                <div class="mb-3 mt-3">
                    <label for="txtSala" class="form-label">Sala:</label>
                    <input type="text" class="form-control" id="sala" placeholder="Entre com a sala" name="txtSala">
                </div>
                <div class="mb-3 mt-3">
                    <label for="txtTurno" class="form-label">Turno:</label>
                    <input type="text" class="form-control" id="turno" placeholder="Entre com o turno" name="txtTurno">
                </div>
                <div class="mb-3 mt-3">
                    <label for="txtIdAluno" class="form-label">Curso</label>
                    <select>
                        <c:forEach items="${curso}" var="curso">
                            <option value="${curso.idCurso}">${curso.nome}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3 mt-3"> 
                    <label for="txtIdTurma" class="form-label">Professor:</label>
                    <select>
                        <c:forEach items="${professor}" var="pro">
                            <option value="${pro.idProfessor}">${pro.nome}</option>
                        </c:forEach>
                    </select>

                </div>
                <div class="mb-3">
                    <label for="txtStatus" class="form-label">Status</label>
                    <select>
                        <option value="a">Ativa</option>
                        <option value="d">Desativada</option>
                    </select>
                </div>

                <div class="mb-5 mt-3 d-flex">
                    <div class="me-5">
                        <label for="txtInicio" class="form-label">Data de inicio:</label>
                        <input type="date" class="form-control" id="dataInicio" name="txtInicio">
                    </div>
                    <div>
                        <label for="txtTermino" class="form-label">Data de termino:</label>
                        <input type="date" class="form-control" id="dataTermino" name="txtTermino">
                    </div>
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
