package view;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JComboBox;
import dao.daoEmprestimo;
import dao.daoLivros;
import java.awt.Desktop;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Livros;
import model.Usuario;
import model.livroEmprestimo;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.EmailUtil;

/**
 *
 * @author 998518
 */
public class RealizarEmprestimo extends javax.swing.JFrame {

    private final JComboBox<Usuario> comboClientes;
    private final JComboBox<Livros> comboLivros;
    livroEmprestimo emprestimo = new livroEmprestimo();
    Object[] nomeColunas;
    ArrayList<livroEmprestimo> lista;
    DefaultTableModel tabela;

    public RealizarEmprestimo() {
        initComponents();
        comboClientes = (JComboBox<Usuario>) (JComboBox<?>) cxbCliente;
        comboLivros = (JComboBox<Livros>) (JComboBox<?>) cxbLivro;
        carregarComboBoxes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnConfirmaEmprestimo = new javax.swing.JButton();
        txtDataDevolucao = new javax.swing.JTextField();
        txtDataEmprestimo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        voltarTela = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cxbCliente = new javax.swing.JComboBox<>();
        cxbLivro = new javax.swing.JComboBox<>();
        btnRelatorio = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(728, 667));

        btnConfirmaEmprestimo.setBackground(new java.awt.Color(159, 199, 170));
        btnConfirmaEmprestimo.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnConfirmaEmprestimo.setText("Confirmar Emprestimo");
        btnConfirmaEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmaEmprestimoActionPerformed(evt);
            }
        });

        txtDataDevolucao.setBackground(new java.awt.Color(240, 240, 234));

        txtDataEmprestimo.setBackground(new java.awt.Color(240, 240, 234));

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel2.setText("Cliente:");

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel3.setText("Livro:");

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));
        jPanel3.setPreferredSize(new java.awt.Dimension(728, 58));

        voltarTela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/right-arrow (1).png"))); // NOI18N
        voltarTela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voltarTelaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(voltarTela, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(voltarTela, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(240, 240, 234));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logos/fabulas_logo_450x250_sharpened.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(107, 107, 107))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel1.setText("Realizar Emprestimo");

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel4.setText("Data de Devolução:");

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel5.setText("Data de Emprestimo:");

        cxbCliente.setBackground(new java.awt.Color(240, 240, 234));
        cxbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cxbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxbClienteActionPerformed(evt);
            }
        });

        cxbLivro.setBackground(new java.awt.Color(240, 240, 234));
        cxbLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cxbLivro.setSelectedIndex(1);
        cxbLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxbLivroActionPerformed(evt);
            }
        });

        btnRelatorio.setBackground(new java.awt.Color(159, 199, 170));
        btnRelatorio.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnRelatorio.setText("Inprimir Formulario");
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        limpar.setBackground(new java.awt.Color(159, 199, 170));
        limpar.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        limpar.setText("Limpar");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        jToggleButton1.setBackground(new java.awt.Color(159, 199, 170));
        jToggleButton1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jToggleButton1.setText("Tela de devolução");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cxbLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cxbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConfirmaEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(btnRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(limpar, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(26, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cxbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(btnConfirmaEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cxbLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmaEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmaEmprestimoActionPerformed
        //grava o registro após verificar preenchimento de todos os campos
        if (verificarDados() == true) {
            try {
                cadastrarEmprestimo();
            } catch (SQLException ex) {
            String msg = "Todos os campos devem ser preenchidos e um livro e um cliente devem ser selecionados.";
            JOptionPane.showMessageDialog(null, msg, "Erro ao Salvar", JOptionPane.ERROR_MESSAGE);
            } catch (java.text.ParseException ex) {
                Logger.getLogger(RealizarEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnConfirmaEmprestimoActionPerformed

    private void cxbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxbClienteActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_cxbClienteActionPerformed

    private void cxbLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxbLivroActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_cxbLivroActionPerformed

    private void voltarTelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarTelaMouseClicked
        voltarTela();
    }//GEN-LAST:event_voltarTelaMouseClicked

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        // definir uma instancia para um objeto documento PFD
        // import com.itextpdf.text.Document;
        Document docPDF = new Document(PageSize.A6.rotate(), 20, 20, 20, 20);

        try {
            String nomeArquivo = emprestimo.getId_Emprestimo() + "º Empréstimo de Fábulas do Passado.pdf";
            PdfWriter.getInstance(docPDF, new FileOutputStream(nomeArquivo));
            docPDF.open();

            // Fontes personalizadas
            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font textoFont = new Font(Font.FontFamily.HELVETICA, 12);
            Font rodapeFont = new Font(Font.FontFamily.HELVETICA, 8, Font.ITALIC, BaseColor.GRAY);

            // Título
            Paragraph titulo = new Paragraph("COMPROVANTE DE EMPRÉSTIMO\nFÁBULAS DO PASSADO", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(10f);
            docPDF.add(titulo);

            docPDF.add(new Chunk(new LineSeparator()));
            docPDF.add(Chunk.NEWLINE);

            // Conteúdo
            String cliente = comboClientes.getSelectedItem().toString();
            String livro = comboLivros.getSelectedItem().toString();
            Livros livroSelecionado = (Livros) comboLivros.getSelectedItem();
            String isbn = livroSelecionado.getIsbn();
            String dataEmprestimo = txtDataEmprestimo.getText();
            String dataDevolucao = txtDataDevolucao.getText();

            docPDF.add(Chunk.NEWLINE);
            docPDF.add(new Paragraph("Cliente: " + cliente, textoFont));
            docPDF.add(new Paragraph("Livro: " + livro, textoFont));
            docPDF.add(new Paragraph("ISBN: " + isbn, textoFont));
            docPDF.add(new Paragraph("Data do Empréstimo: " + dataEmprestimo, textoFont));
            docPDF.add(new Paragraph("Data de Devolução: " + dataDevolucao, textoFont));

            docPDF.add(Chunk.NEWLINE);
            docPDF.add(new Chunk(new LineSeparator()));

            Paragraph rodape = new Paragraph("Obrigado pela preferência Fábulas do Passado.", rodapeFont);
            rodape.setAlignment(Element.ALIGN_CENTER);
            rodape.setSpacingBefore(10f);
            docPDF.add(rodape);

            docPDF.close();

            // Abre o PDF automaticamente
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(nomeArquivo));
            }
            System.out.println("Comprovante gerado e aberto com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (docPDF.isOpen()) {
                docPDF.close();
            }
        }
    }//GEN-LAST:event_btnRelatorioActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        limpar();
    }//GEN-LAST:event_limparActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    TelaDevolucao livrosDevolucao = new TelaDevolucao();
    livrosDevolucao.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RealizarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RealizarEmprestimo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmaEmprestimo;
    private javax.swing.JButton btnRelatorio;
    private javax.swing.JComboBox<String> cxbCliente;
    private javax.swing.JComboBox<String> cxbLivro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton limpar;
    private javax.swing.JTextField txtDataDevolucao;
    private javax.swing.JTextField txtDataEmprestimo;
    private javax.swing.JLabel voltarTela;
    // End of variables declaration//GEN-END:variables

    private void voltarTela() {
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.setVisible(true);
        this.dispose();
    }

    private boolean verificarDados() {
      if (!txtDataDevolucao.getText().isEmpty()
            && !txtDataEmprestimo.getText().isEmpty()
            && cxbCliente.getSelectedIndex() > 0
            && cxbLivro.getSelectedIndex() > 0) {
        
        return true;
    } else {
        String msg = "Todos os campos devem ser preenchidos e um livro e um cliente devem ser selecionados.";
        JOptionPane.showMessageDialog(null, msg, "Erro ao Salvar", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    }

   private void limpar() {
    txtDataDevolucao.setText("");
    txtDataEmprestimo.setText("");
    cxbCliente.setSelectedIndex(0); 
    cxbLivro.setSelectedIndex(0);   
    cxbCliente.requestFocus();
}

    private void cadastrarEmprestimo() throws SQLException, java.text.ParseException {
    livroEmprestimo emprestimo = new livroEmprestimo();

    // Pega os objetos selecionados
    Usuario usuarioSelecionado = (Usuario) comboClientes.getSelectedItem();
    Livros livroSelecionado = (Livros) comboLivros.getSelectedItem();

    if (usuarioSelecionado == null || livroSelecionado == null) {
        JOptionPane.showMessageDialog(this, "Selecione um usuário e um livro válidos.");
        return;
    }

    // Define dados do empréstimo
    emprestimo.setUsuario_CPF(usuarioSelecionado.getCPF());
    emprestimo.setLivros_ISBN(livroSelecionado.getIsbn());
    emprestimo.setDataEmprestimo(txtDataEmprestimo.getText());
    emprestimo.setDataDevolucao(txtDataDevolucao.getText());

    daoEmprestimo crud = new daoEmprestimo();
    crud.inserirLivrosEmprestimo(emprestimo); // grava no banco
    atualizarLivros();

    // Enviar e-mail
    String assunto = "📚 Empréstimo Confirmado - Fábulas do Passado";
    String corpo = "Olá " + usuarioSelecionado.getNome() + ",\n\n"
                 + "Você realizou o empréstimo do livro:\n"
                 + "📖 " + livroSelecionado.getTitulo() + "\n"
                 + "📅 Empréstimo: " + txtDataEmprestimo.getText() + "\n"
                 + "📅 Devolução: " + txtDataDevolucao.getText() + "\n\n"
                 + "Por favor, devolva o livro até a data combinada.\n\n"
                 + "Obrigado!\nEquipe Fábulas do Passado";

    try {
        EmailUtil.enviarEmail(usuarioSelecionado.getEmail(), assunto, corpo);
        JOptionPane.showMessageDialog(this, "Empréstimo cadastrado com sucesso!\nE-mail enviado ao cliente.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Empréstimo salvo, mas falha ao enviar e-mail:\n" + e.getMessage());
        e.printStackTrace();
    }
}

    private void carregarComboBoxes() {
        daoEmprestimo crud = new daoEmprestimo();
        try {
            comboClientes.removeAllItems();
            comboClientes.addItem(null); // item vazio para "selecione"
            for (Usuario u : crud.listarTodosUsuarios()) {
                comboClientes.addItem(u);
            }
            comboLivros.removeAllItems();
            comboLivros.addItem(null);
            for (Livros l : crud.listarTodosLivros()) {
                comboLivros.addItem(l);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + ex.getMessage());
        }
    }
    
//se der errado continuar aqui.
    private void atualizarLivros() throws SQLException {
        Livros livroSelecionado = (Livros) comboLivros.getSelectedItem();

        if (livroSelecionado != null && livroSelecionado.getIsbn() != null) {
            livroSelecionado.setDisponibilidade("n"); // ou "emprestado", conforme seu sistema

            dao.daoLivros biblioteca = new daoLivros();
            biblioteca.updateDisponibilidade(livroSelecionado);

            String msg = "Emprestimo cadastrado com sucesso";
            JOptionPane.showMessageDialog(null, msg);
        } else {
            JOptionPane.showMessageDialog(null, "Erro: Nenhum livro selecionado ou ISBN inválido.");
        }
    }

}
