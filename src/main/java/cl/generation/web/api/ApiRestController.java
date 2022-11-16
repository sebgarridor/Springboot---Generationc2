package cl.generation.web.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiRestController {
	
	// http://localhost:8080/api/hola
	@RequestMapping("/hola")
	public String hola() {
		return "hola api";
	}
	
	// http://localhost:8080/api/edad/25
	@RequestMapping("/edad/{edad}")
	public String rutaDinamica(@PathVariable("edad") int edad) {
		return "Capturando edad:" + edad;
	}
	
	// http://localholst:8080/api/nombre/sebastian
	@RequestMapping("/nombre/{nombre}")
	public String capturarNombre(@PathVariable("nombre")String nombre) {
		return "El nombre capturado es: " +nombre;
	}
	
	// http://localhost:8080/api/14/noviembre/2022
	
	@RequestMapping("/{dia}/{mes}/{año}")
	public String capturar(@PathVariable("dia")int dia, @PathVariable("mes") String mes, @PathVariable("año")  int año) {
		return "La fecha de hoy es: "+dia +mes +año;
	}
	
	//http://localhost:8080/api/usuario?usuarioId=1&nombre=sebastian// a través de GET
	// capturamos otro valor aparte de usuarioId
	@RequestMapping("/usuario2")
	public String parametro2(@RequestParam(value="usuarioId",required = false) Integer id,
			@RequestParam(value="nombre",required = false) String nombre) {
		//int , long , float =0
		//Integer, Float, Long... pueden ser nulos
		if(id == null) {
			return "parametro no existe";
		}else {
			return "parametro por get  "+id + " nombre:" +nombre;
		}
	}
	
	
	//http://localhost:8080/api/usuario?usuarioId=1// a través de GET
	@RequestMapping("/usuario")
	public String parametro(@RequestParam(value="usuarioId",required = false) Integer id ) {
		//int , long , float =0
		//Integer, Float, Long... pueden ser nulos
		if(id == null) {
			return "parametro no existe";
		}else {
			return "parametro por get "+id;
		}
	}
	 

	 


}
