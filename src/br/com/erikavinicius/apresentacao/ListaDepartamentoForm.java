/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.erikavinicius.apresentacao;

import br.com.erikavinicius.CryptographyTripleDES;
import br.com.erikavinicius.TrabalhoSeguranca;
import br.com.erikavinicius.dados.BancoDadosDepartamento;
import br.com.erikavinicius.dados.BancoDadosFuncionario;
import br.com.erikavinicius.entidade.Departamento;
import br.com.erikavinicius.entidade.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Erika
 */
public class ListaDepartamentoForm extends javax.swing.JFrame {

    private TrabalhoSeguranca trabalhoSeguranca;
    private BancoDadosFuncionario bancoDadosFuncionario;
    private BancoDadosDepartamento bancoDadosDepartamento;
 
    
    
    public ListaDepartamentoForm(TrabalhoSeguranca trabalhoSeguranca) throws SQLException {
        initComponents();
        this.trabalhoSeguranca = trabalhoSeguranca;
        this.bancoDadosFuncionario = bancoDadosFuncionario;
        this.bancoDadosDepartamento = bancoDadosDepartamento;
        this.configurarTblDepartamentos();
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDepartamentos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Funcionários");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Departamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        tblDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDepartamentos);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addContainerGap(118, Short.MAX_VALUE))
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
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblDepartamentos.getSelectedRow() != - 1) {
           int result = JOptionPane.showConfirmDialog(null, "Deseja Editar ? ", "Editar", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                TabelaDepartamentoModel model = null;
                try {
                    model = new TabelaDepartamentoModel(this.bancoDadosDepartamento.ConsultaTodosDepartamentos());
                } catch (SQLException ex) {
                    Logger.getLogger(ListaDepartamentoForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                int colunaCodigo = 0;
                String codigoDep = (String) model.getValueAt(tblDepartamentos.getSelectedRow(), colunaCodigo);
                String CPFAtual = (String) model.getValueAt(tblDepartamentos.getSelectedRow(), 2);
                
                EditaDepartamentoForm editaDepartamentoForm = new EditaDepartamentoForm(this.trabalhoSeguranca, codigoDep, CPFAtual);
                editaDepartamentoForm.setVisible(true);
                
               try {
                   this.configurarTblDepartamentos();
               } catch (SQLException ex) {
                   Logger.getLogger(ListaDepartamentoForm.class.getName()).log(Level.SEVERE, null, ex);
               }
                
                //JOptionPane.showMessageDialog(null,"Editado com sucesso!");
               this.dispose();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, selecione um item!");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       /* if (tblDepartamentos.getSelectedRow() != - 1) {
            int result = JOptionPane.showConfirmDialog(null, "Deseja Excluir ? ", "Excluir", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                TabelaFuncionariosModel model = null;
                try {
                    model = new TabelaFuncionariosModel(this.bancoDadosFuncionario.ConsultaTodos());
                } catch (SQLException ex) {
                    Logger.getLogger(ListaFuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                int colunaCPF = 1;
                String CPF = (String) model.getValueAt(tblDepartamentos.getSelectedRow(), colunaCPF);
                
                try {
                    this.bancoDadosFuncionario.removeFuncionario(CPF);
                } catch (SQLException ex) {
                    Logger.getLogger(ListaFuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    this.configurarTblFuncionarios();
                } catch (SQLException ex) {
                    Logger.getLogger(ListaFuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null,"Excluído com sucesso!");
                
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, selecione um item!");
        }*/
    }//GEN-LAST:event_btnExcluirActionPerformed
    
    void configurarTblDepartamentos() throws SQLException {
        
        TabelaDepartamentoModel model = new TabelaDepartamentoModel(this.bancoDadosDepartamento.ConsultaTodosDepartamentos());

        tblDepartamentos.setModel(model);
    }

    private class TabelaDepartamentoModel extends AbstractTableModel {

        private List<Departamento> listaDepartamento;

        public TabelaDepartamentoModel(List<Departamento> listaDepartamentos) {
            this.listaDepartamento = listaDepartamentos;
        }

        @Override
        public int getRowCount() {
            return this.listaDepartamento.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Departamento departamento = this.listaDepartamento.get(rowIndex);
            if (columnIndex == 0) {
                return departamento.getCodigo();
            } else if(columnIndex==1) {
                return departamento.getNome();
            } else {
                return departamento.getGerente().getNome();
            }   
        }

        public String getColumnName(int columnIndex) {
            if (columnIndex == 0) {
                return "Codigo";
            } else if (columnIndex == 1){
                return "Nome";
            } else {
                return "Gerente";
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
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDepartamentos;
    // End of variables declaration//GEN-END:variables
}
