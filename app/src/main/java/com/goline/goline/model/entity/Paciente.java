package com.goline.goline.model.entity;

import java.util.List;

/**
 * Created by vinicius on 15/05/17.
 */

public class Paciente {

    private Long id;
    private String nome;
    private String email;
    private String password;
    private String token;
    private String telefone;
    private List<Consultorio> consultorio;
    private List<Agendamento> agendamento;
    private List<Senha> senha;
    private boolean status;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Consultorio> getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(List<Consultorio> consultorio) {
        this.consultorio = consultorio;
    }

    public List<Agendamento> getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(List<Agendamento> agendamento) {
        this.agendamento = agendamento;
    }

    public List<Senha> getSenha() {
        return senha;
    }

    public void setSenha(List<Senha> senha) {
        this.senha = senha;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", telefone='" + telefone + '\'' +
                ", consultorio=" + consultorio +
                ", agendamento=" + agendamento +
                ", senha=" + senha +
                ", status=" + status +
                '}';
    }
}
