package dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Matricula;

public class MatriculaDAO {

    MyConnection myConnection = new MyConnection();
    Connection con;
    PreparedStatement stmt;
    ResultSet result;
    
    public boolean create(Matricula mat) {
        boolean resposta = false;
        
        con = MyConnection.getConnection();
        String sql = "insert into matricula(idAluno, idTurma, valor, dataMatricula) values(?,?,?,?)";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, mat.getIdAluno());
            stmt.setInt(2, mat.getIdTurma());
            stmt.setDouble(3, mat.getValor());
            
            Date d = new Date (mat.getData().getTime());
            stmt.setDate(4, d);
            stmt.executeUpdate();
            
            resposta = true;
            
        } catch (SQLException e) {
            System.out.println("Erro ao tentar inserir nova Matricula" + e);
        } finally {
           MyConnection.closeConnection(con, stmt);
        }
        
        return resposta;
    }
}
