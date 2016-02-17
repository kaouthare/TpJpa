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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OWNED_ID")
	private Person Owner;
	
	public ElectronicDevices(){
		
	}
	
	public ElectronicDevices(int ocnso){
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

	public Person getOwner() {
		return Owner;
	}

	public void setOwner(Person owner) {
		Owner = owner;
	}

}
