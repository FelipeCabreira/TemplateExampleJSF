package com.templatejsf.persistencia.dao;

import com.templatejsf.exception.BDException;
import com.templatejsf.persistencia.modelos.Carro;

import javax.inject.Named;


@Named
public class CarroDAO extends HibernateGenericDAO<Carro> {

    public CarroDAO() {
        super(Carro.class);
    }



}
