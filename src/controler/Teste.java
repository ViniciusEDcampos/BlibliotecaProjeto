package controler;
 
import dao.Conexao;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
 
/**
*
* @author 998518
*/
public class Teste {
 
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        //recupera uma conexão com o mysql
        Connection conex = Conexao.criarConexao();

        //verifica se a conexão e valida ou nula
        if (conex != null){
            String teste = "Conexão obtida com Sucesso!\n\n";
            JOptionPane.showMessageDialog(null, teste + conex);
            //fecha a conexão após teste
            JOptionPane.showMessageDialog(null, "Conexão finalizada");
            conex.close();
        }
        else{
         String errus = "Não foi possivel realizar a conexão";
         JOptionPane.showMessageDialog(null, errus,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
}
