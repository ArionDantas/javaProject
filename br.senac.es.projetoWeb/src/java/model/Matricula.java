package model;

import java.util.Date;

public class Matricula {
    private int idMatricula;
    private Date data;
    private int idAluno;
    private int idCurso;
    private boolean gratuidade;

    public Matricula() {
    }

    public Matricula(int idMatricula, Date data, int idAluno, int idCurso, boolean gratuidade) {
        this.idMatricula = idMatricula;
        this.data = data;
        this.idAluno = idAluno;
        this.idCurso = idCurso;
        this.gratuidade = gratuidade;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public boolean isGratuidade() {
        return gratuidade;
    }

    public void setGratuidade(boolean gratuidade) {
        this.gratuidade = gratuidade;
    }
    
}
