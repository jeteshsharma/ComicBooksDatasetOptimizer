package com.dell.projects.comicBooksDatasetOptimiser.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Planet {

	@Id
	@Column(name = "ip_id", unique = true, nullable = false)
	private long id;

	private String planetName;

	public Planet() {
	}

	public Planet(String planetName) {
		this.planetName = planetName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}
}