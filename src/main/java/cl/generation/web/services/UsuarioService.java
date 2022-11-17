package cl.generation.web.services;

import java.util.List;
import java.util.Optional;

import cl.generation.web.models.Usuario;

public interface UsuarioService {
	
	//solo para definir metodos para crud Usuario
	public Usuario guardarUsuario(Usuario usuario);
	
	public String eliminarUsuario(Long id);
	
	public String actualizarUsuario(Usuario usuario);
	
	public Usuario obtenerUsuario(Long id);
	
	public List<Usuario> obtenerListaUsuarios();

}
