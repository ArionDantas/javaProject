package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Curso;

public class CursoDAO {

    MyConnection myConnection = new MyConnection();
    Connection con;
    PreparedStatement stmt;
    ResultSet result;

    public boolean create(Curso curso) {
        boolean resposta = false;
        //Estabelecendo conexão com o Banco de dados
        String sql = "insert into curso(nome, categoria, cargaHoraria, gratuidade) values(?,?,?,?)";
        //Definindo o comando que será executado no DB
        con = MyConnection.getConnection();
        //Tentando executar os comandos no DB

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getCategoria());
            stmt.setInt(3, curso.getCargaHoraria());
            stmt.setBoolean(4, curso.getGratuito());
            stmt.executeUpdate();
            resposta = true;

        } catch (SQLException e) {
            System.out.println("Erro ao tentar inserir Curso. " + e);
        } finally {
            MyConnection.closeConnection(con, stmt);
        }

        return resposta;
    }

    public List<Curso> read() {

        List cursos = new ArrayList();
        con = MyConnection.getConnection();
        String sql = "select * from curso";

        try {
            stmt = con.prepareStatement(sql);
            result = stmt.executeQuery();
            
            while (result.next()) {
                
                System.out.println("result =>>>>> " + result.getInt("idCurso"));
                Curso curso = new Curso();
                curso.setIdCurso(result.getInt("idCurso"));
                curso.setNome(result.getString("nome"));
                curso.setCategoria(result.getString("categoria"));
                curso.setCargaHoraria(result.getInt("cargaHoraria"));
                curso.setGratuito(result.getBoolean("gratuidade"));

                cursos.add(curso);
            }

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao selecionar Cursos!..." + e);
        } finally {
            MyConnection.closeConnection(con, stmt, result);
        }

        return cursos;
    }
}