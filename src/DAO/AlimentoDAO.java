package DAO;

import Conexion.ConexionA;
import java.sql.*;
import java.util.*;

public class AlimentoDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<String> obtenerRegistrosHistorial() {
        List<String> registros = new ArrayList<>();
        try {
            con = ConexionA.conectar();
            ps = con.prepareStatement("SELECT DISTINCT nombreRegistro FROM historial_comidas");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(rs.getString("nombreRegistro"));
            }
        } catch (Exception e) {
            System.out.println("Error al cargar registros del historial: " + e.getMessage());
        }
        return registros;
    }

    public Map<String, String> obtenerDiagnosticoPorRegistro(String registro) {
        Map<String, String> diagnostico = new HashMap<>();
        try {
            con = ConexionA.conectar();
            ps = con.prepareStatement("SELECT dieta, estadoCalorico, equilibrioMacro, recomendaciones"
                    + " FROM diagnostico_nutricional WHERE nombreRegistro = ?");
            ps.setString(1, registro);
            rs = ps.executeQuery();
            if (rs.next()) {
                diagnostico.put("dieta", rs.getString("dieta"));
                diagnostico.put("estadoCalorico", rs.getString("estadoCalorico"));
                diagnostico.put("equilibrio", rs.getString("equilibrioMacro"));
                diagnostico.put("recomendaciones", rs.getString("recomendaciones"));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener diagnóstico: " + e.getMessage());
        }
        return diagnostico;
    }

    public int obtenerCaloriasTotalesPorRegistro(String registro) {
        int calorias = 0;
        try {
            con = ConexionA.conectar();
            ps = con.prepareStatement("SELECT caloriasTotales FROM historial_"
                    + ""
                    + "comidas WHERE nombreRegistro = ?");
            ps.setString(1, registro);
            rs = ps.executeQuery();
            if (rs.next()) {
                calorias = rs.getInt("caloriasTotales");
            }
        } catch (Exception e) {
            System.out.println("Error al obtener calorías totales: " + e.getMessage());
        }
        return calorias;
    }
    public boolean guardarDiagnostico(String nombreRegistro, 
            String dieta, String estadoCalorico, String equilibrio, String recomendaciones) {
        try {
            con = ConexionA.conectar();
            ps = con.prepareStatement("EXEC sp_guardarDiagnostico ?, ?, ?, ?, ?");
            ps.setString(1, nombreRegistro);
            ps.setString(2, dieta);
            ps.setString(3, estadoCalorico);
            ps.setString(4, equilibrio);
            ps.setString(5, recomendaciones);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar diagnóstico: " + e.getMessage());
            return false;
        }
    }
}