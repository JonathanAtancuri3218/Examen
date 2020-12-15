package ec.ups.edu.g1.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.g1.modelo.Solicitud;

public class SolicitudDAO {
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;

	public boolean insert(Solicitud solicitud) throws SQLException {
		em.persist(solicitud);
		
		return true;
	}
	public boolean update(Solicitud solicitud) throws SQLException {
		em.merge(solicitud);
		return true;
	}
	public Solicitud read(int id){
		Solicitud solicitud=em.find(Solicitud.class, id);
		return solicitud;
	}
	public boolean delete(int id) throws SQLException {
		Solicitud solicitud= this.read(id);
		em.remove(solicitud);
		return true;

	}
	public List<Solicitud> getClientes(){
		String jpql="SELECT c FROM Solicitud c WHERE numeroSolicitud=?1";
		
		Query q= em.createQuery(jpql, Solicitud.class);
		q.setParameter(1,1);

		return (List<Solicitud>)q.getResultList();
		
	}
	
	
}
