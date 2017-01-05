package x595;

import java.util.Date;

import javax.persistence.*;

@Embeddable
public class LicenceInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5111410140581791707L;

	private String ownerName;
	
	private String ownerEmail;
	
	@Temporal(value = TemporalType.DATE)
	private java.util.Date registrationDate;
	
	private String licensePlateNumber;
	
	public LicenceInfo() {}

	public LicenceInfo(String ownerName, String ownerEmail, Date registrationDate, String licensePlateNumber) {
		super();
		this.ownerName = ownerName;
		this.ownerEmail = ownerEmail;
		this.registrationDate = registrationDate;
		this.licensePlateNumber = licensePlateNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public java.util.Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(java.util.Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}
	
	@Override
	public String toString() {
		return "LicenceInfo [ownerName=" + ownerName + ", ownerEmail=" + ownerEmail + ", registrationDate="
				+ registrationDate + ", licensePlateNumber=" + licensePlateNumber + "]";
	}
}
