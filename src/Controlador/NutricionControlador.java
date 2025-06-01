package Controlador;

import DAO.NutricionDAO;
import Modelo.NutricionResumen;
import Vista.Nutrición;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import Conexion.ConexionA;

public class NutricionControlador {
    private Nutrición vista;
    private NutricionDAO dao;
    private NutricionResumen resumenActual;

    public NutricionControlador(Nutrición vista) {
        this.vista = vista;
        this.dao = new NutricionDAO();

        this.vista.btnresumen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarResumen();
            }
        });

        this.vista.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarResumen();
            }
        });

        // Listeners para los botones que navegan a otros JFrame (estos botones ya existen en la vista)
        this.vista.btnregistro.addActionListener(e -> NavegacionHelper.abrirVentanaDesdeControlador(vista, "RegistroAlimentos"));
        this.vista.btnpersonalizada.addActionListener(e -> NavegacionHelper.abrirVentanaDesdeControlador(vista, "NutriciónPersonalizada"));
    }

    private void mostrarResumen() {
        String desdeTexto = vista.jTextField1.getText().trim();
        String hastaTexto = vista.jTextField2.getText().trim();

        if (desdeTexto.isEmpty() || hastaTexto.isEmpty()) {
            vista.txtalertas.setText("Por favor, ingresa ambas fechas.");
            vista.txtcalorias.setText("");
            vista.txtarecomendacion.setText("");
            return;
        }

        try {
            java.text.SimpleDateFormat formatoEntrada = new java.text.SimpleDateFormat("dd/MM/yy");
            java.text.SimpleDateFormat formatoSQL = new java.text.SimpleDateFormat("yyyy-MM-dd");

            java.util.Date desdeFecha = formatoEntrada.parse(desdeTexto);
            java.util.Date hastaFecha = formatoEntrada.parse(hastaTexto);

            String desdeSQL = formatoSQL.format(desdeFecha);
            String hastaSQL = formatoSQL.format(hastaFecha);

            resumenActual = dao.obtenerResumen(desdeSQL, hastaSQL);

            vista.txtcalorias.setText(resumenActual.getCaloriasTotales() + " kcal");
            vista.txtalertas.setText(resumenActual.getAlerta());
            vista.txtarecomendacion.setText(resumenActual.getRecomendacion());

        } catch (Exception ex) {
            ex.printStackTrace();
            vista.txtalertas.setText("Formato de fecha inválido. Usa dd/MM/yy");
        }
    }

    private void guardarResumen() {
        String nombreRegistro = vista.txtguardado.getText().trim();

        if (nombreRegistro.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Ingresa un nombre para guardar el resumen.");
            return;
        }

        if (resumenActual == null) {
            JOptionPane.showMessageDialog(vista, "Primero debes generar un resumen.");
            return;
        }

        try {
            String fechaActual = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());

            Connection con = ConexionA.conectar();
            CallableStatement cs = con.prepareCall("{call sp_guardarResumenNutricional(?, ?, ?, ?, ?)}");

            cs.setString(1, nombreRegistro);
            cs.setString(2, fechaActual);
            cs.setInt(3, resumenActual.getCaloriasTotales());
            cs.setString(4, resumenActual.getAlerta());
            cs.setString(5, resumenActual.getRecomendacion());

            cs.execute();
            JOptionPane.showMessageDialog(vista, "Resumen guardado exitosamente.");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista, "Error al guardar el resumen.");
        }
    }
}