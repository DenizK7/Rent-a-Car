import java.util.Random;
public class Command {
	private Office[] offices;
	private Customer[] customers;
	private CarRequest[] carRequests;
	private Contract[]contracts;
	private int office_counter;
	private int employee_counter;
	private int car_counter;
	private int customer_counter;
	private int carRequest_counter;
	private int contract_counter=0;
	private final int officeRent=100;
	private final int OFFICE_NUMBER=100;
	private final int CUSTOMER_NUMBER=1500;
	private final int REQUEST_NUMBER=1500;
	private static Date nowDate;
	private static int totalLoss;
	private static int totalProfit;
	private static  int employeeSalary;
	private int[] employee_3day = new int[999];;
	private int[][] three_Day = new int[999][2];
	private int[]three_Day_employee = new int[999];
	Random rand = new Random();
	public Command() {
		offices = new Office[OFFICE_NUMBER];
		customers = new Customer[CUSTOMER_NUMBER];
		carRequests=new CarRequest[REQUEST_NUMBER];
		contracts=new Contract[OFFICE_NUMBER];
		nowDate = new Date("1.1.2021");
	}
	
	public int[][] maintenanceExpenses(int officeID,int[] dailyKilometers, boolean sorted) {
		int[][] maintenanceExpensesAndIncomes = new int[6][offices[officeID].getCar_count()];//0 id, 1 incomes, 2 cleaning/service/amortization/tax/insurance, 3 daily km maintenance, 4 incomes-cleaning-km
		int tempCarID =0;
		int tempIncome =0;
		int tempCleaningExpense =0;
		int tempKilometerExpense =0;
		int temprofit=0;

		for (int i = 0; i < offices[officeID].getContract_count(); i++) {
			maintenanceExpensesAndIncomes[0][offices[officeID].getContracts()[i].getOfficeCarIndex()]=offices[officeID].getContracts()[i].getOfficeCarIndex();//car office id
			maintenanceExpensesAndIncomes[5][offices[officeID].getContracts()[i].getOfficeEmployeeIndex()]=offices[officeID].getContracts()[i].getOfficeEmployeeIndex();
			int dailyKilometer=dailyKilometers[offices[officeID].getCars()[offices[officeID].getContracts()[i].getOfficeCarIndex()].getCar_id()];
			if (offices[officeID].getCars()[offices[officeID].getContracts()[i].getOfficeCarIndex()].getType().equalsIgnoreCase("economy")){
				maintenanceExpensesAndIncomes[1][offices[officeID].getContracts()[i].getOfficeCarIndex()]+=100;//number of rented car
				maintenanceExpensesAndIncomes[2][offices[officeID].getContracts()[i].getOfficeCarIndex()]+=20;
				maintenanceExpensesAndIncomes[3][offices[officeID].getContracts()[i].getOfficeCarIndex()]+=(dailyKilometer*5);
				maintenanceExpensesAndIncomes[4][offices[officeID].getContracts()[i].getOfficeCarIndex()]+=	maintenanceExpensesAndIncomes[1][offices[officeID].getContracts()[i].getOfficeCarIndex()]-maintenanceExpensesAndIncomes[2][offices[officeID].getContracts()[i].getOfficeCarIndex()]-maintenanceExpensesAndIncomes[3][offices[officeID].getContracts()[i].getOfficeCarIndex()];
			} else if (offices[officeID].getCars()[offices[officeID].getContracts()[i].getOfficeCarIndex()].getType().equalsIgnoreCase("sports")) {
				maintenanceExpensesAndIncomes[1][offices[officeID].getContracts()[i].getOfficeCarIndex()]+=200;
				maintenanceExpensesAndIncomes[2][offices[officeID].getContracts()[i].getOfficeCarIndex()]+=70;
				maintenanceExpensesAndIncomes[3][offices[officeID].getContracts()[i].getOfficeCarIndex()]+=(dailyKilometer*10);
				maintenanceExpensesAndIncomes[4][offices[officeID].getContracts()[i].getOfficeCarIndex()]+=	maintenanceExpensesAndIncomes[1][offices[officeID].getContracts()[i].getOfficeCarIndex()]-maintenanceExpensesAndIncomes[2][offices[officeID].getContracts()[i].getOfficeCarIndex()]-maintenanceExpensesAndIncomes[3][offices[officeID].getContracts()[i].getOfficeCarIndex()];
			} else if (offices[officeID].getCars()[offices[officeID].getContracts()[i].getOfficeCarIndex()].getType().equalsIgnoreCase("luxury")) {
				maintenanceExpensesAndIncomes[1][offices[officeID].getContracts()[i].getOfficeCarIndex()]+=300;
				maintenanceExpensesAndIncomes[2][offices[officeID].getContracts()[i].getOfficeCarIndex()]+=120;
				maintenanceExpensesAndIncomes[3][offices[officeID].getContracts()[i].getOfficeCarIndex()]+=(dailyKilometer*15);
				maintenanceExpensesAndIncomes[4][offices[officeID].getContracts()[i].getOfficeCarIndex()]+=	maintenanceExpensesAndIncomes[1][offices[officeID].getContracts()[i].getOfficeCarIndex()]-maintenanceExpensesAndIncomes[2][offices[officeID].getContracts()[i].getOfficeCarIndex()]-maintenanceExpensesAndIncomes[3][offices[officeID].getContracts()[i].getOfficeCarIndex()];
			} 
		}
		if (sorted) {
			for (int i = 0; i < offices[officeID].getCar_count(); i++) {//sort
				for (int j = i+1; j < offices[officeID].getCar_count(); j++) {
					if (maintenanceExpensesAndIncomes[4][j]>maintenanceExpensesAndIncomes[4][i]) {
						tempCarID=maintenanceExpensesAndIncomes[0][i];
						tempIncome=maintenanceExpensesAndIncomes[1][i];
						tempCleaningExpense=maintenanceExpensesAndIncomes[2][i];
						tempKilometerExpense=maintenanceExpensesAndIncomes[3][i];
						temprofit=maintenanceExpensesAndIncomes[4][i];
						maintenanceExpensesAndIncomes[0][i]=maintenanceExpensesAndIncomes[0][j];
						maintenanceExpensesAndIncomes[1][i]=maintenanceExpensesAndIncomes[1][j];
						maintenanceExpensesAndIncomes[2][i]=maintenanceExpensesAndIncomes[2][j];
						maintenanceExpensesAndIncomes[3][i]=maintenanceExpensesAndIncomes[3][j];
						maintenanceExpensesAndIncomes[4][i]=maintenanceExpensesAndIncomes[4][j];
						maintenanceExpensesAndIncomes[0][j]=tempCarID;
						maintenanceExpensesAndIncomes[1][j]=tempIncome;
						maintenanceExpensesAndIncomes[2][j]=tempCleaningExpense;
						maintenanceExpensesAndIncomes[3][j]=tempKilometerExpense;
						maintenanceExpensesAndIncomes[4][j]=temprofit;
					}
				}
			}
			return maintenanceExpensesAndIncomes;
		} else {
			return maintenanceExpensesAndIncomes;
		}

	}
	public int[][] mostRentedEmployee(int officeID) {
		int[][] mostRentedEmployeeID = new int[2][offices[officeID].getEmployee_count()];
		int tempEmployeeID =0;
		int tempNumberOfRentedEmployee =0;

		for (int i = 0; i < offices[officeID].getContract_count(); i++) {
			mostRentedEmployeeID[0][offices[officeID].getContracts()[i].getOfficeEmployeeIndex()]=offices[officeID].getContracts()[i].getOfficeEmployeeIndex();
			mostRentedEmployeeID[1][offices[officeID].getContracts()[i].getOfficeEmployeeIndex()]++;
		}
		for (int i = 0; i < offices[officeID].getEmployee_count(); i++) {//sort
			for (int j = i+1; j < offices[officeID].getEmployee_count(); j++) {
				if (mostRentedEmployeeID[1][j]>mostRentedEmployeeID[1][i]) {
					tempNumberOfRentedEmployee=mostRentedEmployeeID[1][i];
					tempEmployeeID=mostRentedEmployeeID[0][i];
					mostRentedEmployeeID[1][i]=mostRentedEmployeeID[1][j];
					mostRentedEmployeeID[0][i]=mostRentedEmployeeID[0][j];
					mostRentedEmployeeID[1][j]=tempNumberOfRentedEmployee;
					mostRentedEmployeeID[0][j]=tempEmployeeID;
				}
			}
		}
		return mostRentedEmployeeID;
	}
	public int[][] mostRentedCustomer(int officeID) {
		int[][] mostRentedCustomerID = new int[2][customer_counter];
		int tempCustomerID =0;
		int tempNumberOfRentedCustomer =0;

		for (int i = 0; i < offices[officeID].getContract_count(); i++) {
			mostRentedCustomerID[0][offices[officeID].getContracts()[i].getCustomer_id()]=offices[officeID].getContracts()[i].getCustomer_id();
			mostRentedCustomerID[1][offices[officeID].getContracts()[i].getCustomer_id()]++;
		}
		for (int i = 0; i < customer_counter; i++) {//sort
			for (int j = i+1; j < customer_counter; j++) {
				if (mostRentedCustomerID[1][j]>mostRentedCustomerID[1][i]) {
					tempNumberOfRentedCustomer=mostRentedCustomerID[1][i];
					tempCustomerID=mostRentedCustomerID[0][i];
					mostRentedCustomerID[1][i]=mostRentedCustomerID[1][j];
					mostRentedCustomerID[0][i]=mostRentedCustomerID[0][j];
					mostRentedCustomerID[1][j]=tempNumberOfRentedCustomer;
					mostRentedCustomerID[0][j]=tempCustomerID;
				}
			}
		}
		return mostRentedCustomerID;
	}
	public int[][] highestCarProfit(int officeID) {
		int[][] mostRentedCarArray = new int[2][offices[officeID].getCar_count()];
		int tempCarID =0;
		int tempNumberOfRentedCar =0;

		for (int i = 0; i < offices[officeID].getContract_count(); i++) {
			mostRentedCarArray[0][offices[officeID].getContracts()[i].getOfficeCarIndex()]=offices[officeID].getContracts()[i].getOfficeCarIndex();//car office id
			if (offices[officeID].getCars()[offices[officeID].getContracts()[i].getOfficeCarIndex()].getType().equalsIgnoreCase("economy")){
				mostRentedCarArray[1][offices[officeID].getContracts()[i].getOfficeCarIndex()]+=100;//number of rented car
			} else if (offices[officeID].getCars()[offices[officeID].getContracts()[i].getOfficeCarIndex()].getType().equalsIgnoreCase("sports")) {
				mostRentedCarArray[1][offices[officeID].getContracts()[i].getOfficeCarIndex()]+=200;
			} else if (offices[officeID].getCars()[offices[officeID].getContracts()[i].getOfficeCarIndex()].getType().equalsIgnoreCase("luxury")) {
				mostRentedCarArray[1][offices[officeID].getContracts()[i].getOfficeCarIndex()]+=300;
			} 
		}
		for (int i = 0; i < offices[officeID].getCar_count(); i++) {//sort
			for (int j = i+1; j < offices[officeID].getCar_count(); j++) {
				if (mostRentedCarArray[1][j]>mostRentedCarArray[1][i]) {
					tempNumberOfRentedCar=mostRentedCarArray[1][i];
					tempCarID=mostRentedCarArray[0][i];
					mostRentedCarArray[1][i]=mostRentedCarArray[1][j];
					mostRentedCarArray[0][i]=mostRentedCarArray[0][j];
					mostRentedCarArray[1][j]=tempNumberOfRentedCar;
					mostRentedCarArray[0][j]=tempCarID;
				}
			}
		}
		return mostRentedCarArray;
	}
	public int[][] mostRentedCarID(int officeID) {
		int[][] mostRentedCarArray = new int[2][offices[officeID].getCar_count()];
		int tempCarID =0;
		int tempNumberOfRentedCar =0;

		for (int i = 0; i < offices[officeID].getContract_count(); i++) {
			mostRentedCarArray[0][offices[officeID].getContracts()[i].getOfficeCarIndex()]=offices[officeID].getContracts()[i].getOfficeCarIndex();//car office id
			mostRentedCarArray[1][offices[officeID].getContracts()[i].getOfficeCarIndex()]++;//number of rented car
		}
		for (int i = 0; i < offices[officeID].getCar_count(); i++) {//sort
			for (int j = i+1; j < offices[officeID].getCar_count(); j++) {
				if (mostRentedCarArray[1][j]>mostRentedCarArray[1][i]) {
					tempNumberOfRentedCar=mostRentedCarArray[1][i];
					tempCarID=mostRentedCarArray[0][i];
					mostRentedCarArray[1][i]=mostRentedCarArray[1][j];
					mostRentedCarArray[0][i]=mostRentedCarArray[0][j];
					mostRentedCarArray[1][j]=tempNumberOfRentedCar;
					mostRentedCarArray[0][j]=tempCarID;
				}
			}
		}
		return mostRentedCarArray;
	}
	public double averageDayRented(int officeID) {
		int sum=0;
		for (int i = 0; i < offices[officeID].getContract_count(); i++) {
			sum+=offices[officeID].getContracts()[i].getEndDate().getDay()-offices[officeID].getContracts()[i].getStartDate().getDay()+1;
		}
		double avarage = (double) sum/(double) offices[officeID].getContract_count();
		if (offices[officeID].getContract_count()==0) {
			avarage=0;
		}
		return avarage;
	}
	public int[][] highestTypeProfit(int offficeID) {
		int[][] mostRentedCarType = new int[2][3];//0=economy, 1= sports, 2= luxury

		int tempCarID =0;
		int tempNumberOfRentedCarType =0;

		mostRentedCarType[0][0]=0;//economy
		mostRentedCarType[0][1]=1;//sports
		mostRentedCarType[0][2]=2;//luxury
		for (int i = 0; i < offices[offficeID].getContract_count(); i++) {
			if (offices[offficeID].getCars()[offices[offficeID].getContracts()[i].getOfficeCarIndex()].getType().equalsIgnoreCase("economy")){
				mostRentedCarType[1][0]+=100;
			} else if (offices[offficeID].getCars()[offices[offficeID].getContracts()[i].getOfficeCarIndex()].getType().equalsIgnoreCase("sports")) {
				mostRentedCarType[1][1]+=200;
			} else if (offices[offficeID].getCars()[offices[offficeID].getContracts()[i].getOfficeCarIndex()].getType().equalsIgnoreCase("luxury")) {
				mostRentedCarType[1][2]+=300;
			} 
		}
		for (int i = 0; i < 3; i++) {//sort
			for (int j = i+1; j < 3; j++) {
				if (mostRentedCarType[1][j]>mostRentedCarType[1][i]) {
					tempNumberOfRentedCarType=mostRentedCarType[1][i];
					tempCarID=mostRentedCarType[0][i];
					mostRentedCarType[1][i]=mostRentedCarType[1][j];
					mostRentedCarType[0][i]=mostRentedCarType[0][j];
					mostRentedCarType[1][j]=tempNumberOfRentedCarType;
					mostRentedCarType[0][j]=tempCarID;
				}
			}
		}
		return mostRentedCarType;
	}
	public int[][] mostRentedCarType(int offficeID) {
		int[][] mostRentedCarType = new int[2][3];//0=economy, 1= sports, 2= luxury
		int tempCarID =0;
		int tempNumberOfRentedCarType =0;

		mostRentedCarType[0][0]=0;//economy
		mostRentedCarType[0][1]=1;//sports
		mostRentedCarType[0][2]=2;//luxury
		for (int i = 0; i < offices[offficeID].getContract_count(); i++) {
			if (offices[offficeID].getCars()[offices[offficeID].getContracts()[i].getOfficeCarIndex()].getType().equalsIgnoreCase("economy")){
				mostRentedCarType[1][0]++;
			} else if (offices[offficeID].getCars()[offices[offficeID].getContracts()[i].getOfficeCarIndex()].getType().equalsIgnoreCase("sports")) {
				mostRentedCarType[1][1]++;
			} else if (offices[offficeID].getCars()[offices[offficeID].getContracts()[i].getOfficeCarIndex()].getType().equalsIgnoreCase("luxury")) {
				mostRentedCarType[1][2]++;
			} 
		}
		for (int i = 0; i < 3; i++) {//sort
			for (int j = i+1; j < 3; j++) {
				if (mostRentedCarType[1][j]>mostRentedCarType[1][i]) {
					tempNumberOfRentedCarType=mostRentedCarType[1][i];
					tempCarID=mostRentedCarType[0][i];
					mostRentedCarType[1][i]=mostRentedCarType[1][j];
					mostRentedCarType[0][i]=mostRentedCarType[0][j];
					mostRentedCarType[1][j]=tempNumberOfRentedCarType;
					mostRentedCarType[0][j]=tempCarID;
				}
			}
		}
		return mostRentedCarType;
	}
	public void officeStatistics(int[] dailyKilometers) {
		System.out.println("\t--- Office Statistics of the Last 10 Days ----");
		for (int i = 0; i < office_counter; i++) {
			if (offices[i]!=null) {
				System.out.println("\t--- Office"+(offices[i].getOfficeID()+1)+" ---");
				int[][] CarIndexInOffice=mostRentedCarID(i);
				if (CarIndexInOffice[1][0]!=0) {
					System.out.print("\t\tThe most rented car: ");
					for (int j = 0; j < CarIndexInOffice[1].length; j++) {
						if (CarIndexInOffice[1][j]==CarIndexInOffice[1][0]) {
							System.out.print("Car"+(offices[i].getCars()[CarIndexInOffice[0][j]].getCar_id()+1)+";"
									+offices[i].getCars()[CarIndexInOffice[0][j]].getBrand()+";"+offices[i].getCars()[CarIndexInOffice[0][j]].getModel());
						}
						if (j+1<CarIndexInOffice[1].length && CarIndexInOffice[1][j+1]==CarIndexInOffice[1][0]) {
							System.out.print(" - ");
						}
					}
					System.out.println();
				}
				CarIndexInOffice=mostRentedCarType(i);
				if (CarIndexInOffice[1][0]!=0) {
					System.out.print("\t\t"+"The most rented car class: ");
					
					for (int j = 0; j < CarIndexInOffice[1].length; j++) {
						if (CarIndexInOffice[1][j]==CarIndexInOffice[1][0]) {
							if (CarIndexInOffice[0][j]==0) {
								System.out.print("Economy");
							} else if (CarIndexInOffice[0][j]==1) {
								System.out.print("Sports");
							}else if (CarIndexInOffice[0][j]==2) {
								System.out.print("Luxury");
							}
						}
						if (j+1<CarIndexInOffice[1].length && CarIndexInOffice[1][j+1]==CarIndexInOffice[1][0]) {
							System.out.print(" - ");
						}
					}
					System.out.println();
				}
				CarIndexInOffice=highestCarProfit(i);
				if (CarIndexInOffice[1][0]!=0) {
					System.out.print("\t\t"+"The car with the highest profit: ");
					System.out.println("Car"+(offices[i].getCars()[CarIndexInOffice[0][0]].getCar_id()+1)+";"
							+offices[i].getCars()[CarIndexInOffice[0][0]].getBrand()+";"+offices[i].getCars()[CarIndexInOffice[0][0]].getModel());
				}
				CarIndexInOffice=highestCarProfit(i);
				if (CarIndexInOffice[1][0]!=0) {
					System.out.print("\t\t"+"The car class with the highest profit: ");
					if (CarIndexInOffice[0][0]==0) {
						System.out.println("Economy");
					} else if (CarIndexInOffice[0][0]==1) {
						System.out.println("Sports");
					}else if (CarIndexInOffice[0][0]==2) {
						System.out.println("Luxury");
					}
				}
				if (averageDayRented(i)!=0) {
					System.out.println("\t\t"+"The average number of days the cars are rented: "+averageDayRented(i)+" days");
				}
				
				CarIndexInOffice=mostRentedCustomer(i);
				if (CarIndexInOffice[1][0]!=0) {
					System.out.print("\t\tThe customer who rented most: ");
					
					for (int j = 0; j < CarIndexInOffice[1].length; j++) {
						if (offices[i].getContracts()[j]!=null && CarIndexInOffice[1][j]==CarIndexInOffice[1][0]) {
							System.out.print("Customer"+(offices[i].getContracts()[j].getCustomer_id()+1)+";"
									+customers[offices[i].getContracts()[j].getCustomer_id()].getName()+";"+customers[offices[i].getContracts()[j].getCustomer_id()].getSurname());
						}
						if (j+1<CarIndexInOffice[1].length && CarIndexInOffice[1][j+1]==CarIndexInOffice[1][0]) {
							System.out.print(" - ");
						}
					}
					System.out.println();
				}
				CarIndexInOffice=mostRentedEmployee(i);
				if (CarIndexInOffice[1][0]!=0) {
					System.out.print("\t\tThe employee who rented most: ");
					for (int j = 0; j < CarIndexInOffice[1].length; j++) {
						if (CarIndexInOffice[1][j]==CarIndexInOffice[1][0]) {
							System.out.print("Employee"+(offices[i].getEmployees()[CarIndexInOffice[0][j]].getEmployee_id()+1)+";"
									+offices[i].getEmployees()[CarIndexInOffice[0][j]].getName()+";"+offices[i].getEmployees()[CarIndexInOffice[0][j]].getSurname());
						}
						if (j+1<CarIndexInOffice[1].length && CarIndexInOffice[1][j+1]==CarIndexInOffice[1][0]) {
							System.out.print(" - ");
						}
					}
					System.out.println();
				}
				CarIndexInOffice=maintenanceExpenses(i,dailyKilometers, true);
				if (CarIndexInOffice[1][0]!=0) {
					System.out.print("\t\tThe most profitable employee: ");
					System.out.print("Employee"+(offices[i].getEmployees()[CarIndexInOffice[5][0]].getEmployee_id()+1)+";"
							+offices[i].getEmployees()[CarIndexInOffice[5][0]].getName()+";"+offices[i].getEmployees()[CarIndexInOffice[5][0]].getSurname()
							+" ("+CarIndexInOffice[1][0]+" - "+(CarIndexInOffice[2][0]+CarIndexInOffice[3][0])+" = "+(CarIndexInOffice[1][0]-CarIndexInOffice[2][0]-CarIndexInOffice[3][0])+" cp)");
					System.out.println();
					
					System.out.print("\t\tAverage income levels of the employees for the office: ");
					if (offices[i].getContract_count()==1) {
						System.out.print(CarIndexInOffice[4][0]+" cp");
					} else {
						int sum = 0;
						System.out.print("(");
						for (int j = 0; j < CarIndexInOffice[1].length; j++) {
							if (CarIndexInOffice[4][j]!=0 && CarIndexInOffice[4][j]!=-1) {
								System.out.print(CarIndexInOffice[4][j]);
								sum+=CarIndexInOffice[4][j];
							}
							if (j+1<CarIndexInOffice[1].length && CarIndexInOffice[4][j+1]!=0&& CarIndexInOffice[4][j+1]!=-1) {
								System.out.print(" + ");
							}
						}
						System.out.print(")/"+offices[i].getEmployee_count()+" = "+sum/offices[i].getEmployee_count());
					}
					System.out.println();
				}
			}
		}
	
	}
	public boolean isDateLate3Day(Date startDate, Date endDate) {
        boolean flag = false;
        if (endDate.getDay()-startDate.getDay()<4) {
            flag=true;
        }else {
            flag=false;
        }
        return flag;
    }
	public boolean isDateEqualNowDate(Date startDate) {
        boolean flag = false;
        if (startDate.getYear()==nowDate.getYear() && startDate.getDay()==nowDate.getDay() && startDate.getMonth()==nowDate.getMonth()) {
            flag=true;
        }else {
            flag=false;
        }
        return flag;
    }
	public boolean isDateLateAndEqual(Date startDate, Date endDate) {
        boolean flag = false;
        if (startDate.getYear()<endDate.getYear()) {
            flag=true;
        } else if (startDate.getMonth()<endDate.getMonth()) {
            flag=true;
        } else if (startDate.getDay()<=endDate.getDay()) {
            flag=true;
        }else {
            flag=false;
        }
        return flag;
    }
	public boolean isDateLate(Date startDate, Date endDate) {
        boolean flag = false;
        if (startDate.getYear()<endDate.getYear()) {
            flag=true;
        } else if (startDate.getMonth()<endDate.getMonth()) {
            flag=true;
        } else if (startDate.getDay()<endDate.getDay()) {
            flag=true;
        }else {
            flag=false;
        }
        return flag;
    }
	public void carClasses(int officeID,String textMessage1,String textMessage2, String textMessage3, int empOrCar, int[] dailyKilometers) {
		boolean plus_detecter = true;
		int total_km ;
		for (int i = 0; i <= contract_counter; i++) {
			boolean maintenance_bool = false;
			
			if(contracts[i]!= null&& isDateLate(nowDate,contracts[i].getEndDate())) {		
				
					int carID = contracts[i].getCar_id();
					three_Day_employee[contracts[i].getEmployee_id()]=1;//for three day	not contract			
					String type ="";
					int carID2 =0;
					for (int j = 0; j < offices[officeID].getCar_count(); j++) {
						if(offices[officeID].getCars()[j].getCar_id() == carID) {
							type =  offices[officeID].getCars()[j].getType();
							 carID2 = j;
							break;
						}						
					}				
					if(offices[officeID].getCars()[carID2]!= null) {
						if(type.equals("economy")) {
							if(empOrCar ==1)
							totalLoss+=5;
							else if(empOrCar ==2) {
								System.out.print("\n\t\tCar "+ (int)(carID+1)+ " : ");
								totalProfit+= 100;
								
							}
								
							else  {
								System.out.print("\n\t\tCar "+(int)(carID+1)+ " maintenance : ");
								totalLoss+= (20 + (dailyKilometers[carID]*5));
								maintenance_bool = true;
							}
								if(plus_detecter && empOrCar==1) {
									System.out.print(totalLoss);
									plus_detecter = false;
								}
								else	
									if(maintenance_bool) {
										System.out.print(textMessage1 +" + "+(dailyKilometers[carID]*5)+" = "+ (20 + (dailyKilometers[carID]*5)) +" ("+  (dailyKilometers[carID]*100) + " km)");//+ maintenance
										total_km = offices[officeID].getCars()[carID2].getKilometer() + (dailyKilometers[carID]*100);
										offices[officeID].getCars()[carID2].setKilometer(total_km);
									}
									
									else System.out.print(textMessage1);
						}
						else if(type.equals("sports")) {
							if(empOrCar ==1)
								totalLoss+=10;
							else if(empOrCar ==2) {
								System.out.print("\n\t\tCar "+ (int)(carID+1)+ " : ");
								totalProfit+= 200;
							}
								
							else if(empOrCar ==3) {
								System.out.print("\n\t\tCar "+ (int)(carID+1)+ " maintenance : ");
								totalLoss+= (70 +(dailyKilometers[carID]*10));
								maintenance_bool = true;
							}
							if(plus_detecter && empOrCar==1) {
								System.out.print(totalLoss);
								plus_detecter = false;
							}
							else
								if(maintenance_bool) {
									System.out.print(textMessage2 +" + "+(dailyKilometers[carID]*10)+" = "+ (70 + (dailyKilometers[carID]*10)) +" ("+  (dailyKilometers[carID]*100) + " km)");
									total_km = offices[officeID].getCars()[carID2].getKilometer() + (dailyKilometers[carID]*100);
									offices[officeID].getCars()[carID2].setKilometer(total_km);
								}
							
								else System.out.print(textMessage2);
						}
						else if(type.equals("luxury")) {
							
							if(empOrCar ==1)
								totalLoss+=20;
							else if(empOrCar ==2) {
								System.out.print("\n\t\tCar "+ (int)(carID+1)+ " : ");
								totalProfit+= 300;
							}
								
							else if(empOrCar ==3) {
								System.out.print("\n\t\tCar "+ (int)(carID+1)+ " maintenance: ");
								totalLoss+=( 120 + (dailyKilometers[carID]*15));
								maintenance_bool = true;
							}
							if(plus_detecter && empOrCar==1) {
								System.out.print(totalLoss);
								plus_detecter = false;
							}
							else
								if(maintenance_bool) {
									System.out.print(textMessage3 +" + "+(dailyKilometers[carID]*15)+" = "+ (120 + (dailyKilometers[carID]*15)) +" ("+  (dailyKilometers[carID]*100) + " km)");				
									total_km = offices[officeID].getCars()[carID2].getKilometer() + (dailyKilometers[carID]*100);
									offices[officeID].getCars()[carID2].setKilometer(total_km);	
 								}
								else System.out.print(textMessage3);
								
						}
						else {
							continue;
						}
					}
				
					
			}
			
		}

	}
		
