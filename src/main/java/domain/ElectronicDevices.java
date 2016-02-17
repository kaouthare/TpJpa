package domain;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

}
