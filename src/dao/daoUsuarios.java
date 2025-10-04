
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author ACER
 */
public class daoUsuarios {
    
    String tabelaUsuario = "Usuario";
    String tabelaEmprestimo = "Livros_Emprestimo";
    
    public void inserirUsuarios(Usuario usuarios) throws SQLException {
        String Sql = "INSERT INTO usuario (CPF, nome, telefone, endereco, email) VALUES (?, ?, ?, ?, ?)";
        Connection conex = null;
        PreparedStatement ps = null;
        try {
            //o objeto conex serve para usar a conexao
            conex = Conexao.criarConexao();
            //inicia um PreparetedStatement usado para executar uma query (CONSULTA)
            //O PreparetedStatement prepara a sql para ser utilizada
            ps = conex.prepareStatement(Sql);
            //adiciona os valores de parâmetros da SQL
            ps.setString(1, usuarios.getCPF());
            ps.setString(2, usuarios.getNome());
            ps.setString(3, usuarios.getTelefone());
            ps.setString(4, usuarios.getEndereco()); 
            ps.setString(5, usuarios.getEmail());
            //executa a sentença sql para a inserção de dados
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar dados");
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conex != null) {
                conex.close();
            }
        }
    }
    
    public void update(Usuario usuarios) throws SQLException {
         String Sql = "UPDATE " + tabelaUsuario + " SET nome = ?, telefone = ?, endereco = ?, email = ?,  WHERE CPF = ?";
        Connection conex = null;
        PreparedStatement ps = null;
        try {
            conex = Conexao.criarConexao();
            ps = conex.prepareStatement(Sql);
            //atualiza o valor do registro pelo parametro LIVRO
            ps.setString(1, usuarios.getNome());
            ps.setString(2, usuarios.getTelefone());
            ps.setString(3, usuarios.getEndereco()); 
            ps.setString(4, usuarios.getEmail());
            ps.setString(5, usuarios.getCPF());
            ps.executeUpdate();
        } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "Erro ao atualizar livro: " + e.getMessage());
        } finally {
            //fecha as conexões
            if (ps != null)ps.close(); 
            if (conex != null)conex.close();
        }
       }
    
    public void removerUsuario(String CPF) throws SQLException {
     String sql = "DELETE FROM " + tabelaUsuario + " WHERE CPF = ?";
        Connection conex = null;
        PreparedStatement ps = null;
        try {
            //estabelece uma coneção com o DB(DATA BASE)
            conex = Conexao.criarConexao();
            //defne a sentença sql para executar a query
            ps = conex.prepareStatement(sql);
            //adiciona o valor passado como parâmetro(ID)para sentença SQL
            ps.setString(1, CPF);
            //métocdo para executar a sql de exclusão 
             ps.executeUpdate();
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Erro ao remover Contatos: " + e.getMessage());
        } 
    }
    
    public ArrayList<Usuario> pesquisarContatos(String pesquisa) throws SQLException {
        String sql = "SELECT * FROM " + tabelaUsuario + " WHERE CPF LIKE ?";
        ArrayList<Usuario> usuarios = new ArrayList<>();
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
            ps.setString(1, pesquisa);
            rs = ps.executeQuery();
            
            //while -- enquanto existir dados na tabela, a pesquisa continua
            while (rs.next()) {
                Usuario dados = new Usuario();
                dados.setCPF(rs.getString("CPF"));
                dados.setNome(rs.getString("nome"));
                dados.setTelefone(rs.getString("telefone"));
                dados.setEndereco(rs.getString("endereco"));
                dados.setEmail(rs.getString("email"));
                usuarios.add(dados);
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
              return usuarios;
        }
    }
     
}
