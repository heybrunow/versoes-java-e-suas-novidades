package br.com.versaooito.streams;
 
import java.util.ArrayList;
import java.util.List;
 
public class TestePerfomanceComStreams {
	
	public static void main(String[] args) {
		System.out.println("Processamento em RAM:");
		testeComProcessamentoSomenteEmMemoriaRam();
		System.out.println("Processamento simulando chamadas de meio segundo ao banco:");
		testeComProcessamentoSomenteEmBancoSimulado();
	}
 
	// quanto mais elemntos na lista, mas streams será veloz e paralell será mais lento
	// quanto menos elemntos na lista, mas streams será lento e paralell será mais rapido
	//(TUDO A DEPENDER DE QUANTOS PROCESSADORES E NUCLEOS SUA MÁQUINA TEM PARA EXECUTAR EM RAM)
	private static void testeComProcessamentoSomenteEmMemoriaRam() {
		List<String> palavras = new ArrayList<>();
		
		int paraleMaisRapido = 100000;
		int equilibrado = 16000000;
		int streamMaisRapido = 17000000;
		
		for (int i = 0; i < paraleMaisRapido; i++) {
			palavras.add("palavra "+i);
		}
		
		long inicioStream = System.currentTimeMillis();
		palavras.stream().forEach(p -> metodoComProcessamentoSomenteNaMemoriaRam(p));		
		long fimStream = System.currentTimeMillis();
		System.out.println("Tempo com Streams: " + (fimStream-inicioStream));
		
		long inicioParalelStream = System.currentTimeMillis();
		palavras.parallelStream().forEach(p -> metodoComProcessamentoSomenteNaMemoriaRam(p));
		long fimParalelStream = System.currentTimeMillis();
		System.out.println("Tempo com ParallelStream: " + (fimParalelStream-inicioParalelStream));
	}
	
	private static void metodoComProcessamentoSomenteNaMemoriaRam(String palavra) {
		palavra.toString();
	}
	
	// quando se tarta de banco de dados, paralell tendo a sendo mais rapido quando temos muitos elementos na lista
	// sendo um elemento só não precisar usar o paralell, pq não precisa recrutar muitos processadores para uma só consulta
	private static void testeComProcessamentoSomenteEmBancoSimulado() {
		List<String> palavras = new ArrayList<>();
		
		int paraleMaisRapido = 100;
		
		for (int i = 0; i < paraleMaisRapido; i++) {
			palavras.add("palavra "+i);
		}
		
		long inicioStream = System.currentTimeMillis();
		palavras.stream().forEach(p -> metodoComProcessamentoSomenteemBancoSimulado());		
		long fimStream = System.currentTimeMillis();
		System.out.println("Tempo com Streams: " + (fimStream-inicioStream));
		
		long inicioParalelStream = System.currentTimeMillis();
		palavras.parallelStream().forEach(p -> metodoComProcessamentoSomenteemBancoSimulado());
		long fimParalelStream = System.currentTimeMillis();
		System.out.println("Tempo com ParallelStream: " + (fimParalelStream-inicioParalelStream));
	}
	
	private static void metodoComProcessamentoSomenteemBancoSimulado() {
		try {
			Thread.sleep(0500); // tempo de resposta do banco simulado
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
}
 