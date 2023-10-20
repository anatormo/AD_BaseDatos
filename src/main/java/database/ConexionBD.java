package database;

import java.lang.module.InvalidModuleDescriptorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

        //nos conectamos a la base de datos donde podremos crear las tablas

        private static final String URL = "jdbc:mysql://localhost:6606";
        private static final String USUARIO = "root";
        private static final String CLAVE = "admin";

        public static Connection conectar(String nombreBD) {
            Connection conexion = null;
            try {
                conexion = DriverManager.getConnection((URL + "/" +nombreBD), USUARIO, CLAVE);
                System.out.println("Conexión OK");
            } catch (SQLException e) {
                System.out.println("Error en la conexión");
                e.printStackTrace();
            } catch (InvalidModuleDescriptorException e) {
                System.out.println("Error PAM");
            }
            return conexion;
        }
    }


