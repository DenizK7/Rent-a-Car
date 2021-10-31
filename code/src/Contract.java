public class Contract {
	private int contract_id;
	private int customer_id;
	private int car_id;
	private int employee_id;
	private Date startDate;
	private Date endDate;
	private int officeCarIndex;
	private int officeEmployeeIndex;
	public Contract(int contract_id,int employee_id, int customer_id, int car_id, Date startDate, Date endDate,int officeCarIndex, int officeEmployeeIndex) {
		this.contract_id = contract_id;
		this.customer_id = customer_id;
		this.car_id=car_id;
		this.employee_id=employee_id;
		this.startDate=startDate;
		this.endDate=endDate;
		this.officeCarIndex=officeCarIndex;
		this.officeEmployeeIndex=officeEmployeeIndex;
	}
	

	public int getOfficeEmployeeIndex() {
		return officeEmployeeIndex;
	}


	public void setOfficeEmployeeIndex(int officeEmployeeIndex) {
		this.officeEmployeeIndex = officeEmployeeIndex;
	}


	public int getOfficeCarIndex() {
		return officeCarIndex;
	}


	public void setOfficeCarIndex(int officeCarIndex) {
		this.officeCarIndex = officeCarIndex;
	}


	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getContract_id() {
		return contract_id;
	}
	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	
	
	
}
