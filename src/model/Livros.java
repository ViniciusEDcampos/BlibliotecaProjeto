package model;
 
/**
*
* @author 990251
*/

public class Livros {
 
    private String titulo;
    private String autor;
    private String anoDePublicacao;
    private String isbn;
    private String tema;
    private String disponibilidade;
 
    public Livros(String titulo, String autor, String anoDePublicacao, String isbn, String tema, String disponibilidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.isbn = isbn;
        this.tema = tema;               
        this.disponibilidade = disponibilidade;
    }
 
    public Livros() {
    }
 
    public String getTitulo() {
        return titulo;
    }
 
    public String getAnoDePublicacao() {
        return anoDePublicacao;
    }
 
    public String getIsbn() {
       return isbn;
    }
 
    public String getDisponibilidade() {
       return disponibilidade;
    }
 
    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
 
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
 
    public void setAnoDePublicacao(String anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }
 
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
 
    public String getAutor() {
        return autor;
    }
 
    public void setAutor(String autor) {
        this.autor = autor;
    }
 
    public String getTema() {
        return tema;
    }
 
    public void setTema(String tema) {
        this.tema = tema;
    }
     // Método para o Combobox
    @Override
    public String toString() {
        return this.titulo; // O Combobox vai exibir o título
    }
     
}
 
    

