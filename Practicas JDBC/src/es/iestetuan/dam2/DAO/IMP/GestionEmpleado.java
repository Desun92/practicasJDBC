package es.iestetuan.dam2.DAO.IMP;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import es.iestetuan.dam2.DAO.IEmpleado;
import es.iestetuan.dam2.VO.Departamento;
import es.iestetuan.dam2.VO.Empleado;

public class GestionEmpleado implements IEmpleado {
	
	public static Connection getConexionPostgre() {
		Connection conexion = null;
        try
        {
        	Class.forName("org.postgresql.Driver");
        	String url = "jdbc:postgresql://dam2.actividad.cf:5432/aadd-dam2";
            conexion = DriverManager.getConnection(url, "aadd", "d1m2p0sgr3sql");
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
			Connection conexion = getConexionPostgre();
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

	
	public void modificarEmpleado(Empleado empleado, int pk) {
		
		int emp_no = empleado.getNumero();
		String apellido = empleado.getApellido();
		String oficio = empleado.getOficio();
		Integer dir = empleado.getDir();
		Date fecha_alt = empleado.getFechaAlta();
		Float salario = empleado.getSalario();
		Float comision = empleado.getComision();
		int dept_no = empleado.getNumDepto();
		int cp = pk;
		
		try {
			Connection conexion = getConexionPostgre();
			String sentencia = "update empleados set emp_no = ?, apellido = ?, oficio = ?, dir = ?, fecha_alt = ?, salario = ?, comision = ?, dept_no = ? where emp_no = ?";
			PreparedStatement statement = conexion.prepareStatement(sentencia);
			statement.setInt(1, emp_no);
			statement.setString(2, apellido);
			statement.setString(3, oficio);
			statement.setInt(4, dir);
			statement.setDate(5, fecha_alt);
			statement.setFloat(6, salario);
			statement.setFloat(7, comision);
			statement.setInt(8, dept_no);
			statement.setInt(9, cp);
			statement.executeUpdate();
			conexion.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	public void borrarEmpleado(int idEmpleado) {
		
		try {
			Connection conexion = getConexionPostgre();
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
			Connection conexion = getConexionPostgre();
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


	public void consultarEmpleadoApellidoSalario(String apellido, Float Salario) {
		

	}

}
