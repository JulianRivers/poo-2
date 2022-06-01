/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Julian
 */

public interface ControllerInterface extends Remote {
	public void update(String msg) throws RemoteException;
	
	public void suscribirse(String name, ControllerInterface conInt) throws RemoteException;
}
