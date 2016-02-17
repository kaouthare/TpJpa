package domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ElectronicDevices {
	private long id;
	private int conso;
	private Person person;
	
	
	
	public ElectronicDevices(int conso, Person person){
		this.person=person;
		this.conso=conso;
	}

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
		return person;
	}

	public void setOwner(Person owner) {
		this.person = owner;
	}

}
