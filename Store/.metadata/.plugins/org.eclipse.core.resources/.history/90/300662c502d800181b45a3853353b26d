package prob1;

import emps.Employee;

public class Store {

	public static void main(String[] args) {
		// Test to verify signatures correct.
		Store s = new Store();
		s.addEmp(new Employee("a",10.0));
		Employee e = s.getEmp(0);
		int numEmps = s.getNumEmps();
		double totHours = s.getTotalHours();
		double totPay = s.getTotalPay();
		Employee e2 = s.removeEmployee(0);
		String str = s.toString();
	}
	Employee emps[] = new Employee[20];
	int numEmps;

	public Store() {
		numEmps = 0;
	}

	public int getNumEmps() {
		return numEmps;
	}

	public Employee getEmp(int i) {
		if( i>=0 && i<numEmps) 
			return emps[i];
		return null;
	}

	public void addEmp(Employee e) {
		if(numEmps<emps.length)
			emps[numEmps++] = e;
	}

	public Employee removeEmployee(int i) {
		Employee e = null;
		if( i>=0 && i<numEmps) {
			e = emps[i];
			for(int j=i+1; j<numEmps; j++) {
				emps[j-1]=emps[j];
			}
			numEmps--;
		}
		return e;
	}

	public double getTotalHours(){
		double hours = 0;
		for (int i=0; i<numEmps;i++){
			hours += emps[i].getTotalHours();
		}
		return hours;
	}

	public double getTotalPay(){
		double pay = 0;
		for (int i=0; i<numEmps; i++){
			pay += emps[i].getPay();
		}
		return pay;
	}

	public String toString(){
		String report=  String.format("Payroll Report\n\nNum Employees:%d, total hrs:%.2f, total pay=$%,.2f\n\n", numEmps, getTotalHours(), getTotalPay() );
		for (int i=0; i<numEmps; i++){
			report += emps[i] + "\n\n";
		}
		report = report.substring(0,report.length()-1);
		return report;
	}
}
