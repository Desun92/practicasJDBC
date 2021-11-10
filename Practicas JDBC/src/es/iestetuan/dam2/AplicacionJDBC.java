package es.iestetuan.dam2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AplicacionJDBC {

	public static void main(String[] args) {

		// insertarInfoBBDD();
		// modificarInfoBBDD();
		// borrarInfoBBDD();
		 consultarInfoBBDD();

    }
	
	public static Connection getConexion() {
		Connection conexion = null;
        try
        {
        	Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/aadd", "aadd", "aadd");
            if (conexion != null)            
                System.out.println("Connected");           
            else          
                System.out.println("Not Connected");         
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return conexion;
		
	}	
    public static void insertarInfoBBDD()
    {
        String id = "id2";
        String pwd = "pwd2";
        String fullname = "geeks for geeks DOS";
        String email = "geeks@geeks.org DOS";        
        try
        {
            Connection conexion =getConexion();
            Statement stmt = conexion.createStatement();
            String q1 = "insert into userid values('" +id+ "', '" +pwd+
                                  "', '" +fullname+ "', '" +email+ "')";
            int x = stmt.executeUpdate(q1);
            if (x > 0)           
                System.out.println("Successfully Inserted");           
            else          
                System.out.println("Insert Failed");            
            conexion.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void modificarInfoBBDD()
    {
        String id = "id1";
        String pwd = "pwd1";
        String newPwd = "newpwd";
        try
        {
            Connection conexion =getConexion();
            Statement stmt = conexion.createStatement();
            String q1 = "UPDATE userid set pwd = '" + newPwd +
                    "' WHERE id = '" +id+ "' AND pwd = '" + pwd + "'";
            int x = stmt.executeUpdate(q1);
            if (x > 0)           
                System.out.println("Successfully update");           
            else          
                System.out.println("Update Failed");            
            conexion.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
 
    
    public static void borrarInfoBBDD()
    {
        String id = "id2";
        String pwd = "pwd2";
        try
        {
            Connection conexion =getConexion();
            Statement stmt = conexion.createStatement();
            // Deleting from database
            String q1 = "DELETE from userid WHERE id = '" + id +
                  "' AND pwd = '" + pwd + "'";     
            
            int x = stmt.executeUpdate(q1);
            if (x > 0)           
                System.out.println("Successfully delete");           
            else          
                System.out.println("Delete Failed");            
            conexion.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void consultarInfoBBDD()
    {
        String id = "id2";
        String pwd = "newpwd";
        try
        {
            Connection conexion =getConexion();
            Statement stmt = conexion.createStatement();
            String q1 = "select * from userid WHERE id = '" + id + "'"; 
            //+ "' AND pwd = '" + pwd + "'";
			ResultSet rs = stmt.executeQuery(q1);
			 if (rs.next())
			   {
			       System.out.println("User-Id: " + rs.getString(1));
			       System.out.println("Pwd: "+ rs.getString(2));
			       System.out.println("Full Name: " + rs.getString(3));
			       System.out.println("E-mail: " + rs.getString(4));
			    }
			else
			{
			 System.out.println("No such user id is already registered");
			}    
            conexion.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
