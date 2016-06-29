package trabalho3;
import java.util.*;

public class Modulos {
	/**
	* Esta fun��o l� os dados dos produtos
	* @param codigo vetor de codigo do produto
	* @param descricao vetor de descricao do produto
	* @param preco vetor de preco do produto
	* @param qestoque vetor de quantidade de produtos no estoque do produto	
	*/
	public static void leitura(String[] codigo,String[] descricao,double[] preco,int[] qestoque){
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en","US"));
		
		
		for(int i=0;i<codigo.length;i++){
			System.out.print("\nEntre com o c�digo do "+(i+1)+"� produto: ");
			codigo[i]=sc.next();
			System.out.print("\nEntre com a descri��o do "+(i+1)+"� produto: ");
			descricao[i]=sc.next();	
			System.out.print("\nEntre com o pre�o do "+(i+1)+"� produto: ");
			preco[i]=sc.nextDouble();
			System.out.print("\nEntre com a quantidade do "+(i+1)+"� produto: ");
			qestoque[i]=sc.nextInt();
		}		
	}
	/**
	* Esta fun��o mostra o menu de op��es 	
	*/
	public static void mostrarMenu() {
		System.out.println("\nMenu de op��es:");
		System.out.print("\n1 � Imprimir tabela");
		System.out.print("\n2 � Pesquisar produto");
		System.out.print("\n4 � Mostrar c�digo e descri��o dos produtos cuja quantidade est� abaixo de 10");
		System.out.print("\n5 � Ativo total do estoque");
		System.out.print("\n6 � Efetuar uma venda");
		System.out.println("\n7 � Sair");
		System.out.print("\nEntre com a op��o desejada: ");
		
		}
	/**
	* Esta fun��o trata o menu de op��es
	* @param op operacao a ser realizada
	* @param codigo vetor de codigo do produto
	* @param descricao vetor de descricao do produto
	* @param preco vetor de preco do produto
	* @param qestoque vetor de quantidade de produtos no estoque do produto			
	*/
	public static void tratarMenu(int op,String[] codigo,String[] descricao,double[] preco,int[] qestoque){		
		if(op==1){
			imprimirTabela(codigo,descricao,preco,qestoque);
		}
		if(op==2){
			pesquisarProduto(codigo,descricao,preco,qestoque);			
		}
		if(op==3){
			mostrarProdutoMaisCaro(codigo,descricao,preco,qestoque);			
		}
		if(op==4){
			mostraEstoqueMenos10(codigo,descricao,qestoque);
		}
		if(op==5){
			ativoTotalEstoque(preco,qestoque);
		}
		if(op==6){
			efetuarVenda(codigo,descricao,preco,qestoque);
		}
		if(op==7){
			System.out.println("Programa finalizado.");			
		}		
	}
	/**
	* Esta fun��o imprime a tabela de produtos
	* @param codigo vetor de codigo do produto
	* @param descricao vetor de descricao do produto
	* @param preco vetor de preco do produto
	* @param qestoque vetor de quantidade de produtos no estoque do produto			
	*/
	public static void imprimirTabela(String[] codigo,String[] descricao,double[] preco,int[] qestoque){		
		for(int i=0;i<codigo.length;i++){
			System.out.print("C�digo: "+codigo[i]+"\t | \tDescri��o: "+descricao[i]+" \t |" );
			System.out.printf("\tPre�o: R$%.2f \t |",preco[i]);
			System.out.println( "\tQuantidade em Estoque: "+qestoque[i]);
		}
	}
	/**
	* Esta fun��o imprime pruduto pesquisado
	* @param codigo vetor de codigo do produto
	* @param descricao vetor de descricao do produto
	* @param preco vetor de preco do produto
	* @param qestoque vetor de quantidade de produtos no estoque do produto			
	*/
	public static void pesquisarProduto(String[] codigo,String[] descricao,double[] preco,int[] qestoque){
		Scanner sc = new Scanner(System.in);
		System.out.print("Insira o codigo do produto:");
		String cod=sc.next();
		int pos=0;
		int cont=0;
		for(int i=0;i<codigo.length;i++){
			if(cod.equals(codigo[i])){
				pos=i;
				cont++;
			}
		}
		if(cont!=0){				
			System.out.print("C�digo: "+codigo[pos]+"\t | \tDescri��o"+descricao[pos]+" \t | ");
			System.out.printf("\tPre�o: R$%.2f ",preco[pos]);
			System.out.println(" \t | Quantidade em Estoque:"+qestoque[pos]+" \t | ");
			System.out.printf("\tValor Total no Estoque: R$%.2f\n",(qestoque[pos]*preco[pos]));
		}
		else{
			System.out.println("C�digo inexistente.");
		}		
	}	
	/**
	* Esta fun��o imprime pruduto mais caro
	* @param codigo vetor de codigo do produto
	* @param descricao vetor de descricao do produto
	* @param preco vetor de preco do produto
	* @param qestoque vetor de quantidade de produtos no estoque do produto			
	*/
	public static void mostrarProdutoMaisCaro(String[] codigo,String[] descricao,double[] preco,int[] qestoque){
		int pos=0;
		for(int i=0;i<preco.length;i++){
			if(preco[i]>preco[pos]){
				pos=i;
			}
		}
		System.out.print("C�digo: "+codigo[pos]+"\t | \tDescri��o"+descricao[pos]+" \t | ");
		System.out.printf("\tPre�o: R$%.2f ",preco[pos]);
		System.out.print(" \t | Quantidade em Estoque:"+qestoque[pos]+" \t | ");
		System.out.printf("\tValor Total no Estoque: R$%.2f\n",(qestoque[pos]*preco[pos]));
		
	}
	/**
	* Esta fun��o imprime produtos com menos de 10 unidades no estoque
	* @param codigo vetor de codigo do produto
	* @param descricao vetor de descricao do produto
	* @param qestoque vetor de quantidade de produtos no estoque do produto			
	*/
	public static void mostraEstoqueMenos10(String[] codigo,String[] descricao,int[] qestoque){
		System.out.println("Quatidade de produtos com menos de 10 unidades no estoque:");
		int cont=0;
		for(int i=0;i<qestoque.length;i++){
			if(qestoque[i]<10){
				System.out.println("C�digo: "+codigo[i]+"\t | \tDescri��o: "+descricao[i]);
					cont++;		
			}
		}
		if(cont==0){
			System.out.println("Nenhum produto com menos de 10 unidades.");
		}
	}
	/**
	* Esta fun��o imprime o total ativo no estoque
	* @param preco vetor de preco do produto
	* @param qestoque vetor de quantidade de produtos no estoque do produto			
	*/
	public static void ativoTotalEstoque(double[] preco,int[] qestoque){
		double te=0;
		for(int i=0;i<preco.length;i++){
			te+=(preco[i]*qestoque[i]);
		}
		System.out.printf("Total Ativo no Estoque: R$%.2f\n", te);
	}
	/**
	* Esta fun��o efetua compras
	* @param codigo vetor de codigo do produto
	* @param descricao vetor de descricao do produto
	* @param preco vetor de preco do produto
	* @param qestoque vetor de quantidade de produtos no estoque do produto			
	*/
	public static void efetuarVenda(String[] codigo,String[] descricao,double[] preco,int[] qestoque){
		Scanner sc = new Scanner(System.in);
		System.out.println("Efetuar Venda:\nEntre com o C�digo do produto:");
		String cod=sc.next();
		int cont=0;
		int pos=0;
		for(int i=0;i<codigo.length;i++){
			if(cod.equals(codigo[i])){
				pos=i;
				cont++;
			}
		}
		if(cont==0){
			System.out.println("C�digo n�o encontrado.");
		}
		else{
			System.out.print("C�digo: "+codigo[pos]+"\t | \tDescri��o"+descricao[pos]+" \t | ");
			System.out.printf("\tPre�o: R$%.2f ",preco[pos]);
			System.out.println(" \t | Quantidade em Estoque:"+qestoque[pos]+" \t | ");
			System.out.println("\nInforme a quantidade de produtos a ser vendida:");
			int qv=sc.nextInt();
			if(qv<=qestoque[pos]){
				qestoque[pos]-=qv;
				System.out.println("Venda efetuada com sucesso.");
			}
			else{
				System.out.println("N�o possuimos essa quantidade em estoque, venda n�o pode ser efetuada.");
			}
		}
		
	}		

}

