package com.programacion.gestioncursos.service;

import com.programacion.gestioncursos.model.Curso;
import com.programacion.gestioncursos.model.Tema;
import com.programacion.gestioncursos.repository.ICursoRepository;
import java.time.LocalDate;
import java.util.List;
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
        
        if(curso.getLista_temas() != null){
            for(Tema tema : curso.getLista_temas()){
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
    public Curso editCurso(Long idOriginal, Long idNueva, String nombre, String modalidad, LocalDate fecha_finalizacion, List<Tema> lista_temas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
