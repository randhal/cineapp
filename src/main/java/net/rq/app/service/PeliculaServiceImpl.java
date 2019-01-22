package net.rq.app.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.rq.app.model.Pelicula;

@Service
public class PeliculaServiceImpl implements IPeliculaService{
	
	private List<Pelicula> lista = null;
	
	public PeliculaServiceImpl() {
		
		System.out.println("Creando una instancia de la clase PeliculasServiceImpl");
		
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			lista = new LinkedList<>();
			
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Ranger");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formato.parse("21-01-1993"));
			
			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(1);
			pelicula2.setTitulo("Bella");
			pelicula2.setDuracion(120);
			pelicula2.setClasificacion("B");
			pelicula2.setGenero("Aventura");
			pelicula2.setFechaEstreno(formato.parse("21-01-1993"));
			pelicula2.setImagen("bella.png");
			
			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(1);
			pelicula3.setTitulo("Contratiempo");
			pelicula3.setDuracion(120);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Aventura");
			pelicula3.setFechaEstreno(formato.parse("21-01-1993"));
			pelicula3.setImagen("contratiempo.png");
			
			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(1);
			pelicula4.setTitulo("Kong");
			pelicula4.setDuracion(120);
			pelicula4.setClasificacion("B");
			pelicula4.setGenero("Aventura");
			pelicula4.setFechaEstreno(formato.parse("21-01-1993"));
			pelicula4.setImagen("kong.png");
			pelicula4.setEstatus("Inactiva");
			
			Pelicula pelicula5 = new Pelicula();
			pelicula5.setId(1);
			pelicula5.setTitulo("Vida Inteligente");
			pelicula5.setDuracion(120);
			pelicula5.setClasificacion("B");
			pelicula5.setGenero("Drama");
			pelicula5.setFechaEstreno(formato.parse("21-01-1993"));
			pelicula5.setImagen("estreno5.png");
			pelicula5.setEstatus("Inactiva");
			
			//Agregamos los objetos Pelicula 
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
			lista.add(pelicula5);
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}

	@Override
	public List<Pelicula> buscarTodas() {
		return lista;
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		for (Pelicula p : lista) {
			if(p.getId() == idPelicula) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void insertar(Pelicula pelicula) {
		lista.add(pelicula);
	}

}