	//}
	public void Income(int officeID,int empOrCar, int[] dailyKilometers) {
		for (int i = 0; i <= contract_counter; i++) {
			if(contracts[i]!=null &&isDateLate(nowDate,contracts[i].getEndDate())) {
				try {
					int carID = contracts[i].getCar_id();
					String type ="";
					int carID2 =0;
					for (int j = 0; j < offices[officeID].getCar_count(); j++) {
						if(offices[officeID].getCars()[j].getCar_id() == carID) {
							type =  offices[officeID].getCars()[j].getType();
							 carID2 = j;
							break;
						}						
					}				
					if(offices[officeID].getCars()[carID2]!= null) {
						int random_km = dailyKilometers[carID];
						if(type.equals("economy")) {
							if(empOrCar ==1)totalLoss+=5;
							else if(empOrCar ==2)totalProfit+= 100;				
							else totalLoss+= (20 + (random_km*5));
						}
						else if(type.equals("sports")) {
							if(empOrCar ==1)totalLoss+=10;
							else if(empOrCar ==2)totalProfit+= 200;
							else if(empOrCar ==3)totalLoss+= (70 + (random_km*10));
						}
						else if(type.equals("luxury")) {						
							if(empOrCar ==1)totalLoss+=20;
							else if(empOrCar ==2)totalProfit+= 300;				
							else if(empOrCar ==3) totalLoss+= (120 + (random_km*15));					
						}
						else continue;
					}
					
				
					} catch (Exception e) {
						
					}
			}
			
			}

		}
	public void nextDay(int[] dailyKilometers) {
		System.out.println("\t"+"--- Office Profits ----");
		for (int i = 0; i < office_counter; i++) {
			if(offices[i] != null) {
				totalLoss = 0;
				totalProfit = 0;
				Income(offices[i].getOfficeID(),2,dailyKilometers);
				System.out.print("\t"+"Office " + (i+1) + " incomes :" + totalProfit + " cp");
				totalProfit = 0;
				 carClasses(offices[i].getOfficeID(), "100 ", "200", "300", 2,dailyKilometers);
				 Income(offices[i].getOfficeID(),1,dailyKilometers);
				 Income(offices[i].getOfficeID(),3,dailyKilometers);
				 employeeSalary = (offices[i].nextDayEmployee() * 30);
				System.out.println("\n\tOffice " + (i+1) + " expenses :" + (employeeSalary + officeRent + totalLoss + " cp"));//+araba km masrafları
				totalLoss = 0;
				System.out.println("\t"+"\t"+"Office Rent : " + officeRent);
				System.out.println("\t"+"\t"+"Employee Salaries : " + employeeSalary );
				System.out.print("\t"+"\t"+"Employee performance bonuses : ");
				 carClasses(offices[i].getOfficeID(), " + 5", " + 10", " + 20", 1,dailyKilometers);
				 System.out.print(" = " + totalLoss);
				 carClasses(offices[i].getOfficeID(), " 20", "70", "100", 3,dailyKilometers);
				 System.out.println("\n\tOffice " + (i+1) + " profit : " + (totalProfit - (totalLoss + officeRent + employeeSalary )) + " cp");
				System.out.println();
			}
		}
		
	}
	public int randomCar(int officeID, String brand, String model, String type) {
		int carID =-1;
		if (officeID!=-2) {
			for (int i = 0; i < offices[officeID].getCar_count(); i++) {
				if ((offices[officeID].getCars()[i].getBrand().equalsIgnoreCase(brand) || brand.equalsIgnoreCase("*"))//brand
						&& (offices[officeID].getCars()[i].getModel().equalsIgnoreCase(model) || model.equalsIgnoreCase("*")//model
							&& (offices[officeID].getCars()[i].getType().equalsIgnoreCase(type) || type.equalsIgnoreCase("*"))&& offices[officeID].getCars()[i].isAvailable())) {//type
					
					carID=offices[officeID].getCars()[i].getCar_id();
					offices[officeID].getCars()[i].setAvailable(false);
					break;
				}
			}
		}
		
		return carID;
	}
	public int randomEmployee(int officeID) {
		int employeeID=-1;
		if (officeID!=-2) {
			for (int i = 0; i < offices[officeID].getEmployee_count(); i++) {
				if (offices[officeID].getEmployees()[i].isAvailable()) {
					employeeID=offices[officeID].getEmployees()[i].getEmployee_id();
					offices[officeID].getEmployees()[i].setAvailable(false);
					break;
				}
			}
		}
		return employeeID;
	}
	public int randomOffice(int officeID) {
		if (officeID==-2) {
			for (int i = 0; i < office_counter; i++) {
				for (int j = 0; j < offices[i].getEmployee_count(); j++) {
					if (offices[i].getEmployees()[j].isAvailable()) {
						officeID=i;
						break;
					}
				}
				if (officeID==i) {
					break;
				}
			}
		}
		return officeID;
	}

