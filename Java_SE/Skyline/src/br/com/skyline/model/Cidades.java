package br.com.skyline.model;

public class Cidades {
	private int id_cidade;
	private String cidade;
	private String estado;
	private String pais;
	private String aeroporto;
	
	//Construtores Vazio
	public Cidades() {
		
	}
	//Construtores Completo
	public Cidades(int id_cidade, String cidade, String estado, String pais, String aeroporto) {
		this.id_cidade = id_cidade;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.aeroporto = aeroporto;
	}
	//Construtores Sem ID
	public Cidades(String cidade, String estado, String pais, String aeroporto) {
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.aeroporto = aeroporto;
	}
	
	//Gettters & Setters
	public int getId_cidade() {
		return id_cidade;
	}

	public void setId_cidade(int id_cidade) {
		this.id_cidade = id_cidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getAeroporto() {
		return aeroporto;
	}

	public void setAeroporto(String aeroporto) {
		this.aeroporto = aeroporto;
	}
	
	//toString
	@Override
	public String toString() {
		return "Cidades [id_cidade=" + id_cidade + ", cidade=" + cidade + ", estado=" + estado + ", pais=" + pais
				+ ", aeroporto=" + aeroporto + "]";
	}
	
}
