package poo2.adapter.analysis.local.adapter;

import poo2.adapter.analysis.local.AnalysisInterface;
import poo2.adapter.analysis.remote.RemoteAnalysis;

public class RemoteAnalysisAdapter implements AnalysisInterface {

	private RemoteAnalysis remoteAnalysis;
	
	public RemoteAnalysisAdapter() {
		remoteAnalysis = new RemoteAnalysis();
	}
	
	public RemoteAnalysisAdapter(RemoteAnalysis remoteAnalysis) {
		this.remoteAnalysis = remoteAnalysis; 
	}
	
	@Override
	public void goProcessing() {
		System.out.println("RemoteAnalysisAdapter.goProcessing");
		remoteAnalysis.performProcessInformation();		
	}
	
}
