<nav class="navbar navbar-expand-lg bg-dark " data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Secretaria</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="./turma?acao=cad_turma">Cadastrar turma</a></li>
                        <li><a class="dropdown-item" href="#">Listar turma</a></li>
                        <li><a class="dropdown-item" href="#">Cadastrar curso</a></li>
                        <li><a class="dropdown-item" href="#">Listar curso</a></li>
                        <li><a class="dropdown-item" href="./matricula?acao=cad_matricula">Cadastrar matrícula</a></li>
                        <li><a class="dropdown-item" href="#">Listar matrícula</a></li>
                    </ul>
                </li>
                </li>
                <li class="nav-item">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Pedagógico</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="./cadastrar_aluno.jsp">Cadastrar aluno</a></li>
                        <li><a class="dropdown-item" href="./aluno?acao=listar">Listar aluno</a></li>
                        <li><a class="dropdown-item" href="./cadastrar_professor.jsp">Cadastrar professor</a></li>
                        <li><a class="dropdown-item" href="./professor?acao=listar">Listar professor</a></li>
                    </ul>
                </li>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Pessoal</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">RH</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Financeiro</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
