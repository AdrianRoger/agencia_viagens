package br.com.skyline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.skyline.connection.ConnectionMySQL;
import br.com.skyline.model.Cidades;

public class CidadesDAO {

	
	public void createCidade(Cidades cidade) {
		String sql = "INSERT INTO CIDADES(cidade, estado, pais, aeroporto) values(?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cidade.getCidade());
			pstm.setString(2, cidade.getEstado());
			pstm.setString(3,cidade.getPais());
			pstm.setString(4, cidade.getAeroporto());
			
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
	
	public List<Cidades> listar(){
		List<Cidades> cidades = new ArrayList<Cidades>();
		String sql = "SELECT * FROM CIDADES";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Cidades cid = new Cidades();
				cid.setId_cidade(rset.getInt("id_cidade"));
				cid.setCidade(rset.getString("cidade"));
				cid.setEstado(rset.getString("estado"));
				cid.setPais(rset.getString("pais"));
				cid.setAeroporto(rset.getString("aeroporto"));
				
				cidades.add(cid);
				
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
		
		return cidades;
	}
	
	public Cidades buscarPorId(int id) {
		String sql = "Select * from cidades where id_cidade = ?";
		Cidades cid = new Cidades();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			rset.next();
			
			cid.setId_cidade(rset.getInt("id_cidade"));
			cid.setCidade(rset.getString("cidade"));
			cid.setEstado(rset.getString("estado"));
			cid.setPais(rset.getString("pais"));
			cid.setAeroporto(rset.getString("aeroporto"));
			
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
		
		return cid;
	}
	
	public void atualizarDados(Cidades cidade) {
		String sql = "UPDATE CIDADES SET cidade = ?, estado = ?, pais = ?, aeroporto = ?"
				+ "WHERE id_cidade = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cidade.getCidade());
			pstm.setString(2, cidade.getEstado());
			pstm.setString(3, cidade.getPais());
			pstm.setString(4, cidade.getAeroporto());
			pstm.setInt(5, cidade.getId_cidade());
			
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
	
	public void apagar(int id) {
		String sql = "DELETE FROM CIDADES WHERE id_cidade = ?";
		
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
				if(conn !=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
