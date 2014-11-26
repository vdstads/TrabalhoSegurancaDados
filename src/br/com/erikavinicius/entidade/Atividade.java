/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.erikavinicius.entidade;

/**
 *
 * @author vinicius
 */
public class Atividade {
    private int codigo;
    private String nome;
    private String duracao;
    private Encarregado encarregado;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Encarregado getEncarregado() {
        return encarregado;
    }

    public void setEncarregado(Encarregado encarregado) {
        this.encarregado = encarregado;
    }
    
    
}
