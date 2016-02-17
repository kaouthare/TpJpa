package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Home {
	private long id;
	private int taille; 
	private int NbPiece;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OWNED_ID")
	private Person Owner;

	private List<Heaters> chaufagges = new ArrayList<Heaters>();
	
	public Home(){
		
	}
	
	public Home(int taille, int NbPiece){
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

	public Person getOwner() {
		return Owner;
	}

	public void setOwner(Person owner) {
		Owner = owner;
	}
	
	@OneToMany(mappedBy="Residence")
	public List<Heaters> getChaufagges() {
		return chaufagges;
	}

	public void setChaufagges(List<Heaters> chaufagges) {
		this.chaufagges = chaufagges;
	}
	
	
}
