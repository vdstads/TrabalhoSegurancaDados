/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.erikavinicius.apresentacao;

import br.com.erikavinicius.TrabalhoSeguranca;
import br.com.erikavinicius.dados.BancoDadosAtividade;
import br.com.erikavinicius.dados.BancoDadosProjeto;
import br.com.erikavinicius.entidade.Atividade;
import br.com.erikavinicius.entidade.Encarregado;
import br.com.erikavinicius.entidade.Projeto;
import br.com.erikavinicius.entidade.Usuario;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Erika
 */
public class EmitirRelatorioProjeto extends javax.swing.JFrame {

    private TrabalhoSeguranca trabalhoSeguranca;
    private BancoDadosProjeto bancoDadosProjeto;
    public List<Projeto> listaProjetos;
    public List<Atividade> listaAtividade;
    private BancoDadosAtividade bancoDadosAtividade;
    public Atividade atividade = new Atividade();
    public Usuario usuarioAtivo = new Usuario();
    private String codDepAtivo;

    public EmitirRelatorioProjeto(TrabalhoSeguranca trabalhoSeguranca, Usuario usuario) throws SQLException {
        initComponents();

        this.trabalhoSeguranca = trabalhoSeguranca;
        this.bancoDadosProjeto = bancoDadosProjeto;
        this.listaProjetos = listaProjetos;
        this.bancoDadosAtividade = bancoDadosAtividade;
        this.usuarioAtivo = usuario;
        
        
        this.configurarCmbListaProjetos();
        this.gerarProjetos();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plRelatorio = new javax.swing.JPanel();
        lblMensagem = new javax.swing.JLabel();
        cmbListaProjetos = new javax.swing.JComboBox();
        btnGerarRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        plRelatorio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Emissão de Relatório", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        lblMensagem.setText("Escolha um projeto para gerar Relatório:");

        cmbListaProjetos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbListaProjetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListaProjetosActionPerformed(evt);
            }
        });

        btnGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/arrow_refresh.png"))); // NOI18N
        btnGerarRelatorio.setText("Gerar Relatório");
        btnGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plRelatorioLayout = new javax.swing.GroupLayout(plRelatorio);
        plRelatorio.setLayout(plRelatorioLayout);
        plRelatorioLayout.setHorizontalGroup(
            plRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plRelatorioLayout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addComponent(btnGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
            .addGroup(plRelatorioLayout.createSequentialGroup()
                .addGroup(plRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbListaProjetos, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        plRelatorioLayout.setVerticalGroup(
            plRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plRelatorioLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblMensagem)
                .addGap(18, 18, 18)
                .addComponent(cmbListaProjetos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnGerarRelatorio)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarRelatorioActionPerformed
        //chama o relatorio
        try {
            String relatorio = System.getProperty("user.dir")+
                    "/Relatorios/RelatorioAtividade.jasper";
            
            JRBeanCollectionDataSource fonteDados = new JRBeanCollectionDataSource(listaAtividade);
            
            JasperPrint relatorioGerado = JasperFillManager.fillReport(relatorio, null, fonteDados);
            
            JasperViewer jasperViewer = new JasperViewer (relatorioGerado, false);
            jasperViewer.setVisible(true);
        } catch (JRException ex){
            System.out.println("Falha ao gerar Relatorio: "+ex.getMessage());
        }
    }//GEN-LAST:event_btnGerarRelatorioActionPerformed

    private void cmbListaProjetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListaProjetosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbListaProjetosActionPerformed

    
    private void configurarCmbListaProjetos() throws SQLException {
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.cmbListaProjetos.getModel();
        
        model.removeAllElements();
        
        List<Projeto> listaProjetos = this.bancoDadosProjeto.ConsultaTodosProjetos();
        
        for (Projeto projeto : listaProjetos) {
            model.addElement(projeto);
        }
    }
    
     private void gerarProjetos() throws SQLException {
        //this.listaProjetos = new ArrayList<Projeto>();
        this.listaAtividade = new ArrayList<>(this.bancoDadosAtividade.ConsultaAtividadePorProj(usuarioAtivo.getSenha()));
   
       
        }

       
        
        
        /*or(int i=1; i<=100; i++){
            Contato contato = new Contato();
            contato.setNome("Jão da Silva "+i);
            contato.setEmail("joaosilva"+i+"@gmail.com");
            if(i%3==0){
                contato.setSexo('M');
            }else{
                contato.setSexo('F');    
            }
            contato.setDataNascimento(new Date());
            this.listaContatos.add(contato);
        }*/
    
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
            java.util.logging.Logger.getLogger(EmitirRelatorioProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmitirRelatorioProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmitirRelatorioProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmitirRelatorioProjeto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerarRelatorio;
    private javax.swing.JComboBox cmbListaProjetos;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JPanel plRelatorio;
    // End of variables declaration//GEN-END:variables

        
}
