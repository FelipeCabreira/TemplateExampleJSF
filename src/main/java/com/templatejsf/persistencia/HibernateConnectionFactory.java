package com.templatejsf.persistencia;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateConnectionFactory {

    private static HibernateConnectionFactory hibernateConnectionFactory;
    private Configuration cfg;
    private SessionFactory sessionFactory;

    private HibernateConnectionFactory() throws HibernateException {
        // build the config
        cfg = new Configuration().configure();
        sessionFactory = cfg.buildSessionFactory();

        /*
        // Para carregar o arquivo "com.templatejsf.persistencia.cfg.xml" de um diretório diferente do diretório padrão
        SessionFactory sessionFactory = new Configuration()
                .configure("/com/mkyong/persistence/com.templatejsf.persistencia.cfg.xml")
                .buildSessionFactory();
        */
    }

    public static synchronized Session getInstance() throws HibernateException {
        if (hibernateConnectionFactory == null) {
            hibernateConnectionFactory = new HibernateConnectionFactory();
        }
        return hibernateConnectionFactory.getSession();
    }

    private Session getSession() throws HibernateException {
        Session session = sessionFactory.openSession();
        if (!session.isConnected()) {
            this.reconnect();
        }
        return session;
    }

    private void reconnect() throws HibernateException {
        this.sessionFactory = cfg.buildSessionFactory();
    }
}
