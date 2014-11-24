/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erikavinicius.apresentacao;

import br.com.erikavinicius.TrabalhoSeguranca;
import br.com.erikavinicius.dados.BancoDadosDepartamento;
import br.com.erikavinicius.dados.BancoDadosFuncionario;
import br.com.erikavinicius.entidade.Departamento;
import br.com.erikavinicius.entidade.Gerente;
import br.com.erikavinicius.entidade.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author vinicius
 */
public class CadastroEncDpoForm extends javax.swing.JFrame {

     private TrabalhoSeguranca trabalhoSeguranca;
    private BancoDadosFuncionario bancoDadosFuncionario;
    private BancoDadosDepartamento bancoDadosDepartamento;
    private String codigoDep;

    
    public CadastroEncDpoForm(TrabalhoSeguranca trabalhoSeguranca) {
        initComponents();
    this.trabalhoSeguranca = trabalhoSeguranca;
    this.bancoDadosFuncionario = bancoDadosFuncionario;
    this.bancoDadosDepartamento = bancoDadosDepartamento;
    this.codigoDep = codigoDep;
    this.configurarCmbDepartamento();
    this.configurarCmbEncarregado();
    
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCadastrar = new javax.swing.JButton();
        cmbEncarregado = new javax.swing.JComboBox();
        lblEncarregado = new javax.swing.JLabel();
        lblDepartamento = new javax.swing.JLabel();
        cmbDepertamento = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Empregado no Departamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        cmbEncarregado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEncarregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEncarregadoActionPerformed(evt);
            }
        });

        lblEncarregado.setText("Encarregado:");

        lblDepartamento.setText("Departamento:");

        cmbDepertamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbDepertamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepertamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbEncarregado, 0, 409, Short.MAX_VALUE)
                    .addComponent(cmbDepertamento, 0, 409, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEncarregado)
                            .addComponent(lblDepartamento))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEncarregado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbEncarregado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDepartamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbDepertamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnCadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
       /* Departamento depTemp = new Departamento();
        depTemp = (Departamento) this.cmbEncarregado.getSelectedItem();

        String nome = this.txtNome.getText().trim();
        String codigo = this.txtCodigo.getText().trim();
        String cpfGerente = depTemp.getGerente().getCpf();

        if(nome.isEmpty() || codigo.isEmpty()){
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.WARNING_MESSAGE);
        }else{
            try {
                this.bancoDadosDepartamento.EditaDepartamento(codigo, nome, cpfGerente, codigoDep);
            } catch (SQLException ex) {
                Logger.getLogger(EditaDepartamentoForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Departamento Editado com sucesso!", "Edição de Departamento", JOptionPane.INFORMATION_MESSAGE);
            limpar();
            this.dispose();
        }*/
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void cmbEncarregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEncarregadoActionPerformed

    }//GEN-LAST:event_cmbEncarregadoActionPerformed

    private void cmbDepertamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepertamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDepertamentoActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroEncDpoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroEncDpoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroEncDpoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroEncDpoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }
    
     private void configurarCmbEncarregado() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.cmbEncarregado.getModel();
        model.removeAllElements();
        
        List<Usuario> listaTodos = null;
        Usuario user = null;
        try {
            listaTodos = this.bancoDadosFuncionario.ConsultaEncarregadoDisponivel();
        } catch (SQLException ex) {
            Logger.getLogger(EditaDepartamentoForm.class.getName()).log(Level.SEVERE, null, ex);
        }       
        for (Usuario gerente : listaTodos) {
               model.addElement(gerente);
        }
    }
     
    private void configurarCmbDepartamento() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.cmbEncarregado.getModel();
        model.removeAllElements();
        
        List<Departamento> listaDepartamentos = null;
        try {
            listaDepartamentos = this.bancoDadosDepartamento.ConsultaTodosDepartamentos();
        } catch (SQLException ex) {
            Logger.getLogger(EditaDepartamentoForm.class.getName()).log(Level.SEVERE, null, ex);
        }       
        for (Departamento departamento : listaDepartamentos) {
               model.addElement(departamento);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox cmbDepertamento;
    private javax.swing.JComboBox cmbEncarregado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblEncarregado;
    // End of variables declaration//GEN-END:variables
}
