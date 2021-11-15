package es.iestetuan.dam2.DAO.IMP;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import es.iestetuan.dam2.DAO.IEmpleado;
import es.iestetuan.dam2.VO.Departamento;
import es.iestetuan.dam2.VO.Empleado;

public class GestionEmpleado implements IEmpleado {
	
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

	
	public void crearEmpleado(Empleado empleado) {
		
		int emp_no = empleado.getNumero();
		String apellido = empleado.getApellido();
		String oficio = empleado.getOficio();
		Integer dir = empleado.getDir();
		Date fecha_alt = empleado.getFechaAlta();
		Float salario = empleado.getSalario();
		Float comision = empleado.getComision();
		int dept_no = empleado.getNumDepto();
		
		try {
			Connection conexion = getConexion();
			String sentencia = "insert into empleados values(?,?,?,?,?,?,?,?)";
			PreparedStatement statement = conexion.prepareStatement(sentencia);
			statement.setInt(1, emp_no);
			statement.setString(2, apellido);
			statement.setString(3, oficio);
			statement.setInt(4, dir);
			statement.setDate(5, fecha_alt);
			statement.setFloat(6, salario);
			statement.setFloat(7, comision);
			statement.setInt(8, dept_no);
			statement.executeUpdate();
			conexion.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	
	public void modificarEmpleado(Empleado empleado) {
		
		int emp_no = empleado.getNumero();
		String apellido = empleado.getApellido();
		String oficio = empleado.getOficio();
		Integer dir = empleado.getDir();
		Date fecha_alt = empleado.getFechaAlta();
		Float salario = empleado.getSalario();
		Float comision = empleado.getComision();
		int dept_no = empleado.getNumDepto();

		
		try {
			Connection conexion = getConexion();
			String sentencia = "update empleados set apellido = ?, oficio = ?, dir = ?, fecha_alt = ?, salario = ?, comision = ?, dept_no = ? where emp_no = ?";
			PreparedStatement statement = conexion.prepareStatement(sentencia);
			statement.setString(1, apellido);
			statement.setString(2, oficio);
			statement.setInt(3, dir);
			statement.setDate(4, fecha_alt);
			statement.setFloat(5, salario);
			statement.setFloat(6, comision);
			statement.setInt(7, dept_no);
			statement.setInt(8, emp_no);
			statement.executeUpdate();
			conexion.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	public void borrarEmpleado(int idEmpleado) {
		
		try {
			Connection conexion = getConexion();
			String sentencia = "delete from empleados where emp_no = ?";
			PreparedStatement statement = conexion.prepareStatement(sentencia);
			statement.setInt(1, idEmpleado);
			statement.executeUpdate();
			conexion.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}


	public void consultarEmpleado(int idEmpleado) {
		
		try {
			Connection conexion = getConexion();
			String sentencia = "select * from empleados where emp_no = ?";
			PreparedStatement statement = conexion.prepareStatement(sentencia);
			statement.setInt(1, idEmpleado);
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				int emp_no = resultado.getInt("emp_no");
				String apellido = resultado.getString("apellido");
				String oficio = resultado.getString("oficio");
				Integer dir = resultado.getInt("dir");
				Date fecha_alt = resultado.getDate("fecha_alt");
				Float salario = resultado.getFloat("salario");
				Float comision = resultado.getFloat("comision");
				int dept_no = resultado.getInt("dept_no");
				
				Empleado emple = new Empleado(emp_no,apellido,oficio,dir,fecha_alt,salario,comision,dept_no);
				System.out.println(emple.toString());
			}
			conexion.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}


	public void consultarEmpleadoApellidoSalario(String apellido, Float salario) {
		
		String query = "{ call consultarEmpleadoApellidoSalario(?,?) }";
		ResultSet rs;
		
		try {
			Connection conexion = getConexion();
			CallableStatement stmt = conexion.prepareCall(query);
			stmt.setString(1, apellido);
			stmt.setFloat(2, salario);
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				int emp_no = rs.getInt("emp_no");
				String apell = rs.getString("apellido");
				String oficio = rs.getString("oficio");
				Integer dir = rs.getInt("dir");
				Date fecha_alt = rs.getDate("fecha_alt");
				Float salar = rs.getFloat("salario");
				Float comision = rs.getFloat("comision");
				int dept_no = rs.getInt("dept_no");
				
				Empleado emple = new Empleado(emp_no,apell,oficio,dir,fecha_alt,salar,comision,dept_no);
				System.out.println(emple.toString());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
