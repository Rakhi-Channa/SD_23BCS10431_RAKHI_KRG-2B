import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static EmployeeService empService = new EmployeeService();
    static PayrollService payrollService = new PayrollService();

    public static void main(String[] args) {

        while (true) {
            System.out.println("====== PAYROLL SYSTEM ======");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Generate Payslip");
            System.out.println("4. Exit");
            

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Basic Salary: ");
                    double salary = sc.nextDouble();

                    empService.addEmployee(id, name, salary);
                    break;

                case 2:
                    empService.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    int empId = sc.nextInt();

                    payrollService.generatePayslip(
                        empService.getEmployeeById(empId)
                    );
                    break;

                case 4:
                    System.exit(0);

                //  case 5:
                //      System.out.print("Enter Employee ID to delete: ");
                //      int delId = sc.nextInt();
                //      empService.deleteEmployee(delId);
                //      break;
            }
        }
    }
}