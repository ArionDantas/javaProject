package controller;

import dao.CursoDAO;
import dao.ProfessorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TurmaServlet extends HttpServlet {

    ProfessorDAO daoTurma = new ProfessorDAO();
    CursoDAO daoCurso = new CursoDAO();
    private String acao, abrir;
    private final String cadastrar = "cadastrar_turma.jsp";
    private final String editar = "editar_matricula.jsp";
    private final String listar = "listar_matriculas.jsp";
    private final String sucesso = "sucesso.jsp";
    private final String erro = "erro.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        acao = request.getParameter("acao");

        if (acao.equals("cad_turma")) {
            request.setAttribute("curso", daoCurso.read());
            request.setAttribute("turma", daoTurma.read());
            abrir = cadastrar;
        }

        RequestDispatcher visualizar = request.getRequestDispatcher(abrir);
        visualizar.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
