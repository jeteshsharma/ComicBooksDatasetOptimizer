package com.dell.projects.comicBooksDatasetOptimiser.entity;

import javax.persistence.*;

@Entity
public class Power {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String power;

	public Power() {
	}

	public Power(String power) {
		this.power = power;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}
}
