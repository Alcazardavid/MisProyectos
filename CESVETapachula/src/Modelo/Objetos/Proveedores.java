package Modelo.Objetos;

public class Proveedores {
    
    private int id;
    private String nombre;
    private String Telefono;

    public Proveedores() {
    }

    public Proveedores(int id, String nombre, String Telefono) {
        this.id = id;
        this.nombre = nombre;
        this.Telefono = Telefono;
    }

    public Proveedores(String nombre, String Telefono) {
        this.nombre = nombre;
        this.Telefono = Telefono;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    
}