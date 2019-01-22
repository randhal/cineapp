package net.rq.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.rq.app.Utileria.Utileria;
import net.rq.app.model.Pelicula;
import net.rq.app.service.IPeliculaService;

@Controller
public class HomeController {
	
	@Autowired
	private IPeliculaService servicePeliculas;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	//Metodo Buscar
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model){
		System.out.println("Buscando todas las peliculas en exhivicion para la fecha :"+ fecha);
		
		List<String> listasFechas = Utileria.getNextDay(4);
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		model.addAttribute("fechas", listasFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		return "home";
	}
	
	//Inicio de Pagina
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model){
		List<String> listasFechas = Utileria.getNextDay(4);
		
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		model.addAttribute("fechas", listasFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		return "home";
	}
	
	//FORMA DE REQUESTPARAM
//	@RequestMapping(value="/detail", method=RequestMethod.GET)
//	public String mostrarDetalle1(Model model,@RequestParam("idMovie") int idPelicula, @RequestParam("fecha") String fecha) {
//		System.out.println("idPelicula: "+ idPelicula);
//		System.out.println("FechaBusqueda : "+ fecha);
//		return "detalle";
//	}
	
	//FORMA DE PATHVARIBLE
	@RequestMapping(value="detail/{id}/{fecha}", method=RequestMethod.GET)
	public String mostrarDetalle(Model model,@PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha) {
		System.out.println("idPelicula: "+ idPelicula);
		System.out.println("FechaBusqueda : "+ fecha);
		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));
		
		return "detalle";
	}
	
//	//Metodo para generar una lista de Objetos de Modelo (PELICULA)
//	private List<Pelicula> getLista(){
//		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
//		List<Pelicula> lista = null;
//		
//		try {
//			lista = new LinkedList<>();
//			
//			Pelicula pelicula1 = new Pelicula();
//			pelicula1.setId(1);
//			pelicula1.setTitulo("Power Ranger");
//			pelicula1.setDuracion(120);
//			pelicula1.setClasificacion("B");
//			pelicula1.setGenero("Aventura");
//			pelicula1.setFechaEstreno(formato.parse("21-01-1993"));
//			
//			Pelicula pelicula2 = new Pelicula();
//			pelicula2.setId(1);
//			pelicula2.setTitulo("Bella");
//			pelicula2.setDuracion(120);
//			pelicula2.setClasificacion("B");
//			pelicula2.setGenero("Aventura");
//			pelicula2.setFechaEstreno(formato.parse("21-01-1993"));
//			pelicula2.setImagen("bella.png");
//			
//			Pelicula pelicula3 = new Pelicula();
//			pelicula3.setId(1);
//			pelicula3.setTitulo("Contratiempo");
//			pelicula3.setDuracion(120);
//			pelicula3.setClasificacion("B");
//			pelicula3.setGenero("Aventura");
//			pelicula3.setFechaEstreno(formato.parse("21-01-1993"));
//			pelicula3.setImagen("contratiempo.png");
//			
//			Pelicula pelicula4 = new Pelicula();
//			pelicula4.setId(1);
//			pelicula4.setTitulo("Kong");
//			pelicula4.setDuracion(120);
//			pelicula4.setClasificacion("B");
//			pelicula4.setGenero("Aventura");
//			pelicula4.setFechaEstreno(formato.parse("21-01-1993"));
//			pelicula4.setImagen("kong.png");
//			pelicula4.setEstatus("Inactiva");
//			
//			Pelicula pelicula5 = new Pelicula();
//			pelicula5.setId(1);
//			pelicula5.setTitulo("Vida Inteligente");
//			pelicula5.setDuracion(120);
//			pelicula5.setClasificacion("B");
//			pelicula5.setGenero("Drama");
//			pelicula5.setFechaEstreno(formato.parse("21-01-1993"));
//			pelicula5.setImagen("estreno5.png");
//			pelicula5.setEstatus("Inactiva");
//			
//			//Agregamos los objetos Pelicula 
//			lista.add(pelicula1);
//			lista.add(pelicula2);
//			lista.add(pelicula3);
//			lista.add(pelicula4);
//			lista.add(pelicula5);
//			return lista;
//			
//		} catch (Exception e) {
//			System.out.println("ERROR: " + e.getMessage());
//			return null;
//		}
//	};
	
}
