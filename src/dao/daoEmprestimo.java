
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Livros;
import model.Usuario;
import model.livroEmprestimo;

/**
 * @author ACER
 */
public class daoEmprestimo {
    
    
    String tabela = "Livros";
    String tabelaUsuario = "Usuario";
    String tabelaEmprestimo = "Livros_Emprestimo";

    //método para inseir em Livros_Emprestimos
    //passando a informação do tipo contato para o inserir Livro_emprestimo
    //passando parametros a ele  
     
    public void inserirLivrosEmprestimo(livroEmprestimo emprestimo) throws SQLException {
        //sentença SQL para adicionar dados no DB(Data Base)
        String Sql = "INSERT INTO livros_emprestimo (dataDevolucao, dataEmprestimo, Livros_ISBN, Usuario_CPF) VALUES (?, ?, ?, ?)";
        
        Connection conex = null;
        PreparedStatement ps = null;
        try {
            //iniciar uma conexão com o DB
            //o objeto conex serve para usar a conexao
            conex = Conexao.criarConexao();
            //inicia um PreparetedStatement usado para executar uma query (CONSULTA)
            //O PreparetedStatement prepara a sql para ser utilizada
            ps = conex.prepareStatement(Sql);
            //adiciona os valores de parâmetros da SQL
            ps.setString(1, emprestimo.getDataDevolucao());
            ps.setString(2, emprestimo.getDataEmprestimo());
            ps.setString(3, emprestimo.getLivros_ISBN());
            ps.setString(4, emprestimo.getUsuario_CPF()); 
         
            //executa a sentença sql para a inserção de dados
            ps.execute();
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Erro ao gravar dados: " + e.getMessage());
        } finally {
            //fecha as conexões do DB 
            if (ps != null) {
                ps.close();
            }
            if (conex != null) {
                conex.close();
            }
        }
    }
    
