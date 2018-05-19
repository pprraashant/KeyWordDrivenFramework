package com.domain;


import javax.xml.bind.annotation.XmlAttribute;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="link",namespace="https://www.w3.org/2005/Atom")
public class AtomLink {
	
	private String type;
	private String href;
	private String relationship;
	
	public AtomLink()
	{
		
	}
	public AtomLink(String type, String href, String relationship) {
		super();
		this.type = type;
		this.href = href;
		this.relationship = relationship;
	}
	@XmlAttribute(name= "type")
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	@XmlAttribute(name= "href")
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	@XmlAttribute(name= "rel")
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

}
