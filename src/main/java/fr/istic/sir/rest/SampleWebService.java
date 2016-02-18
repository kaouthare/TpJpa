package fr.istic.sir.rest;

import javax.ws.rs.core.MediaType;

import domain.Heaters;
import domain.Home;
import domain.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")

public class SampleWebService {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello, how are you?";
	}
	@GET
	@Path("/home")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson() {
		Home h = new Home();
		h.setNbPiece(5);
		
		Heaters h1 = new Heaters();
		h1.setConso(200);
		Heaters h2 = new Heaters();
		h1.setConso(600);
		h.addDevice(h1);
		h.addDevice(h2);
		Person p = new Person();
		p.setNom("dupont");
		p.setEmail("email");
		p.setPrenom("narjis");
		
		return p;
	}
}