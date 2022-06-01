package poo2.parqueadero.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import poo2.parqueadero.model.dto.MarcaDTO;

public class MarcaDAO {

	private Connection conn;

	public MarcaDAO() {
		try {
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/poo2_local", "poo2", "poo2");
		} catch (SQLException e) {
			System.err.println("La conexión no se pudo establecer. " + e.getMessage());
		}

	}

	public MarcaDAO(Connection conn) {
		this.conn = conn;
	}
	
	public ArrayList<MarcaDTO> listar(){
		ArrayList<MarcaDTO> lista = new ArrayList<MarcaDTO>();
		Statement statementOb = null;
		
		try {
			statementOb = conn.createStatement();
	        ResultSet rs = statementOb.executeQuery("SELECT MARCANO, MNAME FROM MARCA");
	        
	        while (rs.next()) {
	        	MarcaDTO dto = new MarcaDTO();
	        	dto.setId(rs.getInt("MARCANO"));
	        	dto.setNombre(rs.getString("MNAME"));
	        	
	        	lista.add(dto);
	        	
	        }
        
		}catch(Exception e) {
			System.err.println("Se presentó un error ejecutando la consulta. "+e.getMessage());
		}finally {
			// Close the connection            
            try {
            	statementOb.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
            
		}
		
		return lista;
	}
	
	public int obtenerId(String nombreMarca){
		int id = 0;
		Statement statementOb = null;
		
		try {
			statementOb = conn.createStatement();
	        ResultSet rs = statementOb.executeQuery("SELECT MARCANO FROM MARCA WHERE MNAME = '"+nombreMarca+"'");
	        
	        if (rs.next()) {
	        	id = rs.getInt("MARCANO");
	        }
        
		}catch(Exception e) {
			System.err.println("Se presentó un error ejecutando la consulta. "+e.getMessage());
		}finally {
			// Close the connection            
            try {
            	statementOb.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}            
		}
		
		return id;
	}
	
}
