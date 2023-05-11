package controller;

import model.Aluno;
import dao.alunoDAO;

public class Teste {

    public static void main(String[] args) {

//       Aluno alu = new Aluno();;
//       alu.setNome("Americano Luiz");
//       alu.setEmail("americanoluiz@gmail.com");
//       alu.setTelefone("(27)3200-4040");
//       alu.setIdade(20);
//       alu.setIdAluno(2);
//       
//        if (dao.delete(3)) {
//            System.out.println("Ebaa! Aluno excluído com sucesso!");
//        } else {
//            System.out.println("Ops! Erro ao cadastrar aluno.");
//        }

        alunoDAO dao = new alunoDAO();

        dao.read().forEach((a) -> {
            System.out.println("DADOS DO ALUNO");
            System.out.println(a.getIdAluno());
            System.out.println(a.getNome());
            System.out.println(a.getEmail());
            System.out.println(a.getTelefone());
            System.out.println(a.getIdade());
        });
    }
}
