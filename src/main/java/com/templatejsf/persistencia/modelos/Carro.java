/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.templatejsf.persistencia.modelos;

import javax.persistence.*;

/**
 * @author rmpestano
 */
@Entity
@Table(name = "car")
public class Carro implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "model")
    private String model;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    public Carro() {
    }

    public Carro(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Carro model(String model) {
        this.model = model;
        return this;
    }

    public Carro price(Double price) {
        this.price = price;
        return this;
    }

    public Carro name(String name) {
        this.name = name;
        return this;
    }

    public boolean hasModel() {
        return model != null && !"".equals(model.trim());
    }

    public boolean hasName() {
        return name != null && !"".equals(name.trim());
    }
}
