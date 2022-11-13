package model.evaluacion;

import model.docente.BeanDocente;
import model.estudiante.BeanEstudiante;

public class BeanEvaluacion {
    private Long id;
    private String nombreMateria;
    private Long calificacion;
    private BeanEstudiante estudiante;
    private BeanDocente docente;

    public BeanEvaluacion() {
    }

    public BeanEvaluacion(Long id, String nombreMateria, Long calificacion, BeanEstudiante estudiante, BeanDocente docente) {
        this.id = id;
        this.nombreMateria = nombreMateria;
        this.calificacion = calificacion;
        this.estudiante = estudiante;
        this.docente = docente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Long getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Long calificacion) {
        this.calificacion = calificacion;
    }

    public BeanEstudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(BeanEstudiante estudiante) {
        this.estudiante = estudiante;
    }

    public BeanDocente getDocente() {
        return docente;
    }

    public void setDocente(BeanDocente docente) {
        this.docente = docente;
    }
}
