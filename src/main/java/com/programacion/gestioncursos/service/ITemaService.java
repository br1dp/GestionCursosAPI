package com.programacion.gestioncursos.service;

import com.programacion.gestioncursos.model.Tema;
import java.util.List;

public interface ITemaService {

    public List<Tema> getTemas();

    public void saveTema(Tema tema);

    public void deleteTema(Long id);

    public Tema findTema(Long id);
    
    public Tema editTema(Long idOriginal, Long idNueva, String nombre, String descripcion);
}
