package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;

public class AlunoDAO {

    //CRUD --> Objetos para conexão com o Banco de Dados
    MyConnection myConnection = new MyConnection();
    Connection con;
    PreparedStatement stmt;
    ResultSet result;

    public boolean create(Aluno aluno) {
        boolean resposta = false;
        //Estabelecendo conexão com o Banco de dados
        String sql = "insert into aluno(nome, email, telefone, idade) values(?,?,?,?)";
        //Definindo o comando que será executado no DB
        con = MyConnection.getConnection();
        //Tentando executar os comandos no DB

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getTelefone());
            stmt.setInt(4, aluno.getIdade());
            stmt.executeUpdate();
            resposta = true;

        } catch (SQLException e) {
            System.out.println("Erro ao tentar inserir Aluno. " + e);
        } finally {
            MyConnection.closeConnection(con, stmt);
        }

        return resposta;
    }

    public List<Aluno> read() {

        List alunos = new ArrayList();
        con = MyConnection.getConnection();
        String sql = "select * from aluno";

        try {
            stmt = con.prepareStatement(sql);
            result = stmt.executeQuery();
            while (result.next()) {
                Aluno aluno = new Aluno();
                aluno.setIdAluno(result.getInt("idAluno"));
                aluno.setNome(result.getString("nome"));
                aluno.setEmail(result.getString("email"));
                aluno.setTelefone(result.getString("telefone"));
                aluno.setIdade(result.getInt("idade"));

                alunos.add(aluno);
            }

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao selecionar Alunos!..." + e);
        } finally {
            MyConnection.closeConnection(con, stmt, result);
        }

        return alunos;
    }

    public boolean update(Aluno aluno) {

        boolean resposta = false;
        con = MyConnection.getConnection();
        String sql = "update aluno set nome=?, email=?, telefone=?, idade=? where idAluno=?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEmail());
            stmt.setString(3, aluno.getTelefone());
            stmt.setInt(4, aluno.getIdade());
            stmt.setInt(5, aluno.getIdAluno());
            stmt.executeUpdate();
            resposta = true;

        } catch (SQLException e) {
            System.out.println("Opss.. Erro ao atualizar Aluno" + e);
        }finally {
            MyConnection.closeConnection(con, stmt);
        }

        return resposta;
    }

    public boolean delete(int id) {
        
        boolean resposta = false;
        con = MyConnection.getConnection();
        String sql = "delete from aluno where idAluno=?";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            resposta = true;
            
        } catch (SQLException e) {
            System.out.println("Opss... Erro ao tentar excluir aluno" + e);
        }finally {
            MyConnection.closeConnection(con, stmt);
        }
        
        return resposta;
    }

}
