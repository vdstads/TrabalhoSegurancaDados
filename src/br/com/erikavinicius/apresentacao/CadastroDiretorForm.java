/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.erikavinicius.apresentacao;


import br.com.erikavinicius.CryptographyTripleDES;
import br.com.erikavinicius.TrabalhoSeguranca;
import br.com.erikavinicius.dados.BancoDados;
import br.com.erikavinicius.entidade.Diretor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;

/**
 *
 * @author Erika
 */
public class CadastroDiretorForm extends javax.swing.JFrame {

    private TrabalhoSeguranca trabalhoSeguranca;
    private BancoDados bancoDados;
    private CryptographyTripleDES criptografia;
    Logger logger = Logger.getLogger(TrabalhoSeguranca.class.getName());
    
    public CadastroDiretorForm(TrabalhoSeguranca trabalhoSeguranca) {
        initComponents();
        this.trabalhoSeguranca = trabalhoSeguranca;
        this.bancoDados = bancoDados;
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

        plDiretor = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        txtCpf = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Diretor");

        plDiretor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Diretor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 18))); // NOI18N
        plDiretor.setMinimumSize(new java.awt.Dimension(0, 0));
        plDiretor.setPreferredSize(new java.awt.Dimension(405, 245));

        lblNome.setText("Nome:");

        lblEmail.setText("E-mail:");

        lblCpf.setText("CPF:");

        lblSenha.setText("Senha:");

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/application_add.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
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
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                    .addComponent(txtNome)
                    .addComponent(txtEmail)
                    .addComponent(txtSenha)
                    .addGroup(plDiretorLayout.createSequentialGroup()
                        .addGroup(plDiretorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(lblEmail)
                            .addComponent(lblCpf)
                            .addComponent(lblSenha))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtCpf))
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
                .addGap(18, 18, 18)
                .addComponent(btnCadastrar)
                .addGap(0, 52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plDiretor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plDiretor, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed

      String nome = this.txtNome.getText().trim();
      String senha = this.txtSenha.getText().trim();
      String cpf = this.txtCpf.getText().trim();
      String email = this.txtEmail.getText().trim();
      
        if(nome.isEmpty() || senha.isEmpty() || email.isEmpty() || cpf.isEmpty()){
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.WARNING_MESSAGE);
        } else if(validarEmail(email) == false){
                JOptionPane.showMessageDialog(this, "E-mail invalido!", "Erro", JOptionPane.WARNING_MESSAGE);
            } else{
            try {
                //CRIPTOGRAFANDO A SENHA---------------------------
                try {
                     CryptographyTripleDES cryptography = CryptographyTripleDES.newInstance();
                     senha = cryptography.encrypt(senha);
                } catch (Exception e) {
                    logger.log(Level.SEVERE, e.getMessage(), e);
                }
                //---------------------------------------------------
                this.bancoDados.CriarFuncionario(cpf, nome, email, senha, "DIRETOR");
            } catch (SQLException ex) {
                Logger.getLogger(CadastroDiretorForm.class.getName()).log(Level.SEVERE, null, ex);
                logger.log(Level.SEVERE, ex.getMessage(), ex);
            }
            this.limpar();
            JOptionPane.showMessageDialog(this, "Diretor cadastrado com sucesso!", "Cadastro de Diretor", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            this.logger.info("Diretor Cadastrado Com Sucesso");
            LoginForm loginForm = new LoginForm(this.trabalhoSeguranca);
            loginForm.setVisible(true);
            
        }       
    }//GEN-LAST:event_btnCadastrarActionPerformed

    
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
    private javax.swing.JButton btnCadastrar;
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
