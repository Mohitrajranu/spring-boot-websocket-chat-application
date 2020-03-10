package com.javainuse.domain;

import java.io.Serializable;

public class SimpleMessage implements Serializable {

	private String name;
	private String description;
	/**
	 * 
	 */
	public SimpleMessage() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
