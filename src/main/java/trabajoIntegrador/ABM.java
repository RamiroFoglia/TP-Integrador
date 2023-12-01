package trabajoIntegrador;

import java.util.Scanner;

public class ABM {

    public static void menuEmpleado() {
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
                    if (nuevoEmp != null) {
                        ConexionDB.altaEmpleadoDB(nuevoEmp);
                    }

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

    
    
    static void menuCliente() {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        boolean validar = true;
        while (validar) {
            System.out.println("\n\t********************** ABM CLIENTE ***********************");
            System.out.println("\tPara seleccionar una opcion, elija su numero correspondiente");
            System.out.println("\n\t 1- <<Nuevo Cliente>>");
            System.out.println("\t 2- <<Modificar Cliente>>");
            System.out.println("\t 3- <<Eliminar Cliente>>");
            System.out.println("\t 4- <<Volver...>>");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    Cliente nuevocli = Cliente.altaCliente();
                    if (nuevocli != null) {
                        ConexionDB.altaClienteDB(nuevocli);
                    }
                    break;
                //                Empleado modificarEmp = Empleado.modificaerEmpleado(); // hacer metodo modificarEmpleado() en la clase Empleado
//                ConexionDB.modificarEmpleadoDB(modificarEmp); //Hacer el metodo modificarEmpleadoDB() en la clase ConexionDB
                case 2:
                    break;
                // logica de eliminar un cliente
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
