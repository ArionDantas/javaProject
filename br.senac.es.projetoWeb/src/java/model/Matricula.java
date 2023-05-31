package model;

import java.util.Date;

public class Matricula {
    private int idMatricula;
    private Date data;
    private int idAluno;
    private int idTurma;
    private Double valor;
    private boolean gratuidade;

    public Matricula() {
    }

    public Matricula(int idMatricula, Date data, int idAluno, int idTurma, Double valor, boolean gratuidade) {
        this.idMatricula = idMatricula;
        this.data = data;
        this.idAluno = idAluno;
        this.idTurma = idTurma;
        this.valor = valor;
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

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean getGratuidade() {
        return gratuidade;
    }

    public void setGratuidade(boolean gratuidade) {
        this.gratuidade = gratuidade;
    }

    
    
}