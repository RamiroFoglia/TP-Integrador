package trabajoIntegrador;

import java.util.Scanner;

/**
 *
 * @author Ramiro Foglia
 */
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
                System.out.println(" 3- <<Alta de Tecnicos>>");
                System.out.println(" 4- <<Gestionar Incidente>>");
                System.out.println(" 5- <<Mostrar contratos de un cliente>>");
                System.out.println(" 6- <<Salir>>");

                opcion = entrada.nextInt();

                switch (opcion) {
                    case 1:
                        ABM.menuEmpleado();
                        break;
                    case 2:
                        ABM.menuCliente();
                        break;
                    case 3:
                        ConexionDB.listarTecnico();
                        Tecnico tec1 = Tecnico.altaTecnico();
                        ConexionDB.altaTecnicoDB(tec1);                        
                        break;
                    case 4:
                        //ciclo de vida del incidente
                        GestionarIncidente.iniciarGestion();
                        break;
                    case 5:
                        ConexionDB.listarCliente();
                        System.out.println("Seleccionar un cliente(ID): ");
                        int idCl = entrada.nextInt();
                        ConexionDB.contratosCliente(idCl);
                        break;
                    case 6:
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
