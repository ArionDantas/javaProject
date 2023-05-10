package controller;

import dao.alunoDAO;
import model.Aluno;

public class Teste {
    public static void main(String[] args) {
       Aluno alu = new Aluno();
       alu.setNome("Americano Luiz");
       alu.setEmail("americanoluiz@gmail.com");
       alu.setTelefone("(27)3200-4040");
       alu.setIdade(20);
       alu.setIdAluno(2);
       
        alunoDAO dao = new alunoDAO();
        if (dao.delete(3)) {
            System.out.println("Ebaa! Aluno excluído com sucesso!");
        } else {
            System.out.println("Ops! Erro ao cadastrar aluno.");
        }
    }
}
