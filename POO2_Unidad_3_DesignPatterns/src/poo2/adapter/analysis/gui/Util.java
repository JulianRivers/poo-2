package poo2.adapter.analysis.gui;

import poo2.adapter.analysis.local.AnalysisInterface;
import poo2.adapter.analysis.local.LocalAnalysis;
import poo2.adapter.analysis.local.adapter.RemoteAnalysisAdapter;

public class Util {

	private Util() {
		
	}
	
	public static AnalysisInterface obtenerInstancia(char parametro) {
		AnalysisInterface obj = null;
		
		if(parametro=='L')
			obj = new LocalAnalysis();
		else if(parametro=='R') {
			// obj = new RemoteAnalysis();
			/* Esto genera error porque el API remoto de analisis
			 * no implementa la interfaz requerida. 
			 * No se modificar el codigo del API remoto para ponerlo 
			 * a que implemente la interfaz local. Y de poderlo hacer
			 * se estaría modificando una implementación utilizada tal 
			 * vez en muchos lugares. 
			 * Por eso la relevancia del adaptador. 
			 */
			obj = new RemoteAnalysisAdapter();
		}
		
		return obj;
	}
	
}
