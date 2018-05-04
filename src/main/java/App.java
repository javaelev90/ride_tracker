import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	public static void main(String[] args) {

		String url = "jdbc:sqlite:C:\\Users\\elev\\Documents\\GitHub\\ride_tracker.db";
		String sql = "CREATE TABLE Ride (" +
			     "id INTEGER Primary key, " +
			     "name VARCHAR(100) not null, " +
			     "duration INTEGER not null)";
		String selectQuery = "SELECT * FROM " + "ride";
//		String add = "INSERT INTO ride"
//				+ " (name, duration)"
//				+ " VALUES "+"('anders-ride', 12)";
		
		
		try(Connection conn = DriverManager.getConnection(url)){
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()){
			stmt.execute("DROP TABLE IF EXISTS Ride");
			
			stmt.executeUpdate(sql);
//			stmt.executeUpdate(add);
			ResultSet result = stmt.executeQuery(selectQuery);
			while(result.next()) {
				System.out.println(result.getString(1));
				System.out.println(result.getString(2));
				System.out.println(result.getString(3));
				System.out.println("");
			}
			System.out.println("...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
	}

}
