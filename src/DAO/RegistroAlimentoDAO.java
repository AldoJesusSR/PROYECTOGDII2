package DAO;

import Modelo.RegistroAlimento;
import java.sql.*;
import javax.swing.JOptionPane;

public class RegistroAlimentoDAO {

    private Connection conn;

    public RegistroAlimentoDAO(Connection conn) {
        this.conn = conn;
    }

    public void guardarRegistro(RegistroAlimento registro) {
        CallableStatement cs = null;
        try {
            conn.setAutoCommit(false);

            String sql = "{call sp_registrarAlimento(?, ?, ?, ?, ?, ?)}";
            cs = conn.prepareCall(sql);

            cs.setString(1, registro.getAlimento());
            cs.setString(2, registro.getCantidad());

            // Convierte String fecha (yyyy-MM-dd) a java.sql.Date
            Date fechaSql = Date.valueOf(registro.getFecha());
            cs.setDate(3, fechaSql);

            cs.setInt(4, registro.getCalorias());
            cs.setString(5, registro.getNombreRegistro());

            cs.registerOutParameter(6, Types.VARCHAR);

            cs.execute();

            String mensaje = cs.getString(6);
            if ("Registro exitoso".equalsIgnoreCase(mensaje)) {
                conn.commit();
                JOptionPane.showMessageDialog(null, "Registro guardado correctamente en la base de datos.");
            } else {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Error en el procedimiento almacenado: " + mensaje);
            }
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Error al guardar registro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                }
                if (cs != null) {
                    cs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}