package domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Heaters {
	private long id;
	private int conso;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="HOME_ID")
	private Home Residence;
	
	public Heaters(){
		
	}

	public Heaters(int conso){
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

	public Home getResidence() {
		return Residence;
	}

	public void setResidence(Home residence) {
		Residence = residence;
	}
}
