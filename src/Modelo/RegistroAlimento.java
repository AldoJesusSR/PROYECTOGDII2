package Modelo;

public class RegistroAlimento {
    private String alimento;
    private String cantidad;
    private String fecha;
    private int calorias;
    private String nombreRegistro;

    public RegistroAlimento(String alimento, String cantidad, 
            String fecha, int calorias, String nombreRegistro) {
        this.alimento = alimento;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.calorias = calorias;
        this.nombreRegistro = nombreRegistro;
    }

    public String getAlimento() { return alimento; }
    public String getCantidad() { return cantidad; }
    public String getFecha() { return fecha; }
    public int getCalorias() { return calorias; }
    public String getNombreRegistro() { return nombreRegistro; }
}