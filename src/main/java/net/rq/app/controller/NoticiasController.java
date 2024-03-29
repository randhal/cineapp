package net.rq.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.rq.app.model.Noticia;
import net.rq.app.service.INoticiasService;

@Controller
@RequestMapping(value="/noticias")
public class NoticiasController {
	
	
	@Autowired
	private INoticiasService serviceNoticias;
	
	@GetMapping(value="/create")
	public String crear() {
		return "noticias/formNoticias";
	}
	
	@PostMapping(value="/save")
	public String guardar(Noticia noticia) {
		
		//Pendiente guardar el objeto Noticia en BD
		
		serviceNoticias.guardar(noticia);
		
		return "noticias/formNoticias";
	}
}
