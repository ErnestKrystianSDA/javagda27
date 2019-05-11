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
		
		try {
			String sql = "select * from faktury";
			String sqlUpdateString = "update faktury set numer = '____' where kwota < 1000";
			
			connection = DriverManager.getConnection(url, user, password);

			Statement stmtStatement = connection.createStatement();
			
			stmtStatement.executeUpdate(sqlUpdateString);
			
			ResultSet results = stmtStatement.executeQuery(sql);
			
			while (results.next()) {
				Faktury fakturaFaktury = new Faktury(results.getString("numer"), results.getDouble("kwota"),
						results.getInt("id_klienta"));
				faktury.add(fakturaFaktury);
			}
			
			for (Faktury faktury2 : faktury) {
				System.out.println(faktury2.getNr_fsaktury() + "  " + faktury2.getKwota());
			}
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
