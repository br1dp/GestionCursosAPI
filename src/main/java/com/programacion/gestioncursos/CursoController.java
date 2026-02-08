package com.programacion.gestioncursos;

import com.programacion.gestioncursos.model.Curso;
import com.programacion.gestioncursos.model.Tema;
import com.programacion.gestioncursos.service.ICursoService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {

    @Autowired
    private ICursoService cursoService;

    @GetMapping("/cursos/traerCursos")
    public List<Curso> getCursos() {

        return cursoService.getCursos();

    }

    @PostMapping("/cursos/crear")
    public String saveCurso(@RequestBody Curso curso) {

        cursoService.saveCurso(curso);

        return "El curso fue creado exitosamente";

    }

    @DeleteMapping("/cursos/borrar/{id_curso}")
    public String deleteCurso(@PathVariable Long id_curso) {

        cursoService.deleteCurso(id_curso);

        return "El curso fue eliminado exitosamente";

    }

    @GetMapping("/cursos/traer/{id_curso}")
    public Curso findCurso(@PathVariable Long id_curso) {

        return cursoService.findCurso(id_curso);

    }
    
    @GetMapping("/cursos/obtenerTemasCurso/{id_curso}")
    public List<Tema> findTemasCurso(@PathVariable Long id_curso){
        
        Curso curso = cursoService.findCurso(id_curso);
        List<Tema> listaTemas = curso.getLista_temas();
        
        return listaTemas;
    }
    
    @GetMapping("/cursos/buscarPalabra/{palabra}")
    public ArrayList<Curso> findWord(@PathVariable String palabra){
        
        ArrayList<Curso> listaCursos = new ArrayList(cursoService.findWord(palabra));
        
        return listaCursos;
        
    }
    
    @PutMapping("/cursos/editar/{id_original}")
    public Curso editCurso(@PathVariable Long id_original,
            @RequestParam(required = false, name = "nombre") String nombre,
            @RequestParam(required = false, name = "modalidad") String modalidad,
            @RequestParam(required = false, name = "fecha_finalizacion") LocalDate fecha_finalizacion,
            @RequestParam(required = false, name = "lista_temas") List<Tema> lista_temas) {

        cursoService.editCurso(id_original, nombre, modalidad, fecha_finalizacion, lista_temas);

        Curso curso = cursoService.findCurso(id_original);

        return curso;
    }
}
