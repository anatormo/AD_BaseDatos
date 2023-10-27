package database;

import classes.Empleado;
import libs.Validaciones;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insertarNuevoEmpleado {
    public static void insertEmpleado (){
        //declaracion de variables
        Empleado nuevoEmpleado = new Empleado();
        String nombreDep;
        Integer idDepRecuperado = 0;

        System.out.println("Inserte el número del nuevo empleado");
        nuevoEmpleado.setEmp_no(Validaciones.enteros());
        System.out.println("Inserte el apellido del nuevo empleado");
        nuevoEmpleado.setApellido(Validaciones.strings());
        System.out.println("Inserte el nombre del departamento al que pertenece");
        nombreDep = Validaciones.strings();
        try (Connection miCon = ConexionBD.conectar("miBD")) {
            //montamos la sentencia SQL de que el departamento existe
            //nos devuleve el id del departamento si existe
            PreparedStatement pstmt = miCon.prepareStatement("SELECT dept_no FROM departamentos WHERE dnombre = ?;");
            pstmt.setString(1, nombreDep);
            //ejecutamos la sentencia
            ResultSet rs = pstmt.executeQuery();
            //para recorrer un reultset
            while (rs.next()){
                //almacenamos la información obtenida
                idDepRecuperado = rs.getInt("dept_no");//dept_no es el valor de la tabla
            }
           if (idDepRecuperado == 0) {
               System.out.println("El departamento indicado no existe y el empleado no se insertará.");
           } else {
               nuevoEmpleado.setDept_no(idDepRecuperado);
               PreparedStatement insEmp = miCon.prepareStatement("INSERT INTO empleados (emp_no, apellido, dept_no) VALUES (?, ?, ?); ");
               insEmp.setInt(1, nuevoEmpleado.getEmp_no());
               insEmp.setString(2, nuevoEmpleado.getApellido());
               insEmp.setInt(3, nuevoEmpleado.getDept_no());
               insEmp.execute();
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
