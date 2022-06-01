package poo2.adapter.analysis.gui;

import poo2.adapter.analysis.local.AnalysisInterface;

public class GUIClient {

	public GUIClient() {
	}
	
	public void realizarAnalisis() {
		
		// Realizar procesamiento de la información
		
		AnalysisInterface obj = Util.obtenerInstancia('L');
		obj.goProcessing();
		
		obj = Util.obtenerInstancia('R');
		obj.goProcessing();
		
		// Realizar limpieza y agregaciones
	}
	
	
	public static void main(String[] args) {
		
		GUIClient gC = new GUIClient();
		gC.realizarAnalisis();
		
	}
	
}


