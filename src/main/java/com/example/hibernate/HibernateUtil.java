package com.example.hibernate;

import com.example.modelo.Edificio;
import com.example.modelo.Persona;
import com.example.modelo.Reclamo;
import com.example.modelo.Unidad;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
	private Configuration config;
    private static SessionFactory sessionFactory;

    private HibernateUtil() {
        	 config = new Configuration();
             config.addAnnotatedClass(Edificio.class);
             /*config.addAnnotatedClass(Imagen.class);*/
             config.addAnnotatedClass(Persona.class);
             config.addAnnotatedClass(Reclamo.class);
             config.addAnnotatedClass(Unidad.class);
             sessionFactory = config.buildSessionFactory();
   }
    
    public static SessionFactory getSessionFactory()
    {
    	if(sessionFactory == null)
    		new HibernateUtil();
        return sessionFactory;
    }
}
