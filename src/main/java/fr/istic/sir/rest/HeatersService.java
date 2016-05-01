package fr.istic.sir.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Heaters;
import jpa.EntityManagerHelper;

@Path("/heaters")
public class HeatersService {
	
	
	@Path("/lister")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Heaters> getlistHeater(){
		String query="select s from SmartDevices as s where DTYPE='Heaters'";
		List<Heaters> hs = EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
		EntityManagerHelper.closeEntityManager();
		return hs;
	}
	
	@Path("/ajouter")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Heaters create(Heaters h){
		EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
		t.begin();
		EntityManagerHelper.getEntityManager().persist(h);
		t.commit();
		EntityManagerHelper.closeEntityManager();
		return h;
	}
	
	@DELETE 
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam("id") String arg0){
		EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
		t.begin();
		EntityManagerHelper.getEntityManager().remove(EntityManagerHelper.getEntityManager().find(Heaters.class, Long.parseLong(arg0)));
		t.commit();
		EntityManagerHelper.getEntityManager().close();
		
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Heaters find(@PathParam("id") String arg0){
		
		String query ="select h from SmartDevices as h where h.id="+Integer.parseInt(arg0);
		List<Heaters> res = EntityManagerHelper.getEntityManager().createQuery(query).getResultList();
		if(res.size()==0){
			return null;
		}else{
			Heaters ht = res.get(0);
			return ht;
			
		}
	}
	
	
}
