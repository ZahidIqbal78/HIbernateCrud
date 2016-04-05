package com.zahid.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by Zahid Iqbal Tushar.
 */
public class HibernateUtil {

    //This class creates hibernate session and returns it.

    private static SessionFactory sessionFactory = buildSessionFactory();
    private static ServiceRegistry serviceRegistry;

    private static SessionFactory buildSessionFactory() {

        try{
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }catch(Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
        return sessionFactory;
    }

    public static Session getSession() throws HibernateException{
        return sessionFactory.openSession();
    }

}
