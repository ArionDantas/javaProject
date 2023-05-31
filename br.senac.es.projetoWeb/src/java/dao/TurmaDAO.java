package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Turma;

public class TurmaDAO {

    MyConnection myConnection = new MyConnection();
    Connection con;
    PreparedStatement stmt;
    ResultSet result;

    public boolean create(Turma turma) {
        boolean resposta = false;
        //Estabelecendo conexão com o Banco de dados
        String sql = "insert into turma(sala, turno, idCurso, idProfessor, status, inicio, termino, codigo) values(?,?,?,?,?,?,?,?)";
        //Definindo o comando que será executado no DB
        con = MyConnection.getConnection();
        //Tentando executar os comandos no DB

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, turma.getSala());
            stmt.setString(2, turma.getTurno());
            stmt.setInt(3, turma.getIdCurso());
            stmt.setInt(4, turma.getIdTurma());
            stmt.setString(5, turma.getStatus());
            Date dataInicio = new Date(turma.getInicio().getTime());
            Date dataTermino = new Date(turma.getFim().getTime());
            stmt.setDate(6, dataInicio);
            stmt.setDate(7, dataTermino);
            stmt.setString(8, turma.getCodigo());
            stmt.executeUpdate();
            resposta = true;

        } catch (SQLException e) {
            System.out.println("Erro ao tentar inserir Turma. " + e);
        } finally {
            MyConnection.closeConnection(con, stmt);
        }

        return resposta;
    }

    public List<Turma> read() {

        List turmas = new ArrayList();
        con = MyConnection.getConnection();
        String sql = "select * from turma";

        try {
            stmt = con.prepareStatement(sql);
            result = stmt.executeQuery();
            while (result.next()) {
                Turma turma = new Turma();
                turma.setIdTurma(result.getInt("idTurma"));
                turma.setSala(result.getString("sala"));
                turma.setTurno(result.getString("turno"));
                turma.setIdCurso(result.getInt("idCurso"));
                turma.setIdProfessor(result.getInt("idProfessor"));
                turma.setStatus(result.getString("status"));
                turma.setInicio(result.getDate("inicio"));
                turma.setFim(result.getDate("fim"));
                turma.setCodigo(result.getString("codigo"));

                turmas.add(turma);
            }

        } catch (SQLException e) {
            System.out.println("Opss... Erro ao selecionar Turmas!..." + e);
        } finally {
            MyConnection.closeConnection(con, stmt, result);
        }

        return turmas;
    }
}
