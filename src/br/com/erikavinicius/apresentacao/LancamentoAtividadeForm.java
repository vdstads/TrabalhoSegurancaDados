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
public class LancamentoAtividadeForm extends javax.swing.JFrame {

    private TrabalhoSeguranca trabalhoSeguranca;
    private BancoDadosAtividade bancoDadosAtividade;
    private BancoDadosFuncionario bancoDadosFuncionario;
    private Usuario usuarioAtivo;

    public LancamentoAtividadeForm(TrabalhoSeguranca trabalhoSeguranca, Usuario usuario) {
        initComponents();
        this.bancoDadosAtividade = bancoDadosAtividade;
        this.trabalhoSeguranca = trabalhoSeguranca;
        this.bancoDadosFuncionario = bancoDadosFuncionario;
        this.usuarioAtivo = usuario;
        this.configurarCmbAtividade();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblHoras = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        lblTarefa = new javax.swing.JLabel();
        cmbTarefa = new javax.swing.JComboBox();
        lblPercentual = new javax.swing.JLabel();
        txtPercentual = new javax.swing.JFormattedTextField();
        txtHrs = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lançamento de horas Trabalhadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        lblHoras.setText("Horas Trabalhadas:");

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/application_add.png"))); // NOI18N
        btnCadastrar.setText("Lançar Horas");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lblTarefa.setText("Tarefa:");

        cmbTarefa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTarefaActionPerformed(evt);
            }
        });

        lblPercentual.setText("Percentual de Conclusão:");

        try {
            txtPercentual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtPercentual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPercentualActionPerformed(evt);
            }
        });

        try {
            txtHrs.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTarefa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPercentual)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTarefa)
                                    .addComponent(lblHoras)
                                    .addComponent(lblPercentual))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btnCadastrar)
                        .addGap(0, 109, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtHrs)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHoras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHrs, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPercentual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPercentual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTarefa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnCadastrar)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
       try {
            int percentual = parseInt(this.txtPercentual.getText().trim());
            int horasTrab = parseInt(this.txtHrs.getText().trim());
            
            Atividade atvTemp = new Atividade();
            atvTemp = (Atividade) this.cmbTarefa.getSelectedItem();
            
            if (horasTrab < 1 || percentual >100 || percentual<1) {
                JOptionPane.showMessageDialog(this, "Preencha os campos Corretamente!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else {
                this.bancoDadosAtividade.SetaHorasAtividade(horasTrab, percentual, atvTemp.getCodigo());
                JOptionPane.showMessageDialog(this, "Horas adicionada com sucesso!", "Lançamento de horas", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoAtividadeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void cmbTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTarefaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTarefaActionPerformed

    private void txtPercentualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPercentualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPercentualActionPerformed

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
            java.util.logging.Logger.getLogger(LancamentoAtividadeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LancamentoAtividadeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LancamentoAtividadeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LancamentoAtividadeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }
     
    private void configurarCmbAtividade() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.cmbTarefa.getModel();
        model.removeAllElements();
        
        List<Atividade> listaTodos = null;
        Projeto projeto = null;
        try {
            listaTodos = this.bancoDadosAtividade.ConsultaAtividadePorEncarregado(usuarioAtivo.getCpf());
        } catch (SQLException ex) {
            Logger.getLogger(LancamentoAtividadeForm.class.getName()).log(Level.SEVERE, null, ex);
        }       
        for (Atividade a : listaTodos) {
               model.addElement(a);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox cmbTarefa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblHoras;
    private javax.swing.JLabel lblPercentual;
    private javax.swing.JLabel lblTarefa;
    private javax.swing.JFormattedTextField txtHrs;
    private javax.swing.JFormattedTextField txtPercentual;
    // End of variables declaration//GEN-END:variables
}
