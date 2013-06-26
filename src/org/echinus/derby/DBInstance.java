package org.echinus.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBInstance {

	private static DBInstance instance = null;
	static Connection conn;
	static Statement s;
	static ResultSet files;
	static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	static String dbName = "fileDB";
	static String connectionURL = "jdbc:derby:" + dbName + ";create=true";
	static String protocol = "jdbc:derby:";

	private DBInstance() {

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(connectionURL);

			s = conn.createStatement();
			System.out.println("Calling DB Constructor");

			// s.execute("CREATE TABLE files (NAME VARCHAR(256), PATH VARCHAR(256))");

			// s.execute("INSERT INTO files (NAME, PATH) VALUES ('TEST','TESTPATH/LOL/')");

//			files = s.executeQuery("SELECT * FROM files");
//			while (files.next()) {
//				System.out.println("On " + files.getString("NAME")
//						+ " I wished for " + files.getString("PATH"));
//			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		DBInstance dbi = new DBInstance();
	}

	public static synchronized DBInstance getInstance() {

		if (instance == null) {
			instance = new DBInstance();
		}

		return instance;
	}

	public static ArrayList<String> getAllFiles() {

		System.out.println("preparing getAllFiles");

		// s.execute("CREATE TABLE files (NAME VARCHAR(256), PATH VARCHAR(256))");

		// s.execute("INSERT INTO files (NAME, PATH) VALUES ('TEST','TESTPATH/LOL/')");

		ArrayList<String> filesList = new ArrayList<String>();

		try {
			s = conn.createStatement();
			files = s.executeQuery("SELECT * FROM files");
			while (files.next()) {
				filesList.add(files.getString("PATH"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return filesList;

	}

	public static void insertFile(String path) {
		try {

			s = conn.createStatement();
			System.out.println("preparing statement");

			// s.execute("CREATE TABLE files (NAME VARCHAR(256), PATH VARCHAR(256))");

			// s.execute("INSERT INTO files (NAME, PATH) VALUES ('TEST','TESTPATH/LOL/')");

			s.execute("INSERT INTO files (NAME, PATH) VALUES ('"
					+ path.substring(1, 5) + "','" + path + "')");
			System.out.println("Running: "
					+ "INSERT INTO files (NAME, PATH) VALUES ('"
					+ path.substring(1, 5) + "','" + path + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clearDB() {

		try {

			System.out.println("clearing DB");
			s = conn.createStatement();
			

			// s.execute("CREATE TABLE files (NAME VARCHAR(256), PATH VARCHAR(256))");

			// s.execute("INSERT INTO files (NAME, PATH) VALUES ('TEST','TESTPATH/LOL/')");

			s.execute("DELETE FROM files");
			System.out.println("Deleting files");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
