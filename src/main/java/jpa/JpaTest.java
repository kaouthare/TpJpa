package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.ElectronicDevices;
import domain.Heaters;
import domain.Home;
import domain.Person;

public class JpaTest {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		try {
			Person p1= new Person();
			manager.persist(p1);
			ElectronicDevices Elc= new ElectronicDevices();
			Elc.setConso(200);
			Elc.setOwner(p1);
			manager.persist(Elc);
			
			
			Heaters h1= new Heaters();
			h1.setConso(200);
			Heaters h2= new Heaters();
			h2.setConso(180);
			Heaters h3= new Heaters();
			h3.setConso(250);
			
			manager.persist(h1);
			manager.persist(h2);
			manager.persist(h3);
			
			Home r=new Home();
			r.setNbPiece(10);
			r.addChauffage(h1);
			r.addChauffage(h2);
			r.addChauffage(h3);
			manager.persist(r);
			
			Person p = new Person();
			p.setNom("martin");
			p.setPrenom("Dupont");
			p.addMaisons(r);
			p.addElec(Elc);
			manager.persist(p);
			
			Person dupont= new Person();
			dupont.setNom("bennouna");
			dupont.setPrenom("kaoutar");
			dupont.setEmail("kaou.benn");
			manager.persist(dupont);
			
			
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
//		String s = "SELECT e FROM Person as e where e.name=:name";
		
//		Query q = manager.createQuery(s,Person.class);
//		q.setParameter("name", "martin"); 
//		List<Person> res = q.getResultList();
		
//		System.err.println(res.size());
//		System.err.println(res.get(0).getName());
		
		manager.close();
		factory.close();
	}

}
