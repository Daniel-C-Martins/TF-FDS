package tf.fds.app.domain.entity;

public class UsuarioModel {
    private String nome;
    private String senha;
    
    public UsuarioModel(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String toString(){
        return "Nome: " + nome + ", Senha: " + senha;
    }    
}
