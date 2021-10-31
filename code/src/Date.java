public class Date {
	private int day;
	private int month;
	private int year;
	public Date(String date) {
		String[] splitDate = date.split("[.]"); 
		int day = Integer.parseInt(splitDate[0]);
		int month = Integer.parseInt(splitDate[1]);
		int year = Integer.parseInt(splitDate[2]);
		if (day>0 && day<=31 && month<=12 && month>0) {
			this.day = day;
			this.month = month;
			this.year = year;
		}

	}
	public  int getDay() {
		return day;
	}
	public  int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public void nextDate(int nextDay) {
		if (nextDay<=7 && nextDay>0) {
			this.day+=nextDay;
			if (this.day-30>0) {
				this.day-=30;
				this.month+=1;
			}
			if (this.month-12>0) {
				this.month-=12;
				this.year+=1;
			}
		}
	}
	public String returnNextDate(int nextDay) {
		int day = this.day;
		int month = this.month;
		int year = this.year;
		if (nextDay<=7 && nextDay>0) {
			day+=nextDay;
			if (day-30>0) {
				day-=30;
				month+=1;
			}
			if (month-12>0) {
				month-=12;
				year+=1;
			}
		}
		return day+"."+month+"."+year;
	}
	public String display() {
		return getDay()+"."+getMonth()+"."+getYear();
	}
	
	
}
