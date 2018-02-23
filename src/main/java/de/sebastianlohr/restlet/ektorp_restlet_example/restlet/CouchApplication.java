package de.sebastianlohr.restlet.ektorp_restlet_example.restlet;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import de.sebastianlohr.restlet.ektorp_restlet_example.restlet.resource.SofaServerResource;
import de.sebastianlohr.restlet.ektorp_restlet_example.restlet.resource.SofasServerResource;

public class CouchApplication extends Application
{
    
    @Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		router.attach("/couch/{couchId}", SofaServerResource.class);
		router.attach("/couch" , SofasServerResource.class);
		return router;
	}
}
