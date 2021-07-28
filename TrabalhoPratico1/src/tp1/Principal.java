package tp1;

import java.util.*;

/* Nome: João Paulo da Silva Freitas
 * Matrícula: 180019767
 */

public class Principal {

	public static void main(String[] args) {
		//Variáveis
		int opcao;
		
		//Referência para a classe Cliente
		Cliente objCliente = null;
		
		//Referência para a classe Produto
		Produto objProduto = null;
		
		do {
			opcao = mostrarMenu();
			switch (opcao) {
			case 1: //Cadastro de novo cliente
				System.out.println();
				cadastroCliente(objCliente);
				break;
			case 2: //Busca por cliente
				System.out.println();
				buscaCliente(objCliente);
				break;
			case 3: //Cadastro de novo produto
				System.out.println();
				cadastroProduto(objProduto);
				break;
			case 4: //Busca por produto
				System.out.println();
				buscaProduto(objProduto);
				break;
			case 5: //Cadastro de venda
				System.out.println();
				cadastroDeVenda();
				break;
			case 6: //Mostrar produtos em estoque
				System.out.println();
				mostrarProdutosEmEstoque();
				break;
			case 7: //Sair
				System.out.println("\nVocê optou por encerrar o programa...");
				break;
			default: //Opção inválida
				System.out.println("===================================================================================================");
				System.out.println("Digite uma opção válida!");
				System.out.println("===================================================================================================\n");
				break;
			}
		} while(opcao != 7);
	}

	//Métodos
	public static int mostrarMenu() {
		//Declarações
		int opcao;
		Scanner leitor = new Scanner(System.in);
		
		//Menu
		System.out.println("|==============TP1===============|");
		System.out.println("|[1] Cadastro de novo cliente    |");
		System.out.println("|[2] Busca por cliente           |");
		System.out.println("|[3] Cadastro de novo produto    |");
		System.out.println("|[4] Busca por produto           |");
		System.out.println("|[5] Cadastro de venda           |");
		System.out.println("|[6] Mostrar produtos em estoque |");
		System.out.println("|[7] Sair                        |");
		System.out.println("|================================|");
		System.out.print(">>>Sua opção: ");
		opcao = leitor.nextInt();
		
		return opcao;
	}
	
	public static void cadastroCliente(Cliente objCliente) {
		//Declarações
		int quantidade = 0;
		String nome, endereco, telefone;
		Scanner leitor = new Scanner(System.in);
		Scanner leitorString = new Scanner(System.in);
	
		//Definição da quantidade de clientes a serem cadastrados
		do {
			System.out.println("=========================================================================================================");
			System.out.print(">>>Quantos clientes serão cadastrados? ");
			quantidade = leitor.nextInt();
			if (quantidade <= 0) {
				System.out.println("Digite um número maior que 0!");
			}
		} while (quantidade <= 0);
		System.out.println();
		
		//Definição dos atributos nome, endereço e telefone que serão armazenados no objeto da classe Cliente
		for (int i = 0; i < quantidade; i++) {
			System.out.println("CLIENTE " + (i+1));
			
			System.out.print(">Nome do cliente: ");
			nome = leitorString.nextLine();
			
			System.out.print(">Endereço do cliente: ");
			endereco = leitorString.nextLine();
			
			System.out.print(">Telefone do cliente (sem espaços): ");
			telefone = leitorString.next();
			leitorString.nextLine();
			System.out.println("---------------------------------------------------------------------------------------------------");
			
			//Criação de um novo objeto com construtor a cada iteração
			objCliente = new Cliente(nome, endereco, telefone);
			
			//Adicionando o objeto criado na classe ConjuntoClientes
			ConjuntoClientes.adicionar(objCliente);
		}
		System.out.println("DADOS CADASTRADOS [" + quantidade + " clientes]");
		System.out.println("---------------------------------------------------------------------------------------------------\n");
	}
	
