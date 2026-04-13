package sis_414.practica.controller;

import sis_414.practica.model.Pelicula;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PeliculaController {

    private List<Pelicula> misPeliculas = new ArrayList<>();

    public PeliculaController() {
    misPeliculas.add(new Pelicula("Inception", "Christopher Nolan", 2010, 148, "Ciencia Ficcion", "Un ladrón entra en los sueños."));
    misPeliculas.add(new Pelicula("Interstellar", "Christopher Nolan", 2014, 169, "Ciencia Ficcion", "Viaje espacial para salvar la humanidad."));
    misPeliculas.add(new Pelicula("The Matrix", "Lana Wachowski", 1999, 136, "Acción", "Un hacker descubre la realidad."));
    misPeliculas.add(new Pelicula("Gladiator", "Ridley Scott", 2000, 155, "Acción", "Un general busca venganza."));
    misPeliculas.add(new Pelicula("Avatar", "James Cameron", 2009, 162, "Ciencia Ficcion", "Un mundo alienígena impresionante."));
    misPeliculas.add(new Pelicula("The Lion King", "Roger Allers", 1994, 88, "Animación", "Historia de Simba."));
    misPeliculas.add(new Pelicula("Spider-Man", "Sam Raimi", 2002, 121, "Acción", "Origen del hombre araña."));
    misPeliculas.add(new Pelicula("Iron Man", "Jon Favreau", 2008, 126, "Acción", "Nacimiento de un héroe."));
    misPeliculas.add(new Pelicula("Frozen", "Chris Buck", 2013, 102, "Animación", "Reinas con poderes de hielo."));
    misPeliculas.add(new Pelicula("Coco", "Lee Unkrich", 2017, 105, "Animación", "Viaje al mundo de los muertos."));
    misPeliculas.add(new Pelicula("The Godfather", "Francis Ford Coppola", 1972, 175, "Drama", "Historia de la mafia."));
    misPeliculas.add(new Pelicula("Forrest Gump", "Robert Zemeckis", 1994, 142, "Drama", "Vida extraordinaria de un hombre."));
    misPeliculas.add(new Pelicula("The Avengers", "Joss Whedon", 2012, 143, "Acción", "Héroes unidos contra Loki."));
    misPeliculas.add(new Pelicula("Harry Potter", "Chris Columbus", 2001, 152, "Fantasia", "Un joven mago inicia su aventura."));
    misPeliculas.add(new Pelicula("Pirates of the Caribbean", "Gore Verbinski", 2003, 143, "Aventura", "Piratas y tesoros."));
}

    @GetMapping("/peliculas")
    public List<Pelicula> listarPeliculas() {
        return misPeliculas;
    }

    @PostMapping("/peliculas")
    public String agregarPelicula(@RequestBody Pelicula nuevaPelicula) {
        misPeliculas.add(nuevaPelicula);
        return "Película '" + nuevaPelicula.getTitulo() + "' agregada con éxito!";
    }

    @PutMapping("/peliculas/{indice}")
    public String actualizarPelicula(@PathVariable int indice, @RequestBody Pelicula peliculaActualizada) {
        if (indice >= 0 && indice < misPeliculas.size()) {
            misPeliculas.set(indice, peliculaActualizada);
            return "Película en la posición " + indice + " actualizada con éxito.";
        }
        return "Error: Índice fuera de rango.";
    }

    @DeleteMapping("/peliculas/{indice}")
    public String eliminarPelicula(@PathVariable int indice) {
        if (indice >= 0 && indice < misPeliculas.size()) {
            Pelicula eliminada = misPeliculas.remove(indice);
            return "Película '" + eliminada.getTitulo() + "' eliminada correctamente.";
        }
        return "Error: No se pudo encontrar la película para eliminar.";
    }
}