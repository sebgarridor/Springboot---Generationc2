package cl.generation.web.services;

import java.util.List;

import cl.generation.web.models.Auto;


public interface AutoService {
	
	
	public Auto guardarAuto(Auto auto);
	
	public String eliminarAuto(Long id);
	
	public String actualizarAuto(Auto auto);
	
	public Auto obtenerAuto(Long id);
	
	public Auto editarAuto(Long id,Auto auto);

	
	
	
	public List<Auto> listarAutos();
	
	public List<Auto> findAllByUsuario(Long id);
}
