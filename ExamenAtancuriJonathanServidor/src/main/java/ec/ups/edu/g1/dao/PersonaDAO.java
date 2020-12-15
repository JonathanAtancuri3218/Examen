package ec.ups.edu.g1.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.g1.modelo.Persona;
import ec.ups.edu.g1.modelo.Solicitud;

public class PersonaDAO {

	
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;

	public boolean insert(Persona persona) throws SQLException {
		em.persist(persona);
		
		return true;
	}
	public boolean update(Persona persona) throws SQLException {
		em.merge(persona);
		return true;
	}
	public Persona read(String cedula){
		Persona persona=em.find(Persona.class, cedula);
		return persona;
	}
	public boolean delete(String cedula) throws SQLException {
		Persona persona= this.read(cedula);
		em.remove(persona);
		return true;

	}
	public List<Persona> getClientes(){
		String jpql="SELECT c FROM Persona c WHERE cedula=?1";
		
		Query q= em.createQuery(jpql, Solicitud.class);
		q.setParameter(1,1);

		return (List<Persona>)q.getResultList();
		
	}
	
}
