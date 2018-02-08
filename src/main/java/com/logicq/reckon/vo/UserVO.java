package com.logicq.reckon.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:userlisence.properties")
public class UserVO {

	@Value("${username}")
	private String username;

	@Value("${firstname}")
	private String firstname;

	@Value("${lastname}")
	private String lastname;

	@Value("${address}")
	private String address;

	@Value("${city}")
	private String city;

	@Value("${country}")
	private String country;

	@Value("${postalcode}")
	private String postalcode;

	@Value("${mobileno}")
	private String mobileno;

	@Value("${email}")
	private String email;

	@Value("${isactive}")
	private boolean isactive;
	
	@Value("${compname}")
	private String compname;
	
	
	@Value("${tagline}")
	private String tagline;
	
	
	@Value("${aboutcomp}")
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


	public boolean isIsactive() {
		return isactive;
	}


	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
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
		return "UserVO [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", address="
				+ address + ", city=" + city + ", country=" + country + ", postalcode=" + postalcode + ", mobileno="
				+ mobileno + ", email=" + email + ", isactive=" + isactive + ", compname=" + compname + ", tagline="
				+ tagline + ", aboutcomp=" + aboutcomp + "]";
	}

	

}
