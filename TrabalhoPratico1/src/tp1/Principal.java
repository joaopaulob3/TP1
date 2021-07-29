package tp1;

import java.util.*;

/* Nome: João Paulo da Silva Freitas
 * Matrícula: 180019767
 */

public class Principal {

	public static void main(String[] args) {
		//Variáveis
		int opcao = 0;
		
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
				cadastroDeVenda(objProduto, objCliente);
				break;
			case 6: //Mostrar produtos em estoque
				System.out.println();
				mostrarProdutosEmEstoque();
				break;
			case 7: //Sair
				System.out.println("\nVocê optou por encerrar o programa...");
				break;
			default: //Opção inválida
				System.out.println("\n===================================================================================================");
				System.out.println("Digite uma opção válida!");
				System.out.println("===================================================================================================\n");
				break;
			}
		} while(opcao != 7);
	}

	//Métodos
	public static int mostrarMenu() {
		//Declarações
		int opcao = 0;
		
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
		opcao = LerDados.lerInt(opcao);
		
		return opcao;
	}
	
	public static void cadastroCliente(Cliente objCliente) {
		//Declarações
		int quantidade = 0;
		String nome, endereco, telefone;
	
		//Definição da quantidade de clientes a serem cadastrados
		do {
			System.out.println("=========================================================================================================");
			System.out.print(">>>Quantos clientes serão cadastrados? ");
			quantidade = LerDados.lerInt(quantidade);
			//Se o número digitado for 0, partimos do pressuposto que o usuário quer voltar ao menu
			if (quantidade == 0) {
				break;
			} else if (quantidade < 0){
				System.out.println("Digite um número maior que 0!");
			}
		} while (quantidade <= 0);
		System.out.println();
		
		//Definição dos atributos nome, endereço e telefone que serão armazenados no objeto da classe Cliente
		for (int i = 0; i < quantidade; i++) {
			System.out.println("CLIENTE " + (i+1));
			
			System.out.print(">Nome do cliente: ");
			nome = LerDados.lerString();
			
			System.out.print(">Endereço do cliente: ");
			endereco = LerDados.lerString();
			
			System.out.print(">Telefone do cliente (sem espaços): ");
			telefone = LerDados.lerString();
			System.out.println("---------------------------------------------------------------------------------------------------");
			
			//Criação de um novo objeto com construtor a cada iteração
			objCliente = new Cliente(nome, endereco, telefone);
			
			//Adicionando o objeto criado na classe ConjuntoClientes
			ConjuntoClientes.adicionar(objCliente);
		}
		System.out.println("DADOS CADASTRADOS [" + ConjuntoClientes.quantidadeDeClientes() + " clientes no sistema]");
		System.out.println("---------------------------------------------------------------------------------------------------\n");
	}
	
	public static void buscaCliente(Cliente objCliente) {
		//Declarações
		String nome, novoNome, novoEndereco, novoTelefone;
		char opcao = 0;
		boolean temClientes = false;
		
		//Verifica se há cliente cadastrado no sistema, se não houver, será exibida a mensagem das linhas 178-180
		temClientes = ConjuntoClientes.temCliente();
		if (temClientes) {
			//Pesquisa pelo nome do cliente
			System.out.println("=========================================================================================================");
			System.out.print(">>>Qual o nome do cliente? ");
			nome = LerDados.lerString();
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
				opcao = LerDados.lerChar(opcao);
				
				//Altera os dados do cliente
				if (opcao == 'S' || opcao == 's') {
					//Definição dos novos atributos nome, endereço e telefone que serão armazenados no objeto da classe Cliente
					System.out.print("\n>Nome do cliente: ");
					novoNome = LerDados.lerString();
					
					System.out.print(">Endereço do cliente: ");
					novoEndereco = LerDados.lerString();
					
					System.out.print(">Telefone do cliente (sem espaços): ");
					novoTelefone = LerDados.lerString();
					System.out.println("---------------------------------------------------------------------------------------------------");
					
					//Atualização dos dados do objeto
					objCliente.atualizaDados(novoNome, novoEndereco, novoTelefone);
					
					System.out.println("DADOS CADASTRADOS");
					System.out.println("---------------------------------------------------------------------------------------------------");
				}
			} else {
				System.out.println("=========================================================================================================");
				System.out.println("Cliente não encontrado!");
				System.out.println("=========================================================================================================");
			}
		} else {
			System.out.println("=========================================================================================================");
			System.out.println("Cadastre algum cliente antes de prosseguir nessa opção.");
			System.out.println("=========================================================================================================");
		}	
		System.out.println();
	}
	
	public static void cadastroProduto(Produto objProduto) {
		//Declarações
		int quantidade = 0;
		String nome, descricao;
		double valorCompra = 0, porcentagemLucro = 0;
		int quantidadeEstoque = 0;
	
		//Definição da quantidade de produtos a serem cadastrados
		do {
			System.out.println("=========================================================================================================");
			System.out.print(">>>Quantos produtos serão cadastrados? ");
			quantidade = LerDados.lerInt(quantidade);
			//Se o número digitado for 0, partimos do pressuposto que o usuário quer voltar ao menu
			if (quantidade == 0) {
				break;
			} else if (quantidade < 0){
				System.out.println("Digite um número maior que 0!");
			}
		} while (quantidade < 0);
		System.out.println();
		
		//Definição dos atributos nome, descrição, valor da compra, porcentagem do lucro, quantidade no estoque que serão armazenados no objeto da classe Produto
		for (int i = 0; i < quantidade; i++) {
			System.out.println("PRODUTO " + (i+1));
			
			System.out.print(">Nome do produto: ");
			nome = LerDados.lerString();
			
			System.out.print(">Descrição do produto: ");
			descricao = LerDados.lerString();
			
			System.out.print(">Valor de compra: R$");
			valorCompra = LerDados.lerDouble(valorCompra);
			
			System.out.print(">Porcentagem de lucro: ");
			porcentagemLucro = LerDados.lerDouble(porcentagemLucro);
			
			System.out.print(">Quantidade em estoque: ");
			quantidadeEstoque = LerDados.lerInt(quantidadeEstoque);
			System.out.println("---------------------------------------------------------------------------------------------------");
			
			//Criação de um novo objeto com construtor a cada iteração
			objProduto = new Produto(nome, descricao, valorCompra, porcentagemLucro, quantidadeEstoque);
			
			//Adicionando o objeto criado na classe ConjuntoProdutos
			ConjuntoProdutos.adicionar(objProduto);
		}
		System.out.println("DADOS CADASTRADOS [" + ConjuntoProdutos.quantidadeDeProdutos() + " produtos no sistema]");
		System.out.println("---------------------------------------------------------------------------------------------------\n");
	}
	
	public static void buscaProduto(Produto objProduto) {
		//Declarações
		String nome, novoNome, novaDescricao;
		double novoValorCompra = 0, novaPorcentagemLucro = 0;
		int novaQuantidadeEstoque = 0;
		char opcao = 0;
		boolean temProdutos = false;

		//Verifica se há produto cadastrado no sistema, se não houver, será exibida a mensagem das linhas 298-300
		temProdutos = ConjuntoProdutos.temProduto();
		if (temProdutos) {
			//Pesquisa pelo nome do produto
			System.out.println("=========================================================================================================");
			System.out.print(">>>Qual o nome do produto? ");
			nome = LerDados.lerString();
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
				opcao = LerDados.lerChar(opcao);
				
				//Altera os dados do produto
				if (opcao == 'S' || opcao == 's') {
					//Definição dos novos atributos nome, endereço e telefone que serão armazenados no objeto da classe Cliente
					System.out.print("\n>Nome do produto: ");
					novoNome = LerDados.lerString();
					
					System.out.print(">Descrição do produto: ");
					novaDescricao = LerDados.lerString();
					
					System.out.print(">Valor de compra: R$");
					novoValorCompra = LerDados.lerDouble(novoValorCompra);
					
					System.out.print(">Porcentagem de lucro: ");
					novaPorcentagemLucro = LerDados.lerDouble(novaPorcentagemLucro);
					
					System.out.print("Quantidade em estoque: ");
					novaQuantidadeEstoque = LerDados.lerInt(novaQuantidadeEstoque);
					System.out.println("---------------------------------------------------------------------------------------------------");
					
					//Atualização dos dados do objeto
					objProduto.atualizaDados(novoNome, novaDescricao, novoValorCompra, novaPorcentagemLucro, novaQuantidadeEstoque);
					
					System.out.println("DADOS CADASTRADOS");
					System.out.println("---------------------------------------------------------------------------------------------------");
				}
			} else {
				System.out.println("=========================================================================================================");
				System.out.println("Produto não encontrado!");
				System.out.println("=========================================================================================================");
			}
		} else {
			System.out.println("=========================================================================================================");
			System.out.println("Cadastre algum produto antes de prosseguir nessa opção.");
			System.out.println("=========================================================================================================");
		}
		System.out.println();
	}
	
	public static void cadastroDeVenda(Produto objProduto, Cliente objCliente) {
		//Declarações
		String nomeCliente;
		String nomeProduto;
		int quantidade = 0;
		boolean temClientes = false;
		boolean temProdutos = false;
		
		//Verifica se há cliente E produto cadastrado no sistema
		temClientes = ConjuntoClientes.temCliente();
		temProdutos = ConjuntoProdutos.temProduto();
		
		//Esse método (cadastroDeVenda()) só será executado se houver cliente E produto cadastrado no sistema
		//Caso contrário, mostra a mensagem das linhas 398-400
		if (temClientes && temProdutos) {
			//Lista os nomes dos clientes
			System.out.println("===================================================================================================");
			ConjuntoClientes.imprimeNomes();
			
			//Pede para o usuário digitar o nome a ser trabalhado
			System.out.println("===================================================================================================");
			System.out.print(">Digite o nome do cliente: ");
			nomeCliente = LerDados.lerString();
			
			//O nome do cliente será pesquisado e comparado com algum cliente que já exista no sistema
			//O objeto contendo os atributos é resgatado aqui
			objCliente = ConjuntoClientes.pesquisarCliente(nomeCliente);
			
			//Se o nome digitado bater com algum nome já no sistema, significa que o objCliente é diferente de null e podemos prosseguir
			//Caso contrário o programa retorna a mensagem das linhas 392-395
			if (objCliente != null) {
				//Lista os nomes dos produtos
				System.out.println("===================================================================================================");
				ConjuntoProdutos.imprimeNomes();
				
				//Pede para o usuário digitar o nome a ser trabalhado
				System.out.println("===================================================================================================");
				System.out.print(">>>Digite o nome do produto: ");
				nomeProduto = LerDados.lerString();
				
				//O nome do produto será pesquisado e comparado com algum produto que já exista no sistema
				//O objeto contendo os atributos é resgatado aqui
				objProduto = ConjuntoProdutos.pesquisarProduto(nomeProduto);
				
				//Se o nome digitado bater com algum nome já no sistema, significa que o objProduto é diferente de null e podemos prosseguir
				//Caso contrário, o programa retorna a mesagem das linhas 386-389
				if (objProduto != null) {
					do {				
						//Pede para o usuário digitar a quantidade do produto se ele for encontrado
						System.out.println("Quantidade no estoque: " + objProduto.getQuantidadeEstoque());
						System.out.println("=========================================================================================================");
						System.out.print(">>>Quanto do produto " + nomeProduto + " será levado? ");
						quantidade = LerDados.lerInt(quantidade);
						
						//Se a quantidade digitada for negativa, o programa continuará perguntando a quantidade
						if (quantidade == 0) {
							break;
						} else {
							if (quantidade < 0) {
								System.out.println("=========================================================================================================");
								System.out.println("Digite um valor maior que 0!");
								System.out.println("=========================================================================================================");
							} else {
								//Se a quantidade digitada for maior que a quantidade de produto no estoque será exibida uma mensagem
								//avisando que o valor digitado é maior que a quantidade em estoque do produto e o programa continuará
								//perguntando a quantidade. Caso contrário, o programa irá retirar a quantidade digitada do produto do estoque
								if (quantidade > objProduto.getQuantidadeEstoque()) {
									System.out.println("=========================================================================================================");
									System.out.println("A quantidade digitada é maior que a quantidade no estoque.");
									System.out.println("=========================================================================================================");
								} else {
									objProduto.setQuantidadeEstoque(objProduto.getQuantidadeEstoque() - quantidade);
									System.out.println("===================================================================================================");
									System.out.println("Quantidade em estoque desse produto: " + objProduto.getQuantidadeEstoque());
									System.out.println("===================================================================================================");
									break;
								}
							}
						}
					//O loop permanecerá até o usuário digitar uma quantidade maior que zero e um valor que não ultrapasse a quantidade 
					//em estoque do produto
					} while (quantidade <= 0 || quantidade > objProduto.getQuantidadeEstoque() );
				} else {
					System.out.println("===================================================================================================");
					System.out.println("O nome digitado não foi encontrado.");
					System.out.println("Tente novamente.");
					System.out.println("===================================================================================================");
				}
			} else {
				System.out.println("===================================================================================================");
				System.out.println("O nome digitado não foi encontrado.");
				System.out.println("Tente novamente.");
				System.out.println("===================================================================================================");
			}
		} else {
			System.out.println("===================================================================================================");
			System.out.println("Você precisa ter cliente E produto cadastrado no sistema!");
			System.out.println("===================================================================================================");
		}
		System.out.println();
	}
	
	public static void mostrarProdutosEmEstoque() {
		//Varre o ArrayList de produtos e mostra os produtos no estoque com suas respectivas quantidades
		System.out.println("===================================================================================================");
		ConjuntoProdutos.impressaoNomesEstoque();
		System.out.println();
	}
}
