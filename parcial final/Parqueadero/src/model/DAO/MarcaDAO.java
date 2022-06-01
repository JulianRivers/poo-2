/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Julian
 */
public class MarcaDAO {
    
    public ArrayList<String> listarMarcas() throws SQLException {
        Connection connectionOb = null;
        ArrayList<String> marcas = new ArrayList<String>();
        try {
            connectionOb = DriverManager.getConnection("jdbc:derby://localhost:1527/segundoParcial;user=poo2;password=poo2;create=true");
            PreparedStatement statementOb = connectionOb.prepareStatement("SELECT NAME FROM MARCA");
            ResultSet queryResult = statementOb.executeQuery();
            while (queryResult.next()) {
                marcas.add(queryResult.getString("NAME"));
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
        return marcas;
    }
}
