package datos;
import java.sql.*;

import util.AppException;

public class FactoryConexion {

	private String dbDriver="com.mysql.jdbc.Driver";
	private String host="vps-1039890-x.dattaweb.com";
	private String port="3306";
	private String user="prueba";
	private String pass="123456";
	private String db="javadb";
	private String dbType="mysql";
	
	private Connection conn;
	private int cantConn=0;
	
	private FactoryConexion() throws AppException{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException cnfex) {
			throw new AppException("Error del Driver JDBC",cnfex);
		}
	}
	
	private static FactoryConexion instancia;
	
	public static FactoryConexion getInstancia() throws AppException{
		if (instancia==null){
			instancia = new FactoryConexion();
		}
		return instancia;
	}
	
	public Connection getConn(){
		try {
			if(conn==null || conn.isClosed()){
				conn = DriverManager.getConnection(
						"jdbc:"+dbType+"://"+host+":"+port+"/"+
						db+"?user="+user+"&password="+pass);
				cantConn++;
			}
		} catch (SQLException sqlex) {
			new AppException("Error al conectar a la DB", sqlex);

		}
		return conn;
	}
	
	public void releaseConn() throws AppException{
		try {
			cantConn--;
			if(cantConn==0){
				conn.close();
			}
		} catch (SQLException sqlex) {
			throw new AppException("Error al cerrar conexión",sqlex);
		}
		
}
}
