package es.iestetuan.dam2.DAO;
import es.iestetuan.dam2.VO.Departamento;

public interface IDepartamento {
	
	public void crearDepartamento(Departamento departamento);
	public void modificarDepartamento(Departamento departamento, int pk);
	public void borrarDepartamento(int idDepartamento);
	public void consultarDepartamento(int idDepartamento);

}
