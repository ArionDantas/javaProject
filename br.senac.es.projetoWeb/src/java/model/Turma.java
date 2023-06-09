package model;

import java.util.Date;


public class Turma {
    private int idTurma;
    private String sala;
    private String turno;
    private Date inicio;
    private Date fim;
    private int idProfessor;
    private int idCurso;
    private String codigo;
    private String status;

    public Turma() {
    }

    public Turma(int idTurma, String sala, String turno, Date inicio, Date fim, int idProfessor, int idCurso, String codigo, String status) {
        this.idTurma = idTurma;
        this.sala = sala;
        this.turno = turno;
        this.inicio = inicio;
        this.fim = fim;
        this.idProfessor = idProfessor;
        this.idCurso = idCurso;
        this.codigo = codigo;
        this.status = status;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
    
}
