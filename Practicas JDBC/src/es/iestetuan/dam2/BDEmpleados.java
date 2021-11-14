package es.iestetuan.dam2;

import java.sql.Date;

import es.iestetuan.dam2.DAO.IDepartamento;
import es.iestetuan.dam2.DAO.IEmpleado;
import es.iestetuan.dam2.DAO.IMP.GestionDepartamento;
import es.iestetuan.dam2.DAO.IMP.GestionEmpleado;
import es.iestetuan.dam2.VO.Departamento;
import es.iestetuan.dam2.VO.Empleado;

public class BDEmpleados {

	public static void main(String[] args) {
		
		
		Departamento departamento = new Departamento(100,"PRUEBA2","MADRID");
		Date fecha = new Date(2021/11/14);
		Empleado empleado = new Empleado(8003,"VAZQUEZ","ANALISTA",7780,fecha,2000f,0f,10);
		IDepartamento gestion = new GestionDepartamento();
		IEmpleado gestionEmple = new GestionEmpleado();
		
		//gestion.crearDepartamento(departamento);
		//gestion.modificarDepartamento(departamento,60);
		//gestion.borrarDepartamento(100);
		//gestion.consultarDepartamento(10);
		
		//-----------------------------------------------
		
		//gestionEmple.crearEmpleado(empleado);
		//gestionEmple.modificarEmpleado(empleado, 8003);
		//gestionEmple.borrarEmpleado(8003);
		gestionEmple.consultarEmpleado(7902);
	}
	
}