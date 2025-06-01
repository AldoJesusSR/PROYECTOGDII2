package DAO;

import Conexion.ConexionA;
import Modelo.NutricionResumen;
import java.sql.*;

public class NutricionDAO {

    public NutricionResumen obtenerResumen(String desde, String hasta) {
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        int totalCalorias = 0;

        try {
            con = ConexionA.conectar();
            cs = con.prepareCall("{call sp_obtenerResumenNutricional(?, ?)}");
            cs.setString(1, desde);
            cs.setString(2, hasta);
            rs = cs.executeQuery();

            if (rs.next()) {
                totalCalorias = rs.getInt("totalCalorias");
            }

            String alerta;
            if (totalCalorias == 0) {
                alerta = "No hay datos registrados en ese rango de fechas.";
            } else if (totalCalorias < 1500) {
                alerta = "Déficit calórico: Riesgo de desnutrición.";
            } else if (totalCalorias > 3000) {
                alerta = "Exceso severo de calorías: Riesgo de obesidad.";
            } else if (totalCalorias > 2500) {
                alerta = "Exceso calórico moderado: Riesgo de sobrepeso.";
            } else {
                alerta = "Consumo calórico dentro del rango adecuado.";
            }

            String recomendacion;
            if (totalCalorias < 1500) {
                recomendacion = "Aumenta tu ingesta calórica diaria. Incluye más proteínas, legumbres, arroz, frutas,"
                        + " frutos secos y grasas saludables.";
            } else if (totalCalorias > 3000) {
                recomendacion = "Revisa tu dieta. Reduce grasas saturadas y azúcares. Aumenta actividad física. "
                        + "Consulta a un especialista si es necesario.";
            } else if (totalCalorias > 2500) {
                recomendacion = "Evita alimentos ultraprocesados. Incrementa el consumo de vegetales,"
                        + " frutas y proteínas magras.";
            } else {
                recomendacion = "Muy bien. Mantén tu dieta equilibrada y continúa con buenos hábitos.";
            }

            return new NutricionResumen(totalCalorias, alerta, recomendacion);

        } catch (Exception e) {
            e.printStackTrace();
            return new NutricionResumen(0, "Error al obtener el resumen", 
                    "Revisa la conexión o intenta más tarde.");
        } finally {
            try { if(rs != null) rs.close(); } catch(Exception e) {}
            try { if(cs != null) cs.close(); } catch(Exception e) {}
            try { if(con != null) con.close(); } catch(Exception e) {}
        }
    }

    public boolean guardarResumenDiario(String nombreRegistro, String fecha, int calorias, String alerta, String recomendacion) {
        Connection con = null;
        CallableStatement cs = null;
        try {
            con = ConexionA.conectar();
            cs = con.prepareCall("{call sp_guardarResumenDiario(?, ?, ?, ?, ?)}");
            cs.setString(1, nombreRegistro);
            cs.setString(2, fecha);
            cs.setInt(3, calorias);
            cs.setString(4, alerta);
            cs.setString(5, recomendacion);
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try { if(cs != null) cs.close(); } catch(Exception e) {}
            try { if(con != null) con.close(); } catch(Exception e) {}
        }
    }
}