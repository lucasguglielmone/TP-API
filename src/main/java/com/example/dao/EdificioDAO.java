package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import hibernate.HibernateUtil;
import modelo.Edificio;

public class EdificioDAO {
    private static EdificioDAO instancia;
	private Session session;
	
	private EdificioDAO() {}

	public static EdificioDAO getInstancia() {
		if(instancia == null)
			instancia = new EdificioDAO();
		return instancia;
	}

    public List<Edificio> getAll() {
		List<Edificio> resultado = new ArrayList<Edificio>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
		}
		catch( java.lang.reflect.InaccessibleObjectException a) {
			System.out.println(a.getMessage());
		}
		session.beginTransaction();
		List<Edificio> edificios = (List<Edificio>) session.createQuery("from edificios").list();
		session.getTransaction().commit();
		session.close();
		return resultado;
    }

    public Edificio findById(int id) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
		}
		catch( java.lang.reflect.InaccessibleObjectException a) {
			System.out.println(a.getMessage());
		}
		session.beginTransaction();
		Edificio resultado = (Edificio) session.createQuery("from edificios e where e.idClub = ?").setInteger(0, id).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return resultado;
	}

}

