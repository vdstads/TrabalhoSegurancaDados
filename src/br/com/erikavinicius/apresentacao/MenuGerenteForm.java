/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erikavinicius.apresentacao;

import br.com.erikavinicius.TrabalhoSeguranca;
import br.com.erikavinicius.dados.BancoDadosAtividade;
import br.com.erikavinicius.dados.BancoDadosDepartamento;
import br.com.erikavinicius.dados.BancoDadosFuncionario;
import br.com.erikavinicius.dados.BancoDadosProjeto;
import br.com.erikavinicius.entidade.Departamento;
import br.com.erikavinicius.entidade.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private BancoDadosDepartamento bancoDadosDepartamento;
    private BancoDadosAtividade bancoDadosAtividade;
    private BancoDadosProjeto bancoDadosProjeto;
    private BancoDadosFuncionario bancoDadosFuncionario;
    
    public MenuGerenteForm(TrabalhoSeguranca trabalhoSeguranca, Usuario usuario) {
        initComponents();
        this.usuarioAtivo = usuario;
        this.bancoDadosDepartamento = bancoDadosDepartamento;
        this.bancoDadosAtividade = bancoDadosAtividade;
        this.bancoDadosProjeto = bancoDadosProjeto;
        this.bancoDadosFuncionario = bancoDadosFuncionario;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuDepartamento = new javax.swing.JMenu();
        itmListaDepartamentos = new javax.swing.JMenuItem();
        MenuFuncionario = new javax.swing.JMenu();
        itmCadastroFuncionarios = new javax.swing.JMenuItem();
        itmListaFuncionarios = new javax.swing.JMenuItem();
        MenuProjeto = new javax.swing.JMenu();
        itmCadastrarProjeto = new javax.swing.JMenuItem();
        itmListarProjetos = new javax.swing.JMenuItem();
        MenuAtividade = new javax.swing.JMenu();
        itmCadastarAtividades = new javax.swing.JMenuItem();
        itmListarAtividades = new javax.swing.JMenuItem();
        itmListarAtividadesAtrasadas = new javax.swing.JMenuItem();
        MenuRelatorio = new javax.swing.JMenu();
        itmEmitirRelatorioProjeto = new javax.swing.JMenuItem();
        MenuSair = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        MenuDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/dossier-orange-icone-9020-32.png"))); // NOI18N
        MenuDepartamento.setText("Departamentos");

        itmListaDepartamentos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itmListaDepartamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/liste-texte-vue-icone-4177-32.png"))); // NOI18N
        itmListaDepartamentos.setText("Lista de Departamentos");
        itmListaDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListaDepartamentosActionPerformed(evt);
            }
        });
        MenuDepartamento.add(itmListaDepartamentos);

        jMenuBar1.add(MenuDepartamento);

        MenuFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/homme-costume-cravate-utilisateur-icone-7362-32.png"))); // NOI18N
        MenuFuncionario.setText("Funcionários");

        itmCadastroFuncionarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        itmCadastroFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/1416951045_user_add.png"))); // NOI18N
        itmCadastroFuncionarios.setText("Cadastrar Funcionarios");
        itmCadastroFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCadastroFuncionariosActionPerformed(evt);
            }
        });
        MenuFuncionario.add(itmCadastroFuncionarios);

        itmListaFuncionarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        itmListaFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/liste-texte-vue-icone-4177-32.png"))); // NOI18N
        itmListaFuncionarios.setText("Lista de Funcionários");
        itmListaFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListaFuncionariosActionPerformed(evt);
            }
        });
        MenuFuncionario.add(itmListaFuncionarios);

        jMenuBar1.add(MenuFuncionario);

        MenuProjeto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/Edit_page.png"))); // NOI18N
        MenuProjeto.setText("Projetos");

        itmCadastrarProjeto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        itmCadastrarProjeto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/Create.png"))); // NOI18N
        itmCadastrarProjeto.setText("Cadastrar Projetos");
        itmCadastrarProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCadastrarProjetoActionPerformed(evt);
            }
        });
        MenuProjeto.add(itmCadastrarProjeto);

        itmListarProjetos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itmListarProjetos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/liste-texte-vue-icone-4177-32.png"))); // NOI18N
        itmListarProjetos.setText("Listar Projetos");
        itmListarProjetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListarProjetosActionPerformed(evt);
            }
        });
        MenuProjeto.add(itmListarProjetos);

        jMenuBar1.add(MenuProjeto);

        MenuAtividade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/List.png"))); // NOI18N
        MenuAtividade.setText("Atividades");

        itmCadastarAtividades.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        itmCadastarAtividades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/List_add.jpg"))); // NOI18N
        itmCadastarAtividades.setText("Cadastrar Atividades");
        itmCadastarAtividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCadastarAtividadesActionPerformed(evt);
            }
        });
        MenuAtividade.add(itmCadastarAtividades);

        itmListarAtividades.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        itmListarAtividades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/liste-texte-vue-icone-4177-32.png"))); // NOI18N
        itmListarAtividades.setText("Listar Atividades");
        itmListarAtividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListarAtividadesActionPerformed(evt);
            }
        });
        MenuAtividade.add(itmListarAtividades);

        itmListarAtividadesAtrasadas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        itmListarAtividadesAtrasadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/To_do_list.png"))); // NOI18N
        itmListarAtividadesAtrasadas.setText("Listar Atividades em Atraso");
        itmListarAtividadesAtrasadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListarAtividadesAtrasadasActionPerformed(evt);
            }
        });
        MenuAtividade.add(itmListarAtividadesAtrasadas);

        jMenuBar1.add(MenuAtividade);

        MenuRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/10693_32x32.png"))); // NOI18N
        MenuRelatorio.setText("Relatórios");

        itmEmitirRelatorioProjeto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        itmEmitirRelatorioProjeto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/Form.png"))); // NOI18N
        itmEmitirRelatorioProjeto.setText("Emitir Relatório por Projeto");
        itmEmitirRelatorioProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmEmitirRelatorioProjetoActionPerformed(evt);
            }
        });
        MenuRelatorio.add(itmEmitirRelatorioProjeto);

        jMenuBar1.add(MenuRelatorio);

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
            .addGap(0, 760, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itmListaDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmListaDepartamentosActionPerformed
        try {
            if(this.bancoDadosDepartamento.ConsultaDepartamentoExiste()){
                ListaDepartamentoGerenteForm departamentoGerenteForm = null;
                departamentoGerenteForm = new ListaDepartamentoGerenteForm(this.trabalhoSeguranca);
                departamentoGerenteForm.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "Não possui Departamentos Cadastrados! Cadastre um Novo!", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuGerenteForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_itmListaDepartamentosActionPerformed

    private void itmCadastroFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCadastroFuncionariosActionPerformed
        CadastroFuncionarioGerenteForm cadastroFuncionarioGerenteForm = new CadastroFuncionarioGerenteForm(this.trabalhoSeguranca, this.usuarioAtivo);
        cadastroFuncionarioGerenteForm.setVisible(true);
    }//GEN-LAST:event_itmCadastroFuncionariosActionPerformed

    private void itmListaFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmListaFuncionariosActionPerformed
        
        List<Usuario> listaUser= new ArrayList<Usuario>();
        
        try {
            listaUser = (List<Usuario>) this.bancoDadosFuncionario.ConsultaFuncionariosDepartamento(usuarioAtivo.getSenha());
        } catch (SQLException ex) {
            Logger.getLogger(MenuGerenteForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
        if(!listaUser.isEmpty()){
        
            ListaFuncionarioGerenteForm listaFuncionarioGerenteForm =  new ListaFuncionarioGerenteForm(this.trabalhoSeguranca, usuarioAtivo);
            listaFuncionarioGerenteForm.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Não possui Funcionários Cadastrados! Cadastre um Novo!", "Erro", JOptionPane.WARNING_MESSAGE);
        }
        } catch (SQLException ex) {
            Logger.getLogger(MenuGerenteForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_itmListaFuncionariosActionPerformed

    private void MenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSairActionPerformed
      
    }//GEN-LAST:event_MenuSairActionPerformed

    private void MenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSairMouseClicked
        if(javax.swing.JOptionPane.showConfirmDialog(null,"Deseja Sair do Sistema?","ATENÇÃO ",javax.swing.JOptionPane.YES_NO_OPTION )==0){  
            System.exit(0);  
        }  
    }//GEN-LAST:event_MenuSairMouseClicked

    private void itmCadastrarProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCadastrarProjetoActionPerformed
        CadastroProjetoForm cadastroProjetoForm = new CadastroProjetoForm(this.trabalhoSeguranca, usuarioAtivo);
        cadastroProjetoForm.setVisible(true);
    }//GEN-LAST:event_itmCadastrarProjetoActionPerformed

    private void itmListarProjetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmListarProjetosActionPerformed
        try {
            if(this.bancoDadosProjeto.ConsultaProjetoExiste()){
                ListaProjetoForm listaProjetoForm = new ListaProjetoForm(this.trabalhoSeguranca, usuarioAtivo);  
                listaProjetoForm.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "Não possui Projetos Cadastrados! Cadastre um Novo!", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuGerenteForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itmListarProjetosActionPerformed

    private void itmCadastarAtividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCadastarAtividadesActionPerformed
      CadastroAtividadeForm cadastroAtividadesForm = new CadastroAtividadeForm(this.trabalhoSeguranca, usuarioAtivo);
      cadastroAtividadesForm.setVisible(true);
    }//GEN-LAST:event_itmCadastarAtividadesActionPerformed

    private void itmListarAtividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmListarAtividadesActionPerformed
        try {
            Usuario usuario = new Usuario();
            usuario = BancoDadosFuncionario.ConsultaFuncionarioPorEmail(usuarioAtivo.getEmail());
            if(this.bancoDadosAtividade.ConsultaAtividadeExiste(usuario.getSenha())){
                ListaAtividadeForm listaAtividadeForm = new ListaAtividadeForm(this.trabalhoSeguranca, usuarioAtivo);
                listaAtividadeForm.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "Não possui Atividades Cadastradas! Cadastre uma Nova!", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuGerenteForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itmListarAtividadesActionPerformed

    private void itmListarAtividadesAtrasadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmListarAtividadesAtrasadasActionPerformed
        ListaAtividadeAtrasadaForm listaAtividadeAtrasadaForm = null;
        try {
            listaAtividadeAtrasadaForm = new ListaAtividadeAtrasadaForm(this.trabalhoSeguranca, usuarioAtivo);
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuGerenteForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        listaAtividadeAtrasadaForm.setVisible(true);
    }//GEN-LAST:event_itmListarAtividadesAtrasadasActionPerformed

    private void itmEmitirRelatorioProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmEmitirRelatorioProjetoActionPerformed
        EmitirRelatorioProjeto emitirRelatorioProjeto = new EmitirRelatorioProjeto(this.trabalhoSeguranca);
        emitirRelatorioProjeto.setVisible(true);
    }//GEN-LAST:event_itmEmitirRelatorioProjetoActionPerformed

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
    private javax.swing.JMenu MenuAtividade;
    private javax.swing.JMenu MenuDepartamento;
    private javax.swing.JMenu MenuFuncionario;
    private javax.swing.JMenu MenuProjeto;
    private javax.swing.JMenu MenuRelatorio;
    private javax.swing.JMenu MenuSair;
    private javax.swing.JMenuItem itmCadastarAtividades;
    private javax.swing.JMenuItem itmCadastrarProjeto;
    private javax.swing.JMenuItem itmCadastroFuncionarios;
    private javax.swing.JMenuItem itmEmitirRelatorioProjeto;
    private javax.swing.JMenuItem itmListaDepartamentos;
    private javax.swing.JMenuItem itmListaFuncionarios;
    private javax.swing.JMenuItem itmListarAtividades;
    private javax.swing.JMenuItem itmListarAtividadesAtrasadas;
    private javax.swing.JMenuItem itmListarProjetos;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
