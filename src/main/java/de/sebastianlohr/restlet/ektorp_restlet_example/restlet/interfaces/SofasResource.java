package de.sebastianlohr.restlet.ektorp_restlet_example.restlet.interfaces;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

public interface SofasResource {

	@Get ("txt")
	public Representation represent();
	
	@Post ("json")
	public void add(Representation representation);
}
