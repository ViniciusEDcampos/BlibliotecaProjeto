
package dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Livros;

/**
 *
 * @author ACER
 */
public class daoLivros {
    
    String tabela = "Livros";
    public void inserirLivros(Livros livros) throws SQLException {
        String Sql = "INSERT INTO livros (titulo, autor, tema, anoPublicacao, ISBN, disponibilidade) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conex = null;
        PreparedStatement ps = null;
        try {
            //iniciar uma conexão com o DB
            //o objeto conex serve para usar a conexao
            conex = Conexao.criarConexao();
            //inicia um PreparetedStatement usado para executar uma query (CONSULTA)
            //O PreparetedStatement prepara a sql para ser utilizada
            ps = conex.prepareStatement(Sql);
            livros.setDisponibilidade("s");
            //adiciona os valores de parâmetros da SQL
            ps.setString(1, livros.getTitulo());
            ps.setString(2, livros.getAutor());
            ps.setString(3, livros.getTema());
            ps.setString(4, livros.getAnoDePublicacao());
            ps.setString(5, livros.getIsbn());
            ps.setString(6, livros.getDisponibilidade());
            //executa a sentença sql para a inserção de dados
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar dados");
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
    
    public void update(Livros livros) throws SQLException {
         String Sql = "UPDATE " + tabela + " SET titulo = ?, autor = ?, tema = ?, anoPublicacao = ? WHERE ISBN = ?";
        Connection conex = null;
        PreparedStatement ps = null;
        try {
            conex = Conexao.criarConexao();
            ps = conex.prepareStatement(Sql);
            //atualiza o valor do registro pelo parametro LIVRO
            ps.setString(1, livros.getTitulo());
            ps.setString(2, livros.getAutor());
            ps.setString(3, livros.getTema());
            ps.setString(4, livros.getAnoDePublicacao());
            ps.setString(5, livros.getIsbn());
      
            ps.executeUpdate();
        } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "Erro ao atualizar livro: " + e.getMessage());
        } finally {
            if (ps != null)ps.close();
            if (conex != null)conex.close();
        }
       }
    
    public void updateDisponibilidade(Livros livros) throws SQLException{
         String Sql = "UPDATE " + tabela + " SET disponibilidade = ? WHERE ISBN = ?";

        Connection conex = null;
        PreparedStatement ps = null;
        try {
            conex = Conexao.criarConexao();
            ps = conex.prepareStatement(Sql);
            //atualiza o valor do registro pelo parametro LIVRO
            ps.setString(1, livros.getDisponibilidade());
            ps.setString(2, livros.getIsbn());
            ps.executeUpdate();
        } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "Erro ao atualizar disponibilidade livro: " + e.getMessage());
        } finally {
            if (ps != null)ps.close();
            if (conex != null)conex.close();
        }
       }
 
    public void removerLivro(String ISBN) throws SQLException {
     String sql = "DELETE FROM " + tabela + " WHERE ISBN = ?";
        Connection conex = null;
        PreparedStatement ps = null;
        try {
            //estabelece uma coneção com o DB(DATA BASE)
            conex = Conexao.criarConexao();
            //defne a sentença sql para executar a query
            ps = conex.prepareStatement(sql);
            //adiciona o valor passado como parâmetro(ID)para sentença SQL
            ps.setString(1, ISBN);
            //métocdo para executar a sql de exclusão 
             ps.executeUpdate();
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Erro ao remover livro: " + e.getMessage());
        } 
    }
   
    public ArrayList<Livros> pesquisarLivros(String pesquisa) throws SQLException {
        //nome pesquisa pois pega do campo pesquisa
        String sql = "SELECT * FROM " + tabela + " WHERE titulo LIKE ?";
        ArrayList<Livros> livros = new ArrayList<>();
        Connection conex = null;
        PreparedStatement ps = null;
        //classe que recupera os dados localizados no banco
        ResultSet rs = null;
        
        try {
            //criação da conexão com banco
            conex = Conexao.criarConexao();
            ps = conex.prepareStatement(sql);
            //envia o criterio de pesquisa para sentença SQL          
            ps.setString(1, pesquisa);
            rs = ps.executeQuery();
            
            //while -- enquanto existir dados na tabela, a pesquisa continua
            while (rs.next()) {
                Livros dados = new Livros();
                dados.setTitulo(rs.getString("titulo"));
                dados.setAutor(rs.getString("autor"));
                dados.setTema(rs.getString("tema"));
                dados.setAnoDePublicacao(rs.getString("anoPublicacao"));
                dados.setIsbn(rs.getString("ISBN"));
                 dados.setDisponibilidade(rs.getString("disponibilidade"));
                livros.add(dados);
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
        }
        return livros;
    }

    
}
