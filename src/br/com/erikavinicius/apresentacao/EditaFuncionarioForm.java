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
 * @author vinicius
 */
public class EditaFuncionarioForm extends javax.swing.JFrame {

    private TrabalhoSeguranca trabalhoSeguranca;
    private BancoDadosFuncionario bancoDadosFuncionario;
    private BancoDados bancoDados;
    private CryptographyTripleDES criptografia;
    String CPF;
    private ListaFuncionarioForm listaFuncionario;
    Logger logger = Logger.getLogger(TrabalhoSeguranca.class.getName()); 
    
    public EditaFuncionarioForm(TrabalhoSeguranca trabalhoSeguranca, String cpf) {
        initComponents();
        this.trabalhoSeguranca = trabalhoSeguranca;
        this.bancoDadosFuncionario = bancoDadosFuncionario;
        this.bancoDados = bancoDados;
        CPF = cpf;
        preencher();
        
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

        grpCargo = new javax.swing.ButtonGroup();
        plDiretor = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        txtCpf = new javax.swing.JFormattedTextField();
        lblCargo = new javax.swing.JLabel();
        rdoGerente = new javax.swing.JRadioButton();
        rdoEncarregado = new javax.swing.JRadioButton();
        rdoDiretor = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        plDiretor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edição de Funcionários", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 18))); // NOI18N
        plDiretor.setPreferredSize(new java.awt.Dimension(405, 245));

        lblNome.setText("Nome:");

        lblEmail.setText("E-mail:");

        lblCpf.setText("CPF:");

        lblSenha.setText("Senha:");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/erikavinicius/entidade/icones/tick.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblCargo.setText("Cargo:");

        grpCargo.add(rdoGerente);
        rdoGerente.setText("Gerente");

        grpCargo.add(rdoEncarregado);
        rdoEncarregado.setText("Encarregado");

        grpCargo.add(rdoDiretor);
        rdoDiretor.setText("Diretor");
        rdoDiretor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout plDiretorLayout = new javax.swing.GroupLayout(plDiretor);
        plDiretor.setLayout(plDiretorLayout);
        plDiretorLayout.setHorizontalGroup(
            plDiretorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plDiretorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plDiretorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNome)
                    .addComponent(txtEmail)
                    .addComponent(txtSenha)
                    .addComponent(txtCpf)
                    .addGroup(plDiretorLayout.createSequentialGroup()
                        .addGroup(plDiretorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(lblEmail)
                            .addComponent(lblCpf)
                            .addComponent(lblSenha)
                            .addComponent(lblCargo)
                            .addGroup(plDiretorLayout.createSequentialGroup()
                                .addComponent(rdoGerente)
                                .addGap(18, 18, 18)
                                .addComponent(rdoEncarregado)
                                .addGap(18, 18, 18)
                                .addComponent(rdoDiretor)))
                        .addGap(0, 35, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCargo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plDiretorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoGerente)
                    .addComponent(rdoEncarregado)
                    .addComponent(rdoDiretor))
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plDiretor, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plDiretor, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        
        String nome = this.txtNome.getText().trim();
        String senha = this.txtSenha.getText().trim();
        String cpf = this.txtCpf.getText().trim();
        String email = this.txtEmail.getText().trim();
        String cargo = null;
        if(this.rdoEncarregado.isSelected()){
            cargo = "ENCARREGADO";
        }else if(this.rdoGerente.isSelected()){
            cargo = "GERENTE";
        }else{
            cargo = "DIRETOR";
        }

        if(nome.isEmpty() || senha.isEmpty() || email.isEmpty() || cpf.isEmpty() || cargo.isEmpty()){
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.WARNING_MESSAGE);
        } else if(validarEmail(email) == false){
            JOptionPane.showMessageDialog(this, "E-mail invalido!", "Erro", JOptionPane.WARNING_MESSAGE);
        } else{
            try {
                //------------------CRIPTOGRAFANDO A SENHA----------------------
                try {
                    CryptographyTripleDES cryptography = CryptographyTripleDES.newInstance();
                    senha = cryptography.encrypt(senha);
                } catch (Exception e) {
                    logger.log(Level.SEVERE, e.getMessage(), e);
               }
                //--------------------------------------------------------------
                this.bancoDadosFuncionario.EditaFuncionario(cpf, nome, email, senha, cargo, CPF);
            } catch (SQLException ex) {
                Logger.getLogger(CadastroDiretorForm.class.getName()).log(Level.SEVERE, null, ex);
                logger.log(Level.SEVERE, ex.getMessage(), ex);
            }
            this.limpar();
            JOptionPane.showMessageDialog(this, cargo+" editado com sucesso!", "Edição de Funcionario", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            logger.info("Funcionario "+nome+" Editado com sucesso");
            ListaFuncionarioForm listaFuncionarioForm;
            
            try {
                listaFuncionarioForm = new ListaFuncionarioForm(this.trabalhoSeguranca);
                listaFuncionarioForm.setVisible(true);
            } catch (Exception e) {
                logger.log(Level.SEVERE, e.getMessage(), e);
            }   
        }  
    }//GEN-LAST:event_btnSalvarActionPerformed

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
            if (usuario.getCpf().equals(CPF)) {
               usrTemp = usuario;
               break;
            }
        }
        try {
                    CryptographyTripleDES cryptography = CryptographyTripleDES.newInstance();
                    senha = cryptography.decrypt(usrTemp.getSenha());
                } catch (Exception e) {
               }
        //grpCargo.setSelected(, true);
        if(usrTemp.getCargo().equals("ENCARREGADO")){
            rdoEncarregado.setSelected(true);
        }else if(usrTemp.getCargo().equals("GERENTE")){
            rdoGerente.setSelected(true);
        }else{
            rdoDiretor.setSelected(true);
            rdoEncarregado.setEnabled(false);
            rdoGerente.setEnabled(false);
        }

        txtNome.setText(usrTemp.getNome());
        txtCpf.setText(usrTemp.getCpf());
        txtEmail.setText(usrTemp.getEmail());
        txtSenha.setText(senha);
        rdoDiretor.setEnabled(false);

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
            java.util.logging.Logger.getLogger(EditaFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditaFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditaFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditaFuncionarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup grpCargo;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPanel plDiretor;
    private javax.swing.JRadioButton rdoDiretor;
    private javax.swing.JRadioButton rdoEncarregado;
    private javax.swing.JRadioButton rdoGerente;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
