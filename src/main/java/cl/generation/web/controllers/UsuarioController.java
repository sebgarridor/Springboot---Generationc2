package cl.generation.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {
	
	
	//https://localhost:8080/
	@RequestMapping("/")
	public String getUsuario() {
		System.out.println("Metodo de obtener usuario");
		return "index.jsp";
		
	}

}
