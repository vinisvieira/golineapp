package com.goline.goline.model.entity;

/**
 * Created by vinicius on 24/05/17.
 */

public class Notification {

    private Long id;
    private String tokenFMC;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTokenFMC() {
        return tokenFMC;
    }

    public void setTokenFMC(String tokenFMC) {
        this.tokenFMC = tokenFMC;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", tokenFMC='" + tokenFMC + '\'' +
                '}';
    }
}
