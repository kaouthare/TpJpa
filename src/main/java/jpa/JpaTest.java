package jpa;

import java.awt.List;
import java.util.ArrayList;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		/*Ajout des donn�es pour remplir la base de donn�es*/
		tx.begin();
		
		try {
			Person P1= new Person();
			P1.setNom("Dupont");
			
			Person P2= new Person();
			P2.setNom("Legentil");
			
			//Cr�er des maison
			Home H1=new Home();
			H1.setNbPiece(2);
			H1.setTaille(80);
			
			Home H2=new Home();
			H2.setNbPiece(3);
			H2.setTaille(100);
			
		
			
			//cr�er deschauffages
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
			
			
			/* Avant h�ritage 
			//Ajouter des maison
			Home H1 = new Home();
			H1.setTaille(183);
			H1.setNbPiece(5);
			
			Home H2 = new Home();
			H2.setTaille(53);
			H2.setNbPiece(2);
			
			//Cr�ation des personnes 
			Person P1= new Person();
			P1.setNom("Dupont");
			
			Person P2= new Person();
			P2.setNom("Legentil");
			
			
			//Ajouter des chauffages
			Heaters C1= new Heaters();
			C1.setConso(200);
			//attribuer le chauffage C1 � la maison H1
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
			
			//Completer les donn�es des maisons 
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
			//Cr�er les listes
			ArrayList<Home> homes= new ArrayList<Home>();
			ArrayList<ElectronicDevices> ElcDevices= new ArrayList<ElectronicDevices>();
			
			//Remplir les listes
			homes.add(H1);
			ElcDevices.add(ED1);
			
			//Attribuer les listes � la personne
			P1.setDevices(ElcDevices);
			P1.setResidence(homes);
			manager.persist(P1);
			
			
			//Personne 2
			//Cr�er les listes
			ArrayList<Home> homes2= new ArrayList<Home>();
			ArrayList<ElectronicDevices> ElcDevices2= new ArrayList<ElectronicDevices>();
			
			//Remplir les listes
			homes.add(H2);
			ElcDevices.add(ED2);
			
			//Attribuer les listes � la personne
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
		Query q2 = (Query) manager.createQuery(s2,Person.class); //cr�er la requete ou on indique les entit�s manipul�s
		List<Person> res2 = q2.getResultList(); //recup�rer r�sultat
		
		//afficher r�sultat
		for(int i=0; i< res.size();i++){
			System.err.println("id:" +res2.get(i).getId());
			System.err.println("nom:"+res2.get(i).getNom()); //get(i) obtenir le i-�me r�sultat)
			System.err.println("devices:"+res2.get(i).getDevices());
			System.err.println("maisons:"+res2.get(i).getResidence());
			}
			*
		/*Requetes en criteria query ( crit�ria: s'adapte � la strucutre de la BDD)*/
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder(); //Cr�ation du crit�ria
		CriteriaQuery<Heaters> query = criteriaBuilder.createQuery(Heaters.class); //Indiquer l'entit�
		Root<Heaters> heater = query.from(Heaters.class); //Indiquer la table
		query.select(heater); 
		TypedQuery<Heaters> req = manager.createQuery(query); //Cr�er la requete
		List<Heaters> resu = req.getResultList(); 
		
		System.out.println("taille:" + resu.size());
		System.out.println("id:" +resu.get(0).getId());
		System.out.println("Conso:"+resu.get(0).getConso()); //Get(i) obtenir le i-�me r�sultat)
		 
		
		/*Test du fonctionnement d'une requete nomm�*/
		Query q = manager.createNamedQuery("Person.findAll"); //Utiliser requete nomm�e
		List<Person> res = q.getResultList(); //Recup�rer r�sultat
		
		for(int i=0; i< res.size();i++){
			System.err.println("id:" +res.get(i).getId());
			System.err.println("nom:"+res.get(i).getNom()); //Get(i) obtenir le i-�me r�sultat)
			System.err.println("maisons:"+res.get(i).getResidence());
			
		}
		
		
		manager.close();
		factory.close();
	}
	
		
	



}
