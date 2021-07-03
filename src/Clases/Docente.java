
package Clases;
public class Docente {
    private int coddoc;
    private String apellido;
    private String nombre;
    private int dni;
    private int telefono;
    private String direccion;
    private String genero;
    private int idPeriodo;
    //Creacion del constructor 
    public Docente(){
        
    }
    //Sobrecarga de constructores
    public Docente(int coddoc,String nombre,String apellido){
        this.coddoc=coddoc;
        this.nombre=nombre;
        this.apellido=apellido;
    }
    public int getCoddoc() {
        return coddoc;
    }

    public void setCoddoc(int coddoc) {
        this.coddoc = coddoc;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    @Override
    public String toString(){
        return nombre+" "+apellido;
    }
}
