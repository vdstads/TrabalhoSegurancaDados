/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erikavinicius.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author vinicius
 */
public class BancoDadosDepartamento {
    public static void CriarDepartamento(String codigo, String nome, String cpfGerente) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "INSERT INTO DEPARTAMENTO(CODIGO, NOME, CPF_GERENTE) VALUES (?,?,?)";
            comando = conexao.prepareStatement(sql);

            comando.setString(1, codigo);
            comando.setString(2, nome);
            comando.setString(3, cpfGerente);
            
            comando.execute();

            conexao.commit();
        } catch (Exception e) {
            if (conexao != null && !conexao.isClosed()) {
                conexao.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }
}
