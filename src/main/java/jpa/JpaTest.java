package jpa;


import java.util.ArrayList;
import java.util.List;

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
		/*Initialisation de l'entityManager
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();

		//EntityTransaction tx = manager.getTransaction();
		/*Ajout des données pour remplir la base de données*/
		EntityTransaction tx = EntityManagerHelper.getEntityManager().getTransaction();
		tx.begin();
		
		try {
			
			creerPerson();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		
		listerInfos();
		EntityManagerHelper.getEntityManager().close();
		EntityManagerHelper.getfactory().close();
		/*
		manager.close();
		factory.close();
		
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
			*
		/*Requetes en criteria query ( critéria: s'adapte à la strucutre de la BDD)
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder(); //Création du critéria
		CriteriaQuery<Heaters> query = criteriaBuilder.createQuery(Heaters.class); //Indiquer l'entité
		Root<Heaters> heater = query.from(Heaters.class); //Indiquer la table
		query.select(heater); 
		TypedQuery<Heaters> req = manager.createQuery(query); //Créer la requete
		List<Heaters> resu = req.getResultList(); 
		
		System.out.println("taille:" + resu.size());
		System.out.println("id:" +resu.get(0).getId());
		System.out.println("Conso:"+resu.get(0).getConso()); //Get(i) obtenir le i-éme résultat)
		 
		
		//Test du fonctionnement d'une requete nommé
		Query q = manager.createNamedQuery("Person.findAll"); //Utiliser requete nommée
		List<Person> res = q.getResultList(); //Recupérer résultat
		
		for(int i=0; i< res.size();i++){
			System.err.println("id:" +res.get(i).getId());
			System.err.println("nom:"+res.get(i).getNom()); //Get(i) obtenir le i-éme résultat)
			System.err.println("maisons:"+res.get(i).getResidence());
			
		}
		
		*/
		
	}
	
		
	private static void creerPerson(){
		
		Home H1=new Home("residence 1", 80, 2);
		List<Home> residences= new ArrayList<Home>();
		residences.add(H1);
		
		//créer deschauffages
		Heaters C1= new Heaters("Chauffage chambre", 200, H1);
		Heaters C2= new Heaters("Chauffage cuisine", 100, H1);
		Heaters C3= new Heaters("Chauffage salon", 180, H1);
		
		List<SmartDevices> Chauffages = new ArrayList<SmartDevices>();
		Chauffages.add(C1);
		Chauffages.add(C2);
		Chauffages.add(C3);
		
		ElectronicDevices ED1= new ElectronicDevices("Tv", 40, H1);
		ElectronicDevices ED2= new ElectronicDevices("Phone", 30, H1);
		ElectronicDevices ED3= new ElectronicDevices("Frigo", 100, H1);
		
		List<SmartDevices> Equipements = new ArrayList<SmartDevices>();
		Equipements.add(ED1);
		Equipements.add(ED2);
		Equipements.add(ED3);
		
		H1.setHeaters(Chauffages);
		H1.setElectronicDevices(Equipements);
		
	
		
		Person P1= new Person("Bennouna", "Kaoutar", "kawtar.be7@gmail.com", residences);
		Person P2= new Person("Bouka", "Ayoub", "Ayoub.messi@gmail.com", residences);
		H1.setOwner(P1);
		
		
		EntityManagerHelper.getEntityManager().persist(H1);
		EntityManagerHelper.getEntityManager().persist(ED1);
		EntityManagerHelper.getEntityManager().persist(ED2);
		EntityManagerHelper.getEntityManager().persist(ED3);
		EntityManagerHelper.getEntityManager().persist(C1);
		EntityManagerHelper.getEntityManager().persist(C2);
		EntityManagerHelper.getEntityManager().persist(C3);
		
		EntityManagerHelper.getEntityManager().persist(P1);
		EntityManagerHelper.getEntityManager().persist(P2);
		System.out.println("persist");
		
		
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
	}
	
	private static void listerInfos(){
		List<Person> Res = EntityManagerHelper.getEntityManager().createQuery("Select p from Person p ", Person.class).getResultList();
		System.out.println("la liste des personnes :");
		System.out.println("Nombre de person: " + Res.size());
		for (Person p : Res){
			System.out.println( "Perosnne suivante : " + p);
		}
		
		System.out.println("*********");
		
		List<SmartDevices> ResSd = EntityManagerHelper.getEntityManager().createQuery("Select s from SmartDevices s ", SmartDevices.class).getResultList();
		System.out.println("la liste des Smart Devices :");
		System.out.println("Nombre de Smart Devices: " + ResSd.size());
		for (SmartDevices Sd : ResSd){
			System.out.println( "SD suivante : " + Sd);
		}
		
	
		System.out.println("*********");
		System.out.println("---------------------");
		CriteriaBuilder cb = EntityManagerHelper.getEntityManager().getCriteriaBuilder();
		CriteriaQuery query = cb.createQuery(Person.class);
		Root from = query.from(Person.class);
		query.select(from).where(cb.equal(from.get("nom"), "Bennouna"));
		List<Person> result = EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
		for (Object listePerson : result) {
			System.out.println("liste des personnes qui ont le nom NomTest : " + listePerson);
		}
		System.out.println("---------------------");
		
		
	}


}
