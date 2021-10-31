
public class CarRequest {
	private int officeID;
	private int customerID;
	private String brand;
	private String model;
	private String type;
	private Date startDate;
	private Date endDate;
	private int car_request_id;
	/*addCarRequest;office_id;customer_id;brand;model;class;start_date;end_date
addCarRequestRandom;office_id;class
addCarRequestNRandom;min_request_number;max_request_number
*/
	public CarRequest(int officeID, int customerID, String brand, String model, String type, Date startDate,
			Date endDate, int car_request_id) {
		this.officeID = officeID;
		this.customerID = customerID;
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.startDate = startDate;
		this.endDate = endDate;
		this.car_request_id = car_request_id;
	}
	public CarRequest(int officeID, String type,Date startDate,Date endDate,int car_request_id) {
		this.officeID = officeID;
		this.type = type;
		this.customerID=-1;
		this.brand="*";
		this.model="*";
		this.startDate=startDate;
		this.endDate=endDate;
		this.car_request_id = car_request_id;
	}
	public CarRequest(Date startDate,Date endDate,int car_request_id) {
		this.officeID = -1;
		this.type = "*";
		this.customerID=-1;
		this.brand="*";
		this.model="*";
		this.startDate=startDate;
		this.endDate=endDate;
		this.car_request_id = car_request_id;
	}
	public int getOfficeID() {
		return officeID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public String getType() {
		return type;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public int getCar_request_id() {
		return car_request_id;
	}
	public void setOfficeID(int officeID) {
		this.officeID = officeID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setCar_request_id(int car_request_id) {
		this.car_request_id = car_request_id;
	}
	
	

	
	
}
