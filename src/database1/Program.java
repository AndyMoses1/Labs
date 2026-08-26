package database1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) {
		MSSQLExample example = new MSSQLExample();

		example.insertCustomer("3000", "AA", "Andrew Moses", "Boss", "012345 657483");
		example.read();
	}

}

class MSSQLExample {

	private String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=qastore;encrypt=true;trustServerCertificate=true;user=andym;password=password123";

	public void read() {

		StringBuilder out = new StringBuilder();

		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement()) {

			String sql = "select company_no, company_name, post_code, county "
					+ "from company WHERE county=? AND post_code like ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, "London"); // the first ?  (county)
			ps.setString(2, "N%"); // second ?  (post_code)

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				out.append(String.format("No: %-7d| Company name:%-25s|\n", id, name));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(out.toString());
	}

	public void insertCustomer(String customerId, String companyName,
			String contactName, String city, String country) {

		String sql = "INSERT INTO contact "
				+ "(company_no, contact_code, contact_name, job_title, tel) "
				+ "VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(url);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, customerId);
			ps.setString(2, companyName);
			ps.setString(3, contactName);
			ps.setString(4, city);
			ps.setString(5, country);

			int rowsInserted = ps.executeUpdate();

			System.out.println(rowsInserted + " row(s) inserted");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
