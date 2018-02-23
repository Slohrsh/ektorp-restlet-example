package de.sebastianlohr.restlet.ektorp_restlet_example.restlet.resource;

import java.io.IOException;
import java.util.List;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import de.sebastianlohr.restlet.ektorp_restlet_example.ektorp.SofaDB;
import de.sebastianlohr.restlet.ektorp_restlet_example.ektorp.entities.Sofa;
import de.sebastianlohr.restlet.ektorp_restlet_example.restlet.interfaces.SofasResource;

public class SofasServerResource extends ServerResource implements SofasResource{
	
	private SofaDB sofaDb;
	
	@Override
	public void doInit () throws ResourceException
	{
		sofaDb = new SofaDB();
	}
	
	public Representation represent() {
		List<Sofa> sofas = sofaDb.getAllSofas();
		return new JacksonRepresentation<List<Sofa>>(sofas);
	}

	public void add(Representation representation) {
		JacksonRepresentation<Sofa> sofaRepresentation = new JacksonRepresentation<Sofa>(representation, Sofa.class);
		Sofa sofa;
		try {
			sofa = sofaRepresentation.getObject();
			sofaDb.addSofa(sofa);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
