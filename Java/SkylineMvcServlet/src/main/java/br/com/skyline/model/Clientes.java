package br.com.skyline.model;

public class Clientes {
	//atributos
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	private String cep;
	private String rua;
	private int numero;
	private String complemento;
	private boolean ativo;
	
	//construtores
	public Clientes() {
		
	}
	
	public Clientes(String cpf, String nome, String email, String telefone, 
			String cep, String rua, int numero, String complemento,	boolean ativo) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.ativo = ativo;
	}
	
	//getters and setters
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	//toString
	@Override
	public String toString() {
		return "Clientes [cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", cep="
				+ cep + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", ativo=" + ativo + "]";
	}
	
	
}
