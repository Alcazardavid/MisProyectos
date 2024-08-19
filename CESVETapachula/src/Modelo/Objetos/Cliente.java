package Modelo.Objetos;

public class Cliente {
    
    
    
    private int id;
    private String nombre;
    private int edad;
    private String Telefono;

    public Cliente() {
    }

    public Cliente(int id, String nombre, int edad, String Telefono) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
}