package com.logicq.reckon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7259072063380073045L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "USER_NAME")
	private String username;

	@Column(name = "F_NAME")
	private String firstname;

	@Column(name = "L_NAME")
	private String lastname;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "CITY")
	private String city;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "POSTAL_CODE")
	private String postalcode;

	@Column(name = "MOBILE_NO")
	private String mobileno;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ACTIVE")
	private boolean isActive;

	@Column(name = "COMP_NAME")
	private String compname;

	@Column(name = "TAG_LINE")
	private String tagline;

	@Column(name = "ABOUTCOMP", columnDefinition = "TEXT")
	private String aboutcomp;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompname() {
		return compname;
	}

	public void setCompname(String compname) {
		this.compname = compname;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getAboutcomp() {
		return aboutcomp;
	}

	public void setAboutcomp(String aboutcomp) {
		this.aboutcomp = aboutcomp;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname="
				+ lastname + ", address=" + address + ", city=" + city + ", country=" + country + ", postalcode="
				+ postalcode + ", mobileno=" + mobileno + ", email=" + email + ", isActive=" + isActive + ", compname="
				+ compname + ", tagline=" + tagline + ", aboutcomp=" + aboutcomp + "]";
	}

}
