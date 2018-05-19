package com.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement(name="customer")
public class Customer implements Serializable {
	
	private int id;
	private String name;
	private double balance;
	
	private AtomLink self;
	

	
	@XmlElementRef
	public AtomLink getSelf() {
		return self;
	}

	public void setSelf(AtomLink self) {
		this.self = self;
	}
	
	
	
	
	@XmlAttribute(name ="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(name = "balance")
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	

}
