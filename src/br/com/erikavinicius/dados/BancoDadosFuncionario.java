/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erikavinicius.dados;

import br.com.erikavinicius.entidade.Gerente;
import br.com.erikavinicius.entidade.Usuario;
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
public class BancoDadosFuncionario {
    public static void CriarFuncionario(String cpf, String nome, String email, String senha, String cargo) throws SQLException {
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

    public static List<Usuario> ConsultaTodos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Usuario> listaFuncionarios = new ArrayList<Usuario>();
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT CPF, NOME, EMAIL, SENHA, CARGO FROM FUNCIONARIO";
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                Usuario usuario = new Usuario();
                usuario.setCpf(resultado.getString(1));
                usuario.setNome(resultado.getString(2));
                usuario.setEmail(resultado.getString(3));
                usuario.setSenha(resultado.getString(4));
                usuario.setCargo(resultado.getString(5));
//Adiciona um item à lista que será retornada
                listaFuncionarios.add(usuario);
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
        return listaFuncionarios;
    }

      
   
   public static boolean ConsultaDiretor() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        boolean existeDiretor = false;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT * FROM FUNCIONARIO WHERE CARGO = 'DIRETOR'";
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                existeDiretor = true;
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
        return existeDiretor;
    }
   
    public static void removeFuncionario(String CPF) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "DELETE FROM FUNCIONARIO WHERE CPF ='"+CPF+"'";
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
    
    public static void EditaFuncionario(String cpf, String nome, String email, String senha, String cargo, String cpfAtual) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "UPDATE FUNCIONARIO SET CPF = ?, NOME = ?, EMAIL = ?, SENHA = ?, CARGO = ? WHERE CPF ='"+cpfAtual+"'";
            comando = conexao.prepareStatement(sql);

            comando.setString(1, cpf);
            comando.setString(2, nome);
            comando.setString(3, email);
            comando.setString(4, senha);
            comando.setString(5, cargo);

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
     public static List<Usuario> ConsultaGerenteDisponivel() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Usuario> listaFuncionarios = new ArrayList<Usuario>();
        try {
            conexao = BancoDadosUtil.getConnection();
            
            //Código SQL...
            String sql = "SELECT F.CPF, F.NOME FROM FUNCIONARIO F  WHERE F.CPF NOT IN (SELECT CPF_GERENTE FROM DEPARTAMENTO) AND (F.CARGO = 'GERENTE')";
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                Usuario usuario = new Usuario();
                usuario.setCpf(resultado.getString(1));
                usuario.setNome(resultado.getString(2));
                
                //Adiciona um item à lista que será retornada
                listaFuncionarios.add(usuario);
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
        return listaFuncionarios;
    }    
    
     public static Gerente ConsultaGerentePorCPF(String CPFBuscado) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Gerente gerente = new Gerente();
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT CPF, NOME, EMAIL, SENHA, CARGO FROM FUNCIONARIO WHERE CPF ='"+CPFBuscado+"'";
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                
                gerente.setCpf(resultado.getString(1));
                gerente.setNome(resultado.getString(2));
                gerente.setEmail(resultado.getString(3));
                gerente.setSenha(resultado.getString(4));
                gerente.setCargo(resultado.getString(5));
//Adiciona um item à lista que será retornada
                
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
        return gerente;
    }
    
    public static Usuario ConsultaFuncionarioPorCPF(String CPFBuscado) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Usuario usuario = new Usuario();
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT CPF, NOME FROM FUNCIONARIO WHERE CPF ='"+CPFBuscado+"'";
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                
                usuario.setCpf(resultado.getString(1));
                usuario.setNome(resultado.getString(2));
                //Adiciona um item à lista que será retornada
                //----------------------------------
                
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
        return usuario;
    }

}
