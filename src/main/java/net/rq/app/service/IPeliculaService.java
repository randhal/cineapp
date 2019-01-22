package net.rq.app.service;

import java.util.List;
import net.rq.app.model.Pelicula;


public interface IPeliculaService {
	
	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int idPelicula);
	void insertar(Pelicula pelicula);
	
	
}
