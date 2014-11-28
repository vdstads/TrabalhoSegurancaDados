/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.erikavinicius.apresentacao;

import br.com.erikavinicius.CryptographyTripleDES;
import br.com.erikavinicius.TrabalhoSeguranca;
import br.com.erikavinicius.dados.BancoDadosAtividade;
import br.com.erikavinicius.dados.BancoDadosDepartamento;
import br.com.erikavinicius.dados.BancoDadosFuncionario;
import br.com.erikavinicius.dados.BancoDadosProjeto;
import br.com.erikavinicius.entidade.Atividade;
import br.com.erikavinicius.entidade.Departamento;
import br.com.erikavinicius.entidade.Gerente;
import br.com.erikavinicius.entidade.Projeto;
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
public class ListaAtividadeForm extends javax.swing.JFrame {

    private TrabalhoSeguranca trabalhoSeguranca;
    private BancoDadosProjeto bancoDadosProjeto;
    private BancoDadosDepartamento bancoDadosDepartamento;
    private BancoDadosAtividade bancoDadosAtividade;
    private Usuario usuarioAtivo;
    Usuario usuario = new Usuario();
    private String codDepAtivo;
    
    
    public ListaAtividadeForm(TrabalhoSeguranca trabalhoSeguranca, Usuario usuario) throws SQLException {
        initComponents();
        this.trabalhoSeguranca = trabalhoSeguranca;
        this.bancoDadosProjeto = bancoDadosProjeto;
        this.bancoDadosDepartamento = bancoDadosDepartamento;
        this.bancoDadosAtividade = bancoDadosAtividade;
        this.usuarioAtivo = usuario;
        usuario = BancoDadosFuncionario.ConsultaFuncionarioPorEmail(usuarioAtivo.getEmail());
        this.codDepAtivo = usuario.getSenha();
        this.configurarTblAtividade();
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAtividade = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Atividades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        tblAtividade.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblAtividade);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/application_edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/application_delete.png"))); // NOI18N
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblAtividade.getSelectedRow() != - 1) {
           int result = JOptionPane.showConfirmDialog(null, "Deseja Editar ? ", "Editar", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                TabelaAtividadeModel model = null;
                try {
                    model = new TabelaAtividadeModel(this.bancoDadosAtividade.ConsultaAtividadePorProj(codDepAtivo));
                } catch (SQLException ex) {
                    Logger.getLogger(ListaAtividadeForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                int colunaCodigo = 0;
                int codigo =  (int) model.getValueAt(tblAtividade.getSelectedRow(), colunaCodigo);
                
               try {
                   EditaAtividadeForm editaAtividadeForm = new EditaAtividadeForm(this.trabalhoSeguranca, usuarioAtivo, codigo);
                   editaAtividadeForm.setVisible(true);
               } catch (SQLException ex) {
                   Logger.getLogger(ListaAtividadeForm.class.getName()).log(Level.SEVERE, null, ex);
               }
                
                
               try {
                   this.configurarTblAtividade();
               } catch (SQLException ex) {
                   Logger.getLogger(ListaAtividadeForm.class.getName()).log(Level.SEVERE, null, ex);
               }
                
                //JOptionPane.showMessageDialog(null,"Editado com sucesso!");
               this.dispose();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, selecione um item!");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tblAtividade.getSelectedRow() != - 1) {
            int result = JOptionPane.showConfirmDialog(null, "Deseja Excluir ? ", "Excluir", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                TabelaAtividadeModel model = null;
                try {
                    model = new TabelaAtividadeModel(this.bancoDadosAtividade.ConsultaAtividadePorProj(codDepAtivo));
                } catch (SQLException ex) {
                    Logger.getLogger(ListaAtividadeForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                int colunaCodigo = 0;
                int Codigo =  (int) model.getValueAt(tblAtividade.getSelectedRow(), colunaCodigo);

                /*try {
                    this.bancoDadosProjeto.remove(Codigo);
                    } catch (SQLException ex) {
                    Logger.getLogger(ListaAtividadeForm.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                
                try {
                    this.configurarTblAtividade();
                } catch (SQLException ex) {
                    Logger.getLogger(ListaAtividadeForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null,"Excluído com sucesso!");
                
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, selecione um item!");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed
    
    void configurarTblAtividade() throws SQLException {
        TabelaAtividadeModel model = new TabelaAtividadeModel(this.bancoDadosAtividade.ConsultaAtividadePorProj(codDepAtivo));

        tblAtividade.setModel(model);
    }

    private class TabelaAtividadeModel extends AbstractTableModel {

        private List<Atividade> listaAtividade;


        public TabelaAtividadeModel(List<Atividade> listaAtividade) {
            this.listaAtividade = listaAtividade;
        }

        @Override
        public int getRowCount() {
            return this.listaAtividade.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Atividade atividade = this.listaAtividade.get(rowIndex);
            if (columnIndex == 0) {
                return atividade.getCodigo();
            } else if(columnIndex==1) {
                return atividade.getNome();
            } else if(columnIndex==2) {
                return atividade.getDuracao();
            } else {
                return atividade.getEncarregado();
            }   
        }

        public String getColumnName(int columnIndex) {
            if (columnIndex == 0) {
                return "Código";
            } else if (columnIndex == 1){
                return "Nome";
            } else if (columnIndex == 2){
                return "Duração";
            } else {
                return "Encarregado";
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
    private javax.swing.JTable tblAtividade;
    // End of variables declaration//GEN-END:variables
}
