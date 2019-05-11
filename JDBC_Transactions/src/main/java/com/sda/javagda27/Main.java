package com.sda.javagda27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	private static String url = "jdbc:mysql://localhost:3306/mojabaza?useSSL=false&useTimezone=true&serverTimezone=UTC";
	private static String user = "root";
	private static String password = "1234";

	public static void main(String[] args) {

		Connection connection;
		Scanner sc = new Scanner(System.in);

		try {
			String sqlPrepare = "update faktury set numer = ? where numer = ?";
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(false);
			PreparedStatement stmtStatement = connection.prepareStatement(sqlPrepare);
						
			while (true) {

				System.out.println("Podaj nr faktury: ");
				String nrFaktury = sc.nextLine();
				stmtStatement.setString(1, "bledny");
				stmtStatement.setString(2, nrFaktury);
				System.out.println("Czy b³edna ");
				int isAccept = sc.nextInt();
				sc.nextLine();
				stmtStatement.executeUpdate();
				if (isAccept < 1) {
					connection.rollback();
				} else {
					connection.commit();
				}
				if(isAccept == -1) {
					break;
				}
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
