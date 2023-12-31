package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBUtill {

	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	// register account
	public static boolean registerUser(String salutation, String firstname, String lastname, String tell,
			String address, String email, String username, String password) {

		boolean isSuccess = false;

		try {
			con = DbConnect.getConnection();
			stmt = con.createStatement();

			// save details inside profile table
			String profileDetailssql = "INSERT INTO profile VALUES(0, '" + salutation + "', '" + firstname + "' , '"
					+ lastname + "', '" + tell + "', '" + address + "' , '" + email + "')";
			int response = stmt.executeUpdate(profileDetailssql);

			if (response > 0) {
				// Fetch user details from the profile table providing email
				String selectProfileSql = "SELECT id FROM profile WHERE email = '" + email + "'";
				ResultSet profileResult = stmt.executeQuery(selectProfileSql);

				if (profileResult.next()) {
					int profileId = profileResult.getInt("id");

					String insertLoginSql = "INSERT INTO login VALUES (0 , '" + username + "' , '" + password + "' , '"
							+ profileId + "')";
					int loginInsertResponse = stmt.executeUpdate(insertLoginSql);

					// Check if the insertion into the login table was successful
					if (loginInsertResponse > 0) {
						isSuccess = true;
					} else {
						isSuccess = false;
					}
				}
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	// validate login
	public static List<login> validate(String username, String password) {

		ArrayList<login> userDetails = new ArrayList<>();

		// validate
		try {
			con = DbConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from login where username = '" + username + "' and password = '" + password + "'";
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String pwd = rs.getString(3);
				String profile_id = rs.getString(4);

				login loginObj = new login(id, name, pwd, profile_id);
				userDetails.add(loginObj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userDetails;
	}

	// insert new product
	public static boolean insertProduct(String name, String brand, double price) {

		boolean isSuccess = false;

		try {
			con = DbConnect.getConnection();
			stmt = con.createStatement();

			String insetQuery = "INSERT INTO product VALUES(0, '" + name + "', '" + brand + "' , '" + price + "')";
			int response = stmt.executeUpdate(insetQuery);

			if (response > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	// retrive all products exist
	public static List<product> getProducts() {

		ArrayList<product> productList = new ArrayList<>();

		try {
			con = DbConnect.getConnection();
			stmt = con.createStatement();

			String sqlQuery = "SELECT * FROM product";
			rs = stmt.executeQuery(sqlQuery);

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String brand = rs.getString(3);
				double price = rs.getDouble(4);

				product product = new product(id, name, brand, price);
				productList.add(product);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productList;
	}

	// save invoice
	public static boolean generateInvoice(int uid, String date, double totalPrice, int points, int qty, int pid) {
		boolean isSuccess = false;

		try {
			con = DbConnect.getConnection();
			stmt = con.createStatement();

			// Parse the incoming date string
			SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy, hh:mm a");
			Date newdate = inputFormat.parse(date);

			// Format the date as per MySQL datetime format
			SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formattedDate = outputFormat.format(newdate);

			String insetQuery = "INSERT INTO invoice VALUES(0, '" + formattedDate + "', '" + totalPrice + "' , '"
					+ points + "' , '" + uid + "')";
			int response = stmt.executeUpdate(insetQuery);

			if (response > 0) {
				String retrieveQuery = "SELECT * FROM invoice ORDER BY id DESC LIMIT 1";
				ResultSet retirveResult = stmt.executeQuery(retrieveQuery);

				if (retirveResult.next()) {
					int invoiceId = retirveResult.getInt("id");

					String insertquery2 = "INSERT INTO invoice_has_product VALUES (0 , '" + invoiceId + "' , '" + pid
							+ "' , '" + qty + "', '" + totalPrice + "')";

					int response2 = stmt.executeUpdate(insertquery2);

					if (response2 > 0) {
						isSuccess = true;
					} else {
						isSuccess = false;
					}
				}
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;

	}

	public static List<Combine> userDetails(int profileId) {

		
		ArrayList<Combine> profileDetails = new ArrayList<>();
		int id = 0;
		String salutation = "";
		String firstname = "";
		String lastname = "";
		String tell = "";
		String address = "";
		String email = "";
		String username = "";
		int totalPoints = 0;

		try {
			con = DbConnect.getConnection();
			stmt = con.createStatement();

			String sqlQuery1 = "SELECT * FROM profile WHERE id = '" + profileId + "'";
			rs = stmt.executeQuery(sqlQuery1);

			if (rs.next()) {
				id = Integer.parseInt(rs.getString("id"));
				salutation = rs.getString("salutation");
				firstname = rs.getString("firstName");
				lastname = rs.getString("lastName");
				tell = rs.getString("tel");
				address = rs.getString("address");
				email = rs.getString("email");

			} else {
				System.out.println("error fetching user details from profile table");
			}

			String sqlQuery2 = "SELECT * FROM login WHERE profile_id = '" + profileId + "'";
			rs = stmt.executeQuery(sqlQuery2);
			if (rs.next()) {
				username = rs.getString("username");
			} else {
				System.out.println("error fetching username from login table");
			}

			String sqlQuery3 = "SELECT SUM(points) AS totalPoints FROM invoice WHERE profile_id = '" + profileId + "'";
			rs = stmt.executeQuery(sqlQuery3);

			if (rs.next()) {
				totalPoints = rs.getInt("totalPoints");
			} else {
				System.out.println("error calculating points from invoice table");
			}
			Combine obj = new Combine(id, username, salutation, firstname, lastname, tell, address, email, totalPoints);
			profileDetails.add(obj);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return profileDetails;
	}

}
