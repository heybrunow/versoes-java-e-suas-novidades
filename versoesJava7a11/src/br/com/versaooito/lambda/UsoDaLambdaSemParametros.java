package br.com.versaooito.lambda;

import java.util.Arrays;
import java.util.List;

public class UsoDaLambdaSemParametros {

	public static void main(String[] args) {
		//Passada classe 1 com sua implementação da interface
		metodo(new Classe1());
		//Passada classe 2 com sua implementação da interface
		metodo(new Classe2());
		//Classe anonima, implementação da interface se deu diretamente
		metodo(new InterfaceFuncional() {
			@Override
			public void metodo() {
				System.out.println("Chamando metodo a partir da classe anonima");
				
			}
		});
		//usando lambda (->) voce "resume" o código passando a implementação do metodo da interface funcional
		//contanto que use as regras da interface, no caso: nao recebe parametros e devolve void

		metodo(()-> System.out.println("Chamando método através da lambda"));
		
		//passada rapida em uso com e sem parametros (será mais aprofundado na classe UsoDaLambdaComParamaetros)
		//Exemplo do uso com parametros:
		//Sem lambda:
		List<String> nomes = Arrays.asList("Bruno", "Mario");
		System.out.println("==================== foreach comum");
		for (String nome : nomes) {
			System.out.println(nome);
		}
		//com lambda utilizando parametros:
		System.out.println("==================== foreach utilizando lambda");
		nomes.forEach((nome)-> System.out.println(nome));

	}
	
	public static void metodo(InterfaceFuncional interfaceFuncional) {
		interfaceFuncional.metodo();
	}

}
//Interface que só tem um método abstrato é chamada de interface Funcional
@FunctionalInterface
interface InterfaceFuncional {
	void metodo();
}

class Classe1 implements InterfaceFuncional {

	@Override
	public void metodo() {
		System.out.println("Chamando método da classe 1");
		
	}
	
}

class Classe2 implements InterfaceFuncional{
	@Override
	public void metodo() {
		System.out.println("Chamando método da classe 2");
		
	}
}
