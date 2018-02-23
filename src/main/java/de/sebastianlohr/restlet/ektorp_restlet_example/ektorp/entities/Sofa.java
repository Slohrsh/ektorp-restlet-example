package de.sebastianlohr.restlet.ektorp_restlet_example.ektorp.entities;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sofa {
    
    private String id;
    private String revision;
    private String color;
    private Map<String, String> additionalFields;
    
    @JsonProperty("_id")
    public String getId() 
    {
            return id;
    }

    @JsonProperty("_id")
    public Sofa setId(String s) 
    {
            id = s;
            return this;
    }

    @JsonProperty("_rev")
    public String getRevision() 
    {
            return revision;
    }

    @JsonProperty("_rev")
    public Sofa setRevision(String s) 
    {
            revision = s;
            return this;
    }

    public Sofa setColor(String s) 
    {
            color = s;
            return this;
    }
    
    public String getColor() 
    {
            return color;
    }

	public Map<String, String> getAdditionalFields() {
		return additionalFields;
	}

	public void setAdditionalFields(Map<String, String> additionalFields) {
		this.additionalFields = additionalFields;
	}
}
