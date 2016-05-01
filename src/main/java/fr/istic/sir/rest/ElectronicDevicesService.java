package fr.istic.sir.rest;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.ElectronicDevices;
import domain.Heaters;
import jpa.EntityManagerHelper;

@Path("/ElectronicDevices")
public class ElectronicDevicesService {
	@Path("/lister")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<ElectronicDevices> getlistHeater(){
		String query="select s from SmartDevices as s where DTYPE='Electronic Device'";
		List<ElectronicDevices> hs = EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
		EntityManagerHelper.closeEntityManager();
		return hs;
	}
	
	@Path("/ajouter")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ElectronicDevices create(ElectronicDevices Ed){
		EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
		t.begin();
		EntityManagerHelper.getEntityManager().persist(Ed);
		t.commit();
		EntityManagerHelper.closeEntityManager();
		return Ed;
	}
}
