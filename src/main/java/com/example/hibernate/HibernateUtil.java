import modelo.Edificio;
import modelo.Persona;
import modelo.Reclamo;
import modelo.Unidad;

public class HibernateUtil
{
	private AnnotationConfiguration config;
    private static SessionFactory sessionFactory;

    private HibernateUtil() {
        	 config = new AnnotationConfiguration();
             config.addAnnotatedClass(Edificio.class);
             config.addAnnotatedClass(Imagen.class);
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
