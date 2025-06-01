package Modelo;

public class NutricionResumen {
    private int caloriasTotales;
    private String alerta;
    private String recomendacion;

    public NutricionResumen(int caloriasTotales, String alerta, String recomendacion) {
        this.caloriasTotales = caloriasTotales;
        this.alerta = alerta;
        this.recomendacion = recomendacion;
    }

    public int getCaloriasTotales() {
        return caloriasTotales;
    }
    public String getAlerta() {
        return alerta;
    }
    public String getRecomendacion() {
        return recomendacion;
    }
}