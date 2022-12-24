package cl.generation.web.services;

import java.util.List;
import java.util.Optional;

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
		if(auto.getId()!= null) {
			//logica de traspasar informacion de AutoDTO 
		}
			
		return autoRepository.save(auto);
	}

	@Override
	public String eliminarAuto(Long id) {
		
		autoRepository.deleteById(id);
		System.out.println("pasando por el serviceimpl" + id);
		
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

	@Override
	public List<Auto> listarAutos() {
		// TODO Auto-generated method stub
		return autoRepository.findAll();
	}

	public Auto obtenerAutoNombre(String nombre) {
		// TODO Auto-generated method stub
		return autoRepository.findByNombre(nombre);
	}

	@Override
	public List<Auto> findAllByUsuario(Long id) {
		// TODO Auto-generated method stub
		return autoRepository.findAllByUsuario(id);
	}
	
	@Override
	public Auto editarAuto(Long id, Auto auto) {
		Optional<Auto> autoParaEditar = autoRepository.findById(id);
		Auto autoEditado = autoParaEditar.get();
		autoEditado.setMarca(auto.getMarca());
		autoEditado.setColor(auto.getColor());
		autoRepository.save(autoEditado);
		return autoEditado;
	}




	}



	
	
	


