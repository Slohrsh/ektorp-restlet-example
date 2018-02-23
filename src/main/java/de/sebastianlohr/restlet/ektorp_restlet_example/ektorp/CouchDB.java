package de.sebastianlohr.restlet.ektorp_restlet_example.ektorp;

import java.net.MalformedURLException;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;

public abstract class CouchDB {

	CouchDbConnector database;
	
	public CouchDB()
	{
		HttpClient httpClient;
		try {
			httpClient = new StdHttpClient.Builder()
			        .url("http://localhost:5984")
			        .username("admin")
			        .password("admin")
			        .build();
			CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);
			database = new StdCouchDbConnector("mydatabase", dbInstance);

			database.createDatabaseIfNotExists();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
