package database;

import classes.Departamento;

import java.sql.*;

public class insertarNuevoDep {
    public static void insertarDep (){
        //datos a insertar
        Departamento newDEp = new Departamento();
        newDEp.setNumDept(50);
        newDEp.setNombreDept("IT");
        newDEp.setLocalidadDept("Sabi");
        try (Connection miCon = ConexionBD.conectar("miBD")){
            PreparedStatement pstmt = miCon.prepareStatement("INSERT INTO departamentos VALUES (?,?,?)");
            pstmt.setInt(1, newDEp.getNumDept());
            pstmt.setString(2, newDEp.getNombreDept());
            pstmt.setString(3, newDEp.getLocalidadDept());
            pstmt.execute();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("No se cumple una condición de integridad de la base de datos");

        }catch (SQLSyntaxErrorException e){
            System.out.println("Hay un error de sintaxis" + e.getMessage());
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
