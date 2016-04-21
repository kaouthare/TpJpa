package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@DiscriminatorValue("Heaters")
public class Heaters extends SmartDevices {
	
	public Heaters(){
		super();
	}

	//constructeur apres heritages 
	public Heaters(String nomSd, int conso, Home home){
		super(nomSd, conso, home);
	}
	
	
	
	@Override
	public String toString() {
		return "Electronic device : [id=" + super.getId() + ", conso=" + super.getConso() + "]";
	}

	/* Question 1 à 5
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


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="HOME_ID")
	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}
	*/
}
