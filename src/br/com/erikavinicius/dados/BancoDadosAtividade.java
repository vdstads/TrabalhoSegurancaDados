/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erikavinicius.dados;

import br.com.erikavinicius.entidade.Atividade;
import br.com.erikavinicius.entidade.Departamento;
import br.com.erikavinicius.entidade.Encarregado;
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
public class BancoDadosAtividade {
    public static void CriarAtividade(int codigo, String nome, int duracao, String cpfEnc, int codProj) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "INSERT INTO ATIVIDADE(COD_ATIVIDADE, NOME, DURACAO_PREV, FK_ENCARREGADO_CPF, FK_PROJETO, PERCENTUAL_CONCLUSAO) VALUES (?,?,?,?,?,?)";
            comando = conexao.prepareStatement(sql);

            comando.setInt(1, codigo);
            comando.setString(2, nome);
            comando.setInt(3, duracao);
            comando.setString(4, cpfEnc);
            comando.setInt(5, codProj);
            comando.setInt(6, 0);

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
            String sql = "SELECT MAX(COD_ATIVIDADE) FROM ATIVIDADE";
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
    
    public static void removeAtividade(int Codigo) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "DELETE FROM ATIVIDADE WHERE COD_ATIVIDADE ='"+Codigo+"'";
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
    public static void EditaAtividade(int codigo, String nome, int duaracao, String encarregado, int codProj) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...              
            String sql = "UPDATE ATIVIDADE SET NOME = ?, DURACAO_PREV = ?, FK_ENCARREGADO_CPF = ?, FK_PROJETO = ? WHERE COD_ATIVIDADE ='"+codigo+"'";
            comando = conexao.prepareStatement(sql);

            comando.setString(1, nome);
            comando.setInt(2, duaracao);
            comando.setString(3, encarregado);
            comando.setInt(4, codProj);
            
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
    
    public static boolean ConsultaAtividadeExiste(String codDep) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        boolean existeDepartamento = false;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT * FROM ATIVIDADE A INNER JOIN PROJETO P ON (P.COD_PROJETO = A.FK_PROJETO) WHERE P.FK_DEPARTAMENTO = '"+codDep+"'";
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
       
    public static List<Atividade> ConsultaAtividadePorDep(String codDep) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Atividade> listaAtividade = new ArrayList<Atividade>();
                
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT A.COD_ATIVIDADE, A.NOME, A.DURACAO_PREV, A.HORAS_TRABALHADAS, A.PERCENTUAL_CONCLUSAO, F.NOME FROM ATIVIDADE A "
                       + "INNER JOIN PROJETO P ON (P.COD_PROJETO = A.FK_PROJETO) "
                       + "INNER JOIN FUNCIONARIO F ON (F.CPF = A.FK_ENCARREGADO_CPF) "
                       + "WHERE P.FK_DEPARTAMENTO = '"+codDep+"'";
            
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                                
                Atividade atividade = new Atividade();
                atividade.setCodigo(resultado.getInt(1));
                atividade.setNome(resultado.getString(2));
                atividade.setDuracao(resultado.getInt(3));
                atividade.setHorasTrabalhadas(resultado.getInt(4));
                atividade.setPercentualConclusao(resultado.getInt(5));
                Encarregado encarregado = new Encarregado();
                encarregado.setNome(resultado.getString(6));
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
   
    public static List<Atividade> ConsultaAtividadePorEncarregado(String codEnc) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Atividade> listaAtividade = new ArrayList<Atividade>();
                
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT COD_ATIVIDADE, NOME, DURACAO_PREV, HORAS_TRABALHADAS, PERCENTUAL_CONCLUSAO FROM ATIVIDADE WHERE FK_ENCARREGADO_CPF ='"+codEnc+"'";
            
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                                
                Atividade atividade = new Atividade();
                atividade.setCodigo(resultado.getInt(1));
                atividade.setNome(resultado.getString(2));
                atividade.setDuracao(resultado.getInt(3));
                atividade.setHorasTrabalhadas(resultado.getInt(4));
                atividade.setPercentualConclusao(resultado.getInt(5));
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
    
