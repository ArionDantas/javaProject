/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProfessorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Professor;

/**
 *
 * @author sala303b
 */
public class ProfessorServlet extends HttpServlet {

    private String acao, abrir;
    private final String cadastrar = "cadastrar_professor.jsp";
    private final String editar = "editar_professor.jsp";
    private final String listar = "listar_professores.jsp";
    private final String sucesso = "sucesso.jsp";
    private final String erro = "erro.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProfessorServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfessorServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        acao = request.getParameter("acao");

        ProfessorDAO dao = new ProfessorDAO();

        if (acao.equals("listar")) {

            request.setAttribute("professor", dao.read());
            abrir = listar;

        } else if (acao.equals("editar")) {
            int idProfessor = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("professor", dao.findId(idProfessor));
            abrir = editar;

            //processRequest(request, response);
        } else if (acao.equals("apagar")) {
            int idProfessor = Integer.parseInt(request.getParameter("id"));
            if (dao.delete(idProfessor)) {
                abrir = sucesso;
                request.setAttribute("msg", "Professor excluído com sucesso!");
            } else {
                abrir = erro;
                request.setAttribute("msg", "Erro ao tentar excluir Professor!");
            }
        }

        RequestDispatcher visualizar = request.getRequestDispatcher(abrir);
        visualizar.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        acao = request.getParameter("acao");

        if (acao.equals("cadastrar")) {

            Professor professor = new Professor();

            professor.setNome(request.getParameter("txtNome"));
            professor.setEmail(request.getParameter("txtEmail"));
            professor.setArea((request.getParameter("txtArea")));
            professor.setTelefone(request.getParameter("txtTelefone"));
            professor.setFormacao(request.getParameter("txtFormacao"));

            System.out.println(professor.toString());

            ProfessorDAO dao = new ProfessorDAO();

            if (dao.create(professor)) {
                abrir = sucesso;
                request.setAttribute("msg", "Uhull... Professor cadastrado com sucesso!");
            } else {
                abrir = erro;
                request.setAttribute("msg", "Ops... Erro ao cadastrar Professor!");
            }
        } else if (acao.equals("editar")) {

            Professor pro = new Professor();

            pro.setIdProfessor(Integer.parseInt(request.getParameter("idTxt")));
            pro.setNome(request.getParameter("txtNome"));
            pro.setEmail(request.getParameter("txtEmail"));
            pro.setArea(request.getParameter("txtArea"));
            pro.setTelefone(request.getParameter("txtTelefone"));
            pro.setFormacao(request.getParameter("txtFormacao"));

            ProfessorDAO dao = new ProfessorDAO();

            if (dao.update(pro)) {
                abrir = listar;
                request.setAttribute("professor", dao.read());
            } else {
                abrir = erro;
                request.setAttribute("msg", "Ops... Erro ao atualizar professoe!");
            }

        }

        RequestDispatcher visualizar = request.getRequestDispatcher(abrir);
        visualizar.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
