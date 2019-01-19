package com.webfluxDemo.domain;

import java.sql.Timestamp;

public class User {

	private Long id;

	private String name;

	private Timestamp datetime;

	private boolean people;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	public boolean isPeople() {
		return people;
	}

	public void setPeople(boolean people) {
		this.people = people;
	}

}
