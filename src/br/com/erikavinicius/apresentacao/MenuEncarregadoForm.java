/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.erikavinicius.apresentacao;

import br.com.erikavinicius.TrabalhoSeguranca;
import br.com.erikavinicius.dados.BancoDadosAtividade;
import br.com.erikavinicius.entidade.Atividade;
import br.com.erikavinicius.entidade.Projeto;
import br.com.erikavinicius.entidade.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Erika
 */
public class MenuEncarregadoForm extends javax.swing.JFrame {

    private TrabalhoSeguranca trabalhoSeguranca;
    private Usuario usuarioAtivo;
    private BancoDadosAtividade bancoDadosAtividade;
    Logger logger = Logger.getLogger(TrabalhoSeguranca.class.getName());
    
    MenuEncarregadoForm(TrabalhoSeguranca trabalhoSeguranca, Usuario usuario) {
        initComponents();
        this.trabalhoSeguranca = trabalhoSeguranca;
        this.usuarioAtivo = usuario;
        this.bancoDadosAtividade = bancoDadosAtividade;
        
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

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itmAlterarDados = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        itmLancaHoras = new javax.swing.JMenuItem();
        itmListaAtividades = new javax.swing.JMenuItem();
        MenuSair = new javax.swing.JMenu();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/flashkard-icone-4018-32.png"))); // NOI18N
        jMenu1.setText("Dados");

        itmAlterarDados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itmAlterarDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/kwrite-icone-4245-32.png"))); // NOI18N
        itmAlterarDados.setText("Alterar");
        itmAlterarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAlterarDadosActionPerformed(evt);
            }
        });
        jMenu1.add(itmAlterarDados);

        jMenuBar1.add(jMenu1);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/Pencil.png"))); // NOI18N
        jMenu4.setText("Lançamento");

        itmLancaHoras.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        itmLancaHoras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/To_do_list.png"))); // NOI18N
        itmLancaHoras.setText("Lançar Horas Trabalhadas");
        itmLancaHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmLancaHorasActionPerformed(evt);
            }
        });
        jMenu4.add(itmLancaHoras);

        itmListaAtividades.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        itmListaAtividades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/liste-texte-vue-icone-4177-32.png"))); // NOI18N
        itmListaAtividades.setText("Lista Atividades");
        itmListaAtividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListaAtividadesActionPerformed(evt);
            }
        });
        jMenu4.add(itmListaAtividades);

        jMenuBar1.add(jMenu4);

        MenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/halte-session-icone-4911-32.png"))); // NOI18N
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
            .addGap(0, 266, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuSairActionPerformed

    private void MenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSairMouseClicked
        if(javax.swing.JOptionPane.showConfirmDialog(null,"Deseja Sair do Sistema?","ATENÇÃO ",javax.swing.JOptionPane.YES_NO_OPTION )==0){  
            System.exit(0);  
        } 
    }//GEN-LAST:event_MenuSairMouseClicked

    private void itmAlterarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAlterarDadosActionPerformed
        AlteraDadosEncarregado alteraDadosEncarregado = new AlteraDadosEncarregado(this.trabalhoSeguranca, usuarioAtivo);
        alteraDadosEncarregado.setVisible(true);
    }//GEN-LAST:event_itmAlterarDadosActionPerformed

    private void itmLancaHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmLancaHorasActionPerformed

        try {
            List<Atividade> listaTodos = this.bancoDadosAtividade.ConsultaAtividadePorEncarregado(usuarioAtivo.getCpf());
            if(!listaTodos.isEmpty()){
                LancamentoAtividadeForm lancamentoAtividadeForm = new LancamentoAtividadeForm(trabalhoSeguranca, usuarioAtivo);
                lancamentoAtividadeForm.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "Não possui Atividades Cadastradas para Você!", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuEncarregadoForm.class.getName()).log(Level.SEVERE, null, ex);
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }

        
    }//GEN-LAST:event_itmLancaHorasActionPerformed

    private void itmListaAtividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmListaAtividadesActionPerformed
        try{
            List<Atividade> listaTodos = this.bancoDadosAtividade.ConsultaAtividadePorEncarregado(usuarioAtivo.getCpf());
            if(!listaTodos.isEmpty()){
                ListaAtividadeEmpregadoForm listaAtividadeEmpregadoForm = new ListaAtividadeEmpregadoForm(trabalhoSeguranca, usuarioAtivo);
                listaAtividadeEmpregadoForm.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "Não possui Atividades Cadastradas para Você!", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception e){
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }//GEN-LAST:event_itmListaAtividadesActionPerformed

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
            java.util.logging.Logger.getLogger(MenuEncarregadoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuEncarregadoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuEncarregadoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuEncarregadoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuSair;
    private javax.swing.JMenuItem itmAlterarDados;
    private javax.swing.JMenuItem itmLancaHoras;
    private javax.swing.JMenuItem itmListaAtividades;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    // End of variables declaration//GEN-END:variables
}
