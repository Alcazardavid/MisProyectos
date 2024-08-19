package Modelo.Objetos;

public class ventas {
    
    private int id_venta;
    private int id_cliente;
    private String fecha;
    private int cantProducto;
    private float monto;

    public ventas(int id_venta, int id_cliente, String fecha, int cantProducto, float monto) {
        this.id_venta = id_venta;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.cantProducto = cantProducto;
        this.monto = monto;
    }

    public ventas() {
    }

    public ventas( int id_cliente, int cantProducto, float monto) {
        this.id_cliente = id_cliente;
        this.cantProducto = cantProducto;
        this.monto = monto;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantProducto() {
        return cantProducto;
    }

    public void setCantProducto(int cantProducto) {
        this.cantProducto = cantProducto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
    
}
