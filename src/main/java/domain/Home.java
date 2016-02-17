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

@Entity
public class Home {
	private long id;
	private int taille; 
	private int NbPiece;
	
	
	private Person person;

	private List<Heaters> chaufagges = new ArrayList<Heaters>();
	
	public Home(){
		
	}
	public Home(Person person){
		this.person=person;
		
	}
	
	public Home(int taille, int NbPiece, Person person){
		this.taille=taille;
		this.NbPiece=NbPiece;
		this.person=person;
	}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return person;
	}

	public void setOwner(Person owner) {
		person = owner;
	}
	
	@OneToMany(mappedBy="home")
	public List<Heaters> getChaufagges() {
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
	    
	    
	   
		
	
}
