package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("Electronic Device")
public class ElectronicDevices extends SmartDevices{
	/*
	 * Attributs de la classe Electronics devices
	private long id;
	private int conso;
	private Person owner;
	*/
	public ElectronicDevices(){
		super();
	}
	
	public ElectronicDevices( String nomSd, int conso, Home home){
		super(nomSd, conso, home);
	}

	
	/*Question 1 à 5
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
	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}
*/
	
}
