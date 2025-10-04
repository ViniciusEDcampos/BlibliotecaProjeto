
package model;

/**
 *
 * @author 990251
 */
public class Usuario {
    
    private String nome; 
    private String email;
    private String telefone;
    private String CPF;
    private String endereco;

    public Usuario() {
    }
    
    public Usuario(String nome, String email, String telefone, String CPF, String endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.CPF = CPF;
        this.endereco = endereco;
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
  // Metodo para a combobox usuario
    @Override
    public String toString() {
        return this.nome; 
    }

    
}
