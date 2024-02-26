package br.com.versaooito.objects;

import java.util.Objects;

public class UsoDoObjects {

	public static void main(String[] args) {
		
		String palavra = getPalavra();
		// nao é necessário implementar a logica (palavra != null)
		if(Objects.nonNull(palavra)) {
			System.out.println(palavra.length());
		}
			
		
	}
	
	public static String getPalavra() {
		return null;
	}

}
