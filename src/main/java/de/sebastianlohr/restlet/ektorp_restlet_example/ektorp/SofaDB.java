package de.sebastianlohr.restlet.ektorp_restlet_example.ektorp;

import java.util.List;

import de.sebastianlohr.restlet.ektorp_restlet_example.ektorp.entities.Sofa;
import de.sebastianlohr.restlet.ektorp_restlet_example.ektorp.repositories.SofaRepository;

public class SofaDB extends CouchDB {

	private SofaRepository repo;
	
	public SofaDB()
	{
		super();
		repo = new SofaRepository(database);
	}
	
	public void addSofa(Sofa sofa)
	{
		repo.add(sofa);
	}
	
	public boolean contains(String docId)
	{
		return repo.contains(docId);
	}
	
	public Sofa getSofa(String docId)
	{
		return repo.get(docId);
	}
	
	public void updateSofa(Sofa sofa)
	{
		repo.update(sofa);
	}
	
	public void removeSofa(Sofa sofa)
	{
		repo.remove(sofa);
	}
	
	public List<Sofa> getAllSofas()
	{
		return repo.getAll();
	}

	public void removeSofa(String couchId) {
		repo.remove(repo.get(couchId));		
	}
}