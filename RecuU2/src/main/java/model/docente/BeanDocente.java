package model.docente;

public class BeanDocente {
    private Long id;
    private String nombre;
    private String apellidos;
    private String fechaN;
    private String curp;
    private Long numeroEmp;

    public BeanDocente() {
    }

    public BeanDocente(Long id, String nombre, String apellidos, String fechaN, String curp, Long numeroEmp) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaN = fechaN;
        this.curp = curp;
        this.numeroEmp = numeroEmp;
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

    public Long getNumeroEmp() {
        return numeroEmp;
    }

    public void setNumeroEmp(Long numeroEmp) {
        this.numeroEmp = numeroEmp;
    }
}
