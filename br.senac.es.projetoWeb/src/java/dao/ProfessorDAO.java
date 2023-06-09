package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Professor;

public class ProfessorDAO {

    MyConnection myConnection = new MyConnection();
    Connection con;
    PreparedStatement stmt;
    ResultSet result;

    public boolean create(Professor professor) {
        boolean resposta = false;

        String sql = "insert into professor(nome, area, telefone, email, formacao) values(?,?,?,?,?)";

        con = MyConnection.getConnection();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getArea());
            stmt.setString(3, professor.getTelefone());
            stmt.setString(4, professor.getEmail());
            stmt.setString(5, professor.getFormacao());
            stmt.executeUpdate();

            resposta = true;

        } catch (SQLException e) {
            System.out.println("Erro ao tentar inserir professor" + e);
        } finally {
            MyConnection.closeConnection(con, stmt);
        }

        return resposta;
    }

    public List<Professor> read() {

        List professores = new ArrayList();
        con = MyConnection.getConnection();
        String sql = "select * from professor";

        try {
            stmt = con.prepareCall(sql);
            result = stmt.executeQuery();

            while (result.next()) {
                Professor professor = new Professor();
                professor.setIdProfessor(result.getInt("idProfessor"));
                professor.setNome(result.getString("nome"));
                professor.setArea(result.getString("area"));
                professor.setTelefone(result.getString("telefone"));
                professor.setEmail(result.getString("email"));
                professor.setFormacao(result.getString("formacao"));

                professores.add(professor);
            }

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao selecionar Professors!..." + e);
        } finally {
            MyConnection.closeConnection(con, stmt, result);
        }

        return professores;
    }

    public boolean update(Professor professor) {
        boolean resposta = false;
        con = MyConnection.getConnection();
        String sql = "update professor set nome=?, area=?, telefone=?, email=?, formacao=? where idProfessor=?";

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getArea());
            stmt.setString(3, professor.getTelefone());
            stmt.setString(4, professor.getEmail());
            stmt.setString(5, professor.getFormacao());
            stmt.setInt(6, professor.getIdProfessor());
            stmt.executeUpdate();
            resposta = true;

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao atualizar Professor" + e);
        } finally {
            MyConnection.closeConnection(con, stmt);
        }

        return resposta;
    }

    public boolean delete(int id) {

        boolean resposta = false;
        con = MyConnection.getConnection();
        String sql = "delete from professor where idProfessor=?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            resposta = true;

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao tentar excluir professor" + e);
        } finally {
            MyConnection.closeConnection(con, stmt);
        }

        return resposta;
    }

    public Professor findId(int idProfessor) {

        Professor pro = new Professor();
        con = MyConnection.getConnection();
        String sql = "select * from professor where idProfessor =?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idProfessor);
            result = stmt.executeQuery();

            while (result.next()) {
                pro.setIdProfessor(result.getInt("IdProfessor"));
                pro.setNome(result.getString("nome"));
                pro.setArea(result.getString("area"));
                pro.setEmail(result.getString("email"));
                pro.setFormacao(result.getString("formacao"));
                pro.setTelefone(result.getString("telefone"));
            }

        } catch (SQLException e) {
            System.out.println("Opss.. Erro ao selecionar Professor" + e);
        } finally {
            MyConnection.closeConnection(con, stmt, result);
        }

        return pro;
    }
}
