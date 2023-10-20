package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class gestionDB {
    public static void crearBD() {

        try {
            Connection miCon = ConexionSG.conectar();
            Statement crearBD = miCon.createStatement();
            crearBD.executeUpdate("CREATE DATABASE miBD");

        } catch (
                SQLException e) {
            System.out.println("Error al conectar");
        }
    }

    public static void crearTablaInsernadoDatos() {
        //creamos la tabla DEPARTAMENTOS y solo se va a ejecutar una vez
        try (
            Connection miCon = ConexionBD.conectar("miBD")) {
            String tablaDep = "CREATE TABLE departamentos (\n" +
                    " dept_no  TINYINT(2) NOT NULL PRIMARY KEY,\n" +
                    " dnombre  VARCHAR(15), \n" +
                    " loc      VARCHAR(15)\n" +
                    ")";
            Statement crearTabalDep = miCon.createStatement();
            crearTabalDep.execute("DROP TABLE IF EXISTS empleados");
            crearTabalDep.execute("DROP TABLE IF EXISTS departamentos");
            crearTabalDep.executeUpdate(tablaDep);
            ArrayList<String> listaSentencias = new ArrayList<>();
            listaSentencias.add("INSERT INTO departamentos VALUES (10,'CONTABILIDAD','SEVILLA');");
            listaSentencias.add("INSERT INTO departamentos VALUES (20,'INVESTIGACION','MADRID');");
            listaSentencias.add("INSERT INTO departamentos VALUES (30,'VENTAS','BARCELONA');");
            listaSentencias.add("INSERT INTO departamentos VALUES (40,'PRODUCCION','BILBAO');");
            for (String lista : listaSentencias) {
                crearTabalDep.execute(String.valueOf(lista));
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar");
        }
        //creamos la tabla EMPLEADOS y sus sentencias

        try(Connection miCon = ConexionBD.conectar("miBD")){
            String tablaDep = "CREATE TABLE empleados (emp_no    SMALLINT(4)  NOT NULL PRIMARY KEY,\n" +
                    " apellido  VARCHAR(10),\n" +
                    " oficio    VARCHAR(10),\n" +
                    " dir       SMALLINT,\n" +
                    " fecha_alt DATE      ,\n" +
                    " salario   FLOAT(6,2),\n" +
                    " comision  FLOAT(6,2),\n" +
                    " dept_no   TINYINT(2) NOT NULL,\n" +
                    " CONSTRAINT FK_DEP FOREIGN KEY (dept_no ) REFERENCES departamentos(dept_no)\n" +
                    "\n" +
                    ");";
            Statement crearTabalDep = miCon.createStatement();
            crearTabalDep.execute("DROP TABLE IF EXISTS empleados");
            crearTabalDep.executeUpdate(tablaDep);
            ArrayList<String> listaSentencias = new ArrayList<>();
            listaSentencias.add("INSERT INTO empleados VALUES (7369,'SANCHEZ','EMPLEADO',7902,'1990/12/17',1040,NULL,20);");
            listaSentencias.add("INSERT INTO empleados VALUES (7499,'ARROYO','VENDEDOR',7698,'1990/02/20',1500,390,30);");
            listaSentencias.add("INSERT INTO empleados VALUES (7521,'SALA','VENDEDOR',7698,'1991/02/22',1625,650,30);");
            listaSentencias.add("INSERT INTO empleados VALUES (7654,'MARTIN','VENDEDOR',7698,'1991/09/29',1600,1020,30);");
            listaSentencias.add("INSERT INTO empleados VALUES (7698,'NEGRO','DIRECTOR',7839,'1991/05/01',3005,NULL,30);");
            listaSentencias.add("INSERT INTO empleados VALUES (7782,'CEREZO','DIRECTOR',7839,'1991/06/09',2885,NULL,10);");
            listaSentencias.add("INSERT INTO empleados VALUES (7788,'GIL','ANALISTA',7566,'1991/11/09',3000,NULL,20);");
            listaSentencias.add("INSERT INTO empleados VALUES (7839,'REY','PRESIDENTE',NULL,'1991/11/17',4100,NULL,10);");
            listaSentencias.add("INSERT INTO empleados VALUES (7844,'TOVAR','VENDEDOR',7698,'1991/09/08',1350,0,30);");
            listaSentencias.add("INSERT INTO empleados VALUES (7876,'ALONSO','EMPLEADO',7788,'1991/09/23',1430,NULL,20);");
            listaSentencias.add("INSERT INTO empleados VALUES (7900,'JIMENO','EMPLEADO',7698,'1991/12/03', 1335,NULL,30);");
            listaSentencias.add("INSERT INTO empleados VALUES (7902,'FERNANDEZ','ANALISTA',7566,'1991/12/03',3000,NULL,20);");
            listaSentencias.add("INSERT INTO empleados VALUES (7934,'MUNOZ','EMPLEADO',7782,'1992/01/23',1690,NULL,10);");

            for (String lista : listaSentencias){
                crearTabalDep.execute(String.valueOf(lista));
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar");
        }
    }
}
