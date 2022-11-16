package cl.generation.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.generation.web.models.Usuario;
import cl.generation.web.repositories.UsuarioRepository;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	//Logica de negocio del sistema web
	@Autowired //facilita la inyeccion
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
		
		//hacemos llamado al método guardar
		return usuarioRepository.save(usuario);
	}

}