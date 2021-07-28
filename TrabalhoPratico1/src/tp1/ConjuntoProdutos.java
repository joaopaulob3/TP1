package tp1;

import java.util.*;

public class ConjuntoProdutos {
	
	//Criação do ArrayList de objetos da classe Produto
	private static ArrayList<Produto> listaProdutos = new ArrayList<>();
	
	//Adiciona um objeto na lista
	public static void adicionar(Produto p) {
		listaProdutos.add(p);
	}
	
	//Retorna a quantidade de elementos (objetos do tipo Produto) no ArrayList listaProdutos
	public static int quantidadeDeProdutos() {
		return listaProdutos.size();
	}
		
	//Verifica se o ArrayList listaProdutos está vazio ou não e retorna false se estiver e true se não estiver
	public static boolean temProduto() {
		if (listaProdutos.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	//Lista apenas os nomes dos produtos
	public static void imprimeNomes() {
		int i = 1;
				
		System.out.println("LISTA DOS PRODUTOS:");
		for (Produto produto : listaProdutos) {
			System.out.println((i++) + ". " + produto.listaNome());
		}
	}
		
	//Lista os nomes dos produtos e a quantidade em estoque
	public static void impressaoNomesEstoque() {
		int i = 1;
		
		//Verifica se o ArrayList está vazio ou não e imprime os dados na tela
		if (listaProdutos.isEmpty()) {
			System.out.println("Ainda não foi cadastrado nenhum produto...");
			System.out.println("===================================================================================================");
		} else {
			for (Produto produto : listaProdutos) {
				System.out.println("PRODUTO " + (i++) + ":");
				System.out.print(produto.listaNomeEstoque());
				System.out.print("----------------------------------------------------------------------------------------------------");
				System.out.println();
			}
		}
	}
	
	// Pesquisa o produto retornando objeto
	// Esse método varre o ArrayList listaProdutos e procura qual objeto tem o mesmo nome que o nome digitado pelo usuário
	// e retorna esse objeto (com seus dados). Se nada for encontrado, retorna null
	public static Produto pesquisarProduto(String nome) {
		for (Produto produto : listaProdutos) {
			if (nome.equalsIgnoreCase(produto.getNome())) {
				return produto;
			}
		}
		return null;
	}
}
