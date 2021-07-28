package tp1;

public class Produto {
	//Atributos
	private String nome, descricao;
	private double valorCompra, porcentagemLucro;
	private int quantidadeEstoque;
	
	//Método Construtor
	public Produto(String nome, String descricao, double valorCompra, double porcentagemLucro, int quantidadeEstoque) {
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setValorCompra(valorCompra);
		this.setPorcentagemLucro(porcentagemLucro);
		this.setQuantidadeEstoque(quantidadeEstoque);
	}
	
	//Métodos modificadores
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public void setPorcentagemLucro(double porcentagemLucro) {
		this.porcentagemLucro = porcentagemLucro;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	//Métodos acessores
	public String getNome() {
		return this.nome;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public double getValorCompra() {
		return this.valorCompra;
	}
	public double getPorcentagemLucro() {
		return this.porcentagemLucro;
	}
	public int getQuantidadeEstoque() {
		return this.quantidadeEstoque;
	}
	
	//Retorna uma String com todos os dados do produto
	public String listagemDados() {
		return "#Nome do produto: " + this.getNome() + "\n#Descrição do produto: " + this.getDescricao() + "\n#Valor de compra: R$" + this.getValorCompra()
		+ "\n#Porcentagem de lucro: " + this.getPorcentagemLucro() + "\n#Quantidade em estoque: " + this.getQuantidadeEstoque() + "\n";
	}
	
	//Retorna uma String com o nome, descricao e quantidade em estoque do produto
	public String listaEstoque() {
		return "#Nome do produto: " + this.getNome() + "\n#Quantidade em estoque: " + this.getQuantidadeEstoque() + "\n";
	}
	
	//Retorna uma String apenas com o nome do produto
	public String listaNome() {
		return "#Nome do produto: " + this.getNome();
	}
	
	//Atualiza os dados do produto
	public void atualizaDados(String nome, String descricao, double valorCompra, double porcentagemLucro, int quantidadeEstoque) {
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setValorCompra(valorCompra);
		this.setPorcentagemLucro(porcentagemLucro);
		this.setQuantidadeEstoque(quantidadeEstoque);
	}
}
