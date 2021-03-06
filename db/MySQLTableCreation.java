package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class MySQLTableCreation {
	// Run this as Java application to reset the database.
	public static void main(String[] args) {
		try {
			// Step 1: Connect to MySQL.
			System.out.println("Connecting to " + MySQLDBUtil.URL);
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(MySQLDBUtil.URL);

			if (conn == null) {
				return;
			}
			// Step 2: Drop tables in case they exist.
			Statement statement = conn.createStatement();
			
			String sql = "DROP TABLE IF EXISTS transactions";
			statement.executeUpdate(sql);

			sql = "CREATE TABLE transactions (" + "trans_id VARCHAR(255) NOT NULL," 
					+ "station_id INTEGER NOT NULL," 
					+ "start_device_is_robot BOOLEAN NOT NULL,"+ "end_device_is_robot BOOLEAN NOT NULL," 
					+ "status_id INTEGER NOT NULL,"					
					+ "pick_up_lat DOUBLE NOT NULL," + "pick_up_lon DOUBLE NOT NULL,"			
					+ "deliver_location_lat DOUBLE NOT NULL," + "deliver_location_lon DOUBLE NOT NULL," 
					+ "timestamp INTEGER NOT NULL," + "PRIMARY KEY (trans_id)"											
					+ ")";
			statement.executeUpdate(sql);
			
	    		// Step 4: insert fake user 3229c1097c00d497a0fd282d586be050
//            		sql = "INSERT INTO transactions VALUES('3229c1097c00d497a0fd282d586be050', "
//            		+ "'1' , '3',"
//            		+ " true, false,"
//            		+ "'19', "
//            		+ "'-120', '30',"
//            		+ " '-110', '10', "
//            		+ "'123456789,'"
//            		+ ")";
//            	
//			statement.executeUpdate(sql);
			conn.close();
			System.out.println("Import done successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
