package br.com.versaooito.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UsoDoOptional {
	
	public static void main(String[] args) {
		
		Carro carroPelaMarca = getCarroPelaMarca("Ford");
		//if (carroPelaMarca != null) {
		if (Objects.nonNull(carroPelaMarca)) {
			System.out.println(carroPelaMarca.getMarca());
		}
		
		Optional<Carro> optionalCarroPelaMarca = getOptionalCarroPelaMarca("sdf");
		if (optionalCarroPelaMarca.isPresent()) {
			System.out.println(optionalCarroPelaMarca.get().getMarca());
		}
		Carro carroAlternativo = optionalCarroPelaMarca.orElse(new Carro("AUDI"));
		System.out.println(carroAlternativo.getMarca());
		
		Carro carroOuException = optionalCarroPelaMarca.orElseThrow(() -> new IllegalArgumentException("Carro não encontrado"));
		System.out.println(carroOuException.getMarca());
		
		Optional.ofNullable(null);
		Optional.of(null);
	}
	
	public static Carro getCarroPelaMarca(String marca) {
		List<Carro> carros = new ArrayList<>();
		carros.add(new Carro("Ford"));
		carros.add(new Carro("Fiat"));
		
		for (Carro carro : carros) {
			if (carro.getMarca().equals(marca)) {
				return carro;
			}
		}
		
		return null;
	}
	
	public static Optional<Carro> getOptionalCarroPelaMarca(String marca) {
		List<Carro> carros = new ArrayList<>();
		carros.add(new Carro("Ford"));
		carros.add(new Carro("Fiat"));
		
		for (Carro carro : carros) {
			if (carro.getMarca().equals(marca)) {
				return Optional.of(carro);
			}
		}
		
		return Optional.empty();
	}

}

class Carro {
	private String marca;

	public Carro(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}