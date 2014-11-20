/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.erikavinicius;


import br.com.erikavinicius.apresentacao.CadastroDiretorForm;
import br.com.erikavinicius.entidade.Diretor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALUNO 2014 2
 */
public class TrabalhoSeguranca {

    public List<Diretor> listaDiretor;
    
    public TrabalhoSeguranca() {
        listaDiretor = new ArrayList<Diretor>();
    }
    
    public void inserirDiretor(Diretor diretor) {
        listaDiretor.add(diretor);
    }
    
    public boolean loginDiretor(String email, String senha) {
        boolean loginAtivo = false;
        
        for (Diretor diretor : listaDiretor) {
            if (diretor.getEmail().equals(email)) {
               if (diretor.getSenha().equals(senha)) {
                    loginAtivo = true;
                    //System.out.print("Email e senha confere");
               }
               break;
            }
        }
        //System.out.print("Email e senha NAO confere");
    return loginAtivo;
    }
    private void exibirMenu() {
       CadastroDiretorForm cadastroDiretorForm = new CadastroDiretorForm(this);
       cadastroDiretorForm.setVisible(true);
    }
    
    public static void main(String[] args){
        TrabalhoSeguranca trabalhoSeguranca = new TrabalhoSeguranca();
        
        trabalhoSeguranca.exibirMenu();
    }
    
}
