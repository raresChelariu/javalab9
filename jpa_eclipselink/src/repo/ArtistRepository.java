package repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.Album;
import model.Artist;
import util.PersistenceUtil;

public class ArtistRepository {
	public static void create(Artist artist){
		EntityManager manager = PersistenceUtil.createEntityManager();
	    manager.getTransaction().begin();
		
	    manager.persist(artist);
	    manager.getTransaction().commit();
	    manager.close();
	}
	public static Artist findById(int id){
		Artist currArtist = null;
		EntityManager manager = PersistenceUtil.createEntityManager();
		currArtist = manager.find(Artist.class, id);
		manager.close();
		
		return currArtist;
	}
	public static List<Artist> findByName(String name){
		List<Artist> patternSearchResult = null;
		EntityManager manager = PersistenceUtil.createEntityManager();
		
		String queryString = "SELECT x FROM Artist x WHERE x.name LIKE '" + name + "'";
		Query query = manager.createQuery(queryString);
		patternSearchResult = (List<Artist>) query.getResultList(); 
		manager.close();
		return patternSearchResult;
	}
}
