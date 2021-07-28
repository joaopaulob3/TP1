package tp1;

import java.util.*;

public class ConjuntoProdutos {
	//Criação do ArrayList de objetos da classe Produto
	private static ArrayList<Produto> listaProdutos = new ArrayList<>();
	
	//Adiciona um objeto na lista
	public static void adicionar(Produto p) {
		listaProdutos.add(p);
	}
	
	//Lista os produtos e a quantidade em estoque
	public static void impressao() {
		int i = 1;
		
		//Verifica se o ArrayList está vazio ou não e imprime os dados na tela
		if (listaProdutos.isEmpty()) {
			System.out.println("Ainda não foi cadastrado nenhum produto...");
			System.out.println("===================================================================================================");
		} else {
			for (Produto produto : listaProdutos) {
				System.out.println("PRODUTO " + (i++) + ":");
				System.out.print(produto.listaEstoque());
				System.out.print("----------------------------------------------------------------------------------------------------");
				System.out.println();
			}
		}
	}
	
	//Lista os nomes dos produtos
	public static boolean imprimeNomes() {
		int i = 1;
			
		if (listaProdutos.isEmpty()) {
			System.out.println("Ainda não foi cadastrado nenhum produto...");
			System.out.println("===================================================================================================");
			return false;
		} else {
			System.out.println("LISTA DOS PRODUTOS:");
			for (Produto produto : listaProdutos) {
				System.out.println((i++) + ". " + produto.listaNome());
			}
			return true;
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
