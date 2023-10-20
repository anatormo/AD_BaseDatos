package com.iessanalberto.atd;

public class Main {
    public static void main(String[] args) {

        boolean salir = false;
        int opcion;
        do {
            System.out.println("0. Salir");
            System.out.println("1.Crear Base de Datos ");
            System.out.println("2.Crear tablas e insertar datos de inicio ");
            System.out.println("3.Insertar nuevo departamento");
            System.out.println("3.Insertar nuevo empleado");

            opcion = libs.Validaciones.enteros();
            switch (opcion) {
                case 0 -> {
                    salir = true;
                }
                case 1 -> {database.gestionDB.crearBD();
                }
                case 2 -> {database.gestionDB.crearTablaInsernadoDatos();
                }
                case 3 -> {database.insertarNuevoDep.insertarDep();
                }
                default -> {
                    System.out.println("Opción incorrecta");
                }
            }
        } while (!salir);
    }
}