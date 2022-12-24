package cl.generation.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.generation.web.models.Usuario;
import cl.generation.web.services.UsuarioServiceImpl;

@Controller
@RequestMapping("/registro")
public class RegistroController {
	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl; //variable de tipo UsuarioServiceImpl, lógica de negocios del sistema web
	
	//capturar la url y desplegar el .jsp (controlador)
	
	
	
	/* http://localhost:8080/registro/usuario GET -> desplegar el registro.jsp
	 * http://localhost:8080/registro/usuario POST -> capturar los datos en el controlador
	 * 
	 * http://localhost:8080/registro/login GET -> desplegar el login.jsp
	 * http://localhost:8080/registro/login POST -> capturar los datos (email y password) en el controlador
	 * 
	 */
	@GetMapping("/usuario")
	public String mostrarFormulario() {
		return "registro.jsp";
	}
	//el usuario llena el formulario (vista)
	//enviamos el formulario con el botón 'submit'/'enviar'(vista)
	//capturar la url otra vez http://localhost:8080/registro/formulario
	
	@PostMapping("/usuario")
	//capturar los parametros @RequestParam
	public String guardarFormulario(@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("nick") String nick,
			@RequestParam("correo") String correo,
			@RequestParam("password") String password,
			@RequestParam("password2") String password2,
			Model model) { //con el Model model traspasamos la información desde el backend hacia el frontend
		
		System.out.println(nombre+" "+apellido+" "+correo+" "+nick+" "+password);
		
		if (password.equals(password2)) { //si las passwords son iguales, llenamos el objeto usuario 
		//instanciamos un objeto usuario
		
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setCorreo(correo);
		usuario.setPassword(password);
		usuario.setNick(nick);
		usuario.setPassword2(password2);
		
		// enviar a base de datos
		Boolean resultado = usuarioServiceImpl.guardarUsuario(usuario); //el objeto usuario se lo pasamos a la implementación, se lo pasamos para acceder a los métodos definidos en el UsuarioService
		
		if(resultado) { //si es verdadero
			model.addAttribute("msgOk", "Registro exitoso");
			return "login.jsp"; //enviar a una vista
		}else {
			model.addAttribute("msgError", "Email ya registrado");  // (variable, mensaje a mostrar) ojo que la variable debe ser la misma que va en ${} en el c:out value
			return "registro.jsp"; //si el correo no está registrado, me devuelve al registro + el error.
		}
		 //enviar a una vista, para retornar una vista siempre debemos devolver un String
		
		}else { //cuando password no es igual a password2
			model.addAttribute("msgError", "Password distintos");
			return "registro.jsp";
		}
	}

	
	@GetMapping("/login") //desplegamos la vista login.jsp
	public String login() {
		return "login.jsp";
	}
	
	//capturando el email y password
	@PostMapping("/login")
	public String ingresoUsuario(@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model,
			HttpSession session) {
		
		//llamando al método
		Boolean resultadoLogin = usuarioServiceImpl.ingresarUsuario(email, password);
		
		if(resultadoLogin) { //si resultadoLogin == true, login correcto.
			Usuario usuario = usuarioServiceImpl.obtenerUsuarioEmail(email);
			//guardar información en sesión
			session.setAttribute("usuarioId", usuario.getId());
			session.setAttribute("usuarioEmail", usuario.getCorreo());
			session.setAttribute("usuarioRol", usuario.getRoles());
			session.setAttribute("usuarioNombre", usuario.getNombre() + usuario.getApellido());
			
			return "redirect:/home";
			
		}else {
			model.addAttribute("msgError", "Por favor verifica tus datos ingresados");
			return "login.jsp";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("usuarioId")!= null) {
			session.invalidate(); //el invalidate mata toda la sesion
			
		}
		return "redirect:/registro/login";
	}

}