    public static void SetaHorasAtividade(int horas, int percentual, int codAtv) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "UPDATE ATIVIDADE SET HORAS_TRABALHADAS = ?, PERCENTUAL_CONCLUSAO = ? WHERE COD_ATIVIDADE ='"+codAtv+"'";
            comando = conexao.prepareStatement(sql);

            comando.setInt(1, horas);
            comando.setInt(2, percentual);
                        
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
    
    public static List<Atividade> ConsultaAtividadesAtrasadas(String codGer) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Atividade> listaAtividadeTemp = new ArrayList<Atividade>();
        Encarregado encarregado = new Encarregado();
                
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT COD_ATIVIDADE, NOME, DURACAO_PREV, HORAS_TRABALHADAS, PERCENTUAL_CONCLUSAO, FK_ENCARREGADO_CPF, F.NOME FROM ATIVIDADE A "
                       + "INNER JOIN PROJETO P ON (P.COD_PROJETO = A.FK_PROJETO) "
                       + "INNER JOIN FUNCIONARIO F ON (F.CPF = A.FK_ENCARREGADO_CPF) "
                       + "INNER JOIN DEPARTAMENTO D ON (D.CODIGO = P.FK_DEPARTAMENTO) "
                       + "WHERE D.FK_GERENTE_CPF = '"+codGer+"'";
            
            
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                                
                Atividade atividadeTemp = new Atividade();
                atividadeTemp.setCodigo(resultado.getInt(1));
                atividadeTemp.setNome(resultado.getString(2));
                atividadeTemp.setDuracao(resultado.getInt(3));
                atividadeTemp.setHorasTrabalhadas(resultado.getInt(4));
                atividadeTemp.setPercentualConclusao(resultado.getInt(5));
                encarregado.setCpf(resultado.getString(6));
                encarregado.setNome(resultado.getString(7));
                atividadeTemp.setEncarregado(encarregado);
                //Adiciona um item à lista que será retornada
               // listaAtividadeTemp.add(atividadeTemp);
                if (atividadeTemp.getHorasTrabalhadas() > atividadeTemp.getDuracao() && atividadeTemp.getPercentualConclusao() < 100) {
                    listaAtividadeTemp.add(atividadeTemp);
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
        return listaAtividadeTemp;
    }
    
    public static boolean ConsultaAtividadeExiste() throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        boolean existeAtividade = false;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT * FROM ATIVIDADE";
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                existeAtividade = true;
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
        return existeAtividade;
    }
    
    public static List<Atividade> RelatorioAtividadePorProjeto(int codProj) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Atividade> listaAtividade = new ArrayList<Atividade>();
                
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT A.COD_ATIVIDADE, A.NOME, A.DURACAO_PREV, A.HORAS_TRABALHADAS, A.PERCENTUAL_CONCLUSAO, F.NOME FROM ATIVIDADE A "
                       + "INNER JOIN PROJETO P ON (P.COD_PROJETO = A.FK_PROJETO) "
                       + "INNER JOIN FUNCIONARIO F ON (F.CPF = A.FK_ENCARREGADO_CPF) "
                       + "WHERE P.COD_PROJETO = '"+codProj+"'"
                       + "ORDER BY NOME";
            
            comando = conexao.prepareStatement(sql);

            resultado = comando.executeQuery();

            while (resultado.next()) {
            //Instancia um novo objeto e atribui os valores vindo do BD
                //(Note que no BD o index inicia por 1)
                                
                Atividade atividade = new Atividade();
                
                atividade.setCodigo(resultado.getInt(1));
                atividade.setNome(resultado.getString(2));
                atividade.setDuracao(resultado.getInt(3));
                atividade.setHorasTrabalhadas(resultado.getInt(4));
                atividade.setPercentualConclusao(resultado.getInt(5));
                Encarregado encarregado = new Encarregado();
                encarregado.setNome(resultado.getString(6));
                
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
