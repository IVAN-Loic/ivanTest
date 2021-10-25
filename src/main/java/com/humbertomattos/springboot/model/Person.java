package com.humbertomattos.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private boolean actived;

	public Person() {

	}

	public Person(String name, String email, boolean actived) {
		this.name = name;
		this.email = email;
		this.actived = actived;
	}

	public long getId() {
		return id;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the actived
	 */
	public boolean isActived() {
		return actived;
	}

	/**
	 * @param actived the actived to set
	 */
	public void setActived(boolean actived) {
		this.actived = actived;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", actived=" + actived + "]";
	}




}
