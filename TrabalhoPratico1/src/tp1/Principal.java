package tp1;

import java.util.*;

/* Nome: Jo�o Paulo da Silva Freitas
 * Matr�cula: 180019767
 */

public class Principal {

	public static void main(String[] args) {
		//Vari�veis
		int opcao = 0;
		char escolha = 'n';
		
		//Refer�ncia para a classe Cliente
		Cliente objCliente = null;
		
		//Refer�ncia para a classe Produto
		Produto objProduto = null;
		
		//Instanciando e inicializando 10 clientes
		Cliente c1 = new Cliente("Adriano Mendes", "Rua 1", "63123123123");
		ConjuntoClientes.adicionar(c1);
		Cliente c2 = new Cliente("Jefferson Laatus", "Rua 2", "23423412312");
		ConjuntoClientes.adicionar(c2);
		Cliente c3 = new Cliente("Andr� Machado", "Rua 3", "37123123123");
		ConjuntoClientes.adicionar(c3);
		Cliente c4 = new Cliente("Stormer", "Rua 4", "23612312311");
		ConjuntoClientes.adicionar(c4);
		Cliente c5 = new Cliente("Luan Aral", "Rua 5", "5122312312311");
		ConjuntoClientes.adicionar(c5);
		Cliente c6 = new Cliente("Alexandre Freitas", "Rua 6", "2331231232");
		ConjuntoClientes.adicionar(c6);
		Cliente c7 = new Cliente("Carlos Massa", "Rua 7", "234242434234");
		ConjuntoClientes.adicionar(c7);
		Cliente c8 = new Cliente("Pamela Silva", "Rua 8", "99933123123");
		ConjuntoClientes.adicionar(c8);
		Cliente c9 = new Cliente("Cristina Souza", "Rua 9", "28937472411");
		ConjuntoClientes.adicionar(c9);
		Cliente c10 = new Cliente("Lucas Ferreira", "Rua 10", "1923912939000");
		ConjuntoClientes.adicionar(c10);
		
		//Instanciando e inicializando 10 produtos
		Produto p1 = new Produto("Carne", "carne", 10, 10, 10);
		ConjuntoProdutos.adicionar(p1);
		Produto p2 = new Produto("Abacate", "abacate", 15, 15, 15);
		ConjuntoProdutos.adicionar(p2);
		Produto p3 = new Produto("Ovos", "ovos", 12, 12, 12);
		ConjuntoProdutos.adicionar(p3);
		Produto p4 = new Produto("Arroz", "arroz", 10, 10, 10);
		ConjuntoProdutos.adicionar(p4);
		Produto p5 = new Produto("Feij�o", "feij�o", 8, 8, 8);
		ConjuntoProdutos.adicionar(p5);
		Produto p6 = new Produto("Batata", "batata", 20, 20, 20);
		ConjuntoProdutos.adicionar(p6);
		Produto p7 = new Produto("Papel higi�nico", "papel higi�nico", 30, 30, 30);
		ConjuntoProdutos.adicionar(p7);
		Produto p8 = new Produto("Amaciante", "amaciante", 5, 5, 5);
		ConjuntoProdutos.adicionar(p8);
		Produto p9 = new Produto("Sab�o em p�", "sab�o em p�", 18, 18, 18);
		ConjuntoProdutos.adicionar(p9);
		Produto p10 = new Produto("Iorgute", "iorgute", 12, 12, 12);
		ConjuntoProdutos.adicionar(p10);
		
		//Executa o menu e os m�todos da main enquanto o usu�rio n�o digita 7 e confirma a sa�da do programa
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
				escolha = sair();
				break;
			default: //Op��o inv�lida
				System.out.println("\n===================================================================================================");
				System.out.println("Digite uma op��o v�lida!");
				System.out.println("===================================================================================================\n");
				break;
			}
		} while(opcao != 7 && escolha != 'n' || escolha != 'N');
	}

	//M�todos
	public static int mostrarMenu() {
		//Declara��es
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
		System.out.print(">>>Sua op��o: ");
		opcao = LerDados.lerInt(opcao);
		
		return opcao;
	}
	
	public static void cadastroCliente(Cliente objCliente) {
		//Declara��es
		int quantidade = 0;
		String nome, endereco, telefone;
	
		//Defini��o da quantidade de clientes a serem cadastrados
		do {
			System.out.println("=========================================================================================================");
			System.out.print(">>>Quantos clientes ser�o cadastrados? ");
			quantidade = LerDados.lerInt(quantidade);
			//Se o n�mero digitado for 0, partimos do pressuposto que o usu�rio quer voltar ao menu
			//Se for menor que 0, mostra a mensagem da linha 142
			if (quantidade == 0) {
				break;
			} else if (quantidade < 0){
				System.out.println("Digite um n�mero maior que 0!");
			}
		} while (quantidade <= 0);
		System.out.println();
		
		//Defini��o dos atributos nome, endere�o e telefone que ser�o armazenados no objeto da classe Cliente
		for (int i = 0; i < quantidade; i++) {
			System.out.println("CLIENTE " + (i+1));
			
			System.out.print(">Nome do cliente: ");
			nome = LerDados.lerString();
			
			System.out.print(">Endere�o do cliente: ");
			endereco = LerDados.lerString();
			
			System.out.print(">Telefone do cliente (sem espa�os): ");
			telefone = LerDados.lerString();
			System.out.println("---------------------------------------------------------------------------------------------------");
			
			//Cria��o de um novo objeto com construtor a cada itera��o
			objCliente = new Cliente(nome, endereco, telefone);
			
			//Adicionando o objeto criado na classe ConjuntoClientes
			ConjuntoClientes.adicionar(objCliente);
		}
		//Mostra que os dados foram cadastrados e a quantidade de clientes no sistema
		System.out.println("DADOS CADASTRADOS [" + ConjuntoClientes.quantidadeDeClientes() + " clientes no sistema]");
		System.out.println("---------------------------------------------------------------------------------------------------\n");
	}
	
	public static void buscaCliente(Cliente objCliente) {
		//Declara��es
		String nome, novoNome, novoEndereco, novoTelefone;
		char opcao = 0;
		boolean temClientes = false;
		
		//Verifica se h� cliente cadastrado no sistema, se n�o houver, ser� exibida a mensagem das linhas 230-232
		temClientes = ConjuntoClientes.temCliente();
		if (temClientes) {
			//Lista os nomes dos clientes
			System.out.println("=========================================================================================================");
			ConjuntoClientes.imprimeNomes();
			System.out.println("=========================================================================================================");
			
			//Pesquisa pelo nome do cliente
			System.out.print(">>>Qual o nome do cliente? ");
			nome = LerDados.lerString();
			System.out.println();
			
			//Busca o nome do cliente na classe ConjuntoClientes e resgata apenas o objeto com mesmo nome digitado pelo usu�rio
			objCliente = ConjuntoClientes.pesquisarCliente(nome);
			
			//Lista os dados do objeto cliente resgatado
			if (objCliente != null) {
				System.out.println("=========================================================================================================");
				System.out.println("Esse cliente est� cadastrado!");
				System.out.println("Seus dados s�o:\n");
				System.out.println(objCliente.listagemDados());
				System.out.println("=========================================================================================================");
				
				System.out.print(">>>Deseja alterar os dados desse cliente? [S/N]: ");
				opcao = LerDados.lerChar(opcao);
				
				//Altera os dados do cliente
				if (opcao == 'S' || opcao == 's') {
					//Defini��o dos novos atributos nome, endere�o e telefone que ser�o armazenados no objeto da classe Cliente
					System.out.print("\n>Nome do cliente: ");
					novoNome = LerDados.lerString();
					
					System.out.print(">Endere�o do cliente: ");
					novoEndereco = LerDados.lerString();
					
					System.out.print(">Telefone do cliente (sem espa�os): ");
					novoTelefone = LerDados.lerString();
					System.out.println("---------------------------------------------------------------------------------------------------");
					
					//Atualiza��o dos dados do objeto
					objCliente.atualizaDados(novoNome, novoEndereco, novoTelefone);
					
					System.out.println("DADOS CADASTRADOS");
					System.out.println("---------------------------------------------------------------------------------------------------");
				}
			} else {
				System.out.println("=========================================================================================================");
				System.out.println("Cliente n�o encontrado!");
				System.out.println("=========================================================================================================");
			}
		} else {
			System.out.println("=========================================================================================================");
			System.out.println("Cadastre algum cliente antes de prosseguir nessa op��o.");
			System.out.println("=========================================================================================================");
		}	
		System.out.println();
	}
	
	public static void cadastroProduto(Produto objProduto) {
		//Declara��es
		int quantidade = 0;
		String nome, descricao;
		double valorCompra = 0, porcentagemLucro = 0;
		int quantidadeEstoque = 0;
	
		//Defini��o da quantidade de produtos a serem cadastrados
		do {
			System.out.println("=========================================================================================================");
			System.out.print(">>>Quantos produtos ser�o cadastrados? ");
			quantidade = LerDados.lerInt(quantidade);
			//Se o n�mero digitado for 0, partimos do pressuposto que o usu�rio quer voltar ao menu
			//Se for menor que 0, mostra a mensagem da linha 254
			if (quantidade == 0) {
				break;
			} else if (quantidade < 0){
				System.out.println("Digite um n�mero maior que 0!");
			}
		} while (quantidade < 0);
		System.out.println();
		
		//Defini��o dos atributos nome, descri��o, valor da compra, porcentagem do lucro, quantidade no estoque que ser�o armazenados no objeto da classe Produto
		for (int i = 0; i < quantidade; i++) {
			System.out.println("PRODUTO " + (i+1));
			
			System.out.print(">Nome do produto: ");
			nome = LerDados.lerString();
			
			System.out.print(">Descri��o do produto: ");
			descricao = LerDados.lerString();
			
			System.out.print(">Valor de compra: R$");
			valorCompra = LerDados.lerDouble(valorCompra);
			
			System.out.print(">Porcentagem de lucro: ");
			porcentagemLucro = LerDados.lerDouble(porcentagemLucro);
			
			System.out.print(">Quantidade em estoque: ");
			quantidadeEstoque = LerDados.lerInt(quantidadeEstoque);
			System.out.println("---------------------------------------------------------------------------------------------------");
			
			//Cria��o de um novo objeto com construtor a cada itera��o
			objProduto = new Produto(nome, descricao, valorCompra, porcentagemLucro, quantidadeEstoque);
			
			//Adicionando o objeto criado na classe ConjuntoProdutos
			ConjuntoProdutos.adicionar(objProduto);
		}
		//Mostra que os dados foram cadastrados e a quantidade de produtos no sistema
		System.out.println("DADOS CADASTRADOS [" + ConjuntoProdutos.quantidadeDeProdutos() + " produtos no sistema]");
		System.out.println("---------------------------------------------------------------------------------------------------\n");
	}
	
	public static void buscaProduto(Produto objProduto) {
		//Declara��es
		String nome, novoNome, novaDescricao;
		double novoValorCompra = 0, novaPorcentagemLucro = 0;
		int novaQuantidadeEstoque = 0;
		char opcao = 0;
		boolean temProdutos = false;

		//Verifica se h� produto cadastrado no sistema, se n�o houver, ser� exibida a mensagem das linhas 356-358
		temProdutos = ConjuntoProdutos.temProduto();
		if (temProdutos) {
			//Lista os nomes dos produtos
			System.out.println("=========================================================================================================");
			ConjuntoProdutos.imprimeNomes();
			System.out.println("=========================================================================================================");
			
			//Pesquisa pelo nome do produto
			System.out.print(">>>Qual o nome do produto? ");
			nome = LerDados.lerString();
			System.out.println();
			
			//Busca o nome do produto na classe ConjuntoProdutos e resgata apenas o objeto com mesmo nome digitado pelo usu�rio
			objProduto = ConjuntoProdutos.pesquisarProduto(nome);
			
			//Lista os dados do objeto produto resgatado
			if (objProduto != null) {
				System.out.println("=========================================================================================================");
				System.out.println("Esse produto est� cadastrado!");
				System.out.println("Seus dados s�o:\n");
				System.out.println(objProduto.listagemDados());
				System.out.println("=========================================================================================================");
				
				System.out.print(">>>Deseja alterar os dados desse produto? [S/N]: ");
				opcao = LerDados.lerChar(opcao);
				
				//Altera os dados do produto
				if (opcao == 'S' || opcao == 's') {
					//Defini��o dos novos atributos nome, endere�o e telefone que ser�o armazenados no objeto da classe Cliente
					System.out.print("\n>Nome do produto: ");
					novoNome = LerDados.lerString();
					
					System.out.print(">Descri��o do produto: ");
					novaDescricao = LerDados.lerString();
					
					System.out.print(">Valor de compra: R$");
					novoValorCompra = LerDados.lerDouble(novoValorCompra);
					
					System.out.print(">Porcentagem de lucro: ");
					novaPorcentagemLucro = LerDados.lerDouble(novaPorcentagemLucro);
					
					System.out.print("Quantidade em estoque: ");
					novaQuantidadeEstoque = LerDados.lerInt(novaQuantidadeEstoque);
					System.out.println("---------------------------------------------------------------------------------------------------");
					
					//Atualiza��o dos dados do objeto
					objProduto.atualizaDados(novoNome, novaDescricao, novoValorCompra, novaPorcentagemLucro, novaQuantidadeEstoque);
					
					System.out.println("DADOS CADASTRADOS");
					System.out.println("---------------------------------------------------------------------------------------------------");
				}
			} else {
				System.out.println("=========================================================================================================");
				System.out.println("Produto n�o encontrado!");
				System.out.println("=========================================================================================================");
			}
		} else {
			System.out.println("=========================================================================================================");
			System.out.println("Cadastre algum produto antes de prosseguir nessa op��o.");
			System.out.println("=========================================================================================================");
		}
		System.out.println();
	}
	
	public static void cadastroDeVenda(Produto objProduto, Cliente objCliente) {
		//Declara��es
		String nomeCliente;
		String nomeProduto;
		int quantidade = 0;
		boolean temClientes = false;
		boolean temProdutos = false;
		
		//Verifica se h� cliente E produto cadastrado no sistema
		temClientes = ConjuntoClientes.temCliente();
		temProdutos = ConjuntoProdutos.temProduto();
		
		//Esse m�todo (cadastroDeVenda()) s� ser� executado se houver cliente E produto cadastrado no sistema
		//Caso contr�rio, mostra a mensagem das linhas 458-460
		if (temClientes && temProdutos) {
			//Lista os nomes dos clientes
			System.out.println("===================================================================================================");
			ConjuntoClientes.imprimeNomes();
			
			//Pede para o usu�rio digitar o nome a ser trabalhado
			System.out.println("===================================================================================================");
			System.out.print(">Digite o nome do cliente: ");
			nomeCliente = LerDados.lerString();
			
			//O nome do cliente ser� pesquisado e comparado com algum cliente que j� exista no sistema
			//O objeto contendo os atributos � resgatado aqui
			objCliente = ConjuntoClientes.pesquisarCliente(nomeCliente);
			
			//Se o nome digitado bater com algum nome j� no sistema, significa que o objCliente � diferente de null e podemos prosseguir
			//Caso contr�rio o programa retorna a mensagem das linhas 452-455
			if (objCliente != null) {
				//Lista os nomes dos produtos
				System.out.println("===================================================================================================");
				ConjuntoProdutos.imprimeNomes();
				
				//Pede para o usu�rio digitar o nome a ser trabalhado
				System.out.println("===================================================================================================");
				System.out.print(">>>Digite o nome do produto: ");
				nomeProduto = LerDados.lerString();
				
				//O nome do produto ser� pesquisado e comparado com algum produto que j� exista no sistema
				//O objeto contendo os atributos � resgatado aqui
				objProduto = ConjuntoProdutos.pesquisarProduto(nomeProduto);
				
				//Se o nome digitado bater com algum nome j� no sistema, significa que o objProduto � diferente de null e podemos prosseguir
				//Caso contr�rio, o programa retorna a mesagem das linhas 446-449
				if (objProduto != null) {
					do {				
						//Pede para o usu�rio digitar a quantidade do produto se ele for encontrado
						System.out.println("Quantidade no estoque: " + objProduto.getQuantidadeEstoque());
						System.out.println("=========================================================================================================");
						System.out.print(">>>Quanto do produto " + nomeProduto + " ser� levado? ");
						quantidade = LerDados.lerInt(quantidade);
						
						//Se a quantidade digitada for negativa, o programa continuar� perguntando a quantidade
						if (quantidade == 0) {
							break;
						} else {
							if (quantidade < 0) {
								System.out.println("=========================================================================================================");
								System.out.println("Digite um valor maior que 0!");
								System.out.println("=========================================================================================================");
							} else {
								//Se a quantidade digitada for maior que a quantidade de produto no estoque ser� exibida uma mensagem
								//avisando que o valor digitado � maior que a quantidade em estoque do produto e o programa continuar�
								//perguntando a quantidade. Caso contr�rio, o programa ir� retirar a quantidade digitada do produto do estoque
								if (quantidade > objProduto.getQuantidadeEstoque()) {
									System.out.println("=========================================================================================================");
									System.out.println("A quantidade digitada � maior que a quantidade no estoque.");
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
					//O loop permanecer� at� o usu�rio digitar uma quantidade maior que zero e um valor que n�o ultrapasse a quantidade 
					//em estoque do produto
					} while (quantidade <= 0 || quantidade > objProduto.getQuantidadeEstoque() );
				} else {
					System.out.println("===================================================================================================");
					System.out.println("O nome digitado n�o foi encontrado.");
					System.out.println("Tente novamente.");
					System.out.println("===================================================================================================");
				}
			} else {
				System.out.println("===================================================================================================");
				System.out.println("O nome digitado n�o foi encontrado.");
				System.out.println("Tente novamente.");
				System.out.println("===================================================================================================");
			}
		} else {
			System.out.println("===================================================================================================");
			System.out.println("Voc� precisa ter cliente E produto cadastrado no sistema!");
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
	
	public static char sair() {
		//Declara��es
		char escolha = 'n';
		
		//Pergunta se o usu�rio deseja sair do programa
		System.out.print(">>>Deseja realmente sair do programa? [S/N]: ");
		escolha = LerDados.lerChar(escolha);
		if (escolha == 's' || escolha == 'S') {
			System.out.println("\nVoc� optou por encerrar o programa...");
			System.exit(0);
		} 
		System.out.println();
		return escolha;
	}
}
