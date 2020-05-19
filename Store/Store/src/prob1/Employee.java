package prob1;

public class Employee {
	private double[] hours = new double[7];
	private String name;
	private double payRate;

	public double getPayRate() {
		return payRate;
	}

	public String getName() {
		return name;
	}

	public Employee(String name, double payRate){
		if(name.length()==0)
			throw new RuntimeException("name must have length >0");
		if(payRate<=0)
			throw new RuntimeException("payrate must be >0");
		this.name = name;
		this.payRate = payRate;
	}

	public double getHours(int day){
		return hours[day];
	}

	public void setHours(int day, double hours){
		this.hours[day]= hours;

	}

	public int getNumDaysWorked(){
		int count = 0;

		for (int i=0; i<hours.length; i++){
			if (hours[i]>0)
				count++;
		}
		return count;
	}

	public double getPay() {
		double total = 0.0;
		double weekDayHours = getWeekdayHours();
		double weekendHours = getWeekendHours();
		if(weekDayHours<=40.0) {
			total += weekDayHours*payRate;
		}
		else {
			total += 40*payRate + (weekDayHours-40.0)*payRate*1.5;
		}
		if(weekendHours>0.0) {
			total += weekendHours*payRate*2;
		}
		if(getNumDaysWorked()==7) {
			total += 50.0;
		}
		return total;
	}

	public double getTotalHours(){
		double total = 0;
		for (int i=0; i<hours.length; i++){
			total+= hours[i];
		}
		return total;
	}

	public double getWeekdayHours(){
		double total = 0;
		for (int i=0; i<hours.length-2; i++){
			total+= hours[i];
		}
		return total;
	}

	public void mergeEmployee(Employee e){
		for (int i=0; i<hours.length; i++){
			setHours(i,this.getHours(i)+e.getHours(i));
		}
	}

	public void newWeek() {
		hours = new double[7];
	}

	public double getWeekendHours(){
		return hours[5]+hours[6];
	}

	public String toString(){
		String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
		String strHours = "";
		int i=0;
		String stub = String.format("Pay Stub\n--------\nName:%s, Pay Rate $%.2f\nHours:", name, payRate);
		for(String day : days) {
			strHours += String.format("%s:%.2f ", day, hours[i++]);
		}
		stub += strHours + "\n";
		stub += String.format("Days worked:%d, Total Hours:%.2f\n", getNumDaysWorked(), getTotalHours());
		stub += String.format("Weekday hours:%.2f, Weekend hours: %.2f\n", getWeekdayHours(), getWeekendHours());
		stub += String.format("Total pay: $%.2f", getPay());
		return stub;
	}
}






