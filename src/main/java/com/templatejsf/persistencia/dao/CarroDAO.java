package com.templatejsf.persistencia.dao;

import com.templatejsf.exception.BDException;
import com.templatejsf.persistencia.modelos.Carro;

/**
 * Created by allanmoreira on 10/01/2018.
 */
public class CarroDAO extends HibernateGenericDAO<Carro> {

    public CarroDAO() {
        super(Carro.class);
    }
    /*
    public List<Carro> selectAll() {
        Session session = null;
//        Transaction transaction = null;
        try {
            session = HibernateConnectionFactory.getInstance();
//            transaction = session.beginTransaction();
            Query query = session.createQuery("from Carro ");
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

    public Carro selectById(long idCar) throws BDException {
//        Carro Carro;
//        try {
//            Carro = entityManager.find(Carro.class, idCar);
//        } catch(Exception e){
//            e.printStackTrace();
//            throw new BDException("Houve um erro ao realizar a consulta");
//        }
//        return Carro;
        return null;
    }


}
