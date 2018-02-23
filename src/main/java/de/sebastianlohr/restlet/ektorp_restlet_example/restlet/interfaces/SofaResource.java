package de.sebastianlohr.restlet.ektorp_restlet_example.restlet.interfaces;

import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface SofaResource {

	@Get ("txt")
	public Representation represent();
	
	@Put ("json")
	public Representation store(Representation representation);
	
	@Delete
	public void remove();
}
