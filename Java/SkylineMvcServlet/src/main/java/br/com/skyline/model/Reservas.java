package br.com.skyline.model;

public class Reservas {
	private int id_reserva;
	private String data_reserva;
	private int num_pessoas;
	private boolean cancelada;
	//objetos
	Clientes cliente;
	Voo voo;
	
	//Construtor Vazio
	public Reservas() {
		
	}
	//Construtor Completo
	public Reservas(int id_reserva, String data_reserva, int num_pessoas, boolean cancelada, 
				Clientes cliente,Voo voo) {
		this.id_reserva = id_reserva;
		this.data_reserva = data_reserva;
		this.num_pessoas = num_pessoas;
		this.cancelada = cancelada;
		this.cliente = cliente;
		this.voo = voo;
	}
	//Construtor sem ID
	public Reservas(String data_reserva, int num_pessoas, boolean cancelada, 
				Clientes cliente,Voo voo) {
		this.data_reserva = data_reserva;
		this.num_pessoas = num_pessoas;
		this.cancelada = cancelada;
		this.cliente = cliente;
		this.voo = voo;
	}
	
	//Getters & Setters
	public int getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	public String getData_reserva() {
		return data_reserva;
	}
	public void setData_reserva(String data_reserva) {
		this.data_reserva = data_reserva;
	}
	public int getNum_pessoas() {
		return num_pessoas;
	}
	public void setNum_pessoas(int num_pessoas) {
		this.num_pessoas = num_pessoas;
	}
	public boolean isCancelada() {
		return cancelada;
	}
	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public Voo getVoo() {
		return voo;
	}
	public void setVoo(Voo voo) {
		this.voo = voo;
	}
	
	//toString
	@Override
	public String toString() {
		return "Reservas [id_reserva=" + id_reserva + ", data_reserva=" + data_reserva + ", num_pessoas=" + num_pessoas
				+ ", cancelada=" + cancelada + ", cliente=" + cliente + ", voo=" + voo + "]";
	}
	
}
