public class Office {
	private String phone;
	private Address officeAddress;
	private int officeID;
	private Employee[] employees;
	private int employee_count;
	private Car[] cars;	
	private int car_count;
	private Contract[] contracts;
	private  int contract_count;
	private final int EMPLOYEE_NUMBEER=3;
	private final int CAR_NUMBEER=15;
	private final int CONTRACT_NUMBEER=100;
	public Office(String phone, Address officeAddress, int officeID) {
		this.phone = phone;
		this.officeAddress = officeAddress;
		this.officeID = officeID;
		employees = new Employee[EMPLOYEE_NUMBEER];
		employee_count=0;
		cars=new Car[CAR_NUMBEER];
		car_count=0;
		contracts = new Contract[CONTRACT_NUMBEER];
		contract_count=0;
	}
	
	
	public Contract[] getContracts() {
		return contracts;
	}


	public int getContract_count() {
		return contract_count;
	}


	public void setContracts(Contract[] contracts) {
		this.contracts = contracts;
	}


	public void setContract_count(int contract_count) {
		this.contract_count = contract_count;
	}


	public String getPhone() {
		return phone;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public int getOfficeID() {
		return officeID;
	}
	public Employee[] getEmployees() {
		return employees;
	}
	public int getEmployee_count() {
		return employee_count;
	}
	public Car[] getCars() {
		return cars;
	}
	public int getCar_count() {
		return car_count;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public void setOfficeID(int officeID) {
		this.officeID = officeID;
	}
	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}
	public void setEmployee_count(int employee_count) {
		this.employee_count = employee_count;
	}
	public void setCars(Car[] cars) {
		this.cars = cars;
	}
	public void setCar_count(int car_count) {
		this.car_count = car_count;
	}
	
	public void deleteEmployee(int employeeID) {
		for (int i = 0; i <= employee_count; i++) {
			if (employees[i].getEmployee_id()==employeeID) {
				employees[i]=null;
			}
		}
	}
	
	public boolean addEmployee(Employee newEmployee) {
		if(employees[0] != null && employees[1] != null && employees[2] != null) {
			System.out.println("!\t\tError:You cannot add employee");	
			return false;
		}				
		else{
				employees[employee_count]=newEmployee;
				employee_count++;
				return true;
		}				
		}
	public void Employee_threeDay(int OficeID) {
		if(employees[0] == null && employees[1] == null && employees[2] == null) System.out.println("\t"+(OficeID+ 1) + ": No employee delete Office.");										
	
}

	public void addCar(Car newCar) {
		cars[car_count]=newCar;
		car_count++;
	}
	public void addContract(Contract newContract) {
		contracts[contract_count]=newContract;
		contract_count++;
	}

	public int nextDayEmployee() {
		int counter = 0;
		for (int i = 0; i < getEmployee_count(); i++) {
			if(employees[i] != null)
				counter++;
		}
		return counter;
	}
	public int OfficeIdReturner(int employeeId) {
		return employees[employeeId].getOffice_id();
	}
	public void deleteContract(int contractID) {
		for (int i = 0; i < contract_count; i++) {
			if (contracts[i].getContract_id()==contractID) {
					contracts[i]=contracts[contract_count-1];
					contracts[contract_count-1]=null;
					contract_count--;
					break;

			}
		}
	}
}
