/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import model.factory.VehiculoFactory;
import model.DTO.MotoDTO;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Fachada;


/**
 *
 * @author Julian
 */
public class MotoDAO {

    public ArrayList<String> listarVehiculos(byte vehiculo) throws SQLException, RemoteException {
        Connection connectionOb = null;
        ArrayList<String> motos = new ArrayList();
        VehiculoFactory factory = Fachada.getInstance().inicializarFabrica(vehiculo);
        try {
            connectionOb = DriverManager.getConnection("jdbc:derby://localhost:1527/segundoParcial;user=poo2;password=poo2;create=true");
            PreparedStatement statementOb = connectionOb.prepareStatement("SELECT * FROM MOTO");
            ResultSet queryResult = statementOb.executeQuery();
            while (queryResult.next()) {
                MotoDTO dto = (MotoDTO) factory.crearVehiculo();
                dto.setPlaca(queryResult.getString("MPLACA"));
                dto.setMarca(queryResult.getInt("MARCA"));
                dto.setModelo(queryResult.getInt("MODELO"));
                dto.setCilindraje(queryResult.getInt("CILINDRAJE"));
                dto.setTipo(queryResult.getString("TIPO"));
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

    public void crearMoto(MotoDTO moto) throws SQLException {
        try (Connection connectionOb = DriverManager.getConnection("jdbc:derby://localhost:1527/segundoParcial", "poo2", "poo2") // Close the connection
        ) {
            Statement statementOb = connectionOb.createStatement();
            System.out.println("Insertando un registro");
            statementOb.executeUpdate("INSERT INTO MOTO(MPLACA, MARCA, MODELO , CILINDRAJE, TIPO, LLEGADA) VALUES "
                    + "('" + moto.getPlaca() + "', " + moto.getMarca() + ", " + moto.getModelo() + ", "
                    + moto.getCilindraje() + ", '" + moto.getTipo() + "', '" + moto.getLlegada() + "')");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } // To catch any other exception
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void eliminarMoto(String placa) throws SQLException {
        try (Connection connectionOb = DriverManager.getConnection("jdbc:derby://localhost:1527/segundoParcial", "poo2", "poo2") // Close the connection
        ) {
            PreparedStatement statementOb = connectionOb.prepareStatement("delete from MOTO where MPLACA = ?");
            statementOb.setString(1, placa);
            statementOb.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } // To catch any other exception
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
