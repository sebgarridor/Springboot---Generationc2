package cl.generation.web.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
