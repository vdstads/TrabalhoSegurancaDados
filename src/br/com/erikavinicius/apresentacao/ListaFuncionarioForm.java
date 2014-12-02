/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.erikavinicius.apresentacao;

import br.com.erikavinicius.CryptographyTripleDES;
import br.com.erikavinicius.TrabalhoSeguranca;
import br.com.erikavinicius.dados.BancoDadosFuncionario;
import br.com.erikavinicius.entidade.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Erika
 */
public class ListaFuncionarioForm extends javax.swing.JFrame {

    private TrabalhoSeguranca trabalhoSeguranca;
    private BancoDadosFuncionario bancoDadosFuncionario;
    Logger logger = Logger.getLogger(TrabalhoSeguranca.class.getName()); 

    
    public ListaFuncionarioForm(TrabalhoSeguranca trabalhoSeguranca) throws SQLException {
        initComponents();
        this.trabalhoSeguranca = trabalhoSeguranca;
        this.bancoDadosFuncionario = bancoDadosFuncionario;
        
        this.configurarTblFuncionarios();
        
        try {
            
            FileHandler simpleHandler = new FileHandler("log.txt", true);
            simpleHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(simpleHandler);
            logger.setUseParentHandlers(false);
            
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Falha ao criar log", e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnDemitir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Funcionários", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblFuncionarios);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/application_edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnDemitir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/user_delete.png"))); // NOI18N
        btnDemitir.setText("Demitir");
        btnDemitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDemitirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDemitir, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnDemitir))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Lista de Funcionários");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblFuncionarios.getSelectedRow() != - 1) {
           int result = JOptionPane.showConfirmDialog(null, "Deseja Editar ? ", "Editar", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                TabelaFuncionariosModel model = null;
                try {
                    model = new TabelaFuncionariosModel(this.bancoDadosFuncionario.ConsultaTodos());
                } catch (SQLException ex) {
                    Logger.getLogger(ListaFuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
                    logger.log(Level.SEVERE, ex.getMessage(), ex);
                }
                int colunaCPF = 1;
                String CPF = (String) model.getValueAt(tblFuncionarios.getSelectedRow(), colunaCPF);
 
                EditaFuncionarioForm editaFuncionarioForm = new EditaFuncionarioForm(this.trabalhoSeguranca, CPF);
                editaFuncionarioForm.setVisible(true);
   
                try {
                   this.configurarTblFuncionarios();
                } catch (SQLException ex) {
                   Logger.getLogger(ListaFuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
                   logger.log(Level.SEVERE, ex.getMessage(), ex);
                }
                
                //JOptionPane.showMessageDialog(null,"Editado com sucesso!");
               this.dispose();
               logger.info("Funcionario Editado com sucesso");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, selecione um item!");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDemitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDemitirActionPerformed
        if (tblFuncionarios.getSelectedRow() != - 1) {
            int result = JOptionPane.showConfirmDialog(null, "Deseja Demitir ? ", "Demissão", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                TabelaFuncionariosModel model = null;
                try {
                    model = new TabelaFuncionariosModel(this.bancoDadosFuncionario.ConsultaTodos());
                } catch (SQLException ex) {
                    Logger.getLogger(ListaFuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
                    logger.log(Level.SEVERE, ex.getMessage(), ex);
                }
                int colunaCPF = 1;
                int colunaCargo = 2;
                String CPF = (String) model.getValueAt(tblFuncionarios.getSelectedRow(), colunaCPF);
                String CARGO = (String) model.getValueAt(tblFuncionarios.getSelectedRow(), colunaCargo);
                
                if (CARGO.equals("DIRETOR")) {
                    JOptionPane.showMessageDialog(null, "Não é permitido demitir Diretor!");
                } else {
                    try {
                        this.bancoDadosFuncionario.removeFuncionario(CPF);
                    } catch (SQLException ex) {
                        Logger.getLogger(ListaFuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
                        logger.log(Level.SEVERE, ex.getMessage(), ex);
                    }

                    try {
                        this.configurarTblFuncionarios();
                    } catch (SQLException ex) {
                        Logger.getLogger(ListaFuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
                        logger.log(Level.SEVERE, ex.getMessage(), ex);
                    }
                    JOptionPane.showMessageDialog(null,"Demitido com sucesso!");
                    logger.info("Funcionario Demitido com sucesso");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, selecione um item!");
        }
    }//GEN-LAST:event_btnDemitirActionPerformed
    
    void configurarTblFuncionarios() throws SQLException {
        
        TabelaFuncionariosModel model = new TabelaFuncionariosModel(this.bancoDadosFuncionario.ConsultaTodos());

        tblFuncionarios.setModel(model);
    }

    private class TabelaFuncionariosModel extends AbstractTableModel {

        private List<Usuario> listaFuncionarios;

        public TabelaFuncionariosModel(List<Usuario> listaFuncionarios) {
            this.listaFuncionarios = listaFuncionarios;
        }

        @Override
        public int getRowCount() {
            return this.listaFuncionarios.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Usuario funcionarios = this.listaFuncionarios.get(rowIndex);
            if (columnIndex == 0) {
                return funcionarios.getNome();
            } else if(columnIndex==1) {
                return funcionarios.getCpf();
            } else {
                return funcionarios.getCargo();
            }   
        }

        public String getColumnName(int columnIndex) {
            if (columnIndex == 0) {
                return "Nome";
            } else if (columnIndex == 1){
                return "CPF";
            } else {
                return "Cargo";
            }
        }
    }
    
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
            java.util.logging.Logger.getLogger(ListaFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDemitir;
    private javax.swing.JButton btnEditar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFuncionarios;
    // End of variables declaration//GEN-END:variables
}
