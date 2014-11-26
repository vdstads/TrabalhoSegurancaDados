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
            String sql = "INSERT INTO DEPARTAMENTO(CODIGO, NOME, FK_GERENTE_CPF) VALUES (?,?,?)";
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
     public static List<Departamento> ConsultaTodosDepartamentos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Departamento> listaDepartamentos = new ArrayList<Departamento>();
                
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT CODIGO, NOME, FK_GERENTE_CPF FROM DEPARTAMENTO";
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                                
                Departamento departamento = new Departamento();
                departamento.setCodigo(resultado.getString(1));
                departamento.setNome(resultado.getString(2));
                departamento.setGerente(BancoDadosFuncionario.ConsultaGerentePorCPF(resultado.getString(3)));
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
    
     public static void EditaDepartamento(String codigo, String nome, String CPFGerente, String codigoAtual) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "UPDATE DEPARTAMENTO SET CODIGO = ?, NOME = ?, FK_GERENTE_CPF = ? WHERE CODIGO ='"+codigoAtual+"'";
            comando = conexao.prepareStatement(sql);

            comando.setString(1, codigo);
            comando.setString(2, nome);
            comando.setString(3, CPFGerente);
            
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
     
    public static void CadastraEncDep(String cpfEnc, String codigo) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "UPDATE FUNCIONARIO SET DEPARTAMENTO = '"+codigo+"' WHERE CPF ='"+cpfEnc+"'";
            comando = conexao.prepareStatement(sql);
            
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
    
    public static void removeDepartamento(String Codigo) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "DELETE FROM DEPARTAMENTO WHERE CODIGO ='"+Codigo+"'";
            comando = conexao.prepareStatement(sql);
            
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
    public static boolean ConsultaDepartamentoExiste() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        boolean existeDepartamento = false;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT * FROM DEPARTAMENTO";
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                existeDepartamento = true;
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
        return existeDepartamento;
    }
    
    public static void SetaDepartamento(int codigoDep, int codigoProjeto) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "UPDATE DEPARTAMENTO SET FK_PROJETO = ? WHERE CODIGO ='"+codigoDep+"'";
            comando = conexao.prepareStatement(sql);

            comando.setInt(1, codigoProjeto);
            
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
