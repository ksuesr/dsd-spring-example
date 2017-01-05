package x595;

import javax.persistence.*;

@Entity
public class Car implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4393706302039786391L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String maker;
	
	private String model;
	
	private int makeYear;
	
	private int maxSpeed;
	
	@Embedded
	private LicenceInfo licenseInfo;
	
	public Car() {}

	public Car(String maker, String model, int makeYear, int maxSpeed, LicenceInfo licenseInfo) {
		super();
		this.maker = maker;
		this.model = model;
		this.makeYear = makeYear;
		this.maxSpeed = maxSpeed;
		this.licenseInfo = licenseInfo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMakeYear() {
		return makeYear;
	}

	public void setMakeYear(int makeYear) {
		this.makeYear = makeYear;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public LicenceInfo getLicenseInfo() {
		return licenseInfo;
	}

	public void setLicenseInfo(LicenceInfo licenseInfo) {
		this.licenseInfo = licenseInfo;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", maker=" + maker + ", model=" + model + ", makeYear=" + makeYear + ", maxSpeed="
				+ maxSpeed + ", licenseInfo=" + licenseInfo + "]";
	}
}
