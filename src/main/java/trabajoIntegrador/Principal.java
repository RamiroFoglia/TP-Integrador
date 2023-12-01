package trabajoIntegrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        try {
            ConexionDB.conexionDB();
            boolean validarMenu = true;
            int opcion = 0;
            Scanner entrada = new Scanner(System.in);

            System.out.println("\n============================================================\n"
                    + "====          SISTEMA DE GESTION DE INCIDENTES          ====\n"
                    + "============================================================\n");

            //El while manejaria una especie de menu principal
            while (validarMenu) {
                System.out.println("********************** MENU PRINCIPAL **********************");
                System.out.println("Para seleccionar una opcion, elija su numero correspondiente");
                System.out.println("\n 1- <<ABM Empleados>>");
                System.out.println(" 2- <<Gestionar Incidente>>");
                System.out.println(" 3- <<Salir>>");

                opcion = entrada.nextInt();

                switch (opcion) {
                    case 1:
                        menuABMEmpleado();
                        break;
                    case 2:
                        //ciclo de vida del incidente
                        GestionarIncidente.iniciarGestion();
                        break;
                    case 3:
                        //Termina el ciclo del menu del sistema
                        validarMenu = false;
                        break;
                    default:
                        System.out.println("Opcion incorrecta, intente nuevamente!!");
                        break;
                }
            }

        } catch (Exception obj) {

            System.out.println("Error en ABM de la base de datos MAIN");
            System.out.println(obj.fillInStackTrace());
        }
    }

//Menu ABM de Clientes mas logica
    private static void menuABMEmpleado() {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        boolean validar = true;
        while (validar) {
            System.out.println("\n\t********************** ABM EMPLEADO ***********************");
            System.out.println("\tPara seleccionar una opcion, elija su numero correspondiente");
            System.out.println("\n\t 1- <<Nuevo Empleado>>");
            System.out.println("\t 2- <<Modificar Empleado>>");
            System.out.println("\t 3- <<Eliminar Empleado>>");
            System.out.println("\t 4- <<Volver...>>");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    Empleado nuevoEmp = Empleado.altaEmpleado();
                    ConexionDB.altaEmpleadoDB(nuevoEmp);
                    break;
                //                Empleado modificarEmp = Empleado.modificaerEmpleado(); // hacer metodo modificarEmpleado() en la clase Empleado
//                ConexionDB.modificarEmpleadoDB(modificarEmp); //Hacer el metodo modificarEmpleadoDB() en la clase ConexionDB
                case 2:
                    break;
                // logica de eliminar un empleado
                case 3:
                    break;
                case 4:
                    validar = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta, intente nuevamente!!");
                    break;
            }
        }
    }

}
