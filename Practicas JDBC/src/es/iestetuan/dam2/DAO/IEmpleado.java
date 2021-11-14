package es.iestetuan.dam2.DAO;
import es.iestetuan.dam2.VO.Empleado;

public interface IEmpleado {
	
	public void crearEmpleado(Empleado empleado);
	public void modificarEmpleado(Empleado empleado, int pk);
	public void borrarEmpleado(int idEmpleado);
	public void consultarEmpleado(int idEmpleado);
	public void consultarEmpleadoApellidoSalario(String apellido, Float Salario);

}
