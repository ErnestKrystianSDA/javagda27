package com.sda.javagda27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static String url = "jdbc:mysql://localhost:3306/mojabaza?useSSL=false&useTimezone=true&serverTimezone=UTC";
	private static String user = "root";
	private static String password = "1234";

	public static void main(String[] args) {

		Connection connection;
		Scanner sc = new Scanner(System.in);
		List<Faktury> faktury = new ArrayList<>();
		System.out.println("Podaj kwotê: ");
		double kwota = sc.nextDouble();
		sc.nextLine();

		System.out.println("Podaj nr faktury: ");
		String nrFaktury = sc.nextLine();

		try {
			String sql = "select * from faktury";
			connection = DriverManager.getConnection(url, user, password);

			Statement stmtStatement = connection.createStatement();
			ResultSet results = stmtStatement.executeQuery(sql);
			

			while (results.next()) {

				
			}

			System.out.println("Faktury mniejsze: \n");

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
