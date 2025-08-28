package com.hcl.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@NamedQuery(name = "getUserDetailsByStatus",query ="from User_Details ud where ud.status = ?1")
@NamedQueries(value = {
		@NamedQuery(name = "getUserDetailsByStatus",query ="from User_Details ud where ud.status = ?1"),
		@NamedQuery(name = "getUserDetailsByCity",query ="from User_Details ud where ud.city = ?1"),
})
@NamedNativeQuery(name = "getUserDetailsByCityStatus",query = "select id,city,name,status from User_Details where city = ?1"
		+ " and status = ?2")
public class User_Details {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String city;
	
	private String status;

/*	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserDetails(int id, String name, String city, String status) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.status = status;
	}

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
 */
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", city=" + city + ", status=" + status + "]";
	}
	
	
	
	
}
