package model.estudiante;

public class BeanEstudiante {
    private Long id;
    private String nombre;
    private String apellidos;
    private String fechaN;
    private String curp;
    private String matricula;

    public BeanEstudiante() {
    }

    public BeanEstudiante(Long id, String nombre, String apellidos, String fechaN, String curp, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaN = fechaN;
        this.curp = curp;
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}


