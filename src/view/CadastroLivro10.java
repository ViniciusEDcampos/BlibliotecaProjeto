package view;

import dao.Conexao;
import dao.daoLivros;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Livros;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author 990251
 */
public class CadastroLivro10 extends javax.swing.JFrame {

    //declaração de variaveis e objetos
    DefaultTableModel tabela;
    Object[] nomeColunas;
    ArrayList<Livros> lista;

    public CadastroLivro10() {
        initComponents();
        
        nomeColunas = new String[]{"titulo", "autor", "tema", "anoPublicacao", "ISBN"};
        tabela = new DefaultTableModel(null, nomeColunas);
        tabelaLivros.setModel(tabela);
        tabelaLivros.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
        tabelaLivros.getColumnModel().getColumn(0).setPreferredWidth(215);
        tabelaLivros.getColumnModel().getColumn(1).setPreferredWidth(170);
        tabelaLivros.getColumnModel().getColumn(2).setPreferredWidth(120);
        tabelaLivros.getColumnModel().getColumn(3).setPreferredWidth(75);
        tabelaLivros.getColumnModel().getColumn(4).setPreferredWidth(120);

        try {
            listarLivros();
        } catch (SQLException ex) {

       }
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        txtISBN = new javax.swing.JTextField();
        btnGravar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaLivros = new javax.swing.JTable();
        btnPesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAnodePublicacao = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        voltarTela = new javax.swing.JLabel();
        comboboxTema = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logos/fabulas_logo_310x140.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
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
        jLabel1.setText("CADASTRAR LIVROS");

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

        tabelaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Titulo", "Autor", "Tema", "ISBN", "Ano de Publicação"
            }
        ));
        tabelaLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaLivrosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaLivros);

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
        jLabel2.setText("Titulo:");

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel3.setText("Autor:");

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel4.setText("Tema:");

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel5.setText("Ano de Publicação:");

        jLabel6.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel6.setText("ISBN:");

        txtAnodePublicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnodePublicacaoActionPerformed(evt);
            }
        });

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
                .addContainerGap(700, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(voltarTela)
                .addContainerGap())
        );

        comboboxTema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Romance", "Aventura", "Drama", "Mistério", "Suspense", "Policial / Investigativo", "Terror / Horror", "Terror", "Fantasia", "Ficção Científica", "Ficção", "Distopia", "Thriller / Psicológico", "Ficção Histórica", "Ficção Realista", "Young Adult (YA)", "Literatura Infantojuvenil", "Literatura Infantil", "Poesia", "Contos ", "Crônicas", "Teatro", "Peças teatrais", "Biografia / Autobiografia", "Memórias / Diários", "Autoajuda", "Psicologia", "Educação", "Ciências (Física, Biologia, Química, etc.)", "Filosofia", "Religião / Espiritualidade", "História", "Histórico", "Política", "Economia", "Negócios / Empreendedorismo", "Sociologia", "Tecnologia", "Saúde / Bem-estar", "Culinária / Gastronomia", "Viagens", "Arte / Música", "Moda / Estilo", "Realismo Mágico", "Estratégia", "Cyberpunk", "Sátira" }));
        comboboxTema.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtAnodePublicacao, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTitulo)
                                    .addComponent(txtAutor)
                                    .addComponent(txtISBN)
                                    .addComponent(comboboxTema, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtPesquisa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPesquisar))))
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel4))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(comboboxTema, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAnodePublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
         try {
            //chamada do metodo preenche table modamodel com dados
            listarLivros();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtAnodePublicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnodePublicacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnodePublicacaoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
         if (!txtISBN.getText().equals("")) {
            try {
                atualizarLivros();
                listarLivros();
                btnEditar.setText("Editar");
                btnGravar.setEnabled(true);
            } catch (SQLException ex) {
            }
        } else {
            String msg = "Porfavor, selecione um Livro";
            JOptionPane.showMessageDialog(null, msg);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
       
        // método para excluir registro no DB
        String msg = "Deseja realmente excluir esse contato?";
        String[] vetorOpcoes = {"Confirmar", "Cancelar"};
        ImageIcon img = new ImageIcon("src/img/erro.gif");

        int resposta = JOptionPane.showOptionDialog(null, msg,
                "Confirmação", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, img,
                vetorOpcoes, vetorOpcoes[0]);

        // verifica resposta do usuário para prosseguir com ação
        if (resposta == 0) {
            // verifica se um registro foi selecionado - indicador ISBN selecionado
            if (!txtISBN.getText().equals("")) {
                try {
                    apagarRegistro(txtISBN.getText());
                } catch (SQLException ex) {
                    Logger.getLogger(CadastroLivro10.class.getName()).log(Level.SEVERE, null, ex); //editar 
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Selecione um Livros");
            }
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        //grava o registro após verificar preenchimento de todos os campos
        if (verificarDados() == true) {
            try {
                cadastrarLivros();
            } catch (SQLException ex) {
            }
            limpar();
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
          limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void tabelaLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaLivrosMouseClicked

        int linha = tabelaLivros.getSelectedRow();

        if (linha < 0) return;
        
        try {
            String isbnSelecionado = tabelaLivros.getValueAt(linha, 4).toString();
            String sql = "SELECT * FROM livros WHERE ISBN='" + isbnSelecionado + "'"; 
        
            // de novo, novamente, mais uma vez, estabelecer a conexão com o DB
            Connection conex = Conexao.criarConexao();
            Statement ps;
            ps = conex.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            rs.next();
            this.txtTitulo.setText(rs.getString("titulo"));
            this.txtAutor.setText(rs.getString("autor"));
            this.comboboxTema.setSelectedItem(rs.getString("tema"));
            this.txtAnodePublicacao.setText(rs.getString("anoPublicacao"));
            this.txtISBN.setText(rs.getString("ISBN"));
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Nenhum Livro");
        }
    }//GEN-LAST:event_tabelaLivrosMouseClicked

    private void voltarTelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarTelaMouseClicked
        voltarTela();
    }//GEN-LAST:event_voltarTelaMouseClicked

  
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroLivro10().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> comboboxTema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabelaLivros;
    private javax.swing.JTextField txtAnodePublicacao;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JLabel voltarTela;
    // End of variables declaration//GEN-END:variables

    private void voltarTela() {
    TelaPrincipal telaPrincipal = new TelaPrincipal();
    telaPrincipal.setVisible(true);
    this.dispose();
    }
    
    private boolean verificarDados() {

        if (!txtTitulo.getText().isEmpty()
                && !txtAutor.getText().isEmpty()
                && !txtISBN.getText().isEmpty()
                && comboboxTema.getSelectedIndex() >= 0
                && !txtAnodePublicacao.getText().isEmpty()) {

            return true;
        } else {
            String msg = "Campos: Titulo, Autor, tema, ISBN, Ano De Publicação devem ser preenchidos";
            JOptionPane.showMessageDialog(null, msg, "Erro ao Salvar", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    private void cadastrarLivros() throws SQLException {
 
        Livros livro = new Livros();
        livro.setTitulo(txtTitulo.getText());
        livro.setAutor(txtAutor.getText());
        //livro.setTema(txtTema.getText());
        livro.setTema((String) comboboxTema.getSelectedItem());
        livro.setAnoDePublicacao(txtAnodePublicacao.getText());
        livro.setIsbn(txtISBN.getText());
        livro.setDisponibilidade("s");
 
        daoLivros gravarLivros = new daoLivros();
        //gravar contatos pega Dados no Inserir Livros (livro)
        gravarLivros.inserirLivros(livro);
        JOptionPane.showMessageDialog(null, "Gravado com sucesso!!!"); 
        //metodo 
        listarLivros();
    }

    private void listarLivros() throws SQLException {
        daoLivros dao = new daoLivros();
        lista = dao.pesquisarLivros("%" + txtPesquisa.getText() + "%");
        exibirLivros(lista);
    }

    private void exibirLivros(ArrayList<Livros> lista) {
        while (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum livro existente");
        } else {
            String[] linha = new String[]{null, null, null, null, null};
            // percorre a lista de Livros e preenche a tablemodel
            for (int i = 0; i < lista.size(); i++) {
                tabela.addRow(linha); // 
                tabela.setValueAt(lista.get(i).getTitulo(), i, 0);
                tabela.setValueAt(lista.get(i).getAutor(), i, 1);
                tabela.setValueAt(lista.get(i).getTema(), i, 2);
                tabela.setValueAt(lista.get(i).getAnoDePublicacao(), i, 3);
                tabela.setValueAt(lista.get(i).getIsbn(), i, 4);
            }
        }
    }
    
    private void apagarRegistro(String ISBN) throws SQLException {
        //instancia de um objeto para 'invocar' um metodo remoer registro 
        daoLivros biblioteca = new daoLivros();
        biblioteca.removerLivro(ISBN);
        //metodo para atuallizar o tableModel
        listarLivros();
        //método para limpar os campos do formulario
        limpar();
    }

    private void atualizarLivros() throws SQLException {
        Livros livro = new Livros();

        livro.setTitulo(txtTitulo.getText());
        livro.setAutor(txtAutor.getText());
        livro.setTema((String) comboboxTema.getSelectedItem());
        livro.setAnoDePublicacao(txtAnodePublicacao.getText());
        livro.setIsbn(txtISBN.getText());

        daoLivros biblioteca = new daoLivros();
        biblioteca.update(livro);

        String msg = "Livro Atualizado com sucesso";
        JOptionPane.showMessageDialog(null, msg);
    }

    private void limpar() {
        txtTitulo.setText("");
        txtISBN.setText("");
        comboboxTema.setSelectedIndex(-1);
        txtAnodePublicacao.setText("");
        txtAutor.setText("");
        txtPesquisa.setText("");
        txtTitulo.requestFocus();
    }
}

