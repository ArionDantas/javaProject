package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Matricula;

public class MatriculaServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");;;;
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MatriculaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MatriculaServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>"); */
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        acao = request.getParameter("acao");
        
        if (acao.equals("cadastrar")) {
            
            Matricula mat = new Matricula();
            
            mat.setIdAluno(Integer.parseInt(request.getParameter("txtIdAluno")));
            mat.setIdTurma(Integer.parseInt(request.getParameter("txtIdTurma")));
            mat.setValor(Double.parseDouble(request.getParameter("txtValor")));
            mat.setData();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
