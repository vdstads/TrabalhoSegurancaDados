/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erikavinicius.dados;

import br.com.erikavinicius.entidade.Atividade;
import br.com.erikavinicius.entidade.Departamento;
import br.com.erikavinicius.entidade.Projeto;
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
    public static void CriarAtividade(int codigo, String nome, int duracao, String cpfEnc) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "INSERT INTO ATIVIDADE(COD_ATIVIDADE, NOME, DURACAO_PREV, FK_ENCARREGADO_CPF) VALUES (?,?,?,?)";
            comando = conexao.prepareStatement(sql);

            comando.setInt(1, codigo);
            comando.setString(2, nome);
            comando.setInt(3, duracao);
            comando.setString(4, cpfEnc);

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
    public static void EditaAtividade(int codigo, String nome, String descricao, String dataInicio, String dataTermino) throws SQLException {
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
    
    public static boolean ConsultaAtividadeExiste(String codDep) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        boolean existeDepartamento = false;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT * FROM PROJETO INNER JOIN DEPARTAMENTO D ON (D.FK_PROJETO = COD_PROJETO) WHERE D.CODIGO = '"+codDep+"'";
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
    
    public static List<Atividade> ConsultaAtividadePorProj(String codDep) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Atividade> listaAtividade = new ArrayList<Atividade>();
                
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT COD_ATIVIDADE, NOME, DURACAO_PREV, HORAS_TRABALHADAS, PERCENTUAL_CONCLUSAO FROM ATIVIDADE "
                    + "INNER JOIN PROJETO P ON (P.FK_ATIVIDADE = COD_ATIVIDADE) "
                    + "INNER JOIN DEPARTAMENTO D ON (D.FK_PROJETO = P.COD_PROJETO) "
                    + "WHERE D.CODIGO ='"+codDep+"'";
            
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
    
    public static void removeAtv(int codigo) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "DELETE FROM PROJETO WHERE COD_PROJETO ='"+codigo+"'";
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
    
    public static List<Atividade> ConsultaAtividadePorEncarregado(String codEnc) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        List<Atividade> listaAtividade = new ArrayList<Atividade>();
                
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT COD_ATIVIDADE, NOME, DURACAO_PREV, HORAS_TRABALHADAS, PERCENTUAL_CONCLUSAO FROM ATIVIDADE A "
                    + "INNER JOIN FUNCIONARIO F ON (F.CPF = A.FK_ENCARREGADO_CPF) "
                    + "WHERE A.FK_ENCARREGADO_CPF ='"+codEnc+"'";
            
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
        List<Atividade> listaAtividade = new ArrayList<Atividade>();
        List<Atividade> listaAtividadeTemp = new ArrayList<Atividade>();
                
        try {
            conexao = BancoDadosUtil.getConnection();

            //Código de criar...
            String sql = "SELECT COD_ATIVIDADE, NOME, DURACAO_PREV, HORAS_TRABALHADAS, PERCENTUAL_CONCLUSAO FROM ATIVIDADE A "
                    + "INNER JOIN PROJETO P ON (P.FK_ATIVIDADE = COD_ATIVIDADE) "
                    + "INNER JOIN DEPARTAMENTO D ON (D.FK_PROJETO = P.COD_PROJETO) "
                    + "WHERE D.FK_GERENTE_CPF ='"+codGer+"'";
            
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
                //Adiciona um item à lista que será retornada
                listaAtividadeTemp.add(atividadeTemp);
            }
            for (Atividade atividade : listaAtividade) {
            if (atividade.getHorasTrabalhadas() > atividade.getDuracao() && atividade.getPercentualConclusao() < 100) {
               listaAtividade.add(atividade);
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
        return listaAtividade;
    }

}
