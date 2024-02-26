package br.com.versaosete.trywithresourcers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class UsoDoTryWithResources {

	public static void main(String[] args) {

		try(PrintStream printArquivo1 = new PrintStream(new File("arquivo.txt")); 
				PrintStream printArquivo2 = new PrintStream(new File("arquivo.txt"));) {
			System.out.println("logica critica ......");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			//printArquivo1.close();
			//printArquivo2.close();
			//nao é necessário fechar os prints  com print.close(); pois o proprio try com recurso gerencia
			//independente de ter lançado excceção no try ele sempre fecha o recurso utilizado.
			//Apenas recuros que implementam a interface Closeable (faz uso do metodo .close())
		}

	}
}
