package com.iessanalberto.atd;

import database.EstructuraDB;
import database.insertarNuevoEmpleado;

public class Main {
    public static void main(String[] args) {

        boolean salir = false;
        int opcion;
        do {
            System.out.println("0. Salir");
            System.out.println("1.Crear Base de Datos MySQL ");
            System.out.println("2.Crear tablas e insertar datos de inicio ");
            System.out.println("3.Insertar nuevo departamento");
            System.out.println("4.Insertar nuevo empleado");

            System.out.println("Introduce tu elección: ");
            opcion = libs.Validaciones.enteros();
            switch (opcion) {
                case 0 -> {
                    salir = true;
                }
                case 1 -> {EstructuraDB.crearBD();
                }
                case 2 -> {EstructuraDB.crearTablaInsernadoDatos();
                }
                case 3 -> {database.insertarNuevoDep.insertarDep();
                }
                case 4 -> {database.insertarNuevoEmpleado.insertEmpleado();}
                default -> {
                    System.out.println("Opción incorrecta");
                }
            }
        } while (!salir);
    }
}