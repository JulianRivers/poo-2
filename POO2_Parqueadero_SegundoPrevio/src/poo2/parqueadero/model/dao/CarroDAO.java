package poo2.parqueadero.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import poo2.parqueadero.model.dto.CarroDTO;
import poo2.parqueadero.model.dto.VehiculoDTO;

public class CarroDAO {

	private Connection conn;

	public CarroDAO() {
		try {
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/poo2_local", "poo2", "poo2");
		} catch (SQLException e) {
			System.err.println("La conexión no se pudo establecer. " + e.getMessage());
		}

	}

	public CarroDAO(Connection conn) {
		this.conn = conn;
	}
	
	public boolean agregar(CarroDTO dto) {
		boolean exito = false;
		
		try {
			
			Statement statementOb = conn.createStatement();
			
			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO CARRO(CPLACA, CMARCA) VALUES ('"+dto.getPlaca()+"', "+dto.getIdMarca()+")");
			
			statementOb.executeUpdate(sb.toString());
			
			exito = true;
			
		}catch(Exception e) {
			System.err.println("Ocurrió un error insertando el registro. "+e.getMessage());
		}finally {
			// Close the connection            
            try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
            
		}
		
		return exito;
	}
	
	public ArrayList<VehiculoDTO> listar(){
		ArrayList<VehiculoDTO> lista = new ArrayList<VehiculoDTO>();
		Statement statementOb = null;
		
		try {
			statementOb = conn.createStatement();
	        ResultSet rs = statementOb.executeQuery("");
	        
	        while (rs.next()) {
	        	CarroDTO dto = new CarroDTO();
	        	dto.setPlaca(rs.getString("DEPTNO"));
	        	dto.setNombreMarca(rs.getString("DNAME"));
	        	
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

}
