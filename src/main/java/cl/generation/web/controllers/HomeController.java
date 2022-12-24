package cl.generation.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.generation.web.models.Auto;
import cl.generation.web.services.AutoServiceImpl;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	AutoServiceImpl autoServiceImpl;
	
	
	
	@GetMapping("")
	public String home(Model model, HttpSession session) {
		
		if(session.getAttribute("usuarioId")!= null) {
			
			//capturando las variables de sesion.
			String email = (String) session.getAttribute("usuarioEmail");
			Long usuarioId = (Long) session.getAttribute("usuarioId");
			String nombre = (String) session.getAttribute("usuarioNombre");
			List<Auto> listaAutos = autoServiceImpl.listarAutos(); //la info de los autos la estamos almacenando en una Lista de tipo Autos llamado listaAutos.
			
			//pasando lista de autos al .jsp
			model.addAttribute("autos", listaAutos); //en la primera variable va el nombre con el que lo capturaremos en el .jsp
			
			
			List<Auto> listaSelectAutos = autoServiceImpl.listarAutos(); 
			model.addAttribute("listaSelectAutos", listaSelectAutos);
			
			//pasasndo la variable de sesion al jsp.
			model.addAttribute("usuarioNombre", nombre);
			
			return "home.jsp";
			
		}else {
			return "redirect:/registro/login";
		}
		
		//queremos pasar una lista de autos

	}
	
	@PostMapping("")
	public String filtrarAuto(@RequestParam("autoSeleccionado")Long id, Model model) {
		
		List<Auto> listaAutos = new ArrayList<Auto>(); //lista vacia
		
		//obteniendo el id del auto.
		Auto auto = autoServiceImpl.obtenerAuto(id);
		listaAutos.add(auto); //agrego el auto a la lista
		
		//pasando lista de autos al .jsp
		model.addAttribute("autos", listaAutos); //en la primera variable va el nombre con el que lo capturaremos en el .jsp
		
		List<Auto> listaSelectAutos = autoServiceImpl.listarAutos(); 
		model.addAttribute("listaSelectAutos", listaSelectAutos);
		
		return "home.jsp";
		
	}
	
	@PostMapping("/nav")
	public String filtrarNav(@RequestParam("nombre") String nombre, Model model) {
		
		List<Auto> listaAutos = new ArrayList<Auto>(); //lista vacia
		
		//obteniendo el id del auto.
		Auto auto = autoServiceImpl.obtenerAutoNombre(nombre);
		listaAutos.add(auto); //agrego el auto a la lista
		
		//pasando lista de autos al .jsp
		model.addAttribute("autos", listaAutos); //en la primera variable va el nombre con el que lo capturaremos en el .jsp
		
		List<Auto> listaSelectAutos = autoServiceImpl.listarAutos(); 
		model.addAttribute("listaSelectAutos", listaSelectAutos);
		
		return "home.jsp";
		
	}
	

}
