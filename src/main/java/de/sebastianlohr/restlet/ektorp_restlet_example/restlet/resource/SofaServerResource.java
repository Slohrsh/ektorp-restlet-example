package de.sebastianlohr.restlet.ektorp_restlet_example.restlet.resource;

import java.io.IOException;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import de.sebastianlohr.restlet.ektorp_restlet_example.ektorp.SofaDB;
import de.sebastianlohr.restlet.ektorp_restlet_example.ektorp.entities.Sofa;
import de.sebastianlohr.restlet.ektorp_restlet_example.restlet.interfaces.SofaResource;

public class SofaServerResource extends ServerResource implements SofaResource {

	private String couchId;
	private SofaDB sofaDb;
	
	@Override
	public void doInit () throws ResourceException
	{
		couchId = getAttribute("couchId");
		sofaDb = new SofaDB();
	}
	
	public Representation represent() 
	{
		Sofa sofa = sofaDb.getSofa(couchId);
		return new JacksonRepresentation<Sofa>(sofa);
	}

	public Representation store(Representation representation) 
	{
		JacksonRepresentation<Sofa> sofaRepresentation = new JacksonRepresentation<Sofa>(representation, Sofa.class);
		Sofa sofa;
		try {
			sofa = sofaRepresentation.getObject();
			sofa = sofaDb.getSofa(couchId)
					.setColor(sofa.getColor());
			sofaDb.updateSofa(sofa);
			return new JacksonRepresentation<Sofa>(sofa);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sofaRepresentation;
	}

	public void remove() 
	{
		sofaDb.removeSofa(couchId);
	}

}
