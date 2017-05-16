package com.goline.goline.model.entity;

import java.util.Date;

/**
 * Created by vinicius on 15/05/17.
 */

public class Agendamento {

    private Long id;
    private Date dataAgendamento;
    private Date horaAgendamento;
    private Consultorio consultorio;
    private Paciente paciente;
    private boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Date getHoraAgendamento() {
        return horaAgendamento;
    }

    public void setHoraAgendamento(Date horaAgendamento) {
        this.horaAgendamento = horaAgendamento;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", dataAgendamento=" + dataAgendamento +
                ", horaAgendamento=" + horaAgendamento +
                ", consultorio=" + consultorio +
                ", paciente=" + paciente +
                ", status=" + status +
                '}';
    }
}
