
/** Purpose: Hold the class controlling the SQL database
 *  UMGC CMSC 495 Special Topics
 *  Developer: Team 1
 *  Date: February 12, 2021
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Class {

	// Variables
	private String url = "jdbc:mysql://localhost:3306/MySql";
	private String username = "root";
	private String password = "@@t45zr)11";

	// Constructor
	public Database_Class() {

	}

	public Connection getConnection() throws SQLException {

		Connection conn = null;

		try {

			conn = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			throw e;
		} finally {

			// close();

		}

		return conn;

	}

	public void maintainAuditLog() {		
	}

	public void exportWholeDatabaseAsCSV() {		
	}

	public void exportSingleUserAsCSV() {		
	}

	public void specifyExportFilepath() {		
	}

	public void exportEmailContacts() {		
	}

	public void deleteSelectedUser() {		
	}

	public void filterData() {		
	}

}
