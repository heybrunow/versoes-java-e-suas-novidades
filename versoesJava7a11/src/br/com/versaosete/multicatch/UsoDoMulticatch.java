package br.com.versaosete.multicatch;

public class UsoDoMulticatch {
 
	public static void main(String[] args) {
		try {
			System.out.println("lógica do try....................");
		//multi catch
		} catch (NullPointerException | IllegalArgumentException | IllegalStateException e) {
			e.printStackTrace();
			//exceptions especificas tratamento personalizado
		}catch (Exception e) {
			// exception generica tratamento abstrato
		}
	}
}
