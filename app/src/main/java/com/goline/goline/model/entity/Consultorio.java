package com.goline.goline.model.entity;

import java.util.List;

/**
 * Created by danilofernandocavalcanti on 01/12/16.
 */

public class Consultorio {

    private Long id;
    private String nome;
    private String rua;
    private String bairro;
    private String numero;
    private String cep;
    private boolean statusFuncionamento;
    private boolean status;
    private List<Senha> senhas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean isStatusFuncionamento() {
        return statusFuncionamento;
    }

    public void setStatusFuncionamento(boolean statusFuncionamento) {
        this.statusFuncionamento = statusFuncionamento;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Senha> getSenhas() {
        return senhas;
    }

    public void setSenhas(List<Senha> senhas) {
        this.senhas = senhas;
    }

    @Override
    public String toString() {
        return "Consultorio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", numero='" + numero + '\'' +
                ", cep='" + cep + '\'' +
                ", statusFuncionamento=" + statusFuncionamento +
                ", status=" + status +
                ", senhas=" + senhas +
                '}';
    }
}
