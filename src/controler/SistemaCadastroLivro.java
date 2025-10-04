package controler;

import model.Livros;

/**
 *
 * @author 990251
 */
public class SistemaCadastroLivro {

    public void cadastrarLivro(Livros tela) {
        
        Livros livro = new Livros();
        livro.setTitulo(tela.getTitulo());
        livro.setAutor(tela.getAutor());
       
        // salvando no arquivo
        System.out.println("Livro cadastrado: " + livro.toString());
    }
}
