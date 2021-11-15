package es.iestetuan.dam2.DAO.IMP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import es.iestetuan.dam2.DAO.IDepartamento;
import es.iestetuan.dam2.VO.Departamento;

public class GestionDepartamento implements IDepartamento {
	
	public static Connection getConexion() {
		Connection conexion = null;
        try
        {
        	Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/aadd", "aadd", "aadd");
            if (conexion != null)            
                System.out.println("Connected\n");           
            else          
                System.out.println("Not Connected");         
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return conexion;
	}

	public void crearDepartamento(Departamento departamento) {
			
		int dept_no = departamento.getNumero();
		String dnombre = departamento.getNombre();
		String localidad = departamento.getLocalidad();
		
		try {
			Connection conexion = getConexion();
			String sentencia = "insert into departamentos values(?,?,?)";
			PreparedStatement statement = conexion.prepareStatement(sentencia);
			statement.setInt(1, dept_no);
			statement.setString(2, dnombre);
			statement.setString(3, localidad);
			statement.executeUpdate();
			conexion.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void modificarDepartamento(Departamento departamento) {
		
		int dept_no = departamento.getNumero();
		String dnombre = departamento.getNombre();
		String localidad = departamento.getLocalidad();
		
		try {
			Connection conexion = getConexion();
			String sentencia = "update departamentos set dnombre = ?, loc = ? where dept_no = ?";
			PreparedStatement statement = conexion.prepareStatement(sentencia);
			statement.setString(1, dnombre);
			statement.setString(2, localidad);
			statement.setInt(3, dept_no);
			statement.executeUpdate();
			conexion.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void borrarDepartamento(int idDepartamento) {
		
		try {
			Connection conexion = getConexion();
			String sentencia = "delete from departamentos where dept_no = ?";
			PreparedStatement statement = conexion.prepareStatement(sentencia);
			statement.setInt(1, idDepartamento);
			statement.executeUpdate();
			conexion.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void consultarDepartamento(int idDepartamento) {
		
		try {
			Connection conexion = getConexion();
			String sentencia = "select * from departamentos where dept_no = ?";
			PreparedStatement statement = conexion.prepareStatement(sentencia);
			statement.setInt(1, idDepartamento);
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				int dept_no = resultado.getInt("dept_no");
				String dnombre = resultado.getString("dnombre");
				String loc = resultado.getString("loc");
				
				Departamento depto = new Departamento(dept_no, dnombre, loc);
				System.out.println(depto.toString());
			}
			conexion.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
