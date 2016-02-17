package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	private long id;
	private String nom;
	private String prenom;
	private String email;
	private List<Home> Residence = new ArrayList<Home>();
	private List<ElectronicDevices> devices= new ArrayList<ElectronicDevices>();
	
	
	public Person(){
		
	}
	
	public Person(String nom, String prenom, String email){
		this.nom=nom;
		this.prenom=prenom;
		this.email=email;
		
		
	}
	
	public Person(Long id, String nom, List<Home> maisons, List<ElectronicDevices> devices) {
		super();
		this.id = id;
		this.nom = nom;
		this.Residence = maisons;
		this.devices = devices;
		
	}
	public Person(String nom, String prenom){
		this.nom=nom;
		this.prenom=prenom;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
	public List<Home> getResidence() {
		return Residence;
	}

	public void setResidence(List<Home> residence) {
		Residence = residence;
	}
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
	public List<ElectronicDevices> getDevices() {
		return devices;
	}

	public void setDevices(List<ElectronicDevices> devices) {
		this.devices = devices;
	}
	
	 public void addMaisons(Home maison){
	    	Residence.add(maison);
	    }
	    
	    public void removeMaisons(Home maison){
	    	Residence.remove(maison);
	    }
		
	    public void addElec(ElectronicDevices elec){
	    	devices.add(elec);
	    }
	    
	    public void removeElec(ElectronicDevices elec){
	    	devices.remove(elec);
	    }

	    @Override
		public String toString() {
			return "personne [id=" + id + ", name=" + nom + ", prenom="+ prenom + ", email="+email+"]";
		}
	
	
	

}