	public void deleteOffice(int officeID) {
		if (officeID<=office_counter) {
			offices[officeID] = null;
		}
		else {
			System.out.println("!\tError: "+officeID+". Office does not exist");
		}
	}
	public void deleteEmployee(int officeID,int employeeID) {
		boolean flag = false;
		for (int i = 0; i <= offices[i].getEmployee_count(); i++) {
			if (offices[officeID].getEmployees()[i]!=null && offices[officeID].getEmployees()[i].getEmployee_id()==employeeID) {
				offices[officeID].getEmployees()[i]=null;
				flag=true;
				break;
			}
		}
		if (!flag) {
			System.out.println("!\tError: "+(employeeID+1)+". Employee is not working in "+(officeID+1)+".Office");
		}
	}
	public void listCarRequest() {		
		for (int i = 0; i < carRequest_counter; i++) {
			System.out.println("\t"+(carRequests[i].getCar_request_id()+1)+".CarRequest;"+(carRequests[i].getOfficeID()+1)+";"+(carRequests[i].getCustomerID()+1)+";"
		+carRequests[i].getBrand()+";"+carRequests[i].getModel()+";"+carRequests[i].getType()+";"+carRequests[i].getStartDate().display()+carRequests[i].getEndDate().display());
		}
		if (carRequest_counter==0) {
			System.out.println("!\tError: No Car Request to list");
		}
	}
	public void listOffice() {
		boolean flag = false;
		for (int i = 0; i < office_counter; i++) {
			if(offices[i]!=null) {
				flag = true;
				break;
			}
		}for (int i = 0; i < office_counter; i++) {
			if (offices[i]!=null && flag) {
				System.out.println("\t"+(offices[i].getOfficeID()+1)+".Office;"+offices[i].getPhone()+";"+offices[i].getOfficeAddress().display());		
			}	
		}if(flag==false) {
			System.out.println("!\tError: No Office to list");
		}
	}
	public void listContract(){
		for (int i = 0; i < contract_counter; i++) {
			if (contracts[i]!=null) {
				System.out.println("\t"+(contracts[i].getContract_id()+1)+".Contract:Employee"+(contracts[i].getEmployee_id()+1)+";Customer"+(contracts[i].getCustomer_id()+1)+";Car"+(contracts[i].getCar_id()+1)+";"+contracts[i].getStartDate().display()+";"+contracts[i].getEndDate().display());		
		
			}
		}if( contract_counter==0)
			System.out.println("!\tError: No contract to list.");		
	}
		