	public static void buscaCliente(Cliente objCliente) {
		//Declarações
		String nome, novoNome, novoEndereco, novoTelefone;
		char opcao;
		Scanner leitor = new Scanner(System.in);
		Scanner leitorString = new Scanner(System.in);
		
		//Pesquisa pelo nome do cliente
		System.out.println("=========================================================================================================");
		System.out.print(">>>Qual o nome do cliente? ");
		nome = leitorString.nextLine();
		System.out.println();
		
		//Busca o nome do cliente na classe ConjuntoClientes e resgata apenas o objeto com mesmo nome digitado pelo usuário
		objCliente = ConjuntoClientes.pesquisarCliente(nome);
		
		//Lista os dados do objeto cliente resgatado
		if (objCliente != null) {
			System.out.println("=========================================================================================================");
			System.out.println("Esse cliente está cadastrado!");
			System.out.println("Seus dados são:\n");
			System.out.println(objCliente.listagemDados());
			System.out.println("=========================================================================================================");
			
			System.out.print(">>>Deseja alterar os dados desse cliente? [S/N]: ");
			opcao = leitor.next().charAt(0);
			
			//Altera os dados do cliente
			if (opcao == 'S' || opcao == 's') {
				//Definição dos novos atributos nome, endereço e telefone que serão armazenados no objeto da classe Cliente
				System.out.print("\n>Nome do cliente: ");
				novoNome = leitorString.nextLine();
				
				System.out.print(">Endereço do cliente: ");
				novoEndereco = leitorString.nextLine();
				
				System.out.print(">Telefone do cliente (sem espaços): ");
				novoTelefone = leitorString.next();
				leitorString.nextLine();
				System.out.println("---------------------------------------------------------------------------------------------------");
				
				//Atualização dos dados do objeto
				objCliente.atualizaDados(novoNome, novoEndereco, novoTelefone);
				
				System.out.println("DADOS CADASTRADOS");
				System.out.println("---------------------------------------------------------------------------------------------------");
			}
		} else {
			System.out.println("Cliente não encontrado!");
		}
		System.out.println();
	}
	
	public static void cadastroProduto(Produto objProduto) {
		//Declarações
		int quantidade = 0;
		String nome, descricao;
		double valorCompra, porcentagemLucro;
		int quantidadeEstoque;
		Scanner leitor = new Scanner(System.in);
		Scanner leitorString = new Scanner(System.in);
		
		//Definição da quantidade de produtos a serem cadastrados
		do {
			System.out.println("=========================================================================================================");
			System.out.print(">>>Quantos produtos serão cadastrados? ");
			quantidade = leitor.nextInt();
			if (quantidade <= 0) {
				System.out.println("Digite um número maior que 0!");
			}
		} while (quantidade == 0);
		System.out.println();
		
		//Definição dos atributos nome, descrição, valor da compra, porcentagem do lucro, quantidade no estoque que serão armazenados no objeto da classe Produto
		for (int i = 0; i < quantidade; i++) {
			System.out.println("PRODUTO " + (i+1));
			
			System.out.print(">Nome do produto: ");
			nome = leitorString.nextLine();
			
			System.out.print(">Descrição do produto: ");
			descricao = leitorString.nextLine();
			
			System.out.print(">Valor de compra: R$");
			valorCompra = leitor.nextDouble();
			
			System.out.print(">Porcentagem de lucro: ");
			porcentagemLucro = leitor.nextDouble();
			
			System.out.print(">Quantidade em estoque: ");
			quantidadeEstoque = leitor.nextInt();
			System.out.println("---------------------------------------------------------------------------------------------------");
			
			//Criação de um novo objeto com construtor a cada iteração
			objProduto = new Produto(nome, descricao, valorCompra, porcentagemLucro, quantidadeEstoque);
			
			//Adicionando o objeto criado na classe ConjuntoProdutos
			ConjuntoProdutos.adicionar(objProduto);
		}
		System.out.println("DADOS CADASTRADOS [" + quantidade + " produtos]");
		System.out.println("---------------------------------------------------------------------------------------------------\n");
	}
	
