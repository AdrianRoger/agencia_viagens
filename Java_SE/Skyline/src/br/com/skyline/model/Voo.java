package br.com.skyline.model;

public class Voo {
	private int id_voo;
	private int num_voo;
	private String comp_aerea;
	private int assentos;
	private double preco_unit;
	private String data_partida;
	
	Cidades origem;
	Cidades destino;
	
	//Construtor Vazio
	public Voo() {
		
	}
	//Construtor Completo
	public Voo(int id_voo, int num_voo, String comp_aerea, int assentos, double preco_unit, 
				String data_partida, Cidades origem, Cidades destino) {
		this.id_voo = id_voo;
		this.num_voo = num_voo;
		this.comp_aerea = comp_aerea;
		this.assentos = assentos;
		this.preco_unit = preco_unit;
		this.data_partida = data_partida;
		this.origem = origem;
		this.destino = destino;
	}
	//Construtor Sem ID
	public Voo(int num_voo, String comp_aerea, int assentos, double preco_unit, 
				String data_partida, Cidades origem, Cidades destino) {
		this.num_voo = num_voo;
		this.comp_aerea = comp_aerea;
		this.assentos = assentos;
		this.preco_unit = preco_unit;
		this.data_partida = data_partida;
		this.origem = origem;
		this.destino = destino;
	}
	
	//Getters & Setters
	public int getId_voo() {
		return id_voo;
	}
	public void setId_voo(int id_voo) {
		this.id_voo = id_voo;
	}
	public int getNum_voo() {
		return num_voo;
	}
	public void setNum_voo(int num_voo) {
		this.num_voo = num_voo;
	}
	public String getComp_aerea() {
		return comp_aerea;
	}
	public void setComp_aerea(String comp_aerea) {
		this.comp_aerea = comp_aerea;
	}
	public int getAssentos() {
		return assentos;
	}
	public void setAssentos(int assentos) {
		this.assentos = assentos;
	}
	public double getPreco_unit() {
		return preco_unit;
	}
	public void setPreco_unit(double preco_unit) {
		this.preco_unit = preco_unit;
	}
	public String getData_partida() {
		return data_partida;
	}
	public void setData_partida(String data_partida) {
		this.data_partida = data_partida;
	}
	public Cidades getOrigem() {
		return origem;
	}
	public void setOrigem(Cidades origem) {
		this.origem = origem;
	}
	public Cidades getDestino() {
		return destino;
	}
	public void setDestino(Cidades destino) {
		this.destino = destino;
	}
	
	//toString
	@Override
	public String toString() {
		return "Voo [id_voo=" + id_voo + ", num_voo=" + num_voo + ", comp_aerea=" + comp_aerea + ", assentos="
				+ assentos + ", preco_unit=" + preco_unit + ", data_partida=" + data_partida + ", origem=" + origem
				+ ", destino=" + destino + "]";
	}
	
	
}
