package model;

/**
 *
 * @author 990251
 */
public class livroEmprestimo {
     
    private int id_Emprestimo;
    private String dataDevolucao;
    private String dataEmprestimo;
    private String livros_ISBN;
    private String usuario_CPF;
    private String dataDevolucaoCliente;

    public livroEmprestimo(int id_Emprestimo, String dataDevolucao, String dataEmprestimo, String livros_ISNB, String usuario_CPF, String dataDevolucaoCliente ) {
        this.dataDevolucao = dataDevolucao;
        this.dataEmprestimo = dataEmprestimo;
        this.livros_ISBN = livros_ISNB;
        this.usuario_CPF = usuario_CPF;
        this.usuario_CPF = usuario_CPF;
        this.id_Emprestimo = id_Emprestimo;
        this.dataDevolucaoCliente = dataDevolucaoCliente;
    }

    public livroEmprestimo() {
      
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getLivros_ISBN() {
        return livros_ISBN;
    }

    public void setLivros_ISBN(String livros_ISNB) {
        this.livros_ISBN = livros_ISNB;
    }

    public String getUsuario_CPF() {
        return usuario_CPF;
    }

    public void setUsuario_CPF(String usuario_CPF) {
        this.usuario_CPF = usuario_CPF;
    }

    public int getId_Emprestimo() {
        return id_Emprestimo;
    }

    public void setId_Emprestimo(int id_Emprestimo) {
        this.id_Emprestimo = id_Emprestimo;
    }

    public String getDataDevolucaoCliente() {
        return dataDevolucaoCliente;
    }

    public void setDataDevolucaoCliente(String dataDevolucaoCliente) {
        this.dataDevolucaoCliente = dataDevolucaoCliente;
    }
}
    