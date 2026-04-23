import java.sql.ResultSet;

public class PayrollService {

    public void generatePayslip(ResultSet rs) {
        try {
            if (rs != null && rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                double basic = rs.getDouble("basic_salary");

                double hra = 0.30 * basic;
                double pf = 0.12 * basic;

                double gross = basic + hra;
                double annual = gross * 12;

                double tax = calculateTax(annual) / 12;
                double net = gross - pf - tax;

                System.out.println("\n==================================================");
                System.out.println("                 PAYSLIP DETAILS                  ");
                System.out.println("==================================================");
                System.out.printf("Employee ID   : %d%n", id);
                System.out.printf("Employee Name : %s%n", name);
                System.out.println("--------------------------------------------------");

                System.out.printf("%-20s : ₹ %.2f%n", "Basic Salary", basic);
                System.out.printf("%-20s : ₹ %.2f%n", "HRA (30%)", hra);
                System.out.printf("%-20s : ₹ %.2f%n", "PF (12%)", pf);
                System.out.printf("%-20s : ₹ %.2f%n", "Tax Deduction", tax);

                System.out.println("--------------------------------------------------");
                System.out.printf("%-20s : ₹ %.2f%n", "Gross Salary", gross);
                System.out.printf("%-20s : ₹ %.2f%n", "Net Salary", net);
                System.out.println("==================================================\n");

            } else {
                System.out.println("❌ Employee not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double calculateTax(double annualSalary) {
        if (annualSalary < 250000) return 0;
        else if (annualSalary < 500000) return annualSalary * 0.05;
        else if (annualSalary < 1000000) return annualSalary * 0.1;
        else return annualSalary * 0.2;
    }
}