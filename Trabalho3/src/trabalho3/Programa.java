package trabalho3;
import java.util.*;

public class Programa {
	
	
	public static void main(String args[]){		
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en","US"));		
		System.out.print("Digite a quantidade de produtos a serem digitados:");
		int N=sc.nextInt();	
		String codigo[]=new String[N];
		String descricao[]=new String[N];
		double preco[]=new double[N];
		int qestoque[]=new int[N];		
		Modulos.leitura(codigo,descricao,preco,qestoque);
		int a=0;
		while(a!=7){
			Modulos.mostrarMenu();
			a=sc.nextInt();
			Modulos.tratarMenu(a,codigo,descricao,preco,qestoque);
		}		
		sc.close();
	}
}
