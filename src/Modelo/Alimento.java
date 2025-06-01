package Modelo;

public class Alimento {
    private String nombre;
    private int calorias;
    private int cantidad;
    private String fecha;
    private String nombreRegistro;

    public Alimento(String nombre, int calorias, int cantidad, String fecha, String nombreRegistro) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.nombreRegistro = nombreRegistro;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCalorias() {
        return calorias;
    }
    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getNombreRegistro() {
        return nombreRegistro;
    }
    public void setNombreRegistro(String nombreRegistro) {
        this.nombreRegistro = nombreRegistro;
    }
}