package br.com.skyline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.skyline.connection.ConnectionMySQL;
import br.com.skyline.model.Clientes;

public class ClientesDAO {
	

	public void createCliente(Clientes cliente) {
		String sql = "INSERT INTO CLIENTES(CPF, nome, email, telefone, cep, rua, numero, complemento)"
				+ " values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cliente.getCpf());
			pstm.setString(2, cliente.getNome());
			pstm.setString(3,cliente.getEmail());
			pstm.setString(4, cliente.getTelefone());
			pstm.setString(5, cliente.getCep());
			pstm.setString(6, cliente.getRua());
			pstm.setInt(7, cliente.getNumero());
			pstm.setString(8, cliente.getComplemento());
			
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Clientes> listar(){
		List<Clientes> clientes = new ArrayList<Clientes>();
		String sql = "SELECT * FROM CLIENTES";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Clientes cli = new Clientes();
				cli.setCpf(rset.getString("cpf"));
				cli.setNome(rset.getString("nome"));
				cli.setEmail(rset.getString("email"));
				cli.setTelefone(rset.getString("telefone"));
				cli.setCep(rset.getString("cep"));
				cli.setRua(rset.getString("rua"));
				cli.setNumero(rset.getInt("numero"));
				cli.setComplemento(rset.getString("complemento"));
				cli.setAtivo(rset.getBoolean("ativo"));
				
				clientes.add(cli);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return clientes;
	}
	
	public Clientes buscarPorCpf(String cpf) {
		String sql = "Select * from clientes where cpf = ?";
		Clientes cli = new Clientes();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cpf);
			rset = pstm.executeQuery();
			
			rset.next();
			
			cli.setCpf(rset.getString("cpf"));
			cli.setNome(rset.getString("nome"));
			cli.setEmail(rset.getString("email"));
			cli.setTelefone(rset.getString("telefone"));
			cli.setCep(rset.getString("cep"));
			cli.setRua(rset.getString("rua"));
			cli.setNumero(rset.getInt("numero"));
			cli.setComplemento(rset.getString("complemento"));
			cli.setAtivo(rset.getBoolean("ativo"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return cli;
	}
	
	public void atualizarDados(Clientes cliente) {
		String sql = "UPDATE CLIENTES SET nome = ?, email = ?, telefone = ?, cep = ?,"
					+ "rua = ?, numero = ?, complemento = ?, ativo = ? where cpf = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEmail());
			pstm.setString(3, cliente.getTelefone());
			pstm.setString(4, cliente.getCep());
			pstm.setString(5, cliente.getRua());
			pstm.setInt(6, cliente.getNumero());
			pstm.setString(7, cliente.getComplemento());
			pstm.setBoolean(8, cliente.isAtivo());
			pstm.setString(9, cliente.getCpf());
			
			pstm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void apagar(String cpf) {
		String sql = "DELETE FROM CLIENTES WHERE cpf = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cpf);
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn !=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

