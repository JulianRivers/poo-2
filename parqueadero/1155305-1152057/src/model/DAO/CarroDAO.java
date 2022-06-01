/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import model.DTO.CarroDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Fachada;
import model.factory.VehiculoFactory;


/**
 *
 * @author Julian
 */
public class CarroDAO  {

    public void crearCarro(CarroDTO carro) throws SQLException {
        try (Connection connectionOb = DriverManager.getConnection("jdbc:derby://localhost:1527/segundoParcial", "poo2", "poo2") // Close the connection
        ) {
            Statement statementOb = connectionOb.createStatement();
            System.out.println("Insertando un registro");
            statementOb.executeUpdate("INSERT INTO CARRO (CPLACA, MARCA, MODELO, CILINDRAJE, NOPUERTAS, LLEGADA) VALUES "
                    + "('" + carro.getPlaca() + "', " + carro.getMarca() + ", " + carro.getModelo() + ", " + carro.getCilindraje() + ", " + carro.getNoPuertas() + ", '" + carro.getLlegada() + "')");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } // To catch any other exception
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

   
    public ArrayList<String> listarVehiculos(byte vehiculo) throws SQLException {
       Connection connectionOb = null;
        ArrayList<String> motos = new ArrayList();
        VehiculoFactory factory = Fachada.getInstance().inicializarFabrica(vehiculo);
        try {
            connectionOb = DriverManager.getConnection("jdbc:derby://localhost:1527/segundoParcial;user=poo2;password=poo2;create=true");
            PreparedStatement statementOb = connectionOb.prepareStatement("SELECT * FROM CARRO");
            ResultSet queryResult = statementOb.executeQuery();
            while (queryResult.next()) {
                CarroDTO dto = (CarroDTO) factory.crearVehiculo();
                dto.setPlaca(queryResult.getString("CPLACA"));
                dto.setMarca(queryResult.getInt("MARCA"));
                dto.setModelo(queryResult.getInt("MODELO"));
                dto.setCilindraje(queryResult.getInt("CILINDRAJE"));
                dto.setNoPuertas(queryResult.getInt("NOPUERTAS"));
                dto.setLlegada(queryResult.getString("LLEGADA"));
                dto.setSalida(queryResult.getString("SALIDA"));

                motos.add(dto.toString());
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
        return motos;
    }

    public void eliminarCarro(String placa) throws SQLException {
        try (Connection connectionOb = DriverManager.getConnection("jdbc:derby://localhost:1527/segundoParcial", "poo2", "poo2") // Close the connection
        ) {
            Statement statementOb = connectionOb.createStatement();
            System.out.println("Eliminando un registro");
            statementOb.executeUpdate("DELETE FROM CARRO WHERE CPLACA = '"+placa+"'");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } // To catch any other exception
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
