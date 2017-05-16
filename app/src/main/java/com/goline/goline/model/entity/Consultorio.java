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
    private String cidade;
    private String numero;
    private String cep;
    private String especialidade;
    private boolean status;
    private boolean statusFuncionamento;
    private List<Paciente> pacientes;
    private List<Senha> senhas;
    private List<Agendamento> agendamento;

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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatusFuncionamento() {
        return statusFuncionamento;
    }

    public void setStatusFuncionamento(boolean statusFuncionamento) {
        this.statusFuncionamento = statusFuncionamento;
    }

    public List<Senha> getSenhas() {
        return senhas;
    }

    public void setSenhas(List<Senha> senhas) {
        this.senhas = senhas;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Agendamento> getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(List<Agendamento> agendamento) {
        this.agendamento = agendamento;
    }

    @Override
    public String toString() {
        return "Consultorio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", numero='" + numero + '\'' +
                ", cep='" + cep + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", status=" + status +
                ", statusFuncionamento=" + statusFuncionamento +
                ", pacientes=" + pacientes +
                ", senhas=" + senhas +
                ", agendamento=" + agendamento +
                '}';
    }
}
