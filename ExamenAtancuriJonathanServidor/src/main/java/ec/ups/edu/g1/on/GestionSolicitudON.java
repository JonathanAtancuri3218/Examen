package ec.ups.edu.g1.on;

import java.sql.SQLException;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.g1.dao.PersonaDAO;
import ec.ups.edu.g1.dao.SolicitudDAO;
import ec.ups.edu.g1.modelo.Persona;
import ec.ups.edu.g1.modelo.Solicitud;

@Stateless
public class GestionSolicitudON implements GestionSolicitudONRemoto {
	

	@Inject
	private SolicitudDAO daoSolicitud;
	@Inject
	private PersonaDAO daoPersona;
	
	public boolean registraSolicitud(Solicitud solicitud) {
		try {
			Persona persona=solicitud.getPersona();
			   if(daoPersona.read(persona.getCedula())!=null){
				      daoPersona.update(persona);
				}else{
				     daoPersona.insert(persona);

				}
			    solicitud.setFecha(new Date());
				daoSolicitud.insert(solicitud);
			}catch(Exception e) {
				e.printStackTrace();
			}
				return true;
	
	}

}
