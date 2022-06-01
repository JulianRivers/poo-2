package controllers;

import java.util.HashMap;

public class ControllerPool {

	private static HashMap<String, Object> controllers;
	private static ControllerPool pool;

	private ControllerPool() {
		controllers = new HashMap<String, Object>();
	}

	public static ControllerPool getInstance() {
		if (pool == null)
			pool = new ControllerPool();
		return pool;
	}

	public void addController(String name, Object controller) {

		System.out.println("Se añadió "+name + " - " + controller);

		controllers.put(name, controller);
	}

	public Object getController(String name) {
		return controllers.get(name);
	}
	
	public HashMap getControllers() {
		return this.controllers;
	}
}
