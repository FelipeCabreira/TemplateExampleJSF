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
    /*
    public List<Car> selectAll() {
        Session session = null;
//        Transaction transaction = null;
        try {
            session = HibernateConnectionFactory.getInstance();
//            transaction = session.beginTransaction();
            Query query = session.createQuery("from Car ");
            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return queryList;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if(session!= null && session.isOpen())
                session.close();
        }
        return null;
    }
    */

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
