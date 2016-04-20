package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Home {
	// les attributs de la classe Home : maison
	private long id;
	private int taille; 
	private int NbPiece;
	private String nom;
	
	
	private List<SmartDevices> heaters;
	private List<SmartDevices> electronicDevices;
	
	//le proprietaire de la maison 
	//@JsonIgnore
	//@XmlTransient
	private Person owner;
	//une maison a une liste chauffages 
	//private List<Heaters> chaufagges = new ArrayList<Heaters>();
	
	public Home(){
		super();
		this.heaters=new ArrayList<SmartDevices>();
		this.electronicDevices=new ArrayList<SmartDevices>();
		
	}
	
	
	public Home(int taille, int NbPiece, Person person, List<SmartDevices> heaters, List<SmartDevices> electronicDevices){
		super();
		this.taille=taille;
		this.NbPiece=NbPiece;
		this.owner=person;
		this.heaters=heaters;
		this.electronicDevices=electronicDevices;
	}
	public Home(String nom, int taille, int NbPiece){
		
		super();
		this.nom= nom;
		this.taille=taille;
		this.NbPiece=NbPiece;
		
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getNbPiece() {
		return NbPiece;
	}

	public void setNbPiece(int nbPiece) {
		NbPiece = nbPiece;
	}

	@ManyToOne
	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	@OneToMany(mappedBy="home")
	public List<SmartDevices> getHeaters() {
		return heaters;
	}


	public void setHeaters(List<SmartDevices> heaters) {
		this.heaters = heaters;
	}

	@OneToMany(mappedBy="home")
	public List<SmartDevices> getElectronicDevices() {
		return electronicDevices;
	}


	public void setElectronicDevices(List<SmartDevices> electronicDevices) {
		this.electronicDevices = electronicDevices;
	}
	
	public void addDevice(SmartDevices device){
		//Test s'il s'agit d'un chauffage
		if (device instanceof Heaters){
			heaters.add(device);
		}else if (device instanceof ElectronicDevices){
			electronicDevices.add(device);
		}
	}
	
	/*
	 * avant l'heritage
	 * public List<Heaters> getChaufagges() {
	 
		return chaufagges;
	}

	public void setChaufagges(List<Heaters> chaufagges) {
		this.chaufagges = chaufagges;
	}
	
	 public void addChauffage(Heaters h){
		 chaufagges.add(h);
	    }
	    
	    public void removeChauffage(Heaters h){
	    	chaufagges.remove(h);
	    }
	    */
	    
	
		
	
}
