package jpa;

import java.awt.List;
import java.util.ArrayList;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import domain.ElectronicDevices;
import domain.Heaters;
import domain.Home;
import domain.Person;
import domain.SmartDevices;
public class JpaTest {

	/**
	 * @param args
	 */
	public JpaTest(EntityManager entityManager){
		
	}
	
	public static void main(String[] args) {
		/*Initialisation de l'entityManager*/
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		/*Ajout des données pour remplir la base de données*/
		tx.begin();
		
		try {
			Person P1= new Person();
			P1.setNom("Dupont");
			
			Person P2= new Person();
			P2.setNom("Legentil");
			
			//Créer des maison
			Home H1=new Home();
			H1.setNbPiece(2);
			H1.setTaille(80);
			
			Home H2=new Home();
			H2.setNbPiece(3);
			H2.setTaille(100);
			
		
			
			//créer deschauffages
			Heaters C1= new Heaters();
			C1.setConso(200);
			C1.setHome(H2);
			
			Heaters C2= new Heaters();
			C2.setConso(180);
			C2.setHome(H2);
			
			
			//ajout d'un autre chauffage : heater
			Heaters C3= new Heaters();
			C3.setConso(250);
			C3.setHome(H2);
			H1.getHeaters().add(C1);
			H1.getHeaters().add(C2);
			H2.getHeaters().add(C2);
			H2.getHeaters().add(C3);
		
			
			ElectronicDevices ED1= new ElectronicDevices();
			ED1.setConso(34);
			H1.getElectronicDevices().add(ED1);
			H2.getElectronicDevices().add(ED1);
			//Ajouter un deuxieme Device
			ElectronicDevices ED2= new ElectronicDevices();
			ED2.setConso(340);
			H1.getElectronicDevices().add(ED2);
			
			P1.addMaisons(H1);
			P2.getResidence().add(H1);
			
			
			/* Avant héritage 
			//Ajouter des maison
			Home H1 = new Home();
			H1.setTaille(183);
			H1.setNbPiece(5);
			
			Home H2 = new Home();
			H2.setTaille(53);
			H2.setNbPiece(2);
			
			//Création des personnes 
			Person P1= new Person();
			P1.setNom("Dupont");
			
			Person P2= new Person();
			P2.setNom("Legentil");
			
			
			//Ajouter des chauffages
			Heaters C1= new Heaters();
			C1.setConso(200);
			//attribuer le chauffage C1 à la maison H1
			C1.setHome(H1);
			manager.persist(C1);
			
			//ajout d'un autre chauffage : heater
			Heaters C2= new Heaters();
			C2.setConso(180);
			C2.setHome(H2);
			manager.persist(C2);
			
			//ajout d'un autre chauffage : heater
			Heaters C3= new Heaters();
			C3.setConso(250);
			C3.setHome(H2);
			manager.persist(C3);
			
			//Completer les données des maisons 
			//Completer maison H1
			H1.setOwner(P1);
			H1.getChaufagges().add(C1);
			manager.persist(H1);
			
			//Completer maison H2
			H2.setOwner(P2);
			H2.getChaufagges().add(C2);
			H2.getChaufagges().add(C3);
			manager.persist(H2);
			
			//Ajouter des Electronics Devices
			
			ElectronicDevices ED1= new ElectronicDevices();
			ED1.setConso(34);
			ED1.setOwner(P1);
			manager.persist(ED1);
			
			//Ajouter un deuxieme Device
			ElectronicDevices ED2= new ElectronicDevices();
			ED2.setConso(340);
			ED2.setOwner(P2);
			manager.persist(ED2);
			
			
			
			//Completer les personnes pour pourvoir les ajouter 
			
			//Personne 1
			//Créer les listes
			ArrayList<Home> homes= new ArrayList<Home>();
			ArrayList<ElectronicDevices> ElcDevices= new ArrayList<ElectronicDevices>();
			
			//Remplir les listes
			homes.add(H1);
			ElcDevices.add(ED1);
			
			//Attribuer les listes à la personne
			P1.setDevices(ElcDevices);
			P1.setResidence(homes);
			manager.persist(P1);
			
			
			//Personne 2
			//Créer les listes
			ArrayList<Home> homes2= new ArrayList<Home>();
			ArrayList<ElectronicDevices> ElcDevices2= new ArrayList<ElectronicDevices>();
			
			//Remplir les listes
			homes.add(H2);
			ElcDevices.add(ED2);
			
			//Attribuer les listes à la personne
			P2.setDevices(ElcDevices2);
			P2.setResidence(homes2);
			manager.persist(P2);

		*/
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		
		
		/*Liste des requetes
		
	//Requete 1
		String s = "SELECT e FROM Person as e where e.nom=:nom";
	
		Query q = (Query) manager.createQuery(s,Person.class);
		q.setParameter("nom", "legentil"); 
		List<Person> res = q.getResultList();
		
		System.err.println(res.size());
		System.err.println(res.get(0).getNom());
		
		
		//Requete 2
		String s2 = "SELECT p FROM Person as p";
		Query q2 = (Query) manager.createQuery(s2,Person.class); //créer la requete ou on indique les entités manipulés
		List<Person> res2 = q2.getResultList(); //recupérer résultat
		
		//afficher résultat
		for(int i=0; i< res.size();i++){
			System.err.println("id:" +res2.get(i).getId());
			System.err.println("nom:"+res2.get(i).getNom()); //get(i) obtenir le i-éme résultat)
			System.err.println("devices:"+res2.get(i).getDevices());
			System.err.println("maisons:"+res2.get(i).getResidence());
			}
			*/
		
		manager.close();
		factory.close();
	}
	
		
	



}
