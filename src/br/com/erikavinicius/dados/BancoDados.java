/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erikavinicius.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vinicius
 */
public class BancoDados {
    /*public static void main(String[] args) throws SQLException {
        //exemploCriar();
        exemploConsultar();
        System.out.println("EXECUTADO COM SUCESSO");
    }*/
    
    public static void CriarFuncionario(String cpf, String nome, String email,String senha, String cargo) throws SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            
            //Código de criar...
            String sql = "INSERT INTO FUNCIONARIO(CPF, NOME, EMAIL, SENHA, CARGO) VALUES (?,?,?,?,?)";
            comando = conexao.prepareStatement(sql);
            
            comando.setString(1, cpf);
            comando.setString(2, nome);
            comando.setString(3, email);
            comando.setString(4, senha);
            comando.setString(5, cargo);
            
            comando.execute();
            
            conexao.commit();
        }catch(Exception e){
            if(conexao!=null && !conexao.isClosed()){
                conexao.rollback();
            }
            throw new RuntimeException(e);
        }finally{
            if(conexao!=null && !conexao.isClosed()){
                conexao.close();
            }
        }
    }
 
    public static void exemploConsultar() throws SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        try {
            conexao = BancoDadosUtil.getConnection();
            
            //Código de criar...
            String sql = "SELECT COL1, COL2 FROM EXEMPLO";
            comando = conexao.prepareStatement(sql);
            
            resultado = comando.executeQuery();
            
            while(resultado.next()){
                System.out.println("COL 1: "+resultado.getInt(1));
                System.out.println("COL 2: "+resultado.getString(2));
            }
 
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally{
            if(resultado!=null && !resultado.isClosed()){
                resultado.close();
            }
            if(conexao!=null && !conexao.isClosed()){
                conexao.close();
            }
        }
    }
    
}