package Controlador;

import DAO.AlimentoDAO;
import Vista.NutriciónPersonalizada;
import javax.swing.*;
import java.util.Map;

public class NutricionPersonalizadaController {
    private NutriciónPersonalizada vista;
    private AlimentoDAO dao = new AlimentoDAO();
    private String registroSeleccionado;

    public NutricionPersonalizadaController(NutriciónPersonalizada vista) {
        this.vista = vista;

        vista.btnelegir.addActionListener(e -> elegirRegistro());
        vista.btnmostrar.addActionListener(e -> mostrarDieta());
        vista.btnguardar.addActionListener(e -> guardarDiagnostico());

        vista.btnregistrar.addActionListener(e -> NavegacionHelper.abrirVentanaDesdeControlador(vista, "RegistroAlimentos"));
        vista.btnnutricion.addActionListener(e -> NavegacionHelper.abrirVentanaDesdeControlador(vista, "Nutrición"));
        vista.btnpersonalizada.addActionListener(e -> NavegacionHelper.abrirVentanaDesdeControlador(vista, "NutriciónPersonalizada"));

        cargarRegistros();
    }

    private void cargarRegistros() {
        vista.cboseleccionar.removeAllItems();
        vista.cboseleccionar.addItem("---Seleccionar---");
        for (String registro : dao.obtenerRegistrosHistorial()) {
            vista.cboseleccionar.addItem(registro);
        }
    }

    private void elegirRegistro() {
        registroSeleccionado = (String) vista.cboseleccionar.getSelectedItem();
        System.out.println("Registro seleccionado: '" + registroSeleccionado + "'");
        if (registroSeleccionado != null && !registroSeleccionado.equals("---Seleccionar---")) {
            Map<String, String> resumen = dao.obtenerDiagnosticoPorRegistro(registroSeleccionado);
            if (!resumen.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(vista, "Resumen encontrado.");
            } else {
                javax.swing.JOptionPane.showMessageDialog(vista, "No se encontraron datos.");
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(vista, "Seleccione un registro válido.");
        }
    }

    private void mostrarDieta() {
        registroSeleccionado = (String) vista.cboseleccionar.getSelectedItem();
        if (registroSeleccionado == null || registroSeleccionado.equals("---Seleccionar---")) {
            vista.txtamostrar.setText("Selecciona un registro válido.");
            return;
        }

        int calorias = dao.obtenerCaloriasTotalesPorRegistro(registroSeleccionado);

        String estadoCalorico;
        String tipoDieta;

        if (calorias < 1500) {
            estadoCalorico = "Subir de peso";
            tipoDieta = "Hipercalórica";
        } else if (calorias > 2500) {
            estadoCalorico = "Bajar de peso";
            tipoDieta = "Hipocalórica";
        } else {
            estadoCalorico = "Mantener peso";
            tipoDieta = "Normocalórica";
        }

        String diagnosticoFormateado = String.format(
                "- Calorías consumidas: %d\n- Recomendación: %s\n- Dieta sugerida: %s",
                calorias, estadoCalorico, tipoDieta
        );

        vista.txtamostrar.setText(diagnosticoFormateado);
        vista.txtexceso.setText(estadoCalorico);
        vista.txtequilibrio.setText("Evaluación general");
        vista.txtarecomendaciones.setText("Sigue la dieta recomendada según tu objetivo.");
        vista.txtdianostico.setText(registroSeleccionado);
    }

    private void guardarDiagnostico() {
        String nombre = vista.txtdianostico.getText().trim();
        String dieta = vista.txtamostrar.getText();
        String estado = vista.txtexceso.getText();
        String equilibrio = vista.txtequilibrio.getText();
        String recomendaciones = vista.txtarecomendaciones.getText();

        if (nombre.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(vista, "Seleccione un registro válido para guardar.");
            return;
        }

        if (dao.guardarDiagnostico(nombre, dieta, estado, equilibrio, recomendaciones)) {
            javax.swing.JOptionPane.showMessageDialog(vista, "Diagnóstico guardado con éxito.");
        } else {
            javax.swing.JOptionPane.showMessageDialog(vista, "Error al guardar diagnóstico.");
        }
    }
}