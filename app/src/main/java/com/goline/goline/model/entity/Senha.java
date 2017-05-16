package com.goline.goline.model.entity;

import java.util.Date;

/**
 * Created by danilofernandocavalcanti on 01/12/16.
 */

public class Senha {

    private Long id;
    private int valorChamada;
    private boolean status;
    private boolean statusChamada;
    private Date dataInicio;
    private Date dataFinal;
    private Consultorio consultorio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValorChamada() {
        return valorChamada;
    }

    public void setValorChamada(int valorChamada) {
        this.valorChamada = valorChamada;
    }

    public boolean isStatusChamada() {
        return statusChamada;
    }

    public void setStatusChamada(boolean statusChamada) {
        this.statusChamada = statusChamada;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    @Override
    public String toString() {
        return "Senha{" +
                "id=" + id +
                ", valorChamada=" + valorChamada +
                ", statusChamada=" + statusChamada +
                ", status=" + status +
                ", dataInicio=" + dataInicio +
                ", dataFinal=" + dataFinal +
                ", consultorio=" + consultorio +
                '}';
    }
}
