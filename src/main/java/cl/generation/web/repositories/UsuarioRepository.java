package cl.generation.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.generation.web.models.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{  
	//logica de manipulacion de datos(CRUD+)
	
	Usuario findByCorreo(String correo); //cuando usamos un findBy+nombreatributo, spring entiende que estamos en búsqueda de determinado atributo.
	Usuario findByNick(String nick);
	

}
