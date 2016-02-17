package domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
}
