package cl.generation.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.generation.web.models.Auto;
import cl.generation.web.repositories.AutoRepository;

@Service
public class AutoServiceImpl implements AutoService{
	
	@Autowired
	private AutoRepository autoRepository;

	@Override
	public Auto guardarAuto(Auto auto) {
		
		return autoRepository.save(auto);
	}

	@Override
	public String eliminarAuto(Long id) {
		
		autoRepository.deleteById(id);
		
		return "El auto ha sido eliminado de la base de datos";
	}

	@Override
	public String actualizarAuto(Auto auto) {
		autoRepository.save(auto);
		return "Los datos del auto han sido actualizados";
	}

	@Override
	public Auto obtenerAuto(Long id) {
		
		
		
		return autoRepository.findById(id).get();
	}
	
	
	
	

}
