package br.com.skyline.model;

public class Contato {
	private int id_contato;
	private String nome;
	private String email;
	private String telefone;
	private String mensagem;
	private boolean resolvido;
	
	//Construtor Vazio
	public Contato() {
		
	}
	//Construtor Completo
	public Contato(int id_contato, String nome,String email, String telefone, 
				String mensagem, boolean resolvido) {
		this.id_contato = id_contato;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.mensagem = mensagem;
		this.resolvido = resolvido;
	}
	//Construtor Sem ID
	public Contato(String nome, String email, String telefone, String mensagem, boolean resolvido) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.mensagem = mensagem;
		this.resolvido = resolvido;
	}
	
	//Getters & Setters
	public int getId_contato() {
		return id_contato;
	}
	public void setId_contato(int id_contato) {
		this.id_contato = id_contato;
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
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public boolean isResolvido() {
		return resolvido;
	}
	public void setResolvido(boolean resolvido) {
		this.resolvido = resolvido;
	}
	
	//toString
	@Override
	public String toString() {
		return "Contato [id_contato=" + id_contato + ", nome=" + nome +", email= " + email +
				", telefone=" + telefone + ", mensagem=" + mensagem + ", resolvido=" + resolvido + "]";
	}
	
	
}
