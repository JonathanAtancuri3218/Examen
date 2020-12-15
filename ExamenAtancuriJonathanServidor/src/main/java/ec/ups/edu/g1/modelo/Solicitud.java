package ec.ups.edu.g1.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Solicitud implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int numeroSolicitud;
	private String direccionRecogida;
	private String direccionEntrega;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	/*
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="cedula_persona")
	private List<Persona> listaSolicitudes;
	*/

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula")
	private Persona persona;
	
	
	
	public int getNumeroSolicitud() {
		return numeroSolicitud;
	}
	public void setNumeroSolicitud(int numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}
	public String getDireccionRecogida() {
		return direccionRecogida;
	}
	public void setDireccionRecogida(String direccionRecogida) {
		this.direccionRecogida = direccionRecogida;
	}
	public String getDireccionEntrega() {
		return direccionEntrega;
	}
	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
	
}