	public static void buscaProduto(Produto objProduto) {
		//Declarações
		String nome, novoNome, novaDescricao;
		double novoValorCompra, novaPorcentagemLucro;
		int novaQuantidadeEstoque;
		char opcao;
		Scanner leitor = new Scanner(System.in);
		Scanner leitorString = new Scanner(System.in);
		
		//Pesquisa pelo nome do produto
		System.out.println("=========================================================================================================");
		System.out.print(">>>Qual o nome do produto? ");
		nome = leitorString.nextLine();
		System.out.println();
		
		//Busca o nome do produto na classe ConjuntoProdutos e resgata apenas o objeto com mesmo nome digitado pelo usuário
		objProduto = ConjuntoProdutos.pesquisarProduto(nome);
		
		//Lista os dados do objeto produto resgatado
		if (objProduto != null) {
			System.out.println("=========================================================================================================");
			System.out.println("Esse produto está cadastrado!");
			System.out.println("Seus dados são:\n");
			System.out.println(objProduto.listagemDados());
			System.out.println("=========================================================================================================");
			
			System.out.print(">>>Deseja alterar os dados desse produto? [S/N]: ");
			opcao = leitor.next().charAt(0);
			
			//Altera os dados do produto
			if (opcao == 'S' || opcao == 's') {
				//Definição dos novos atributos nome, endereço e telefone que serão armazenados no objeto da classe Cliente
				System.out.print("\n>Nome do produto: ");
				novoNome = leitorString.nextLine();
				
				System.out.print(">Descrição do produto: ");
				novaDescricao = leitorString.nextLine();
				
				System.out.print(">Valor de compra: R$");
				novoValorCompra = leitor.nextDouble();
				
				System.out.print(">Porcentagem de lucro: ");
				novaPorcentagemLucro = leitor.nextDouble();
				
				System.out.print("Quantidade em estoque: ");
				novaQuantidadeEstoque = leitor.nextInt();
				System.out.println("---------------------------------------------------------------------------------------------------");
				
				//Atualização dos dados do objeto
				objProduto.atualizaDados(novoNome, novaDescricao, novoValorCompra, novaPorcentagemLucro, novaQuantidadeEstoque);
				
				System.out.println("DADOS CADASTRADOS");
				System.out.println("---------------------------------------------------------------------------------------------------");
			}
		} else {
			System.out.println("Produto não encontrado!");
		}
		System.out.println();
	}
	
	public static void cadastroDeVenda() {
		//Declarações
		String nomeCliente, nomeProduto;
		Scanner leitorString = new Scanner(System.in);
		boolean verificaClientes, verificaProdutos;
		
		//Lista os nomes (se houver)
		System.out.println("===================================================================================================");
		verificaClientes = ConjuntoClientes.imprimeNomes();
		
		//Pede para o usuário digitar o nome a ser trabalhado apenas se houver cliente cadastrado
		if (verificaClientes) {
			System.out.println("===================================================================================================");
			System.out.print("Digite o nome de um cliente: ");
			nomeCliente = leitorString.nextLine();
		}
		
		//Lista os produtos (se houver)
		System.out.println("===================================================================================================");
		verificaProdutos = ConjuntoProdutos.imprimeNomes();
		
		//Pede para o usuário digitar o nome a ser trabalhado apenas se houver produto cadastrado
		if (verificaProdutos) {
			System.out.println("===================================================================================================");
			System.out.print("Digite o nome de um produto: ");
			nomeProduto = leitorString.nextLine();
		}
		System.out.println();
	}
	
	public static void mostrarProdutosEmEstoque() {
		System.out.println("===================================================================================================");
		ConjuntoProdutos.impressao();
		System.out.println();
	}
}
