package tp1;

import java.util.ArrayList;

public class ConjuntoClientes {
	//Criação do ArrayList de objetos do tipo Cliente
	private static ArrayList<Cliente> listaClientes = new ArrayList<>();
	
	//Adiciona um objeto do tipo Cliente no ArrayList
	public static void adicionar(Cliente cliente) {
		listaClientes.add(cliente);
	}
	
	//Retorna a quantidade de elementos (objetos do tipo Cliente) no ArrayList listaClientes
	public static int quantidadeDeClientes() {
		return listaClientes.size();
	}
	
	//Verifica se o ArrayList listaClientes está vazio ou não e retorna false se estiver 
	//e true se não estiver
	public static boolean temCliente() {
		if (listaClientes.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	//Lista os nomes dos clientes
	public static void imprimeNomes() {
		int i = 1;
		
		System.out.println("LISTA DOS CLIENTES:");
		for (Cliente cliente : listaClientes) {
			System.out.println((i++) + ". " + cliente.listaNome());
		}
	}
	
	//Pesquisa o cliente retornando objeto do tipo Cliente
	//Esse método varre o ArrayList listaClientes e procura qual objeto tem o mesmo
	//nome que o nome digitado pelo usuário e retorna esse objeto (com seus dados). 
	//Se nada for encontrado, retorna null
	public static Cliente pesquisarCliente(String nome) {
		for (Cliente cliente : listaClientes) {
			if(nome.equalsIgnoreCase(cliente.getNome())) {
				return cliente;
			} 
		}
		return null;
	}
}
