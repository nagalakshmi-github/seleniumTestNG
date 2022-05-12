package CRUD;

public class Address {
	/*Address pojo class with simple setters and getters fields*/
	
	private String fname;
	private String lname;
	private String address1;
	private String city;
	private String zipcode;
	
	public Address(String fname, String lname, String address1, String city, String zipcode) {
		this.fname = fname;
		this.lname = lname;
		this.address1 = address1;
		this.city = city;
		this.zipcode = zipcode;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}
