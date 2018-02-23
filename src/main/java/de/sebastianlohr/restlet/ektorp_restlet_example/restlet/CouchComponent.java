package de.sebastianlohr.restlet.ektorp_restlet_example.restlet;

import org.restlet.Component;
import org.restlet.data.Protocol;

public class CouchComponent extends Component
{

	public static void main(String[] args) throws Exception
	{
		new CouchComponent().start();
	}
	
	public CouchComponent()
	{
		setName("CouchDB & Restlet");
		setDescription("Example Application to manipulate data on CouchDB");
		setAuthor("Sebastian Lohr");
		
		getServers().add(Protocol.HTTP, 8111);
		
		getDefaultHost().attachDefault(new CouchApplication());
	}
}

