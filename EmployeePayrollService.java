import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	private List<EmployeePayrollData> employeePayrollList;

	EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	/**
	 * method to read employee detail from the console
	 */
	private void readEmployeePayrollData() {
		Scanner consoleInputReader = new Scanner(System.in);
		System.out.println("Enter Employee ID: ");
		int id = consoleInputReader.nextInt();
		System.out.println("Enter Employee name: ");
		String name = consoleInputReader.next();
		System.out.println("Enter Employee salary: ");
		double salary = consoleInputReader.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}

	/**
	 * method to print employee detail to the console
	 */
	private void writeEmployeePayrollData() {
		System.out.println("\nWriting Employee Payroll to Console Output\n" + employeePayrollList);
	}

	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData();
		employeePayrollService.writeEmployeePayrollData();
		consoleInputReader.close();
	}

}