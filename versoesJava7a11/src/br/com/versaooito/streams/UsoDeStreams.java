package br.com.versaooito.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsoDeStreams {

	public static void main(String[] args) {
		
		List<Time> times = new ArrayList<>();
		
		times.add(new Time("Flamengo", 9, true));
		times.add(new Time("Corinthians", 7, true));
		times.add(new Time("Gremio", 5, true));
		times.add(new Time("Palmeiras", 12, false));
		times.add(new Time("São Paulo", 6, true));
		
		//Maneira antes das streams para percorrer uma coleção e filtrar informações:
		
		Time primeiroSemMundial = null;
		
		for (Time time : times) {
			if(!time.isCampeaoMundial()) {
				primeiroSemMundial = time;
			}
		}
		System.out.println(primeiroSemMundial.getNome());
		//Exemplo utlizando stream
		String nomePrimeiroSemMundial = times.stream().filter(time -> !time.isCampeaoMundial()).findFirst().get().getNome();
		System.out.println(nomePrimeiroSemMundial);
		
		//Stream é um fluxo de dados no qual você pode executar diversas operações apartir do .stream().
		//Operações podem ser intermediarias ou ações finais.
		Stream<Time> stream = times.stream();
		
		//a operação filter é intermediaria, ela retorna o stream e voce pode continuar chamando mais operações a partir dela
		times.stream().filter(time -> !time.isCampeaoMundial()).filter(time -> !time.isCampeaoMundial());
		
		//a operação foreach e a findFirst é uma operação final, nao permmite chamar mais operações a partir dela
		times.stream().forEach(time -> System.out.println(time.getNome()));
		
		
		String nomePrimeiroTimeComMundial = times.stream().filter(time -> time.isCampeaoMundial()).findFirst().get().getNome();
		
		times.stream()
		.filter(time -> time.getQtdTitulos() > 8)
		.forEach(time -> System.out.println(time.getNome()));
		
		// map passou parametro retornou o que precisava e coletou para uma lista
		times.stream().map(time -> {
			return time.getNome();
		}).collect(Collectors.toList()).forEach(time -> System.out.println(time));
	
	
	}
	
	
}

	class Time{
		
		private String nome;
		
		private int qtdTitulosBrasileiros;
		
		private boolean campeaoMundial;

		public Time(String nome, int qtdTitulosBrasileiros, boolean campeaoMundial) {
			this.nome = nome;
			this.qtdTitulosBrasileiros = qtdTitulosBrasileiros;
			this.campeaoMundial = campeaoMundial;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getQtdTitulos() {
			return qtdTitulosBrasileiros;
		}

		public void setQtdTitulos(int qtdTitulos) {
			this.qtdTitulosBrasileiros = qtdTitulos;
		}

		public boolean isCampeaoMundial() {
			return campeaoMundial;
		}

		public void setCampeaoMundial(boolean temMundial) {
			this.campeaoMundial = temMundial;
		}
	
	
	}

