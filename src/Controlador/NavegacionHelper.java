package Controlador;

import Conexion.ConexionA;
import Vista.*;
import DAO.*;
import Modelo.*;
import java.sql.Connection;
import javax.swing.*;

public class NavegacionHelper {

    public static void abrirVentanaDesdeControlador(JFrame frameActual, String nombreVentana) {
        JFrame ventanaNueva = null;

        switch(nombreVentana) {
            case "RegistroAlimentos":
                ventanaNueva = new RegistroAlimentos();
                Connection conexion = ConexionA.conectar();    // Obtienes la conexión
                RegistroAlimentoDAO dao = new RegistroAlimentoDAO(conexion);  // Pasas la conexión al DAO
                new RegistroAlimentoController((RegistroAlimentos) ventanaNueva, dao);
                break;

            case "Nutrición":
                ventanaNueva = new Nutrición();
                new NutricionControlador((Nutrición) ventanaNueva);
                break;

            case "NutriciónPersonalizada":
                ventanaNueva = new NutriciónPersonalizada();
                new NutricionPersonalizadaController((NutriciónPersonalizada) ventanaNueva);
                break;

            default:
                JOptionPane.showMessageDialog(frameActual, "Ventana no encontrada: " + nombreVentana);
                return;
        }

        ventanaNueva.setVisible(true);
        frameActual.dispose();
    }
}