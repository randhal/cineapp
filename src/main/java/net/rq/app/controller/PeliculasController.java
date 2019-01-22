package net.rq.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.rq.app.model.Pelicula;
import net.rq.app.service.IPeliculaService;

@Controller
@RequestMapping(value="/peliculas")
public class PeliculasController {
	
	@Autowired
	private IPeliculaService servicePeliculas;
	
	@GetMapping("/create")
	public String crear() {
		return "peliculas/formPeliculas";
	}
	
	//Mostrar una nueva interfaz
	@GetMapping("/index")
	public String mostrarIndex(Model model){
		List<Pelicula> lista = servicePeliculas.buscarTodas();
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}
	
	@PostMapping("/save")
	public String guardar(Pelicula pelicula, BindingResult  result) {
		
		for(ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage());
		}
		System.out.println("elementos en la lista antes del INSERT : " + servicePeliculas.buscarTodas().size());
		servicePeliculas.insertar(pelicula);
		System.out.println("elementos en la lista despues del INSERT : " + servicePeliculas.buscarTodas().size());
		return "peliculas/formPeliculas"; 
	}
	
	
	//Cambia el formato de fecha
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
	}
	
	
}
