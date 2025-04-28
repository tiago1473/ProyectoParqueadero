package controller;

public class Persona {
    private String identificacion;
    private String nombre;
    private String telefono;
    private String correo;

    // inicializando
    public Persona(String identificacion, String nombre, String telefono, String correo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
