/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.erikavinicius;


import br.com.erikavinicius.apresentacao.CadastroDiretorForm;
import br.com.erikavinicius.apresentacao.LoginForm;
import br.com.erikavinicius.dados.BancoDados;
import br.com.erikavinicius.entidade.Usuario;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author ALUNO 2014 2
 */
public class TrabalhoSeguranca {

    public List<Usuario> listaUsuarios;
    private BancoDados bancoDados;
    CryptographyTripleDES cryptography;   
    
    public TrabalhoSeguranca() {
        try {
            this.cryptography = new CryptographyTripleDES();
        } catch (Exception e) {
        }
        listaUsuarios = new ArrayList<Usuario>();
    }
    
    public boolean login(String email, String senha) throws SQLException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {
        listaUsuarios = this.bancoDados.ConsultaTodos();
        boolean loginAtivo = false;
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEmail().equals(email)) {
               if (cryptography.decrypt(usuario.getSenha()).equals(senha)) {
                    loginAtivo = true;
               }
               break;
            }
        }
    return loginAtivo;
    }
    
    private void exibirMenu() throws SQLException {
        if(this.bancoDados.ConsultaDiretor()==false){
            CadastroDiretorForm cadastroDiretorForm = new CadastroDiretorForm(this);
            cadastroDiretorForm.setVisible(true);
        }else{
            LoginForm loginForm = new LoginForm(this);
            loginForm.setVisible(true);
        }
    }
    
    public static void main(String[] args) throws SQLException{
        TrabalhoSeguranca trabalhoSeguranca = new TrabalhoSeguranca();
        
        trabalhoSeguranca.exibirMenu();
    }

        
}
