public class Car {
	private String brand;
	private String model;
	private String type;
	private int kilometer;
	private int office_id;
	private int car_id;
	private boolean available;
	private int dailyKilometer;
	public Car(String brand, String model, String type, int kilometer, int office_id, int car_id) {
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.kilometer = kilometer;
		this.office_id = office_id;
		this.car_id = car_id;
		this.available=true;
	}
	
	public int getDailyKilometer() {
		return dailyKilometer;
	}

	public void setDailyKilometer(int dailyKilometer) {
		this.dailyKilometer = dailyKilometer;
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
	public int getKilometer() {
		return kilometer;
	}
	public int getOffice_id() {
		return office_id;
	}
	public int getCar_id() {
		return car_id;
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
	public void setKilometer(int kilometer) {
		this.kilometer = kilometer;
	}
	public void setOffice_id(int office_id) {
		this.office_id = office_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	

		
}