package model;

public class Professor {
    private int idProfessor;
    private String nome;
    private String email;
    private String formacao;

    public Professor() {
    }

    public Professor(int idProfessor, String nome, String email, String formacao) {
        this.idProfessor = idProfessor;
        this.nome = nome;
        this.email = email;
        this.formacao = formacao;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
    
    
    
}
