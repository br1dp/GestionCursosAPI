package com.programacion.gestioncursos.service;

import com.programacion.gestioncursos.model.Curso;
import com.programacion.gestioncursos.model.Tema;
import com.programacion.gestioncursos.repository.ICursoRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private ICursoRepository cursoRepository;

    @Override
    public List<Curso> getCursos() {

        return cursoRepository.findAll();

    }

    @Override
    public void saveCurso(Curso curso) {

        if (curso.getLista_temas() != null) {
            for (Tema tema : curso.getLista_temas()) {
                tema.setCurso(curso);
            }
        }

        cursoRepository.save(curso);

    }

    @Override
    public void deleteCurso(Long id) {

        cursoRepository.deleteById(id);

    }

    @Override
    public Curso findCurso(Long id) {

        return cursoRepository.findById(id).orElse(null);

    }

    @Override
    public void editCurso(Long idOriginal, String nombre, String modalidad, LocalDate fecha_finalizacion, List<Tema> lista_temas) {

        Curso curso = this.findCurso(idOriginal);

        if (nombre != null) {
            curso.setNombre(nombre);
        }
        if (modalidad != null) {
            curso.setModalidad(modalidad);
        }
        if (fecha_finalizacion != null) {
            curso.setFecha_finalizacion(fecha_finalizacion);
        }
        if (lista_temas != null) {
            curso.setLista_temas(lista_temas);
        }

        this.saveCurso(curso);

    }

    @Override
    public List<Curso> findWord(String word) {

        List<Curso> listaCursos = cursoRepository.findAll();
        List<Curso> listaCursosPalabra = new ArrayList<>();
        
        Pattern pattern = Pattern.compile("\\b" + word + "\\b",Pattern.CASE_INSENSITIVE);
        
        Matcher matcher;
        
        for (Curso curso : listaCursos) {
            
            matcher = pattern.matcher(curso.getNombre());
            
            if (matcher.find()) {
                
                listaCursosPalabra.add(curso);
            }

        }

        return listaCursosPalabra;

    }

}
