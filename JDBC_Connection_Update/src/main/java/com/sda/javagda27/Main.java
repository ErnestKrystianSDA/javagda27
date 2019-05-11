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
		List<Faktura> faktury = new ArrayList<>();

		try {

			connection = DriverManager.getConnection(url, user, password);
			Statement stmtStatement = connection.createStatement();
			System.out.println("Wprowadz nr klienta: ");
			int numerKlienta = sc.nextInt();
			sc.nextLine();
			System.out.println("Wprowadz czy faktura op³acona: ");
			int jestOplacona = sc.nextInt();
			sc.nextLine();
			String getAllQuery = "select * from faktury";
			String sqlOplacona = "update faktury set oplacona = 1 where id_klienta = "  + numerKlienta;
			String sqlNieoplacona = "update faktury set oplacona = 0 where id_klienta = " + numerKlienta;				
//			
//			
			System.out.println(sqlOplacona);
			System.out.println(sqlNieoplacona);

			ResultSet resultSet = stmtStatement.executeQuery(getAllQuery);

			while (resultSet.next()) {
				faktury.add(new Faktura(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3)));
			}

			for (Faktura faktura : faktury) {
				if (faktura.getIdKlienta() == numerKlienta) {

					if (jestOplacona > 0) {
						stmtStatement.executeUpdate(sqlOplacona);
					} else {
						stmtStatement.executeUpdate(sqlNieoplacona);
					}
				}
			}

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
