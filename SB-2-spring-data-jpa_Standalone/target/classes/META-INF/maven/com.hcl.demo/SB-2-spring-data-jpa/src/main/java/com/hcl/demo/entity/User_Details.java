package com.hcl.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USER_DETAILS_TBL")
//@NamedQuery(name = "getUserDetailsByStatus",query ="from User_Details ud where ud.status = ?1")
@NamedQueries(value = {
		@NamedQuery(name = "getUserDetailsByStatus",query ="from User_Details ud where ud.status = ?1"),
		@NamedQuery(name = "getUserDetailsByCity",query ="from User_Details ud where ud.city = ?1"),
})
//@NamedNativeQuery(name = "getUserDetailsByCityStatus",
//query = "select id,city,name,status from USER_DETAILS_TBL where city = ?1 and status = ?2")
public class User_Details {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String city;
	private String status;


	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", city=" + city + ", status=" + status + "]";
	}
	
	
	
	
}
