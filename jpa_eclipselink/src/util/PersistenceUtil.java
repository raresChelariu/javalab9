package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
	private EntityManagerFactory emfactory = null;
	private static PersistenceUtil instance;
	
	public EntityManagerFactory getEMFactory() {
		return emfactory;
	}
	public static EntityManager createEntityManager() {
		EntintyManagerFactory factory = PersistenceUtil.getInstance().getEMFactory();
		return factory.createEntityManager();
	}
	public static PersistenceUtil getInstance() {
		if (instance != null)
			return instance;
		instance = new PersistenceUtil();
		return instance;
	}
	private PersistenceUtil() {
		emfactory = Persistence.createEntityManagerFactory("jpa_eclipselink");
	}
	
}
