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

//		System.out.println("Podaj nr faktury: ");
//		String nrFaktury = sc.nextLine();

		try {
			String sql = "select * from faktury limit 10";
			connection = DriverManager.getConnection(url, user, password);

			Statement stmtStatement = connection.createStatement();
			ResultSet results = stmtStatement.executeQuery(sql);

			while (results.next()) {
				Faktury fakturaFaktury = new Faktury(results.getString("numer"), results.getDouble("kwota"),
						results.getInt("id_klienta"));
				faktury.add(fakturaFaktury);
			}
			System.out.println("\n Faktury od nowa \n");
			results.beforeFirst();
			while(results.next()) {
				System.out.println(results.getString(1));
			}
			List<Faktury> fakturyMniejsze = new ArrayList<>();
			List<Faktury> fakturyWieksze = new ArrayList<>();
			System.out.println("Faktury mniejsze: \n");
			for (Faktury faktura : faktury) {
				if (faktura.getKwota() > kwota) {
					fakturyWieksze.add(faktura);
					System.out.println(
							"Wieksze - nrFaktury: " + faktura.getNr_fsaktury() + "Kwota: " + faktura.getKwota());
				}

			}

			System.out.println("Faktury wieksze: \n");
			for (Faktury faktura : faktury) {

				if (faktura.getKwota() > kwota) {
					fakturyWieksze.add(faktura);
					System.out.println(
							"Wieksze - nrFaktury: " + faktura.getNr_fsaktury() + "Kwota: " + faktura.getKwota());
				}
			}
			
			
			

			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
