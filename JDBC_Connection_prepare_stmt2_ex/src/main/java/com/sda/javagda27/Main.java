package com.sda.javagda27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		System.out.println("Podaj kwotê wieksz¹: ");
		double kwotaWieksza = sc.nextDouble();
		sc.nextLine();
		
		System.out.println("Podaj kwotê mniejsza: ");
		double kwotaMniejsza = sc.nextDouble();
		sc.nextLine();

		try {
			connection = DriverManager.getConnection(url, user, password);
			String prepateString = "select * from faktury where kwota < ? and kwota > ?";
			PreparedStatement preparedStatement = connection.prepareStatement(prepateString);
			preparedStatement.setDouble(1, kwotaWieksza);
			preparedStatement.setDouble(2, kwotaMniejsza);
			
			ResultSet result = preparedStatement.executeQuery();
			
			while(result.next()) {
				System.out.println("Kwota: " + result.getInt(2));
			}

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
