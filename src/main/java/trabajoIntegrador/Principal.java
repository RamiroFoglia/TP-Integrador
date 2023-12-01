package trabajoIntegrador;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        try {
            ConexionDB.conexionDB();
            boolean validarMenu = true;
            int opcion = 0;
            Scanner entrada = new Scanner(System.in);

            System.out.println("\n\n============================================================\n"
                    + "====          SISTEMA DE GESTION DE INCIDENTES          ====\n"
                    + "============================================================");

            while (validarMenu) {
                System.out.println("\n********************** MENU PRINCIPAL **********************");
                System.out.println("[Para seleccionar una opcion, elija su numero correspondiente]");
                System.out.println("\n 1- <<ABM Empleados>>");
                System.out.println(" 2- <<ABM Clientes>>");
                System.out.println(" 3- <<Gestionar Incidente>>");
                System.out.println(" 4- <<Salir>>");

                opcion = entrada.nextInt();

                switch (opcion) {
                    case 1:
                        ABM.menuEmpleado();
                        break;
                    case 2:
                        ABM.menuCliente();
                        break;
                    case 3:
                        //ciclo de vida del incidente
                        GestionarIncidente.iniciarGestion();
                        break;
                    case 4:
                        //Termina el ciclo del menu del sistema
                        validarMenu = false;
                        break;
                    default:
                        System.out.println("[Opcion incorrecta, intente nuevamente!!]");
                        break;
                }
            }

        } catch (Exception obj) {

            System.out.println("Error en ABM de la base de datos MAIN");
            System.out.println(obj.fillInStackTrace());
        }
    }
}
