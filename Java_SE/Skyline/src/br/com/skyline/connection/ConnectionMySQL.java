package br.com.skyline.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {
	private static final String URL = "jdbc:mysql://localhost:3306/skyline";
	private static final String USER= "root";
	private static final String PASSWORD = "12345";
	
	public static Connection createConnectionMySQL() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
		
		return connection;
	}
	
	//main criado para testar se a conexão está funcionando
	public static void main(String[] args) throws Exception {
		//Recupoera uma conexão com o banco de dados
		Connection conn = createConnectionMySQL();
		
		//testar a conexão
		if(conn != null) {
			System.out.println(conn + "\n\n *** Conexão realizada com sucesso ***");
			conn.close();
		}
	}
	
}
