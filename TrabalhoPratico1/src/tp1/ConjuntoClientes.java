package tp1;

import java.util.*;

public class ConjuntoClientes {
	//Cria��o do ArrayList de objetos da Classe Cliente
	private static ArrayList<Cliente> listaClientes = new ArrayList<>();
	
	//Adiciona um objeto na lista
	public static void adicionar(Cliente cliente) {
		listaClientes.add(cliente);
	}
	
	//Lista os nomes dos clientes retornando false se o ArrayLis estiver vazio e true se n�o estiver
	public static boolean imprimeNomes() {
		int i = 1;
		
		if (listaClientes.isEmpty()) {
			System.out.println("Ainda n�o foi cadastrado nenhum cliente...");
			System.out.println("===================================================================================================");
			return false;
		} else {
			System.out.println("LISTA DOS CLIENTES:");
			for (Cliente cliente : listaClientes) {
				System.out.println((i++) + ". " + cliente.listaNome());
			}
			return true;
		}
	}
	
	// Pesquisa o cliente retornando objeto
	// Esse m�todo varre o ArrayList listaClientes e procura qual objeto tem o mesmo nome que o nome digitado pelo usu�rio
	// e retorna esse objeto (com seus dados). Se nada for encontrado, retorna null
	//Esse m�todo est� relacionado com o buscaCliente(...);
	public static Cliente pesquisarCliente(String nome) {
		for (Cliente cliente : listaClientes) {
			if(nome.equalsIgnoreCase(cliente.getNome())) {
				return cliente;
			} 
		}
		return null;
	}
}
