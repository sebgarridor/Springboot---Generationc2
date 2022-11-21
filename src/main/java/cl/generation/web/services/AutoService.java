package cl.generation.web.services;

import cl.generation.web.models.Auto;


public interface AutoService {
	
	
	public Auto guardarAuto(Auto auto);
	
	public String eliminarAuto(Long id);
	
	public String actualizarAuto(Auto auto);
	
	public Auto obtenerAuto(Long id);
	
}
