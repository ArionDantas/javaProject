package controller;

import dao.CursoDAO;
import dao.ProfessorDAO;
import dao.TurmaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Turma;

public class TurmaServlet extends HttpServlet {

    ProfessorDAO daoProfessor = new ProfessorDAO();
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
            request.setAttribute("professor", daoProfessor.read());
            abrir = cadastrar;
        }

        RequestDispatcher visualizar = request.getRequestDispatcher(abrir);
        visualizar.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        acao = request.getParameter("acao");

        if (acao.equals("cadastrar")) {

            Turma turma = new Turma();

            turma.setCodigo(request.getParameter("txtCodigo"));
            turma.setSala(request.getParameter("txtSala"));
            turma.setTurno(request.getParameter("txtTurno"));
            turma.setStatus(request.getParameter("txtStatus"));
            turma.setIdCurso(Integer.parseInt(request.getParameter("txtCursoId")));
            turma.setIdProfessor(Integer.parseInt(request.getParameter("txtIdProfessor")));

            try {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

                String dataI = request.getParameter("txtInicio");
                String dataT = request.getParameter("txtTermino");

                Date dataInicio = formato.parse(dataI);
                Date dataTermino = formato.parse(dataT);

                turma.setInicio(dataInicio);
                turma.setFim(dataTermino);
            } catch (ParseException e) {
                System.out.println("erro aqui =>" + e);
            }

            TurmaDAO dao = new TurmaDAO();

            if (dao.create(turma)) {
                abrir = sucesso;
                request.setAttribute("msg", "Uhull... Aluno cadastrado com sucesso!");
            } else {
                abrir = erro;
                request.setAttribute("msg", "Ops... Erro ao cadastrar Aluno!");
            }
            RequestDispatcher visualizar = request.getRequestDispatcher(abrir);
            visualizar.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
