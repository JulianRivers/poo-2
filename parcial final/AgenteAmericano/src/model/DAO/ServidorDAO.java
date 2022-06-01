package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ServidorDAO {

	 public int cargarCantCarros() throws SQLException {
		 int cant = 0;
		 System.out.println("Contando Carros...");
		 Connection connectionOb = null;
	        try {
	            connectionOb = DriverManager.getConnection("jdbc:derby://localhost:1527/segundoParcial;user=poo2;password=poo2;create=true");
	            PreparedStatement statementOb = connectionOb.prepareStatement("SELECT * FROM CARRO");
	            ResultSet queryResult = statementOb.executeQuery();
	            while (queryResult.next()) {
	            	cant++;
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        } finally {
	            // Close the connection
	            if (connectionOb != null) {
	                connectionOb.close();
	            }
	        }
	        return cant;
	 }
	 
	 public int cargarCantMotos() throws SQLException {
		 int cant = 0;
		 System.out.println("Contando Motos...");
		 Connection connectionOb = null;
	        try {
	            connectionOb = DriverManager.getConnection("jdbc:derby://localhost:1527/segundoParcial;user=poo2;password=poo2;create=true");
	            PreparedStatement statementOb = connectionOb.prepareStatement("SELECT * FROM MOTO");
	            ResultSet queryResult = statementOb.executeQuery();
	            while (queryResult.next()) {
	            	cant++;
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        } finally {
	            // Close the connection
	            if (connectionOb != null) {
	                connectionOb.close();
	            }
	        }
	        return cant;
	 }
	 
	 public int cargarCantBicicletas() throws SQLException {
		 int cant = 0;
		 System.out.println("Contando Bicicletas...");
		 Connection connectionOb = null;
	        try {
	            connectionOb = DriverManager.getConnection("jdbc:derby://localhost:1527/segundoParcial;user=poo2;password=poo2;create=true");
	            PreparedStatement statementOb = connectionOb.prepareStatement("SELECT * FROM BICICLETA");
	            ResultSet queryResult = statementOb.executeQuery();
	            while (queryResult.next()) {
	            	cant++;
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        } catch (Exception ex) {
	            System.out.println(ex.getMessage());
	        } finally {
	            // Close the connection
	            if (connectionOb != null) {
	                connectionOb.close();
	            }
	        }
	        return cant;
	 }
	 
	 public int cargarCantTotal() throws SQLException {
		 return cargarCantCarros()+cargarCantMotos()+cargarCantBicicletas();
	 }
}
