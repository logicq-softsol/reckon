package com.logicq.reckon.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_ACTIVATION")
public class ActivationDetails implements Serializable {

	@Id
	@Column(name = "ACTIVATION_KEY")
	private String activationKey;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "PRODUCT_VERSION")
	private String productVersion;

	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	
	@Column(name = "ACTIVATE_DATE")
	private Date activateDate;

	@Column(name = "STATUS")
	private boolean productStatus;

	@OneToOne(cascade=CascadeType.ALL)  
    @JoinColumn(name="USER_ID") 
	private UserDetails userDetails;

	
	@OneToOne(cascade=CascadeType.ALL)  
    @JoinColumn(name="COMPANY_ID") 
	private CompanyDetails companyDetails;


	public String getActivationKey() {
		return activationKey;
	}


	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductVersion() {
		return productVersion;
	}


	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}


	public Date getLastUpdate() {
		return lastUpdate;
	}


	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


	public Date getActivateDate() {
		return activateDate;
	}


	public void setActivateDate(Date activateDate) {
		this.activateDate = activateDate;
	}


	public boolean isProductStatus() {
		return productStatus;
	}


	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}


	public UserDetails getUserDetails() {
		return userDetails;
	}


	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}


	public CompanyDetails getCompanyDetails() {
		return companyDetails;
	}


	public void setCompanyDetails(CompanyDetails companyDetails) {
		this.companyDetails = companyDetails;
	}

	
}
