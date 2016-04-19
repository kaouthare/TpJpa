package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

//Question 5 la classe mère des classes Heaters et ElectronicDevices

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  //Definir l'heritage 
public abstract class SmartDevices {
	//atributs 
	private long id;
	private int conso;
	private String nomSd;
	
	private Home home;
	
	//constructeur
	public SmartDevices(String nomSd, int conso, Home home) {
		super();
		this.nomSd= nomSd;
		this.conso= conso;
		this.home = home;
	}
	
	public SmartDevices(){
		
	}

	
	//Création des getters et setters 
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getConso() {
		return conso;
	}

	public void setConso(int conso) {
		this.conso = conso;
	}
	
	@ManyToOne
	//@JsonIgnore
	//@XmlTransient
	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}
	

}
