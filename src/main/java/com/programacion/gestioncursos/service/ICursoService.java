package com.programacion.gestioncursos.service;

import com.programacion.gestioncursos.model.Curso;
import com.programacion.gestioncursos.model.Tema;
import java.time.LocalDate;
import java.util.List;

public interface ICursoService {

    public List<Curso> getCursos();

    public void saveCurso(Curso curso);

    public void deleteCurso(Long id);

    public Curso findCurso(Long id);

    public Curso editCurso(Long idOriginal, Long idNueva, String nombre,
            String modalidad, LocalDate fecha_finalizacion, List<Tema> lista_temas);
}
