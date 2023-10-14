package br.com.skyline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.skyline.connection.ConnectionMySQL;
import br.com.skyline.model.Contato;

public class ContatoDAO {
	
	//Create
	public void createContato(Contato contato) {
		String sql = "insert into contato(nome, email, telefone, mensagem) values( ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getEmail());
			pstm.setString(3, contato.getTelefone());
			pstm.setString(4, contato.getMensagem());
			
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
		
		
		System.out.println("*** Contato registrado com sucesso. ***");
	}
	
	//Rescue
	public List<Contato> listar(){
		List<Contato> contatos = new ArrayList<Contato>(); 
		String sql = "select * from contato";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Contato contato = new Contato();
				contato.setId_contato(rset.getInt("id_contato"));
				contato.setNome(rset.getString("nome"));
				contato.setEmail(rset.getString("email"));
				contato.setTelefone(rset.getString("telefone"));
				contato.setMensagem(rset.getString("mensagem"));
				contato.setResolvido(rset.getBoolean("resolvido"));
				
				contatos.add(contato);
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
		return contatos;
	}
	
	//Update
	public void atualizar(Contato contato) {
		
		String sql = "update contato set nome= ?, email = ?, telefone = ?,"
				+ " mensagem = ?, resolvido = ? Where id_contato = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			//rset = pstm.executeQuery();
			
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getEmail());
			pstm.setString(3, contato.getTelefone());
			pstm.setString(4,contato.getMensagem());
			pstm.setBoolean(5, contato.isResolvido());
			pstm.setInt(6, contato.getId_contato());
			
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

	//Delete
	public void apagar(int id) {
		String sql = "delete from contato where id_contato = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
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
	
	public Contato buscarPorId(int id) {
		String sql = "select * from contato where id_contato = ?";
		Contato contato = new Contato();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			rset.next();
			
			contato.setId_contato(rset.getInt("id_contato"));
			contato.setNome(rset.getString("nome"));
			contato.setEmail(rset.getString("email"));
			contato.setTelefone(rset.getString("telefone"));
			contato.setMensagem(rset.getString("mensagem"));
			contato.setResolvido(rset.getBoolean("resolvido"));
			
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
		
		
		
		return contato;
	}


}