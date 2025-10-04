package dao;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

    /**
     * @author 990251
     */
    public class Conexao {

        //declaração de variavel simples
        String tabela = "biblioteca";
        // usuario do mysql
        private static final String userName = "root";
        // senha do usuario
        private static final String senha = "140352";
        // endereço, porta e nome do db
        String endereco = "useTimezone=true&serverTimezone=UTC";

      private static final String dbURL = "jdbc:mysql://localhost:3306/biblioteca?useSSL=false&allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=UTC";

        // ----------------------------------------------------------------------------------------
        // método conexão com o banco
        public static Connection criarConexao() {

            try {
                // carrega a classe pela JVM
                Class.forName("com.mysql.cj.jdbc.Driver");
                // define conexão com o banco
                Connection conex = DriverManager.getConnection(dbURL, userName, senha);
                // retorna uma conexão para o db
                return conex;

            } catch (ClassNotFoundException e1) {
                String erro1 = "O driver especificado não foi encontrado! \n\n";
                JOptionPane.showMessageDialog(null, erro1 + e1, "ERRO!",
                JOptionPane.ERROR_MESSAGE);
                return null;
            } catch (SQLException e2) {
                // caso não consiga conectar ao banco
                ImageIcon img = new ImageIcon("src/img/erro.gif");
                JOptionPane.showMessageDialog(null, "Não foi possível realizar a conexão", "ERROR", ERROR_MESSAGE, img);
                String erro2 = "Não foi possível conectar ao banco de dados! \n\n";
                JOptionPane.showMessageDialog(null, erro2 + e2, "ERRO!",
                JOptionPane.ERROR_MESSAGE);
                return null;
        }
    }
 }
