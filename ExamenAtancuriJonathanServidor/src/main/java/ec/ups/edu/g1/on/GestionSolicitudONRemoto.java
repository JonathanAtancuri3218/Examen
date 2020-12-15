package ec.ups.edu.g1.on;

import javax.ejb.Remote;

import ec.ups.edu.g1.modelo.Solicitud;

@Remote
public interface GestionSolicitudONRemoto {

	public boolean registraSolicitud(Solicitud solicitud);

}
