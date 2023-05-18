/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AlunoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;

/**
 *
 * @author sala303b
 */
public class AlunoServlet extends HttpServlet {

    // Variaveis globais
    private String acao, abrir;
    private final String cadastrar = "cadastrar_aluno.jsp";
    private final String editar = "editar_aluno.jsp";
    private final String listar = "listar_alunos.jsp";
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
            /* TODO output your page her e. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AlunoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlunoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
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
        AlunoDAO dao = new AlunoDAO();

        if (acao.equals("listar")) {

            abrir = listar;
            request.setAttribute("alunos", dao.read());
        } else if (acao.equals("editar")) {
            int idAluno = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("aluno", dao.findId(idAluno));
            abrir = editar;
        }

        RequestDispatcher visualizar = request.getRequestDispatcher(abrir);
        visualizar.forward(request, response);

        //processRequest(request, response);    
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

            Aluno aluno = new Aluno();

            aluno.setNome(request.getParameter("txtNome"));
            aluno.setEmail(request.getParameter("txtEmail"));
            aluno.setIdade(Integer.parseInt(request.getParameter("txtIdade")));
            aluno.setTelefone(request.getParameter("txtTelefone"));

            AlunoDAO dao = new AlunoDAO();

            if (dao.create(aluno)) {
                abrir = sucesso;
                request.setAttribute("msg", "Uhull... Aluno cadastrado com sucesso!");
            } else {
                abrir = erro;
                request.setAttribute("msg", "Ops... Erro ao cadastrar Aluno!");
            }
        } else if (acao.equals("editar")) {

            Aluno alu = new Aluno();

            alu.setIdAluno(Integer.parseInt(request.getParameter("txtId")));
            alu.setNome(request.getParameter("txtNome"));
            alu.setEmail(request.getParameter("txtEmail"));
            alu.setIdade(Integer.parseInt(request.getParameter("txtIdade")));
            alu.setTelefone(request.getParameter("txtTelefone"));

            AlunoDAO dao = new AlunoDAO();

            if (dao.update(alu)) {
                abrir = listar;
                request.setAttribute("alunos", dao.read());
            } else {
                abrir = erro;
                request.setAttribute("msg", "Ops... Erro ao atualizar Aluno!");

            }

            RequestDispatcher visualizar = request.getRequestDispatcher(abrir);
            visualizar.forward(request, response);

        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
    }

    }
