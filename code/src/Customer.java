
public class Customer {
	private String name;
	private String surname;
	private int customer_id;
	private boolean available;
	public Customer(String name, String surname, int customer_id) {
		this.name = name;
		this.surname = surname;
		this.customer_id = customer_id;
		this.available = true;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
	
	
	
}
