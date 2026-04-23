import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeService {

    public void addEmployee(int id, String name, double salary) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO employee VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, salary);

            ps.executeUpdate();

            System.out.println("✅ Employee added to database!");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewEmployees() {
        try {
            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employee");

            System.out.println("\n--- Employee List ---");
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Salary: " + rs.getDouble("basic_salary"));
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet getEmployeeById(int id) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM employee WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            return ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void deleteEmployee(int id) {
    try {
        Connection con = DBConnection.getConnection();

        String query = "DELETE FROM employee WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("✅ Employee deleted successfully!");
        } else {
            System.out.println("❌ Employee not found!");
        }

        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}