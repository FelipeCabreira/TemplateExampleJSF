package com.templatejsf.persistencia.dao;

import com.templatejsf.persistencia.HibernateConnectionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Allan Moreira on 26/01/2016.
 */
//@Repository
public class HibernateGenericDAO<T> {

    private Class<T> classeDAO;
    private SessionFactory sessionFactory;
//    private Session session;

//    @Autowired
//    public service.HibernateGenericDAO(SessionFactory sessionFactory){
//        this.sessionFactory = sessionFactory;
//    }


//    public service.HibernateGenericDAO() {}

    public HibernateGenericDAO(Class<T> classeDAO) {
//      Query query = session.createQuery("from " + classeDAO.getClass().getName() + " c");
//        this.sessionFactory = sessionFactory;
        this.classeDAO = classeDAO;
    }

    /*
    public void setClasseDAO(Class<T> classeDAO) {
        this.classeDAO = classeDAO;
    }
    */

//    @Transactional
    public List<T> selectAll() {
        Session session = null;
//        Transaction transaction = null;
        try {
            session = HibernateConnectionFactory.getInstance();
//            transaction = session.beginTransaction();
            Query query = session.createQuery("from " + classeDAO.getName());
            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (List<T>) queryList;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if(session!= null && session.isOpen())
                session.close();
        }
        return null;
    }

    public void insert(T entity) {
        Session session = null;
        Transaction transaction = null;
        try {
//            session =
            transaction = session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void delete(int id) {
        Session session = null;
        Transaction transaction = null;
//        try {
            session = HibernateConnectionFactory.getInstance();
            transaction = session.beginTransaction();
            T t = (T) session.load(classeDAO.getName(), id);
            session.delete(t);
            session.getTransaction().commit();
//        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
//            e.printStackTrace();
//        } finally {
            session.flush();
            session.close();
//        }
    }

    public void update(T entity) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnectionFactory.getInstance();
            transaction = session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    /*
    public T selectById(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = service.HibernateConnectionFactory.create();
            transaction = session.beginTransaction();
//            String queryString = "from CartaoCredito where id = :id";
//            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            T entity = (T) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return entity;
    }
    */

    /*/////////////////////////////////////////////////////*/
    public Object salvarBKP(Object o) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnectionFactory.getInstance();
            transaction = session.beginTransaction();
            session.save(o);
            transaction.commit();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
