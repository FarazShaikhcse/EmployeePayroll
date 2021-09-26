import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	public enum IOService{
        CONSOLE_IO,FIlE_IO,DB_IO,REST_IO
    }
	
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
	public void writeEmployeePayrollData(IOService ioService) {
		if (ioService.equals(IOService.CONSOLE_IO)) {
			System.out.println("\nWriting Employee Payroll roaster to console\n" + employeePayrollList);
		} else if (ioService.equals(IOService.FIlE_IO)) {
			new EmployePayrollFileIo().writeData(employeePayrollList);
		}
	}

	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData();
		employeePayrollService.writeEmployeePayrollData(IOService.FIlE_IO);
		consoleInputReader.close();
	}
	public long countEntries() {  
        return new EmployePayrollFileIo().countEntries();
    }

}