package model;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import controllers.ControllerInterface;

public class Fachada {
	
	private static Fachada fachada;
	
	private Fachada() {}

	public static Fachada getInstance() {
		if (fachada == null)
			fachada = new Fachada();
		return fachada;
	}
	
	public ControllerInterface EstablecerConexion() throws RemoteException, NotBoundException {
		Registry reg = LocateRegistry.getRegistry(3232);
		return (ControllerInterface) reg.lookup("servidoramigo");
	}
	
}
