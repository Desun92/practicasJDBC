package es.iestetuan.dam2.VO;
import java.sql.Date;

public class Empleado {
	
	private int numero;
	private String apellido;
	private String oficio;
	private Integer dir;
	private Date fechaAlta;
	private Float salario;
	private Float comision;
	private int numDepto;
	
	public Empleado(int numero, String apellido, String oficio, Integer dir, Date fechaAlta, Float salario, Float comision, int numDepto) {
		this.numero=numero;
		this.apellido=apellido;
		this.oficio=oficio;
		this.dir=dir;
		this.fechaAlta=fechaAlta;
		this.salario=salario;
		this.comision=comision;
		this.numDepto=numDepto;
	}
	
	public String toString() {
		return "Empleado [numero=" + numero + ", apellido=" + apellido + ", oficio=" + oficio + ", dir=" + dir
				+ ", fechaAlta=" + fechaAlta + ", salario=" + salario + ", comision=" + comision + ", numDepto="
				+ numDepto + "]";
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

	public int getNumDepto() {
		return numDepto;
	}

	public void setNumDepto(int numDepto) {
		this.numDepto = numDepto;
	}
	
	

}
