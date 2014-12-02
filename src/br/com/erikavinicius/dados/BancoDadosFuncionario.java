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
    public static void CriarFuncionario(String cpf, String nome, String email, String senha, String cargo, String departamento) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "INSERT INTO FUNCIONARIO(CPF, NOME, EMAIL, SENHA, CARGO, DEPARTAMENTO) VALUES (?,?,?,?,?,?)";
            comando = conexao.prepareStatement(sql);

            comando.setString(1, cpf);
            comando.setString(2, nome);
            comando.setString(3, email);
            comando.setString(4, senha);
            comando.setString(5, cargo);
            comando.setString(6, departamento);

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
            String sql = "SELECT F.CPF, F.NOME FROM FUNCIONARIO F  WHERE F.CPF NOT IN (SELECT FK_GERENTE_CPF FROM DEPARTAMENTO) AND (F.CARGO = 'GERENTE')";
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
    
    public static List<Usuario> ConsultaEncarregadoDisponivel() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Usuario> listaFuncionarios = new ArrayList<Usuario>();
        try {
            conexao = BancoDadosUtil.getConnection();
            
            //Código SQL...
            String sql = "SELECT CPF, NOME FROM FUNCIONARIO WHERE (CARGO = 'ENCARREGADO')";
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
    
    public static String ConsultaCargo(String email) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Usuario usuario = new Usuario();
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT CARGO FROM FUNCIONARIO WHERE EMAIL ='"+email+"'";
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                
                usuario.setCargo(resultado.getString(1));
             
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
        return usuario.getCargo();
    }
    
    public static Usuario ConsultaFuncionarioPorEmail(String email) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Usuario usuario = new Usuario();
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT CPF, NOME, EMAIL, DEPARTAMENTO, CARGO FROM FUNCIONARIO WHERE EMAIL ='"+email+"'";
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                
                usuario.setCpf(resultado.getString(1));
                usuario.setNome(resultado.getString(2));
                usuario.setEmail(resultado.getString(3));
                usuario.setSenha(resultado.getString(4));
                usuario.setCargo(resultado.getString(5));
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
    
    public static boolean ConsultaFuncionarioPorEmailCpf(String email, String cpf) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        boolean existeUsuario = false;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sqlEmail = "SELECT CPF, EMAIL FROM FUNCIONARIO WHERE EMAIL ='"+email+"'";
            String sqlCpf = "SELECT CPF, EMAIL FROM FUNCIONARIO WHERE EMAIL ='"+cpf+"'";
            
            comando = conexao.prepareStatement(sqlEmail);
            resultado = comando.executeQuery();
            while (resultado.next()) {
                existeUsuario = true;         
            }
            if(!existeUsuario){
               comando = conexao.prepareStatement(sqlCpf);
                resultado = comando.executeQuery();
                while (resultado.next()) {
                    existeUsuario = true;         
                } 
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
        return existeUsuario;
    }
    
    public static List<Usuario> ConsultaFuncionariosDepartamento(String codDep) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Usuario> listaFuncionarios = new ArrayList<Usuario>();
     
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT CPF, NOME, CARGO FROM FUNCIONARIO WHERE (DEPARTAMENTO ='"+codDep+"') AND (CARGO = 'ENCARREGADO')";
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                Usuario usuario = new Usuario();
                usuario.setCpf(resultado.getString(1));
                usuario.setNome(resultado.getString(2));
                usuario.setCargo(resultado.getString(3));
                //Adiciona um item à lista que será retornada
                listaFuncionarios.add(usuario);
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
        return listaFuncionarios;
    }
    public static List<Usuario> ConsultaTodosFuncionariosDepartamento(String codDep) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Usuario> listaFuncionarios = new ArrayList<Usuario>();
     
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT CPF, NOME, CARGO FROM FUNCIONARIO WHERE DEPARTAMENTO ='"+codDep+"'";
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                Usuario usuario = new Usuario();
                usuario.setCpf(resultado.getString(1));
                usuario.setNome(resultado.getString(2));
                usuario.setCargo(resultado.getString(3));
                //Adiciona um item à lista que será retornada
                listaFuncionarios.add(usuario);
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
        return listaFuncionarios;
    }
    
    public static void SetaFuncionarioDepartamento(String cpf, String codDep) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "UPDATE FUNCIONARIO SET DEPARTAMENTO = ? WHERE CPF ='"+cpf+"'";
            comando = conexao.prepareStatement(sql);

            comando.setString(1, codDep);
            
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
    public static boolean ConsultaNaoExisteDep(String email) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        boolean existeDiretor = false;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT * FROM FUNCIONARIO WHERE (EMAIL = '"+email+"') AND (DEPARTAMENTO IS NULL)";
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

}
