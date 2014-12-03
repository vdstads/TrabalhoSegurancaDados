/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erikavinicius.dados;

import br.com.erikavinicius.entidade.Atividade;
import br.com.erikavinicius.entidade.Departamento;
import br.com.erikavinicius.entidade.Diretor;
import br.com.erikavinicius.entidade.Encarregado;
import br.com.erikavinicius.entidade.Gerente;
import br.com.erikavinicius.entidade.Projeto;
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
public class BancoDadosProjeto {
    public static void CriarProjeto(int codigo, String nome, String descricao, String dataInicio, String dataTermino, String departamento) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "INSERT INTO PROJETO(COD_PROJETO, NOME, DESCRICAO, DATA_INICIO, DATA_TERMINO, FK_DEPARTAMENTO) VALUES (?,?,?,?,?,?)";
            comando = conexao.prepareStatement(sql);

            comando.setInt(1, codigo);
            comando.setString(2, nome);
            comando.setString(3, descricao);
            comando.setString(4, dataInicio);
            comando.setString(5, dataTermino);
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
    public static int ConsultaUltimoCodigo() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        int ultimoCodigo = 0;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT MAX(COD_PROJETO) FROM PROJETO";
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                ultimoCodigo = (resultado.getInt(1));
             
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
        return ultimoCodigo;
    }
    public static List<Projeto> ConsultaTodosProjetos() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Projeto> listaProjetos = new ArrayList<Projeto>();
                
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT COD_PROJETO, NOME, DESCRICAO, DATA_INICIO, DATA_TERMINO FROM PROJETO";
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                                
                Projeto projeto = new Projeto();
                projeto.setCodigo(resultado.getInt(1));
                projeto.setNome(resultado.getString(2));
                projeto.setDescricao(resultado.getString(3));
                projeto.setDataInicio(resultado.getString(4));
                projeto.setDataTermino(resultado.getString(5));
                //Adiciona um item à lista que será retornada
                listaProjetos.add(projeto);
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
        return listaProjetos;
    }
    
    public static void removeProjeto(int Codigo) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "DELETE FROM PROJETO WHERE COD_PROJETO ='"+Codigo+"'";
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
    public static void EditaProjeto(int codigo, String nome, String descricao, String dataInicio, String dataTermino) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "UPDATE PROJETO SET COD_PROJETO = ?, NOME = ?, DESCRICAO = ?, DATA_INICIO = ?, DATA_TERMINO = ? WHERE COD_PROJETO ='"+codigo+"'";
            comando = conexao.prepareStatement(sql);

            comando.setInt(1, codigo);
            comando.setString(2, nome);
            comando.setString(3, descricao);
            comando.setString(4, dataInicio);
            comando.setString(5, dataTermino);
            
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
    
    public static List<Projeto> ConsultaProjetoPorDep(String codDep) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Projeto> listaProjetos = new ArrayList<Projeto>();
                
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT COD_PROJETO, NOME, DESCRICAO, DATA_INICIO, DATA_TERMINO FROM PROJETO WHERE FK_DEPARTAMENTO = '"+codDep+"'";
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                                
                Projeto projeto = new Projeto();
                projeto.setCodigo(resultado.getInt(1));
                projeto.setNome(resultado.getString(2));
                projeto.setDescricao(resultado.getString(3));
                projeto.setDataInicio(resultado.getString(4));
                projeto.setDataTermino(resultado.getString(5));
                //Adiciona um item à lista que será retornada
                listaProjetos.add(projeto);
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
        return listaProjetos;
    }
    
    public static boolean ConsultaProjetoExiste() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        boolean existeProjeto = false;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT * FROM PROJETO";
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                existeProjeto = true;
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
        return existeProjeto;
    }
    
    public static List<Atividade> RelatorioProjetosPorDep(String codDep) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Atividade> listaAtividade = new ArrayList<Atividade>();
                
        try {
            conexao = BancoDadosUtil.getConnection();
            
            //Código de criar...
            String sql = "SELECT P.NOME, D.NOME, F.NOME, P.DATA_INICIO, P.DATA_TERMINO, COUNT(A.COD_ATIVIDADE), (SELECT COUNT(COD_ATIVIDADE) FROM ATIVIDADE WHERE PERCENTUAL_CONCLUSAO= 100) FROM PROJETO P "
                        +"INNER JOIN DEPARTAMENTO D ON (D.CODIGO = P.FK_DEPARTAMENTO) "
                        +"INNER JOIN FUNCIONARIO F ON (F.CPF = D.FK_GERENTE_CPF) "
                        +"INNER JOIN ATIVIDADE A ON (A.FK_PROJETO = P.COD_PROJETO) "
                        +"WHERE D.CODIGO = '"+codDep+"' "
                        +"GROUP BY P.NOME, D.NOME, F.NOME, P.DATA_INICIO, P.DATA_TERMINO";
            
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                                
                Atividade atividade = new Atividade();
                Projeto projeto = new Projeto();
                Departamento departamento = new Departamento();
                Encarregado encarregado = new Encarregado();
                Gerente gerente = new Gerente();
                
                projeto.setNome(resultado.getString(1));
                departamento.setNome(resultado.getString(2));
                gerente.setNome(resultado.getString(3));
                departamento.setGerente(gerente);
                projeto.setDepartamento(departamento);
                projeto.setDataInicio(resultado.getString(4));
                projeto.setDataTermino(resultado.getString(5));
                atividade.setDuracao(resultado.getInt(6));
                atividade.setHorasTrabalhadas(resultado.getInt(7));
                atividade.setProjeto(projeto);
                atividade.setEncarregado(encarregado);
  
                //Adiciona um item à lista que será retornada
                listaAtividade.add(atividade);
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
        return listaAtividade;
    }
    
    public static List<Atividade> RelatorioDiretorProjeto() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Atividade> listaAtividade = new ArrayList<Atividade>();
                
        try {
            conexao = BancoDadosUtil.getConnection();
            //Código de criar...
            String sql = "SELECT P.NOME, D.NOME, F.NOME, P.DATA_INICIO, P.DATA_TERMINO, COUNT(A.COD_ATIVIDADE), (SELECT COUNT(COD_ATIVIDADE) FROM ATIVIDADE WHERE PERCENTUAL_CONCLUSAO= 100) FROM PROJETO P "
                        +"INNER JOIN DEPARTAMENTO D ON (D.CODIGO = P.FK_DEPARTAMENTO) "
                        +"INNER JOIN FUNCIONARIO F ON (F.CPF = D.FK_GERENTE_CPF) "
                        +"INNER JOIN ATIVIDADE A ON (A.FK_PROJETO = P.COD_PROJETO) "
                        +"GROUP BY P.NOME, D.NOME, F.NOME, P.DATA_INICIO, P.DATA_TERMINO";
            
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                                
                Atividade atividade = new Atividade();
                Projeto projeto = new Projeto();
                Departamento departamento = new Departamento();
                Encarregado encarregado = new Encarregado();
                Gerente gerente = new Gerente();
                
                projeto.setNome(resultado.getString(1));
                departamento.setNome(resultado.getString(2));
                gerente.setNome(resultado.getString(3));
                departamento.setGerente(gerente);
                projeto.setDepartamento(departamento);
                projeto.setDataInicio(resultado.getString(4));
                projeto.setDataTermino(resultado.getString(5));
                atividade.setDuracao(resultado.getInt(6));
                atividade.setHorasTrabalhadas(resultado.getInt(7));
                atividade.setProjeto(projeto);
                atividade.setEncarregado(encarregado);
  
                //Adiciona um item à lista que será retornada
                listaAtividade.add(atividade);
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
        return listaAtividade;
    }
        
}
