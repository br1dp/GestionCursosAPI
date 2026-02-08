package com.programacion.gestioncursos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Curso {

    private Long id_curso;
    private String nombre;
    private String modalidad;
    private LocalDate fecha_finalizacion;
    private List<Tema> lista_temas;

}
