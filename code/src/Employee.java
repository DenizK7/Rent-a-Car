public class Employee {
	private String name;
	private String surname;
	private String gender;
	private Date birthdate;
	private int office_id;
	private int employee_id;
	private boolean available;
	public Employee(String name, String surname, String gender, Date birthdate, int office_id, int employee_id) {
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.birthdate = birthdate;
		this.office_id = office_id;
		this.employee_id = employee_id;
		this.available = true;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getGender() {
		return gender;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public int getOffice_id() {
		return office_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public void setOffice_id(int office_id) {
		this.office_id = office_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
		
	

		
			
}
	