
public class Address {
	private String full_address;
	private String city;
	public Address(String full_address, String city) {
		this.full_address = full_address;
		this.city = city;
	}
	public String getFull_address() {
		return full_address;
	}
	public String getCity() {
		return city;
	}
	public void setFull_address(String full_address) {
		this.full_address = full_address;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String display() {
		return getFull_address()+";"+getCity();
	}

	
}