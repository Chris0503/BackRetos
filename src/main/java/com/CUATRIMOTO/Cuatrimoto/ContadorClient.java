/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CUATRIMOTO.Cuatrimoto;

/**
 *
 * @author 57318
 */
public class ContadorClient {
    private Long total;
    private Client client;
    
    public ContadorClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public ContadorClient() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    
}

