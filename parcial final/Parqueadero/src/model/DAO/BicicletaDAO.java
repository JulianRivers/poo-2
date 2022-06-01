/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.DTO.BicicletaAdapterDTO;
import model.Fachada;
import model.factory.VehiculoFactory;

/**
 *
 * @author Julian
 */
public class BicicletaDAO {

    public int crearBicicleta(BicicletaAdapterDTO bicicleta) throws SQLException {
        Connection connectionOb = null;
        int id = 0;
        try {
            connectionOb = DriverManager.getConnection("jdbc:derby://localhost:1527/segundoParcial", "poo2", "poo2");
            Statement statementOb = connectionOb.createStatement();
            System.out.println("Insertando un registro");
            statementOb.executeUpdate("INSERT INTO BICICLETA(CCPROPIETARIO, MARCA, TIPO, LLEGADA) VALUES "
                    + "('" + bicicleta.getCcPropietarioB() + "', " + bicicleta.getMarca() + ", '" + bicicleta.getTipoB() + "', '" + bicicleta.getLlegada() + "')");
            //id = statementOb.executeUpdate("SELECT MAX(IDBICI) FROM BICICLETA");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } // To catch any other exception
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            // Close the connection
            if (connectionOb != null) {
                connectionOb.close();
            }
        }
        return id;
    }

    public ArrayList<String> listarVehiculos(byte vehiculo) throws SQLException, RemoteException {
        Connection connectionOb = null;
        ArrayList<String> bicicletas = new ArrayList();
        VehiculoFactory factory = Fachada.getInstance().inicializarFabrica(vehiculo);
        try {
            connectionOb = DriverManager.getConnection("jdbc:derby://localhost:1527/segundoParcial;user=poo2;password=poo2;create=true");
            PreparedStatement statementOb = connectionOb.prepareStatement("SELECT * FROM BICICLETA");
            ResultSet queryResult = statementOb.executeQuery();
            while (queryResult.next()) {
                BicicletaAdapterDTO dto = (BicicletaAdapterDTO) factory.crearVehiculo();
                dto.setPlaca(queryResult.getString("IDBICI"));
                dto.setCcPropietarioB(queryResult.getString("CCPROPIETARIO"));
                dto.setMarca(queryResult.getInt("MARCA"));
                dto.setTipoB(queryResult.getString("TIPO"));
                dto.setLlegada(queryResult.getString("LLEGADA"));
                dto.setSalida(queryResult.getString("SALIDA"));

                bicicletas.add(dto.toString());
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
        return bicicletas;
    }

}
