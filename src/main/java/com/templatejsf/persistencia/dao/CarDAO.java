package com.templatejsf.persistencia.dao;

import com.templatejsf.exception.BDException;
import com.templatejsf.persistencia.modelos.Car;

/**
 * Created by allanmoreira on 10/01/2018.
 */
public class CarDAO extends HibernateGenericDAO<Car> {

    public CarDAO() {
        super(Car.class);
    }

    public Car selectById(long idCar) throws BDException {
//        Car Car;
//        try {
//            Car = entityManager.find(Car.class, idCar);
//        } catch(Exception e){
//            e.printStackTrace();
//            throw new BDException("Houve um erro ao realizar a consulta");
//        }
//        return Car;
        return null;
    }


}
