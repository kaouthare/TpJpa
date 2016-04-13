package domain;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


//L'entité qui représente la table personne dans la base de données 
@Entity
public class Person {
	
	//la liste des attributs liés à une personne (id, nom, prenom, mail, sa ou ses résidences et son ou ses elecroticDevices
	private long id; //son id
	private String nom; //nom 
	private String prenom; //prenom
	private String email; //email 
	private List<Home> Residence; //liste des résidences
	//private List<ElectronicDevices> devices; //liste des Devices 
	
	
	//le constructeur de la classe Personne 
	public Person(){
		
	}
	
	
	// le constructeur de la classe Personne avec les parametres 
	
	public Person(long id, String nom, String prenom, String email, List<Home> maisons, List<ElectronicDevices> devices ){
		this.id=id; //id
		this.nom=nom; //nom
		this.prenom=prenom; //prenom
		this.email=email; //email 
		this.Residence=maisons; //maisons
		//this.devices=devices; //Devices
		
	}
	public Person( String nom, String prenom, String email, List<Home> maisons){
		
		this.nom=nom; //nom
		this.prenom=prenom; //prenom
		this.email=email; //email 
		this.Residence=maisons; //maisons
		
		
	}
	
	
	//getter et setter de l'id 
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	//getter et setter du nom 
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//getter et setter du prénom 
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	//getter et setter de l'email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//la liste des résidences de la personne 
	@OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
	public List<Home> getResidence() {
		return Residence;
	}

	public void setResidence(List<Home> residence) {
		Residence = residence;
	}
	
	/*
	////getter et setter de la list des electronics devices 
	@OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
	public List<ElectronicDevices> getDevices() {
		return devices;
	}

	public void setDevices(List<ElectronicDevices> devices) {
		this.devices = devices;
	}*/
	
	 public void addMaisons(Home maison){
	    	Residence.add(maison);
	    }
	    
	    public void removeMaisons(Home maison){
	    	Residence.remove(maison);
	    }
		
	    /*
	    public void addElec(ElectronicDevices elec){
	    	devices.add(elec);
	    }
	    
	    public void removeElec(ElectronicDevices elec){
	    	devices.remove(elec);
	    }*/

	    @Override
		public String toString() {
			return "personne [id=" + id + ", name=" + nom + ", prenom="+ prenom + ", email="+email+"]";
		}
	
	
	

}
