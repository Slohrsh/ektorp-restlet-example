package de.sebastianlohr.restlet.ektorp_restlet_example.ektorp.repositories;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;

import de.sebastianlohr.restlet.ektorp_restlet_example.ektorp.entities.Sofa;

public class SofaRepository extends CouchDbRepositorySupport<Sofa>{

	public SofaRepository(CouchDbConnector db) {
        super(Sofa.class, db);
    }
}
