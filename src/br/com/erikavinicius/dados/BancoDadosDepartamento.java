/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erikavinicius.dados;

import br.com.erikavinicius.entidade.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
     public static List<Departamento> ConsultaTodos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT CODIGO, NOME FROM DEPARTAMENTO";
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                Departamento departamento = new Departamento();
                departamento.setCodigo(resultado.getString(1));
                departamento.setNome(resultado.getString(2));
                
//Adiciona um item à lista que será retornada
                listaDepartamentos.add(departamento);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (resultado != null && !resultado.isClosed()) {
                resultado.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
        return listaDepartamentos;
    }
}
