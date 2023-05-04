package model;

public class Aluno {
    // Atributos
    private int idAluno;
    private String nome;
    private String email; 
    private String telefone; 
    private int idade;
    
        // Métodos
    public Aluno() {
        
    }

    public Aluno(int idAluno, String nome, String email, String telefone, int idade) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idade = idade;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
    
}

