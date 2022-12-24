package cl.generation.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.generation.web.models.Auto;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long>{

	Auto findByNombre(String nombre);
	Auto findByMarca(String marca);
	
	//JPQL
	
	//obtener una lista de autos por marca
	
	@Query("SELECT a FROM Auto a WHERE a.marca = ?1")
	List<Auto> findbAllByMarca(String marca); 
	
	
	
	//query comun
	@Query(value="select * from auto a where a.marca = ?1", nativeQuery = true)
	List<Auto> findbAllByMarcaComun(String marca); 
	
	
	//JPQL listar todos los autos de un usuario
	@Query("SELECT a FROM Auto a WHERE a.usuario.id = ?1")
	List<Auto> findAllByUsuario(Long id);

}
