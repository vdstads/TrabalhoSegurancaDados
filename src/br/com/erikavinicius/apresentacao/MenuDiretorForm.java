/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.erikavinicius.apresentacao;

import br.com.erikavinicius.TrabalhoSeguranca;
import br.com.erikavinicius.dados.BancoDadosDepartamento;
import br.com.erikavinicius.dados.BancoDadosFuncionario;
import br.com.erikavinicius.dados.BancoDadosProjeto;
import br.com.erikavinicius.entidade.Atividade;
import br.com.erikavinicius.entidade.Departamento;
import br.com.erikavinicius.entidade.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Erika
 */
public class MenuDiretorForm extends javax.swing.JFrame {

    private TrabalhoSeguranca trabalhoSeguranca;
    private BancoDadosFuncionario bancoDadosFuncionario;
    private BancoDadosDepartamento bancoDadosDepartamento;
    private BancoDadosProjeto bancoDadosProjeto;
    
    
    public MenuDiretorForm(TrabalhoSeguranca trabalhoSeguranca) {
        initComponents();
        this.trabalhoSeguranca = trabalhoSeguranca;
        this.bancoDadosFuncionario = bancoDadosFuncionario;
        this.bancoDadosDepartamento = bancoDadosDepartamento;
        this.bancoDadosProjeto = bancoDadosProjeto;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itmCadastroDepartamentos = new javax.swing.JMenuItem();
        itmListaDepartamentos = new javax.swing.JMenuItem();
        itmMenuCadastrarFuncionario = new javax.swing.JMenu();
        itmCadastroFuncionarios = new javax.swing.JMenuItem();
        itmListaFuncionarios = new javax.swing.JMenuItem();
        itmCadastroCargo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itmEmitirRelatorioProjetoDiretor = new javax.swing.JMenuItem();
        MenuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setExtendedState(6);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/dossier-orange-icone-9020-32.png"))); // NOI18N
        jMenu1.setText("Departamentos");

        itmCadastroDepartamentos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itmCadastroDepartamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/departamento.png"))); // NOI18N
        itmCadastroDepartamentos.setText("Cadastrar Departamentos");
        itmCadastroDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCadastroDepartamentosActionPerformed(evt);
            }
        });
        jMenu1.add(itmCadastroDepartamentos);

        itmListaDepartamentos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        itmListaDepartamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/liste-texte-vue-icone-4177-32.png"))); // NOI18N
        itmListaDepartamentos.setText("Lista de Departamentos");
        itmListaDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListaDepartamentosActionPerformed(evt);
            }
        });
        jMenu1.add(itmListaDepartamentos);

        jMenuBar1.add(jMenu1);

        itmMenuCadastrarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/homme-costume-cravate-utilisateur-icone-7362-32.png"))); // NOI18N
        itmMenuCadastrarFuncionario.setText("Funcionários");

        itmCadastroFuncionarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        itmCadastroFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/1416951045_user_add.png"))); // NOI18N
        itmCadastroFuncionarios.setText("Cadastrar Funcionarios");
        itmCadastroFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCadastroFuncionariosActionPerformed(evt);
            }
        });
        itmMenuCadastrarFuncionario.add(itmCadastroFuncionarios);

        itmListaFuncionarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        itmListaFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/liste-texte-vue-icone-4177-32.png"))); // NOI18N
        itmListaFuncionarios.setText("Lista de Funcionários");
        itmListaFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmListaFuncionariosActionPerformed(evt);
            }
        });
        itmMenuCadastrarFuncionario.add(itmListaFuncionarios);

        itmCadastroCargo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        itmCadastroCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/cargo.png"))); // NOI18N
        itmCadastroCargo.setText("Cadastro de Cargo");
        itmCadastroCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmCadastroCargoActionPerformed(evt);
            }
        });
        itmMenuCadastrarFuncionario.add(itmCadastroCargo);

        jMenuBar1.add(itmMenuCadastrarFuncionario);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/9754_32x32.png"))); // NOI18N
        jMenu2.setText("Relatórios");

        itmEmitirRelatorioProjetoDiretor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        itmEmitirRelatorioProjetoDiretor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/List.png"))); // NOI18N
        itmEmitirRelatorioProjetoDiretor.setText("Emitir Relatório por Projeto");
        itmEmitirRelatorioProjetoDiretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmEmitirRelatorioProjetoDiretorActionPerformed(evt);
            }
        });
        jMenu2.add(itmEmitirRelatorioProjetoDiretor);

        jMenuBar1.add(jMenu2);

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
            .addGap(0, 559, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itmCadastroFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCadastroFuncionariosActionPerformed
        CadastroFuncionarioForm cadastroFuncionarioForm = new CadastroFuncionarioForm(this.trabalhoSeguranca);
        cadastroFuncionarioForm.setVisible(true);
    }//GEN-LAST:event_itmCadastroFuncionariosActionPerformed

    private void itmListaDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmListaDepartamentosActionPerformed
        try {
            if(this.bancoDadosDepartamento.ConsultaDepartamentoExiste()){
                ListaDepartamentoForm listaDepartamentoForm = new ListaDepartamentoForm(this.trabalhoSeguranca);
                listaDepartamentoForm.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "Não possui Departamentos Cadastrados! Cadastre um Novo!", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuGerenteForm.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_itmListaDepartamentosActionPerformed

    private void itmCadastroDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCadastroDepartamentosActionPerformed
        List<Usuario> listaUsuario = null;
        try {
            listaUsuario = this.bancoDadosFuncionario.ConsultaGerenteDisponivel();
        } catch (SQLException ex) {
            Logger.getLogger(MenuDiretorForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!listaUsuario.isEmpty()){
            CadastroDepartamentoForm cadastroDepartamentoForm = new CadastroDepartamentoForm(this.trabalhoSeguranca);
            cadastroDepartamentoForm.setVisible(true); 
        }else{
            JOptionPane.showMessageDialog(this, "Não possui Gerentes Disponiveis! Cadastre um Novo!", "Erro", JOptionPane.WARNING_MESSAGE);
        }       
    }//GEN-LAST:event_itmCadastroDepartamentosActionPerformed

    private void itmListaFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmListaFuncionariosActionPerformed
        ListaFuncionarioForm listaFuncionarioForm = null;
        try {
            listaFuncionarioForm = new ListaFuncionarioForm(this.trabalhoSeguranca);
        } catch (SQLException ex) {
            Logger.getLogger(MenuDiretorForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        listaFuncionarioForm.setVisible(true);
    }//GEN-LAST:event_itmListaFuncionariosActionPerformed

    private void itmCadastroCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmCadastroCargoActionPerformed
       List<Usuario> listaUsuario = null;
       List<Departamento> listaDepartamentos = null;
        try {
            listaUsuario = this.bancoDadosFuncionario.ConsultaEncarregadoDisponivel();
            listaDepartamentos = this.bancoDadosDepartamento.ConsultaTodos();
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuDiretorForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(listaUsuario.isEmpty()){
            JOptionPane.showMessageDialog(this, "Não possui Encarregados Disponiveis! Cadastre um Novo!", "Erro", JOptionPane.WARNING_MESSAGE);
        }else if(listaDepartamentos.isEmpty()){
                JOptionPane.showMessageDialog(this, "Não possui Departamento cadastrado! Cadastre um Novo!", "Erro", JOptionPane.WARNING_MESSAGE); 
            }else{
                CadastroEncDpoForm cadastroEncDpoForm = new CadastroEncDpoForm(this.trabalhoSeguranca);
                cadastroEncDpoForm.setVisible(true);
            }
    }//GEN-LAST:event_itmCadastroCargoActionPerformed

    private void MenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSairActionPerformed
       
    }//GEN-LAST:event_MenuSairActionPerformed

    private void MenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSairMouseClicked
        if(javax.swing.JOptionPane.showConfirmDialog(null,"Deseja Sair do Sistema?","ATENÇÃO ",javax.swing.JOptionPane.YES_NO_OPTION )==0){
            System.exit(0);
        }
    }//GEN-LAST:event_MenuSairMouseClicked

    private void itmEmitirRelatorioProjetoDiretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmEmitirRelatorioProjetoDiretorActionPerformed
        try {
            if(this.bancoDadosProjeto.ConsultaProjetoExiste()){
                try {
                    List<Atividade> listaAtvividade = new ArrayList<>();
                    listaAtvividade = this.bancoDadosProjeto.RelatorioDiretorProjeto();
                    String relatorio = System.getProperty("user.dir")+
                            "/Relatorios/RelatorioProjetoGerente.jasper";
                    
                    JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(listaAtvividade);
                    
                    JasperPrint relatorioGerado;
                    
                    relatorioGerado = JasperFillManager.fillReport(relatorio, null, fonteDados);
                    
                    
                    JasperViewer jasperViewer = new JasperViewer (relatorioGerado, false);
                    jasperViewer.setVisible(true);
                } catch (JRException ex){
                    System.out.println("Falha ao gerar Relatorio: "+ex.getMessage());
                } catch (SQLException ex) {
                    Logger.getLogger(MenuGerenteForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Não possui Projetos Cadastrados ! Cadastre um Novo!", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuDiretorForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_itmEmitirRelatorioProjetoDiretorActionPerformed

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
            java.util.logging.Logger.getLogger(MenuDiretorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuDiretorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuDiretorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuDiretorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuSair;
    private javax.swing.JMenuItem itmCadastroCargo;
    private javax.swing.JMenuItem itmCadastroDepartamentos;
    private javax.swing.JMenuItem itmCadastroFuncionarios;
    private javax.swing.JMenuItem itmEmitirRelatorioProjetoDiretor;
    private javax.swing.JMenuItem itmListaDepartamentos;
    private javax.swing.JMenuItem itmListaFuncionarios;
    private javax.swing.JMenu itmMenuCadastrarFuncionario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
