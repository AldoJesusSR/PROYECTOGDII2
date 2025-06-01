package Controlador;

import DAO.RegistroAlimentoDAO;
import Modelo.RegistroAlimento;
import Vista.RegistroAlimentos;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistroAlimentoController {

    private RegistroAlimentos vista;
    private RegistroAlimentoDAO dao;

    public RegistroAlimentoController(RegistroAlimentos vista, RegistroAlimentoDAO dao) {
        this.vista = vista;
        this.dao = dao;

        // Ya no se agrega panelBotones ni botones nuevos, solo usamos los que ya están en la vista
        // Se agregan los listeners a los botones existentes que deben abrir otras ventanas

        this.vista.btnguardar.addActionListener(e -> guardarAlimento());
        this.vista.btnlimpiar.addActionListener(e -> limpiarCampos());

        // Botones que llaman a otros JFrames y controladores, deben estar definidos en la vista
        this.vista.btnregistrar.addActionListener(e -> NavegacionHelper.abrirVentanaDesdeControlador(vista, "RegistroAlimentos"));
        this.vista.btnnutricion.addActionListener(e -> NavegacionHelper.abrirVentanaDesdeControlador(vista, "Nutrición"));
        this.vista.btnpersonalizada.addActionListener(e -> NavegacionHelper.abrirVentanaDesdeControlador(vista, "NutriciónPersonalizada"));
    }

    private void guardarAlimento() {
        try {
            String alimento = vista.txtAlimento.getText();
            String cantidad = vista.txtCantidad.getText();
            String fechaTexto = vista.txtFecha.getText();
            int calorias = Integer.parseInt(vista.txtCalorias.getText());
            String nombreRegistro = vista.txtNombreregistro.getText();

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
            Date fechaUtil = formato.parse(fechaTexto);
            java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());

            RegistroAlimento registro = new RegistroAlimento(alimento, cantidad,
                    fechaSQL.toString(), calorias, nombreRegistro);
            dao.guardarRegistro(registro);

            JOptionPane.showMessageDialog(vista, "Registro guardado correctamente.");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Calorías debe ser un número.");
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(vista, "Formato de fecha inválido. Usa dd/MM/yy");
        }
    }

    private void limpiarCampos() {
        vista.txtAlimento.setText("");
        vista.txtCantidad.setText("");
        vista.txtFecha.setText("");
        vista.txtCalorias.setText("");
        vista.txtNombreregistro.setText("");

        JOptionPane.showMessageDialog(vista, "Campos limpiados correctamente.");
    }
}