	public void listEmployee(int officeID) {
		boolean flag = false;
		for (int i = 0; i < offices[officeID].getEmployee_count(); i++) {
			if(offices[officeID].getEmployees()[i]!=null) {
				flag = true;
				break;
			}
		}
		for (int i = 0; i < offices[officeID].getEmployee_count(); i++) {
			if (offices[officeID].getEmployees()[i]!=null&& flag ) {				
				System.out.println("\t"+(offices[officeID].getEmployees()[i].getEmployee_id()+1)+".Employee;"+offices[officeID].getEmployees()[i].getName()+";"
					+offices[officeID].getEmployees()[i].getSurname()+";"+offices[officeID].getEmployees()[i].getGender()+";"
						+offices[officeID].getEmployees()[i].getBirthdate().display()+";"+(officeID+1));
				
			}	
		}
			if(flag==false)
				System.out.println("!\tError: No employee to list in " + (officeID +1) +".Office");
		
	}
	public void listCar(int officeID) {
		boolean flag = false;
		for (int i = 0; i < offices[officeID].getCar_count(); i++) {
			if(offices[officeID].getCars()[i]!=null) {
				flag = true;
				break;
			}
		}
		for (int i = 0; i < offices[officeID].getCar_count(); i++) {
			if(offices[officeID].getCars()[i] != null && flag) {
				System.out.println("\t"+(offices[officeID].getCars()[i].getCar_id()+1)+".Car;"+offices[officeID].getCars()[i].getBrand()+";"+offices[officeID].getCars()[i].getModel()+";"
					+offices[officeID].getCars()[i].getType()+";"+offices[officeID].getCars()[i].getKilometer()+";"+(officeID+1));
			}
		}		
		if(flag==false) {
			System.out.println("!\tError: No cars to list.");
		}
	}
	public void listCustomer() {	
		for (int i = 0; i < customer_counter; i++) {
			if(customers[i].getName()!= null) {
				System.out.println("\t"+(customers[i].getCustomer_id()+1)+".Customer;"+customers[i].getName()+";"+customers[i].getSurname());
			}
		}
		if(customer_counter == 0) {
			System.out.println("!\tError: No customer to list.");
		}
	}
	public void runCommand(String commandsString, String mark) {
		
		String[] commands = commandsString.split(";"); 
		for (int i = 0; i < commands.length; i++) {
			commands[i]=commands[i].trim();
		}
		if(commands[0].equalsIgnoreCase("addOffice")) {			
			
			try {
				Address officeAddress = new Address(commands[2], commands[3]);
				offices[office_counter]=new Office(commands[1], officeAddress,office_counter);
				office_counter++;
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("!\tError: Could not be added. Because you did not enter the complete data.");
			}catch (NumberFormatException e) {
				System.out.println("!\tError: Could not be added. Because you entered the numbers incorrectly."+e.getLocalizedMessage());
			}catch (Exception e) {
				System.out.println("!\tWrong Input"+e.getLocalizedMessage());
			}
		}
		else if(commands[0].equalsIgnoreCase("listOffice")) {
			try {
				listOffice();
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("!\tError: Could not be added. Because you did not enter the complete data.");
			}catch (NumberFormatException e) {
				System.out.println("!\tError: Could not be added. Because you entered the numbers incorrectly."+e.getLocalizedMessage());
			}catch (Exception e) {
				System.out.println("!\tWrong Input"+e.getLocalizedMessage());
			}
			
		}							
		else if(commands[0].equalsIgnoreCase("addEmployee")) {			
			try {
				Date birthDate = new Date(commands[4]);
				int officeID = Integer.parseInt(commands[5])-1;
				Employee newEmployee = new Employee(commands[1], commands[2], commands[3], birthDate, officeID, employee_counter);
				if(offices[officeID].addEmployee(newEmployee))
				employee_counter++;
				else
					employee_3day[officeID] =1;
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("!\tError: Could not be added. Because you did not enter the complete data.");
			}catch (NumberFormatException e) {
				System.out.println("!\tError: Could not be added. Because you entered the numbers incorrectly."+e.getLocalizedMessage());
			}catch (Exception e) {
				System.out.println("!\tWrong Input"+e.getLocalizedMessage());
			}
			
		}
		else if(commands[0].equalsIgnoreCase("listEmployee")){
			try {
				int officeID = Integer.parseInt(commands[1])-1;
				listEmployee(officeID);
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("!\tError: Could not be added. Because you did not enter the complete data.");
			}catch (NumberFormatException e) {
				System.out.println("!\tError: Could not be added. Because you entered the numbers incorrectly."+e.getLocalizedMessage());
			}catch (Exception e) {
				System.out.println("!\tWrong Input"+e.getLocalizedMessage());
			}
			
		}
		else if(commands[0].equalsIgnoreCase("addCar")) {
			try {
				if(commands[3].equals("luxury") || commands[3].equals("economy") || commands[3].equals("sports")) {
					int kilometer=Integer.parseInt(commands[4]);
					int office_id=Integer.parseInt(commands[5])-1;
					Car newCar = new Car(commands[1], commands[2], commands[3], kilometer, office_id, car_counter);
					offices[office_id].addCar(newCar);
					car_counter++;
				}
				else
					System.out.println("!\tError: " +commands[3] + " class of does not exist.");
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("!\tError: Could not be added. Because you did not enter the complete data.");
			}catch (NumberFormatException e) {
				System.out.println("!\tError: Could not be added. Because you entered the numbers incorrectly."+e.getLocalizedMessage());
			}catch (Exception e) {
				System.out.println("!\tWrong Input"+e.getLocalizedMessage());
			}
			
			
		}
		else if(commands[0].equalsIgnoreCase("listCar")){
			try {
				int officeID = Integer.parseInt(commands[1])-1;
				listCar(officeID);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("!\tError: Could not be added. Because you did not enter the complete data.");
			}catch (NumberFormatException e) {
				System.out.println("!\tError: Could not be added. Because you entered the numbers incorrectly."+e.getLocalizedMessage());
			}catch (Exception e) {
				System.out.println("!\tWrong Input"+e.getLocalizedMessage());
			}
			
		}
		else if(commands[0].equalsIgnoreCase("addCustomer")) {
			try {
				Customer newCustomer = new Customer(commands[1], commands[2], customer_counter);
				customers[customer_counter]=newCustomer;
				customer_counter++;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("!\tError: Could not be added. Because you did not enter the complete data.");
			}catch (NumberFormatException e) {
				System.out.println("!\tError: Could not be added. Because you entered the numbers incorrectly."+e.getLocalizedMessage());
			}catch (Exception e) {
				System.out.println("!\tWrong Input"+e.getLocalizedMessage());
			}
			
		}
		else if(commands[0].equalsIgnoreCase("listCustomer")){
			try {
				listCustomer();
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("!\tError: Could not be added. Because you did not enter the complete data.");
			}catch (NumberFormatException e) {
				System.out.println("!\tError: Could not be added. Because you entered the numbers incorrectly."+e.getLocalizedMessage());
			}catch (Exception e) {
				System.out.println("!\tWrong Input"+e.getLocalizedMessage());
			}
		
		}
		else if (commands[0].equalsIgnoreCase("deleteOffice")) {
			try {
				int officeID = Integer.parseInt(commands[1])-1;
				deleteOffice(officeID);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("!\tError: Could not be added. Because you did not enter the complete data.");
			}catch (NumberFormatException e) {
				System.out.println("!\tError: Could not be added. Because you entered the numbers incorrectly."+e.getLocalizedMessage());
			}catch (Exception e) {
				System.out.println("!\tWrong Input"+e.getLocalizedMessage());
			}
		
		}
		else if (commands[0].equalsIgnoreCase("deleteEmployee")) {
			try {
				int officeID = Integer.parseInt(commands[1])-1;
				int employeeID = Integer.parseInt(commands[2])-1;
				deleteEmployee(officeID, employeeID);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("!\tError: Could not be added. Because you did not enter the complete data.");
			}catch (NumberFormatException e) {
				System.out.println("!\tError: Could not be added. Because you entered the numbers incorrectly."+e.getLocalizedMessage());
			}catch (Exception e) {
				System.out.println("!\tWrong Input"+e.getLocalizedMessage());
			}
			
		}else if (commands[0].equalsIgnoreCase("addCarRequest")) {
			try {
				int officeID = Integer.parseInt(commands[1])-1;
				int customerID = -1;
				if (!commands[2].equals("*")) {
					customerID = Integer.parseInt(commands[2])-1;
				}
				
				Date startDate = new Date(commands[6]);
				Date endDate = new Date(commands[7]);
				boolean dateFlag = true;
				if (!isDateLate3Day(startDate, endDate) || !isDateLateAndEqual(startDate, endDate) ||  !isDateEqualNowDate(startDate) ||startDate.getDay()==0 || startDate.getMonth()==0 || startDate.getYear()==0 || endDate.getDay()==0 || endDate.getMonth()==0 || endDate.getYear()==0) {
					dateFlag=false;
					System.out.println("!\tError:"+"You entered an invalid date.");
				}
				if (dateFlag) {
					CarRequest newCarRequest = new CarRequest(officeID, customerID, commands[3], commands[4], commands[5], startDate, endDate, carRequest_counter);
					carRequests[carRequest_counter]=newCarRequest;
					carRequest_counter++;
					
					officeID = randomOffice(officeID);
					int employeeID = randomEmployee(officeID);
					int carID = randomCar(officeID, commands[3], commands[4], commands[5]);
					
					if (officeID==-2) {
						System.out.println("!\tError: No office for the contract");
					}
					if (employeeID==-1) {
						System.out.println("!\tError: No employee for the contract");
						three_Day[officeID][1]++;//for three day counting
					}
					if (carID==-1) {
						System.out.println("!\tError: Car not available");
						three_Day[officeID][0]++;//for three day counting
					}
					if (employeeID!=-1 && carID!=-1 && officeID!=-2) {	
						int officeCarIndex=-1;
						
						for (int i = 0; i < offices[officeID].getCar_count(); i++) {
							if (offices[officeID].getCars()[i].getCar_id() == carID) {
								officeCarIndex=i;
								break;
							}
						}
						int officeEmployeeIndex=-1;
						for (int i = 0; i < offices[officeID].getEmployee_count(); i++) {
							if (offices[officeID].getEmployees()[i].getEmployee_id() == employeeID) {
								officeEmployeeIndex=i;
								break;
							}
						}
						Contract newContract = new Contract(contract_counter, employeeID, customerID, carID, startDate, endDate,officeCarIndex,officeEmployeeIndex);
						offices[officeID].addContract(newContract);
						contracts[contract_counter] = newContract;
						System.out.println("\t"+(contracts[contract_counter].getContract_id()+1)+".Contract:Employee"+(contracts[contract_counter].getEmployee_id()+1)+";Customer"+(contracts[contract_counter].getCustomer_id()+1)+";Car"+(contracts[contract_counter].getCar_id()+1)+";"+contracts[contract_counter].getStartDate().display()+";"+contracts[contract_counter].getEndDate().display());
						contract_counter++;
	 				}
				}
				
				
				
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("!\tError: Could not be added. Because you did not enter the complete data.");
			}catch (NumberFormatException e) {
				System.out.println("!\tError: Could not be added. Because you entered the numbers incorrectly."+e.getLocalizedMessage());
			}catch (Exception e) {
				System.out.println("!\tWrong Input"+e.getLocalizedMessage());
			}
			
		}
		else if (commands[0].equalsIgnoreCase("addCarRequestRandom")) {
			try {
				int officeID = Integer.parseInt(commands[1])-1;
				int nextDay = rand.nextInt(4)+1;
				Date startDate = nowDate;
				Date endDate = new Date(startDate.returnNextDate(nextDay));
				boolean dateFlag = true;
				if (!isDateLate3Day(startDate, endDate) || !isDateLateAndEqual(startDate, endDate) ||  !isDateEqualNowDate(startDate) || startDate.getDay()==0 || startDate.getMonth()==0 || startDate.getYear()==0 || endDate.getDay()==0 || endDate.getMonth()==0 || endDate.getYear()==0) {
					dateFlag=false;
					System.out.println("!\tError:"+"You entered an invalid date.");
				}
				if (dateFlag) {
					int customerID=-2;
					String brand = "*";
					String model = "*";
					CarRequest newCarRequest = new CarRequest(officeID, customerID, "*", "*", commands[2], startDate, endDate, carRequest_counter);
					carRequests[carRequest_counter]=newCarRequest;
					carRequest_counter++;
					
					officeID = randomOffice(officeID);
					int employeeID = randomEmployee(officeID);
					int carID = randomCar(officeID, brand, model, commands[2]);
					
					if (officeID==-2) {
						System.out.println("!\tError: No office for the contract");
					}
					if (employeeID==-1) {
						System.out.println("!\tError: No employee for the contract");
					}
					if (carID==-1) {
						System.out.println("!\tError: Car not available");
					}
					if (employeeID!=-1 && carID!=-1 && officeID!=-2) {
						int officeCarIndex=-1;
						for (int i = 0; i < offices[officeID].getCar_count(); i++) {
							if (offices[officeID].getCars()[i].getCar_id() == carID) {
								officeCarIndex=i;
								break;
							}
						}
						int officeEmployeeIndex=-1;
						for (int i = 0; i < offices[officeID].getEmployee_count(); i++) {
							if (offices[officeID].getEmployees()[i].getEmployee_id() == employeeID) {
								officeEmployeeIndex=i;
								break;
							}
						}
						Contract newContract = new Contract(contract_counter, employeeID, customerID, carID, startDate, endDate,officeCarIndex,officeEmployeeIndex);
						offices[officeID].addContract(newContract);	
						contracts[contract_counter] = newContract;
						System.out.println("\t"+(contracts[contract_counter].getContract_id()+1)+".Contract:Employee"+(contracts[contract_counter].getEmployee_id()+1)+";Customer"+(contracts[contract_counter].getCustomer_id()+1)+";Car"+(contracts[contract_counter].getCar_id()+1)+";"+contracts[contract_counter].getStartDate().display()+";"+contracts[contract_counter].getEndDate().display());
						contract_counter++;
						}
				}
				
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("!\tError: Could not be added. Because you did not enter the complete data.");
			}catch (NumberFormatException e) {
				System.out.println("!\tError: Could not be added. Because you entered the numbers incorrectly."+e.getLocalizedMessage());
			}catch (Exception e) {
				System.out.println("!\tWrong Input"+e.getLocalizedMessage());
			}
			
		}	else if (commands[0].equalsIgnoreCase("addCarRequestNRandom")) {
			try {
				int min_request_number = Integer.parseInt(commands[1]);
				int max_request_number = Integer.parseInt(commands[2]);
				boolean flag = true;
				boolean employeeFlag = false;
				for (int i = 0; i < office_counter; i++) {
					for (int j = 0; j < offices[i].getEmployee_count(); j++) {
						if (offices[i].getEmployees()[j].isAvailable()) {
							employeeFlag=true;
							break;
						}
					}
					if (employeeFlag) {
						break;
					}
				}
				int customerID = rand.nextInt(customer_counter);
				int randomRequest = rand.nextInt(max_request_number-min_request_number)+1;
				if (randomRequest>employee_counter && max_request_number<=7 && min_request_number>=1) {
					System.out.println("!\tError:"+"The randomly generated number is "+randomRequest+". However, since there were "+employee_counter+" employees, the randomly generated number was chosen as "+employee_counter+".");
					randomRequest=employee_counter;
					flag=false;
				}
				if (min_request_number>employee_counter) {
					System.out.println("!\tError:"+"The minimum entered number is higher than the current number of employees");
				}else if (max_request_number>7) {
					System.out.println("!\tError:"+"the maximum number cannot be greater than seven");
				}
				else if (min_request_number<1) {
					System.out.println("!\tError:"+"The minimum number cannot be less than one");
				}else if (employeeFlag==false) {
					System.out.println("!\tError:"+"There are no available employees.");
				}else {
					if (flag) {
						System.out.println("Randomly generated number is "+randomRequest);
					}
					for (int i = 0; i < randomRequest; i++) {
						int nextDay = rand.nextInt(4)+1;
						Date startDate = nowDate;
						Date endDate = new Date(startDate.returnNextDate(nextDay));
						int officeID = randomOffice(-2);
						String brand = "*";
						String model = "*";
						String type = "*";
						CarRequest newCarRequest = new CarRequest(officeID, customerID, brand, model, type, startDate, endDate, carRequest_counter);
						carRequests[carRequest_counter]=newCarRequest;
						carRequest_counter++;
						
						int employeeID = randomEmployee(officeID);
						int carID = randomCar(officeID, brand, model, type);
						
						if (officeID==-2) {
							System.out.println("!\tError: No office for the contract");
						}
						if (employeeID==-1) {
							System.out.println("!\tError: No employee for the contract");
						}
						if (carID==-1) {
							System.out.println("!\tError: Car not available");
						}
						if (employeeID!=-1 && carID!=-1 && officeID!=-2) {
							int officeCarIndex=-1;
							for (int j = 0; j < offices[officeID].getCar_count(); j++) {
								if (offices[officeID].getCars()[j].getCar_id() == carID) {
									officeCarIndex=j;
									break;
								}
							}
							int officeEmployeeIndex=-1;
							for (int j = 0; j < offices[officeID].getEmployee_count();j++) {
								if (offices[officeID].getEmployees()[j].getEmployee_id() == employeeID) {
									officeEmployeeIndex=j;
									break;
								}
							}
							Contract newContract = new Contract(contract_counter, employeeID, customerID, carID, startDate, endDate,officeCarIndex,officeEmployeeIndex);
							contracts[contract_counter] = newContract;
							offices[officeID].addContract(newContract);
							System.out.println("\t"+(contracts[contract_counter].getContract_id()+1)+".Contract:Employee"+(contracts[contract_counter].getEmployee_id()+1)+";Customer"+(contracts[contract_counter].getCustomer_id()+1)+";Car"+(contracts[contract_counter].getCar_id()+1)+";"+contracts[contract_counter].getStartDate().display()+";"+contracts[contract_counter].getEndDate().display());
							contract_counter++;
		 				}
					}
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("!\tError: Could not be added. Because you did not enter the complete data.");
			}catch (NumberFormatException e) {
				System.out.println("!\tError: Could not be added. Because you entered the numbers incorrectly."+e.getLocalizedMessage());
			}catch (Exception e) {
				System.out.println("!\tWrong Input"+e.getLocalizedMessage());
			}
			
			
		}else if (commands[0].equalsIgnoreCase("listCarRequest")) {
			try {
				listCarRequest();
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("!\tError: Could not be added. Because you did not enter the complete data.");
			}catch (NumberFormatException e) {
				System.out.println("!\tError: Could not be added. Because you entered the numbers incorrectly."+e.getLocalizedMessage());
			}catch (Exception e) {
				System.out.println("!\tWrong Input"+e.getLocalizedMessage());
			}
			
		}
		else if(commands[0].equalsIgnoreCase("listContract")) {
			try {
				listContract();
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("!\tError: Could not be added. Because you did not enter the complete data.");
			}catch (NumberFormatException e) {
				System.out.println("!\tError: Could not be added. Because you entered the numbers incorrectly."+e.getLocalizedMessage());
			}catch (Exception e) {
				System.out.println("!\tWrong Input"+e.getLocalizedMessage());
			}
			
		}else if (commands[0].equalsIgnoreCase("nextday")) {
			try {
				int[] dailyKilometers = new int[car_counter];
				Random rand = new Random();
				for (int i = 0; i < dailyKilometers.length; i++) {
					dailyKilometers[i]=rand.nextInt(3)+1;
				}
				
				nextDay(dailyKilometers);
				
				officeStatistics(dailyKilometers);
				nowDate.nextDate(1);
				
				for (int i = 0; i < office_counter; i++) {
					for (int j = 0; j < offices[i].getContract_count(); j++) {
						if ( nowDate.getDay()-offices[i].getContracts()[j].getEndDate().getDay()>=10) {
							offices[i].deleteContract(offices[i].getContracts()[j].getContract_id());;
						}
					}
				}
				
				if((nowDate.getDay() !=1 || nowDate.getMonth() !=1 || nowDate.getYear() !=2021 )  &&nowDate.getDay()%3 == 1) {
					
					System.out.println("\t--- System Recommendations ----");
					for (int i = 0; i < employee_counter; i++) {
						if(three_Day_employee[i]!=1) System.out.println("\t"+(i+1) + ".Employee can be delete.");
						three_Day_employee[i]=0;
							
					}
					for (int i = 0; i < office_counter; i++) {
						if(three_Day[i][0]>0)System.out.println("\t"+"Office" + (i+1) + ": Buy new car (" +  offices[i].getCars()[highestCarProfit(i)[0][0]].getType() + " class )");
						if(three_Day[i][1]>0)System.out.println("\t"+"Office" + (i+1) + ": Add new employee");
						if(employee_3day[i] == 1)System.out.println("\t"+"Office" + (i+1) + ":  Attempted to add more workers. You may consider opening a new office.");
						offices[i].Employee_threeDay(i);
						if(three_Day[i][0]>0) three_Day[i][0] = 0;		
						if(three_Day[i][1]>0) three_Day[i][1] = 0;	
						if(employee_3day[i] == 1)employee_3day[i] = 0;
					}	
				
				}
				for (int i = 0; i < office_counter; i++) {
					for (int j = 0; j < offices[i].getEmployee_count(); j++) {
						offices[i].getEmployees()[j].setAvailable(true);
					}
					for (int j = 0; j < offices[i].getContract_count(); j++) {
						if(offices[i].getContracts()[j]!= null && isDateLate(nowDate, offices[i].getContracts()[j].getEndDate()) == false) {
							
							offices[i].getCars()[offices[i].getContracts()[j].getOfficeCarIndex()].setAvailable(true);
						}
							
						
					}
				}
				System.out.println("\n");
				System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println();
				System.out.println("--- Date:"+nowDate.getDay()+"."+nowDate.getMonth()+"."+nowDate.getYear()+" ---");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("!\tError: Could not be added. Because you did not enter the complete data.");
			}catch (NumberFormatException e) {
				System.out.println("!\tError: Could not be added. Because you entered the numbers incorrectly."+e.getLocalizedMessage());
			}catch (Exception e) {
				System.out.println("!\tWrong Input"+e.getLocalizedMessage());
			}
			
		}else {
			System.out.println("!\tError:"+"Wrong Input");
		}
	}
	
}
