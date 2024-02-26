package br.com.versaooito.lambda;
 
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
 
public class UsoDaLambdaComUmParametro {
	public static void main(String[] args) {
		//Iterando e imprimindo lista sem lambda
		List<String> herois = Arrays.asList("Jaspion", "Chengeman", "Jiraya");
		for (String heroi : herois) {
			System.out.println(heroi);
		}
		//Iterando e inprimindo lista com lambda
		herois.forEach(h -> System.out.println(h));

		
		metodo("Bruno", s -> imprime(s));
		
	}
	//Consumer recebe um parametro e perfomar uma operação em cima dele
	//consumer executa o accept (metodo da interface funcional que vc passar))
	public static void metodo(String s, Consumer<String> consumerString) {
		consumerString.accept(s);
	}
	public static void imprime(String s) {
		s = s.toUpperCase();
		System.out.println(s);
	}
}