    public int buscarIdEmprestimoAberto(String cpf, String isbn) throws SQLException {
    String sql = "SELECT id_Emprestimo FROM Livros_Emprestimo " +
                 "WHERE Usuario_CPF = ? AND Livros_ISBN = ? AND dataDevolucaoCliente IS NULL " +
                 "ORDER BY id_Emprestimo DESC LIMIT 1";

    try (Connection conex = Conexao.criarConexao();
         PreparedStatement ps = conex.prepareStatement(sql)) {

        ps.setString(1, cpf);
        ps.setString(2, isbn);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id_Emprestimo");
            } else {
                throw new SQLException("Esse emprestimo não foi encontrado.");
            }
        }
    }
}
    
    public void registrarDevolucao(int idEmprestimo, String dataDevolucaoCliente) throws SQLException {
    String sql = "UPDATE Livros_Emprestimo SET dataDevolucaoCliente = ? WHERE id_Emprestimo = ?";

    Connection conex = null;
    PreparedStatement ps = null;

    try {
        conex = Conexao.criarConexao();
        if (conex == null) {
            throw new SQLException("Conexão com o banco de dados falhou.");
        }

        ps = conex.prepareStatement(sql);
        ps.setString(1, dataDevolucaoCliente);
        ps.setInt(2, idEmprestimo);
        ps.executeUpdate();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao registrar devolução: " + e.getMessage());
    } finally {
        if (ps != null) ps.close();
        if (conex != null) conex.close();
    }
}

    public void removerLivroEmprestimo(String Livros_ISNB) throws SQLException {
        //instrução SQL onde a "?" será o parametro selecionado para exclusão 
     String sql = "DELETE FROM " + tabelaEmprestimo + " WHERE Livros_ISNB = ?";
        Connection conex = null;
        PreparedStatement ps = null;
        try {
            //estabelece uma coneção com o DB(DATA BASE)
            conex = Conexao.criarConexao();
            //defne a sentença sql para executar a query
            ps = conex.prepareStatement(sql);
            //adiciona o valor passado como parâmetro(ID)para sentença SQL
            ps.setString(3, Livros_ISNB);
            //métocdo para executar a sql de exclusão 
             ps.executeUpdate();
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Erro ao remover Contatos: " + e.getMessage());
        } 
    } 
     
    public ArrayList<livroEmprestimo> pesquisarLivrosEmprestados(String pesquisa) throws SQLException {
         String sql = "SELECT * FROM " + tabelaEmprestimo + " WHERE Livros_ISBN LIKE ?";
         
         ArrayList<livroEmprestimo> livrosEmprestados = new ArrayList<>();
         Connection conex = null;
         PreparedStatement ps = null;
         //classe que recupera os dados localizados no banco
         ResultSet rs = null;
         //instância de um objeto do tipo ArrayList

         try {
             //criação da conexão com banco
             conex = Conexao.criarConexao();
             ps = conex.prepareStatement(sql);
             //envia o criterio de pesquisa para sentença SQL          
             ps.setString(1, "%" + pesquisa + "%");
             rs = ps.executeQuery();

             //while -- enquanto existir dados na tabela, a pesquisa continua
             while (rs.next()) {
                 livroEmprestimo dados = new livroEmprestimo();
                 dados.setUsuario_CPF(rs.getString("Usuario_CPF"));
                 dados.setLivros_ISBN(rs.getString("Livros_ISBN"));
                 dados.setDataEmprestimo(rs.getString("dataEmprestimo"));
                 dados.setDataDevolucao(rs.getString("dataDevolucao"));
                 livrosEmprestados.add(dados);
             }
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Erro ao realizar a pesquisa: " + e.getMessage());
         } finally {
             if (rs != null) {
                 rs.close();
             }
             if (ps != null) {
                 ps.close();
             }
             if (conex != null) {
                 conex.close();
             }
               return livrosEmprestados;
         }
     }

    public ArrayList<Usuario> listarTodosUsuarios() throws SQLException {
    ArrayList<Usuario> usuarios = new ArrayList<>();
    String sql = "SELECT * FROM " + tabelaUsuario;
    Connection conex = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conex = Conexao.criarConexao();
        ps = conex.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            Usuario dados = new Usuario();
            dados.setCPF(rs.getString("CPF"));
            dados.setNome(rs.getString("nome"));
            dados.setTelefone(rs.getString("telefone"));
            dados.setEndereco(rs.getString("endereco"));
            dados.setEmail(rs.getString("email"));
            usuarios.add(dados);
        }
    } finally {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (conex != null) conex.close();
    }

    return usuarios;
}

    public ArrayList<Livros> listarTodosLivros() throws SQLException {
    ArrayList<Livros> livros = new ArrayList<>();
    String sql = "SELECT * FROM " + tabela + " WHERE disponibilidade = 's'";
  
    Connection conex = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conex = Conexao.criarConexao();
        ps = conex.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            Livros dados = new Livros();
            dados.setTitulo(rs.getString("titulo"));
            dados.setAutor(rs.getString("autor"));
            dados.setTema(rs.getString("tema"));
            dados.setAnoDePublicacao(rs.getString("anoPublicacao"));
            dados.setIsbn(rs.getString("ISBN"));
            livros.add(dados);
        }
    } finally {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (conex != null) conex.close();
    }

    return livros;
} 
 
    public ArrayList<Livros> listarLivrosEmprestados() throws SQLException {
    ArrayList<Livros> livros = new ArrayList<>();
    String sql = "SELECT * FROM " + tabela + " WHERE disponibilidade = 'n'";
    
    Connection conex = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conex = Conexao.criarConexao();
        ps = conex.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            Livros dados = new Livros();
            dados.setTitulo(rs.getString("titulo"));
            dados.setAutor(rs.getString("autor"));
            dados.setTema(rs.getString("tema"));
            dados.setAnoDePublicacao(rs.getString("anoPublicacao"));
            dados.setIsbn(rs.getString("ISBN"));
            livros.add(dados);
        }
    } finally {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (conex != null) conex.close();
    }

    return livros;
    } 
    
    public ArrayList<Livros> listarUsuarios() throws SQLException {
    ArrayList<Livros> livros = new ArrayList<>();
    String sql = "SELECT * FROM " + tabela + " WHERE disponibilidade = 'n'";
    
    Connection conex = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        conex = Conexao.criarConexao();
        ps = conex.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            Livros dados = new Livros();
            dados.setTitulo(rs.getString("titulo"));
            dados.setAutor(rs.getString("autor"));
            dados.setTema(rs.getString("tema"));
            dados.setAnoDePublicacao(rs.getString("anoPublicacao"));
            dados.setIsbn(rs.getString("ISBN"));
            livros.add(dados);
        }
    } finally {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (conex != null) conex.close();
    }

    return livros;
    } 
    
}
