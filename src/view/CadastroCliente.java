
package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import dao.Conexao;
import dao.daoUsuarios;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger; 
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author 990251
 */
public class CadastroCliente extends javax.swing.JFrame {

    DefaultTableModel tabela;
    Object[] nomeColunas;
    ArrayList<Usuario> lista;
    
    /**
     * Creates new form CadastroCliente
     */
    public CadastroCliente() {
        initComponents();
        
        nomeColunas = new String[]{"CPF", "Nome", "telefone", "endereco", "email"};
        tabela = new DefaultTableModel(null, nomeColunas);
        tabelaCliente.setModel(tabela);
        tabelaCliente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(120);
        tabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(230);
        tabelaCliente.getColumnModel().getColumn(2).setPreferredWidth(120);
        tabelaCliente.getColumnModel().getColumn(3).setPreferredWidth(150);
        tabelaCliente.getColumnModel().getColumn(4).setPreferredWidth(170);
        try {
            listarUsuarios();
        } catch (SQLException ex) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        voltarTela = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        btnGravar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        btnPesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));

        voltarTela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/right-arrow (1).png"))); // NOI18N
        voltarTela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voltarTelaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(voltarTela)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(voltarTela)
                .addContainerGap())
        );

        btnGravar.setBackground(new java.awt.Color(159, 199, 170));
        btnGravar.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/floppy-disk.png"))); // NOI18N
        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(159, 199, 170));
        btnEditar.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        btnEditar.setText(" Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnDeletar.setBackground(new java.awt.Color(159, 199, 170));
        btnDeletar.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel1.setText("Cadastro de Cliente");

        btnLimpar.setBackground(new java.awt.Color(159, 199, 170));
        btnLimpar.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/broom.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Email", "Telefone", "CPF", "Endereço"
            }
        ));
        tabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaCliente);

        btnPesquisar.setBackground(new java.awt.Color(159, 199, 170));
        btnPesquisar.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search (4).png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel3.setText("CPF:");

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel5.setText("Endereço:");

        jLabel6.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel6.setText("Telefone:");

        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logos/fabulas_logo_310x140.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                                    .addComponent(txtEndereco))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(52, 52, 52))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPesquisar)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(774, 739));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
         //grava o registro após verificar preenchimento de todos os campos
        if (verificarDados()==true) {
            try {
                cadastrarUsuario();
            } catch (SQLException ex) {
            }
            limpar();
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        // Metodo para Atualizar dados de contato
        if (!txtCpf.getText().equals("")) {
            try {
                atualizarUsuarios();
                listarUsuarios();
                btnEditar.setText("Editar");
                btnGravar.setEnabled(true);
            } catch (SQLException ex) {
            }
        } else {
            String msg = "Porfavor, selecione um Usuario";
            JOptionPane.showMessageDialog(null, msg);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
 
        String msg = "Deseja realmente excluir esse Usuario?";
        String[] vetorOpcoes = {"Confirmar", "Cancelar"};
        ImageIcon img = new ImageIcon("src/img/erro.gif");

        int resposta = JOptionPane.showOptionDialog(null, msg,
            "Confirmação", JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE, img,
            vetorOpcoes, vetorOpcoes[0]);

            // verifica resposta do usuário para prosseguir com ação
        if (resposta == 0) {
            // verifica se um registro foi selecionado - indicador ISBN selecionado
            if (!txtTelefone.getText().equals("")) {
                try {
                    apagarRegistro(txtTelefone.getText());
                } catch (SQLException ex) {
                    Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex); //editar
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione um Cliente");
            }
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void tabelaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteMouseClicked
        int linha = tabelaCliente.getSelectedRow();
        if (linha < 0) return;

        try {
            String CPFSelecionado = tabelaCliente.getValueAt(linha, 0).toString();
            String sql = "SELECT * FROM Usuario WHERE CPF='" + CPFSelecionado + "'";

            // estabelecer a conexão com o DB novamente
            Connection conex = Conexao.criarConexao();
            Statement ps;
            ps = conex.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            rs.next();
            this.txtNome.setText(rs.getString("Nome"));
            this.txtCpf.setText(rs.getString("CPF"));
            this.txtEmail.setText(rs.getString("email"));
            this.txtEndereco.setText(rs.getString("endereco"));
            this.txtTelefone.setText(rs.getString("telefone"));
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Nenhum Usuario");
        }
    }//GEN-LAST:event_tabelaClienteMouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            listarUsuarios();
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void voltarTelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarTelaMouseClicked
    voltarTela();
    }//GEN-LAST:event_voltarTelaMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JLabel voltarTela;
    // End of variables declaration//GEN-END:variables

    private void voltarTela() {
    TelaPrincipal telaPrincipal = new TelaPrincipal();
    telaPrincipal.setVisible(true);
    this.dispose();
    }
    
 private boolean verificarDados() {
    if (!txtCpf.getText().isEmpty()
            && !txtEmail.getText().isEmpty()
            && !txtEndereco.getText().isEmpty()
            && !txtNome.getText().isEmpty()
            && !txtTelefone.getText().isEmpty()) {

    return true;
    } else {
       String msg = "Campos: CPF, EMAIL, ENDEREÇO, NOME, TELEFONE devem ser preenchidos";
       JOptionPane.showMessageDialog(null, msg, "Erro ao Salvar", JOptionPane.ERROR_MESSAGE);
       return false;
      }
   }

private void cadastrarUsuario() throws SQLException {
    Usuario user = new Usuario();
    user.setCPF(txtCpf.getText());
    user.setEmail(txtEmail.getText());
    user.setEndereco(txtEndereco.getText());
    user.setNome(txtNome.getText());
    user.setTelefone(txtTelefone.getText());

    daoUsuarios gravarUsuario = new daoUsuarios();
    //gravar contatos pega Dados no Inserir Usuario (Usuario)
    gravarUsuario.inserirUsuarios(user);
    JOptionPane.showMessageDialog(null, "Gravado com sucesso!!!"); 
    
    listarUsuarios();
}

private void listarUsuarios() throws SQLException {
        daoUsuarios dao = new daoUsuarios();
        lista = dao.pesquisarContatos("%" + txtPesquisa.getText() + "%");
        exibirUsuarios(lista);
        
    }

 private void exibirUsuarios(ArrayList<Usuario> lista) {
        while (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum Usuario existente");
        } else {
            String[] linha = new String[]{null, null, null, null, null};
            // percorre a lista de Livros e preenche a tablemodel
            for (int i = 0; i < lista.size(); i++) {
                tabela.addRow(linha); // 
                tabela.setValueAt(lista.get(i).getCPF(), i, 0);
                tabela.setValueAt(lista.get(i).getNome(), i, 1);
                tabela.setValueAt(lista.get(i).getTelefone(), i, 2);
                tabela.setValueAt(lista.get(i).getEndereco(), i, 3);
                tabela.setValueAt(lista.get(i).getEmail(), i, 4);
            }
        }
    }
 
 private void apagarRegistro(String CPF) throws SQLException {
        //instancia de um objeto para 'invocar' um metodo remoer registro 
        daoUsuarios biblioteca = new daoUsuarios();
        biblioteca.removerUsuario(CPF);
        //metodo para atuallizar o tableModel
        listarUsuarios();
        //método para limpar os campos do formulario
        limpar();
    }
 
  private void atualizarUsuarios() throws SQLException {
        Usuario usuario = new Usuario();

        usuario.setCPF(txtCpf.getText());
        usuario.setEmail(txtEmail.getText());
        usuario.setEndereco(txtEndereco.getText());
        usuario.setNome(txtNome.getText());
        usuario.setTelefone(txtTelefone.getText());

        daoUsuarios biblioteca = new daoUsuarios();
        biblioteca.update(usuario);

        String msg = "Usuario Atualizado com sucesso";
        JOptionPane.showMessageDialog(null, msg);
    }

private void limpar() {
      // Metodo limpar
      txtCpf.setText("");
      txtEmail.setText("");
      txtEndereco.setText("");
      txtNome.setText("");
      txtTelefone.setText("");
      txtCpf.requestFocus();
    }
}

