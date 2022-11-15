package cl.generation.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario") //al ponerla aquí todas mis rutas tendrán de prefijo el usuario/
public class IndexController {
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("En el método index");
		return "index.jsp";
		
	}
	
	
	
	
	@RequestMapping("/seb/garrido")
	public String sebgarrido() {
		System.out.println("En el método de sebastián");
		return "seb";
	}
	

}
