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
    private int duracao;
    private int horasTrabalhadas;
    private float percentualConclusao;
    private Encarregado encarregado;

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public float getPercentualConclusao() {
        return percentualConclusao;
    }

    public void setPercentualConclusao(float percentualConclusao) {
        this.percentualConclusao = percentualConclusao;
    }

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

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Encarregado getEncarregado() {
        return encarregado;
    }

    public void setEncarregado(Encarregado encarregado) {
        this.encarregado = encarregado;
    }
    @Override
    public String toString(){
        return nome;
    }
    
}
