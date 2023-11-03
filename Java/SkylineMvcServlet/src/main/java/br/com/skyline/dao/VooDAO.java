package br.com.skyline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.skyline.connection.ConnectionMySQL;
import br.com.skyline.model.Voo;

public class VooDAO {
	
	public void createVoo(Voo voo) {
		String sql = "INSERT INTO VOO(num_voo, comp_aerea, assentos, preco_unit, "
				+ "data_partida, FK_id_cidade_origem, FK_id_cidade_destino) "
				+ "values(?, ?, ?, ?, STR_TO_DATE( ? , '%d/%m/%Y'), ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, voo.getNum_voo());
			pstm.setString(2, voo.getComp_aerea());
			pstm.setInt(3, voo.getAssentos());
			pstm.setDouble(4, voo.getPreco_unit());
			pstm.setString(5, voo.getData_partida());//atenção para o formato da data
			pstm.setInt(6, voo.getOrigem().getId_cidade());//lembrar que isto é um objeto de Cidades
			pstm.setInt(7, voo.getDestino().getId_cidade());//lembrar que isto é um objeto de Cidades
			
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
	
	public List<Voo> listar(){
		List<Voo> voos = new ArrayList<Voo>();
		//String sql = "SELECT * FROM VOO";
		String sql = "SELECT id_voo, num_voo, comp_aerea, assentos, preco_unit, "
				+ "DATE_FORMAT(data_partida, '%d/%m/%Y') AS data_partida, "
				+ "FK_id_cidade_origem, FK_id_cidade_destino FROM VOO";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Voo voo = new Voo();
				CidadesDAO cidDao = new CidadesDAO();
				
				voo.setId_voo(rset.getInt("id_voo"));
				voo.setNum_voo(rset.getInt("num_voo"));
				voo.setComp_aerea(rset.getString("comp_aerea"));
				voo.setAssentos(rset.getInt("assentos"));
				voo.setPreco_unit(rset.getDouble("preco_unit"));
				voo.setData_partida(rset.getString("data_partida"));
				
				//Cria os objetos a partir do métodos de buscar por ID da respectiva classe
				voo.setOrigem(cidDao.buscarPorId(rset.getInt("FK_id_cidade_origem")));
				voo.setDestino(cidDao.buscarPorId(rset.getInt("FK_id_cidade_destino")));
				
				voos.add(voo);
				
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
		
		return voos;
	}
	
	public Voo buscarPorId(int id) {
		String sql = "Select * from voo where id_voo = ?";
		Voo voo = new Voo();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			rset.next();
			
			//instância criada para trabalhar os atributos de objetos
			CidadesDAO cidDao = new CidadesDAO();
			
			voo.setId_voo(rset.getInt("id_voo"));
			voo.setNum_voo(rset.getInt("num_voo"));
			voo.setComp_aerea(rset.getString("comp_aerea"));
			voo.setAssentos(rset.getInt("assentos"));
			voo.setPreco_unit(rset.getDouble("preco_unit"));
			voo.setData_partida(rset.getString("data_partida"));
			
			//Cria os objetos a partir do métodos de buscar por ID da respectiva classe
			voo.setOrigem(cidDao.buscarPorId(rset.getInt("FK_id_cidade_origem")));
			voo.setDestino(cidDao.buscarPorId(rset.getInt("FK_id_cidade_destino")));
			
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
		
		return voo;
	}
	
	public void atualizarDados(Voo voo) {
		String sql = "UPDATE VOO SET num_voo = ?, comp_aerea = ?, assentos = ?, preco_unit = ?, "
		+ "data_partida = STR_TO_DATE( ? ,'%d/%m/%Y') , FK_id_cidade_origem = ?, FK_id_cidade_destino = ? "
		+ "WHERE id_voo = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, voo.getNum_voo());
			pstm.setString(2, voo.getComp_aerea());
			pstm.setInt(3, voo.getAssentos());
			pstm.setDouble(4, voo.getPreco_unit());
			pstm.setString(5, voo.getData_partida());
			pstm.setInt(6, voo.getOrigem().getId_cidade());
			pstm.setInt(7, voo.getDestino().getId_cidade());
			pstm.setInt(8, voo.getId_voo());
			
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
		String sql = "DELETE FROM VOO WHERE id_voo = ?";
		
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
