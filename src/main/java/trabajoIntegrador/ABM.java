package trabajoIntegrador;

import java.util.Scanner;

/**
 *
 * @author Ramiro Foglia
 */
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
                case 2:
                    System.out.println("ME FALTO TIEMPO PARA HACER LOS UPDATE, PERDON PROFE :-)");
                    break;
                case 3:
                    Empleado.eliminarEmpleado();
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
                case 2:
                    System.out.println("ME FALTO TIEMPO PARA HACER LOS UPDATE, PERDON PROFE :-)");
                    break;
                case 3:
                    Cliente.eliminarCliente();
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
