/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.erikavinicius.apresentacao;

import br.com.erikavinicius.CryptographyTripleDES;
import br.com.erikavinicius.TrabalhoSeguranca;
import br.com.erikavinicius.dados.BancoDados;
import br.com.erikavinicius.dados.BancoDadosFuncionario;
import br.com.erikavinicius.entidade.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Erika
 */
public class AlteraDadosEncarregado extends javax.swing.JFrame {

    private TrabalhoSeguranca trabalhoSeguranca;
    private BancoDadosFuncionario bancoDadosFuncionario;
    private BancoDados bancoDados;
    private Usuario usuarioAtivo;
    Logger logger = Logger.getLogger(TrabalhoSeguranca.class.getName());
    
    public AlteraDadosEncarregado(TrabalhoSeguranca trabalhoSeguranca, Usuario usuario) {
        initComponents();
        this.trabalhoSeguranca = trabalhoSeguranca;
        this.bancoDadosFuncionario = bancoDadosFuncionario;
        this.bancoDados = bancoDados;
        this.usuarioAtivo = usuario;
        this.preencher();
        
        try {
            
            FileHandler simpleHandler = new FileHandler("log.txt", true);
            simpleHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(simpleHandler);
            logger.setUseParentHandlers(false);
            
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Falha ao criar log", e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plDiretor = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        txtCpf = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        plDiretor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alterar Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 18))); // NOI18N
        plDiretor.setPreferredSize(new java.awt.Dimension(405, 245));

        lblNome.setText("Nome:");

        lblEmail.setText("E-mail:");

        lblCpf.setText("CPF:");

        lblSenha.setText("Senha:");

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/user_edit.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout plDiretorLayout = new javax.swing.GroupLayout(plDiretor);
        plDiretor.setLayout(plDiretorLayout);
        plDiretorLayout.setHorizontalGroup(
            plDiretorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plDiretorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plDiretorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(txtNome)
                    .addComponent(txtEmail)
                    .addComponent(txtSenha)
                    .addComponent(txtCpf)
                    .addGroup(plDiretorLayout.createSequentialGroup()
                        .addGroup(plDiretorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(lblEmail)
                            .addComponent(lblCpf)
                            .addComponent(lblSenha))
                        .addGap(0, 320, Short.MAX_VALUE)))
                .addContainerGap())
        );
        plDiretorLayout.setVerticalGroup(
            plDiretorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plDiretorLayout.createSequentialGroup()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnAlterar)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plDiretor, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plDiretor, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

        String nome = this.txtNome.getText().trim();
        String senha = this.txtSenha.getText().trim();
        String cpf = this.txtCpf.getText().trim();
        String email = this.txtEmail.getText().trim();
        String cargo = "ENCARREGADO";
        
        if(nome.isEmpty() || senha.isEmpty() || email.isEmpty() || cpf.isEmpty() || cargo.isEmpty()){
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.WARNING_MESSAGE);
        } else if(validarEmail(email) == false){
            JOptionPane.showMessageDialog(this, "E-mail invalido!", "Erro", JOptionPane.WARNING_MESSAGE);
        } else{
            try {
                CryptographyTripleDES cryptography = CryptographyTripleDES.newInstance();
                senha = cryptography.encrypt(senha);
            } catch (Exception e) {
                logger.log(Level.SEVERE, e.getMessage(), e);
            }
            try {
                this.bancoDadosFuncionario.EditaFuncionario(cpf, nome, email, senha, cargo, usuarioAtivo.getCpf());
            } catch (SQLException ex) {
                Logger.getLogger(EditaFuncionarioGerenteForm.class.getName()).log(Level.SEVERE, null, ex);
                logger.log(Level.SEVERE, ex.getMessage(), ex);
            }
            this.limpar();
            JOptionPane.showMessageDialog(this, cargo+" alterado com sucesso!", "Alteração de Encarregado", JOptionPane.INFORMATION_MESSAGE);
            logger.info("Encarregado Alterado com Sucesso");
            this.dispose();
            ListaFuncionarioGerenteForm listaFuncionarioGerenteForm;
            
           
        }  
    }//GEN-LAST:event_btnAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(AlteraDadosEncarregado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlteraDadosEncarregado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlteraDadosEncarregado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlteraDadosEncarregado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }
    private void preencher() {

        Usuario usrTemp = new Usuario();
        List<Usuario> listaUsuario = null;
        String senha = null;
        try {
            listaUsuario  = this.bancoDados.ConsultaTodos();
        } catch (SQLException ex) {
            Logger.getLogger(EditaFuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Usuario usuario : listaUsuario) {
            if (usuario.getCpf().equals(usuarioAtivo.getCpf())) {
               usrTemp = usuario;
               break;
            }
        }
        try {
                    CryptographyTripleDES cryptography = CryptographyTripleDES.newInstance();
                    senha = cryptography.decrypt(usrTemp.getSenha());
                } catch (Exception e) {
               }
        
        txtNome.setText(usrTemp.getNome());
        txtCpf.setText(usrTemp.getCpf());
        txtEmail.setText(usrTemp.getEmail());
        txtSenha.setText(senha);

    }
    
     public void limpar(){
         this.txtNome.setText(null);   
         this.txtCpf.setText(null);
         this.txtEmail.setText(null);
         this.txtSenha.setText(null);
    }
    
    public boolean validarEmail(String email) {
        boolean retorno = false;
        // Expressão Regular para validar E-mail
        Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher m = p.matcher(email);
        if (m.find()) {
            retorno = true;
        }
        return retorno;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPanel plDiretor;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
