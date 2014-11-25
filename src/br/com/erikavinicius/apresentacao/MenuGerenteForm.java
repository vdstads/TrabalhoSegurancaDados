/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erikavinicius.apresentacao;

import br.com.erikavinicius.TrabalhoSeguranca;
import br.com.erikavinicius.entidade.Departamento;
import br.com.erikavinicius.entidade.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius
 */
public class MenuGerenteForm extends javax.swing.JFrame {
    private TrabalhoSeguranca trabalhoSeguranca;
    private Usuario usuarioAtivo;
    
    
    public MenuGerenteForm(TrabalhoSeguranca trabalhoSeguranca, Usuario usuario) {
        initComponents();
        this.usuarioAtivo = usuario;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itmListaDepartamentos = new javax.swing.JMenuItem();
        itmMenuCadastrarFuncionario = new javax.swing.JMenu();
        itmCadastroFuncionarios = new javax.swing.JMenuItem();
        itmListaFuncionarios = new javax.swing.JMenuItem();
        MenuSair = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        jMenu1.setText("Departamentos");

        itmListaDepartamentos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itmListaDepartamentos.setText("Lista de Departamentos");
        itmListaDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListaDepartamentosActionPerformed(evt);
            }
        });
        jMenu1.add(itmListaDepartamentos);

        jMenuBar1.add(jMenu1);

        itmMenuCadastrarFuncionario.setText("Funcionários");

        itmCadastroFuncionarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        itmCadastroFuncionarios.setText("Cadastrar Funcionarios");
        itmCadastroFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCadastroFuncionariosActionPerformed(evt);
            }
        });
        itmMenuCadastrarFuncionario.add(itmCadastroFuncionarios);

        itmListaFuncionarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        itmListaFuncionarios.setText("Lista de Funcionários");
        itmListaFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListaFuncionariosActionPerformed(evt);
            }
        });
        itmMenuCadastrarFuncionario.add(itmListaFuncionarios);

        jMenuBar1.add(itmMenuCadastrarFuncionario);

        MenuSair.setText("Sair");
        MenuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuSairMouseClicked(evt);
            }
        });
        MenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSairActionPerformed(evt);
            }
        });
        jMenuBar1.add(MenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itmListaDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmListaDepartamentosActionPerformed
        ListaDepartamentoGerenteForm departamentoGerenteForm = null;
        try {
            departamentoGerenteForm = new ListaDepartamentoGerenteForm(this.trabalhoSeguranca);
        } catch (Exception e) {
        }
        departamentoGerenteForm.setVisible(true);
        
    }//GEN-LAST:event_itmListaDepartamentosActionPerformed

    private void itmCadastroFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCadastroFuncionariosActionPerformed
        CadastroFuncionarioGerenteForm cadastroFuncionarioGerenteForm = new CadastroFuncionarioGerenteForm(this.trabalhoSeguranca, this.usuarioAtivo);
        cadastroFuncionarioGerenteForm.setVisible(true);
    }//GEN-LAST:event_itmCadastroFuncionariosActionPerformed

    private void itmListaFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmListaFuncionariosActionPerformed
        ListaFuncionarioGerenteForm listaFuncionarioGerenteForm = null;
        try {
            listaFuncionarioGerenteForm = new ListaFuncionarioGerenteForm(this.trabalhoSeguranca, usuarioAtivo);
        } catch (SQLException ex) {
            Logger.getLogger(MenuGerenteForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        listaFuncionarioGerenteForm.setVisible(true);
    }//GEN-LAST:event_itmListaFuncionariosActionPerformed

    private void MenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSairActionPerformed
      
    }//GEN-LAST:event_MenuSairActionPerformed

    private void MenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSairMouseClicked
       if(javax.swing.JOptionPane.showConfirmDialog(null,"Deseja Sair do Sistema?","ATENÇÂO ",javax.swing.JOptionPane.YES_NO_OPTION )==0){  
            System.exit(0);  
        }  
    }//GEN-LAST:event_MenuSairMouseClicked

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
            java.util.logging.Logger.getLogger(MenuGerenteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGerenteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGerenteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGerenteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuSair;
    private javax.swing.JMenuItem itmCadastroFuncionarios;
    private javax.swing.JMenuItem itmListaDepartamentos;
    private javax.swing.JMenuItem itmListaFuncionarios;
    private javax.swing.JMenu itmMenuCadastrarFuncionario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
