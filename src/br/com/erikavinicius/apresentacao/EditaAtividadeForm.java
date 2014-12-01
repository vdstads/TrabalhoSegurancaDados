/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erikavinicius.apresentacao;

import br.com.erikavinicius.TrabalhoSeguranca;
import br.com.erikavinicius.dados.BancoDadosAtividade;
import br.com.erikavinicius.dados.BancoDadosFuncionario;
import br.com.erikavinicius.dados.BancoDadosProjeto;
import br.com.erikavinicius.entidade.Atividade;
import br.com.erikavinicius.entidade.Departamento;
import br.com.erikavinicius.entidade.Encarregado;
import br.com.erikavinicius.entidade.Projeto;
import br.com.erikavinicius.entidade.Usuario;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius
 */
public class EditaAtividadeForm extends javax.swing.JFrame {

    private TrabalhoSeguranca trabalhoSeguranca;
    private BancoDadosAtividade bancoDadosAtividade;
    private BancoDadosFuncionario bancoDadosFuncionario;
    private BancoDadosProjeto bancoDadosProjeto;
    private Usuario usuarioAtivo;
    Usuario usuario = new Usuario();
    private String codDepAtivo;
    private int codAtv;

    public EditaAtividadeForm(TrabalhoSeguranca trabalhoSeguranca, Usuario usuario, int cod) throws SQLException {
        initComponents();
        this.bancoDadosAtividade = bancoDadosAtividade;
        this.trabalhoSeguranca = trabalhoSeguranca;
        this.bancoDadosFuncionario = bancoDadosFuncionario;
        this.bancoDadosProjeto = bancoDadosProjeto;
        this.usuarioAtivo = usuario;
        this.codAtv = cod;
        usuario = BancoDadosFuncionario.ConsultaFuncionarioPorEmail(usuarioAtivo.getEmail());
        this.codDepAtivo = usuario.getSenha();
        this.configurarCmbEncarregado();
        this.configurarCmbProjeto();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblDuração = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        txtDuracao = new javax.swing.JFormattedTextField();
        lblEncarregado = new javax.swing.JLabel();
        cmbEncarregado = new javax.swing.JComboBox();
        lblProjeto = new javax.swing.JLabel();
        cmbProjeto = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edição de Atividades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        lblNome.setText("Nome:");

        lblDuração.setText("Duração Prevista:");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/tick.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtDuracao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##########"))));
        txtDuracao.setText("0");
        txtDuracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracaoActionPerformed(evt);
            }
        });

        lblEncarregado.setText("Encarregado:");

        cmbEncarregado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEncarregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEncarregadoActionPerformed(evt);
            }
        });

        lblProjeto.setText("Projeto:");

        cmbProjeto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProjetoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(btnSalvar)
                .addContainerGap(165, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome)
                    .addComponent(txtDuracao)
                    .addComponent(cmbEncarregado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbProjeto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEncarregado)
                            .addComponent(lblDuração)
                            .addComponent(lblNome)
                            .addComponent(lblProjeto))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDuração)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEncarregado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbEncarregado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblProjeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            int codigo = this.codAtv;
            String nome = this.txtNome.getText().trim();
            int duracao = parseInt(this.txtDuracao.getText().trim());
            Usuario encTemp = new Usuario();
            encTemp = (Usuario) this.cmbEncarregado.getSelectedItem();
            Projeto projTemp = new Projeto();
            projTemp = (Projeto) this.cmbProjeto.getSelectedItem();
            int codProjeto = projTemp.getCodigo();
            
            if (nome.isEmpty() || duracao == 0) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else {
                this.bancoDadosAtividade.EditaAtividade(codigo, nome, duracao, encTemp.getCpf(), codProjeto);
                JOptionPane.showMessageDialog(this, "Atividade adicionada com sucesso!", "Cadastro de Atividade", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditaAtividadeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cmbEncarregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEncarregadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEncarregadoActionPerformed

    private void txtDuracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuracaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuracaoActionPerformed

    private void cmbProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProjetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProjetoActionPerformed

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
            java.util.logging.Logger.getLogger(EditaAtividadeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditaAtividadeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditaAtividadeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditaAtividadeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
    }
    private void configurarCmbEncarregado() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.cmbEncarregado.getModel();
        model.removeAllElements();
        
        List<Usuario> listaTodos = null;
        Usuario user = null;
        try {
            listaTodos = this.bancoDadosFuncionario.ConsultaFuncionariosDepartamento(usuarioAtivo.getSenha());
        } catch (SQLException ex) {
            Logger.getLogger(EditaDepartamentoForm.class.getName()).log(Level.SEVERE, null, ex);
        }       
        for (Usuario gerente : listaTodos) {
               model.addElement(gerente);
        }
    }
    
    private void configurarCmbProjeto() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.cmbProjeto.getModel();
        model.removeAllElements();
        
        List<Projeto> listaTodos = null;
        Projeto projeto = null;
        try {
            listaTodos = this.bancoDadosProjeto.ConsultaProjetoPorDep(usuarioAtivo.getSenha());
        } catch (SQLException ex) {
            Logger.getLogger(EditaDepartamentoForm.class.getName()).log(Level.SEVERE, null, ex);
        }       
        for (Projeto p : listaTodos) {
               model.addElement(p);
        }
    }
    
    private void preencher() {

        Atividade atvTemp = new Atividade();
        List<Atividade> listaAtividade = null;
        try {
            listaAtividade  = this.bancoDadosAtividade.ConsultaAtividadePorDep(codDepAtivo);
        } catch (SQLException ex) {
            Logger.getLogger(EditaDepartamentoForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Atividade atividade : listaAtividade) {
            if (atividade.getCodigo() == codAtv) {
               atvTemp = atividade;
               break;
            }
        }
        
        txtNome.setText(Integer.toString(atvTemp.getDuracao()));        
        txtNome.setText(atvTemp.getNome());
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cmbEncarregado;
    private javax.swing.JComboBox cmbProjeto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDuração;
    private javax.swing.JLabel lblEncarregado;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblProjeto;
    private javax.swing.JFormattedTextField txtDuracao;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
