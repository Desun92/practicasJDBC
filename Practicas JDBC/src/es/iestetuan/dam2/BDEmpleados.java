package es.iestetuan.dam2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BDEmpleados {

	public static void main(String[] args) {
		
		//getConexion();
		//crearRegistroDepartamentos(60,"COMUNICACIONES","MADRID");
		//modificarRegistroDepartamentos(60,60,"INFORMATICA Y COMUNICACIONES","MADRID");
		//borrarRegistroDepartamentos(60);
		//consultarDepartamentos(50);
		Date fecha = new Date(2021-11-10);
		crearRegistroEmpleados(8001,"JUSTO","PROG. MP",7782,fecha,1570f,null,50);
		
	}
	
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
	
	public static void crearRegistroDepartamentos(int dept_n, String nombre, String loc) {
		int dept_no = dept_n;
		String dnombre = nombre;
		String localidad = loc;
		
		try {
			Connection conexion = getConexion();
			Statement statement = conexion.createStatement();
			int op = statement.executeUpdate("insert into departamentos values('"+dept_no+"','"+dnombre+"','"+localidad+"')");
			if(op>0)
				System.out.println("Inserción completada");
			else
				System.out.println("Error al insertar los datos");
			conexion.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void modificarRegistroDepartamentos(int pk, int numero, String nombre, String loc) {
		int numCambio = pk;
		int num = numero;
		String nom = nombre;
		String localidad = loc;
		
		try {
			Connection conexion = getConexion();
			Statement statement = conexion.createStatement();
			int op = statement.executeUpdate("update departamentos set dept_no = '"+num+"',dnombre = '"+nom+"', loc = '"+localidad+"' where dept_no = '"+numCambio+"'"); 
			if(op>0)
				System.out.println("Modificación completada");
			else
				System.out.println("Error al insertar los datos");
			conexion.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void borrarRegistroDepartamentos(int pk) {
		int cp = pk;
		
		try {
			Connection conexion = getConexion();
			Statement statement = conexion.createStatement();
			int op = statement.executeUpdate("delete from departamentos where dept_no = '"+cp+"'");
			if(op>0)
				System.out.println("Eliminación completada");
			else
				System.out.println("Error al eliminar");
			conexion.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void consultarDepartamentos(int pk) {
		int cp = pk;
		
		try {
			Connection conexion = getConexion();
			Statement statement = conexion.createStatement();
			ResultSet resultado = statement.executeQuery("select * from departamentos where dept_no = '"+cp+"'");
			while(resultado.next()) {
				System.out.println("dept_no: "+resultado.getString(1));
				System.out.println("dnombre: "+resultado.getString(2));
				System.out.println("loc: "+resultado.getString(3));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void crearRegistroEmpleados(int emp, String ape, String ofi, int di, Date fecha, Float salar, Float comis, int dept) {
		
		int emp_no = emp;
		String apellido = ape;
		String oficio = ofi;
		int dir = di;
		Date fecha_alt = fecha;
		Float salario = salar;
		Float comision = comis;
		String comisionNula = "null";
		int dept_no = dept;
		
		
		try {
			Connection conexion = getConexion();
			Statement statement = conexion.createStatement();
			int op;
			if(comision!=null)
				op = statement.executeUpdate("insert into empleados values('"+emp_no+"','"+apellido+"','"+oficio+"','"+dir+"','"+fecha_alt+"','"+salario+"','"+comision+"','"+dept_no+"')");
			else
				op = statement.executeUpdate("insert into empleados values('"+emp_no+"','"+apellido+"','"+oficio+"','"+dir+"','"+fecha_alt+"','"+salario+"',"+comisionNula+",'"+dept_no+"')");
			
			if(op>0)
				System.out.println("Inserción completada");
			else
				System.out.println("Error al insertar los datos");
			conexion.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
