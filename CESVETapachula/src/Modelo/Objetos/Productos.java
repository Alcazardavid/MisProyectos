
package Modelo.Objetos;

/**
 *
 * @author david_alcazar
 */
public class Productos {
    
    private int id;
    private String nom_prod;
    private String nom_prov;
    private String descrip;
    private float precioTotal;
    private int cantidad;
    private float PrecioUnitario;
        
//    public Productos(String nom_prod, String nom_prov, String descrip, float precio, int cantidad) {
//        this.nom_prod = nom_prod;
//        this.nom_prov = nom_prov;
//        this.descrip = descrip;
//        this.precioTotal = precio;
//        this.cantidad = cantidad;
//    }

    public Productos(int id, String nom_prod, String nom_prov, String descrip, float precioTotal, int cantidad) {
        this.id = id;
        this.nom_prod = nom_prod;
        this.nom_prov = nom_prov;
        this.descrip = descrip;
        this.precioTotal = precioTotal;
        this.cantidad = cantidad;
    }
    

    public Productos(int id,String nom_prod, float PrecioUnitario, int cantidad) {
        this.id = id;
        this.nom_prod = nom_prod;
        this.PrecioUnitario = PrecioUnitario;
        this.cantidad = cantidad;
        this.precioTotal = PrecioUnitario * cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    public String getNom_prov() {
        return nom_prov;
    }

    public void setNom_prov(String nom_prov) {
        this.nom_prov = nom_prov;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(float PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }
    
}
