package controller;

import dao.AlunoDAO;
import dao.MatriculaDAO;
import dao.TurmaDAO;
import model.Matricula;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MatriculaServlet extends HttpServlet {

    TurmaDAO daoTurma = new TurmaDAO();
    AlunoDAO daoAluno = new AlunoDAO();
    private String acao, abrir;
    private final String cadastrar = "cadastrar_matricula.jsp";
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

        if (acao.equals("cad_matricula")) {
            request.setAttribute("aluno", daoAluno.read());
            request.setAttribute("turma", daoTurma.read());
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

            Matricula mat = new Matricula();
            Date d = new Date();

            mat.setIdAluno(Integer.parseInt(request.getParameter("txtIdAluno")));
            mat.setIdTurma(Integer.parseInt(request.getParameter("txtIdTurma")));
            mat.setValor(Double.parseDouble(request.getParameter("txtValor")));
            mat.setData(d);

            MatriculaDAO dao = new MatriculaDAO();
//            System.out.println("dao: " + dao);

            if (dao.create(mat)) {
                abrir = sucesso;
                request.setAttribute("msg", "Uhull... Matricula cadastrado com sucesso!");
            } else {
                abrir = erro;
                request.setAttribute("msg", "Ops... Erro ao cadastrar Aluno!");
            }
            System.out.println("2: ");

        }

        RequestDispatcher visualizar = request.getRequestDispatcher(abrir);
        visualizar.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
