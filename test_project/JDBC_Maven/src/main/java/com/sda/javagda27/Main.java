package com.sda.javagda27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/mojabaza?useSSL=false&useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "1234";

		try (Connection mainConnection = DriverManager.getConnection(url, user, password)) {

			String queryString = "select * from faktury";
			String prepareStatementString = "select * from faktury where kwota > ? and kwota < ? limit 10";
		
			PreparedStatement preparedStatement = mainConnection.prepareStatement(prepareStatementString);
			preparedStatement.setInt(1, 200);
			preparedStatement.setInt(2, 1000);
			Statement stmt = mainConnection.createStatement();
			ResultSet resultSet = stmt.executeQuery(queryString);
			ResultSet resultSetPrepareStatement = preparedStatement.executeQuery();

			System.out.println("\n----Statement results---\n");
			showResults(resultSet);
			System.out.println("\n----Prepared Statement results---\n");
			showResults(resultSetPrepareStatement);
			
			var resultSetMetadata = resultSet.getMetaData();
			
			for (int i = 1; i <= resultSetMetadata.getColumnCount(); i++) {
				
				System.out.println("Column name: " + resultSetMetadata.getColumnName(i));
				System.out.println("Column type: " + resultSetMetadata.getColumnType(i));
				System.out.println("Column type name: " + resultSetMetadata.getColumnTypeName(i));				
			}
			
//			mainConnection.setAutoCommit(false);
//			
//			Statement updateStatement = mainConnection.createStatement();
//			updateStatement.executeUpdate("update faktury set numer = '----' where kwota > 500");
//			
//			mainConnection.rollback();
			
			System.out.println("\n----------Klient list--------------\n");
			resultSet.beforeFirst();
			for (int klientId : getClientList(resultSet)) {
				if(klientId > 136) {
				stmt.executeUpdate("update faktury set id_klienta = " + new Random().nextInt(136) + " where id_klienta =" + klientId);
				}
			}
			

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private static void showResults(ResultSet resultSet) throws SQLException {

		while (resultSet.next()) {

			System.out.println("Faktura nr: " + resultSet.getString(1) + " Kwota: " + resultSet.getInt("kwota"));
		}
	}
	
	private static Set<Integer> getClientList(ResultSet result) throws SQLException{
		var clientSet = new HashSet<Integer>();
		while (result.next()) {
			var klientId = result.getInt("id_klienta");
			clientSet.add(klientId);		
		}
		return clientSet;
	}

}
