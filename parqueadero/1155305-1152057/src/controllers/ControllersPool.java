/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;

/**
 *
 * @author Julian
 */
public class ControllersPool {

    HashMap<String, ControllerInterface> controllers;
    private static ControllersPool pool;

    private ControllersPool() {
        this.controllers = new HashMap();
    }

    public static ControllersPool getInstance() {
        if (pool == null) {
            pool = new ControllersPool();
        }
        return pool;
    }

    public void addController(String name, ControllerInterface controller) {
        controllers.put(name, controller);
    }

    public ControllerInterface getController(String name) {
        if (controllers.get(name) == null) {
            switch (name) {
                case "CentralReportesEuropea":
                    controllers.put(name, new CentralEropeaAdapterController());
                    break;
                case "CentralReportesAmericano":
                    controllers.put(name, new CentralReporteController());
                    break;
                default:
                    throw new AssertionError();
            }
        }
        return controllers.get(name);
    }

}
