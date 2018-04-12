package com.templatejsf.persistencia.dao;

import com.templatejsf.persistencia.HibernateConnectionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


@SuppressWarnings("unchecked")
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
    public List selectAll() {
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

    public void insert(T entity) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnectionFactory.getInstance();
            transaction = session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if(session!= null && session.isOpen())
                session.close();
        }
    }

    public void delete(T entity) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnectionFactory.getInstance();
            transaction = session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if(session!= null && session.isOpen())
                session.close();
        }

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

    public T selectById(int id) {
        T entity = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnectionFactory.getInstance();
            transaction = session.beginTransaction();
            String queryString = "FROM " + classeDAO.getName() + " WHERE id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            entity = (T) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return entity;
    }

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
