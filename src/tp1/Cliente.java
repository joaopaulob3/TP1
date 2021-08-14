package tp1;

public class Cliente {
	//Atributos
	private String nome, endereco, telefone;
	
	//Método construtor
	public Cliente(String nome, String endereco, String telefone) {
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
	}
	
	//Métodos modificadores
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	//Métodos acessores
	public String getNome() {
		return this.nome;
	}
	public String getEndereco() {
		return this.endereco;
	}
	public String getTelefone() {
		return this.telefone;
	}
	
	//Retorna uma String com todos os dados do cliente
	public String listagemDados() {
		return "#Nome: " + this.getNome() + "\n#Endereço: " + this.getEndereco() + "\n#Telefone: " + this.getTelefone() + "\n";
	}
	
	//Retorna uma String apenas com o nome do cliente
	public String listaNome() {
		return "#Nome: " + this.getNome();
	}
	
	//Atualiza os dados do cliente
	public void atualizaDados(String nome, String endereco, String telefone) {
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
	}
}
