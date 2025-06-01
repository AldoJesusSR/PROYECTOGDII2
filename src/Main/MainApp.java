package main;

import Controlador.RegistroAlimentoController;
import DAO.RegistroAlimentoDAO;
import Vista.RegistroAlimentos;
import java.sql.Connection;
import Conexion.ConexionA;

public class MainApp {
    public static void main(String[] args) {
        RegistroAlimentos vista = new RegistroAlimentos();
        
        Connection conn = ConexionA.conectar();
        if (conn == null) {
            System.out.println("No se pudo conectar a la base de datos.");
            return;
        }
        
        RegistroAlimentoDAO dao = new RegistroAlimentoDAO(conn);
        RegistroAlimentoController controlador = new RegistroAlimentoController(vista, dao);
        
        vista.setVisible(true);
    }
}