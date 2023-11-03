package br.com.skyline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.skyline.connection.ConnectionMySQL;
import br.com.skyline.model.Reservas;

public class ReservasDAO {
	
	public void createReserva(Reservas res) {
		String sql = "INSERT INTO RESERVAS(data_reserva, num_pessoas, FK_cpf_clientes, FK_id_voo) "
				+ "values(STR_TO_DATE( ? , '%d/%m/%Y' ), ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			Date data_atual = new Date();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String data_string = formato.format(data_atual);
			
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, data_string);
			pstm.setInt(2, res.getNum_pessoas());

			pstm.setString(3, res.getCliente().getCpf());//lembrar que isto é um objeto de Clientes
			pstm.setInt(4, res.getVoo().getId_voo());//lembrar que isto é um objeto de Voo
			
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
	
	public List<Reservas> listar(){
		List<Reservas> reservas = new ArrayList<Reservas>();
		String sql = "SELECT id_reserva, DATE_FORMAT(data_reserva, '%d/%m/%Y') AS data_reserva, "
				+ "num_pessoas, cancelada, FK_cpf_clientes, FK_id_voo FROM reservas ";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Reservas res = new Reservas();
				VooDAO vooDao = new VooDAO();
				ClientesDAO cliDao = new ClientesDAO();
				
				res.setId_reserva(rset.getInt("id_reserva"));
				res.setData_reserva(rset.getString("data_reserva"));
				res.setNum_pessoas(rset.getInt("num_pessoas"));
				res.setCancelada(rset.getBoolean("cancelada"));
		
				//Cria os objetos a partir do métodos de buscar por ID da respectiva classe
				res.setCliente(cliDao.buscarPorCpf(rset.getString("FK_cpf_clientes")));
				res.setVoo(vooDao.buscarPorId(rset.getInt("FK_id_voo")));
								
				reservas.add(res);
				
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
		
		return reservas;
	}
	
	public Reservas buscarPorId(int id) {
		String sql = "SELECT id_reserva, DATE_FORMAT(data_reserva, '%d/%m/%Y') AS data_reserva, "
				+ "num_pessoas, cancelada, FK_cpf_clientes, FK_id_voo FROM reservas WHERE id_reserva = ?";
		

		Reservas res = new Reservas();
		
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
			VooDAO vooDao = new VooDAO();
			ClientesDAO cliDao = new ClientesDAO();
			
			res.setId_reserva(rset.getInt("id_reserva"));
			res.setData_reserva(rset.getString("data_reserva"));
			res.setNum_pessoas(rset.getInt("num_pessoas"));
			res.setCancelada(rset.getBoolean("cancelada"));
	
			//Cria os objetos a partir do métodos de buscar por ID da respectiva classe
			res.setCliente(cliDao.buscarPorCpf(rset.getString("FK_cpf_clientes")));
			res.setVoo(vooDao.buscarPorId(rset.getInt("FK_id_voo")));
			
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
		
		return res;
	}
	
	public void atualizarDados(Reservas res) {
		String sql = "UPDATE RESERVAS SET num_pessoas = ?, cancelada = ?, FK_id_voo = ? "
				+ "where id_reserva = ?";
		//As demais informações não são elegíveis para atualização direta
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, res.getNum_pessoas());
			pstm.setBoolean(2, res.isCancelada());
			
			pstm.setInt(3, res.getVoo().getId_voo());
			pstm.setInt(4, res.getId_reserva());
			
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
		String sql = "DELETE FROM RESERVAS WHERE id_reserva = ?";
		
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
