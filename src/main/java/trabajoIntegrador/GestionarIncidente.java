package trabajoIntegrador;

import java.util.Scanner;

/**
 *
 * @author Ramiro Foglia
 */
public class GestionarIncidente {
    public static void iniciarGestion() {
        Cliente cliente = new Cliente();
        int idCliente = 0, idEmp = 0, idSoporte = 0, idTecnico = 0; //Tendran los valores para instanciar el incidente
        Scanner entrada = new Scanner(System.in);

        System.out.println("\t\n[****COMENCEMOS A GESTIONAR EL INCIDENTE****]");

        try {
            //Se elige empleado  
            ConexionDB.listarEmpleado();
            System.out.println("\n==>>Seleccionar el empleado(ID): ");
            idEmp = Integer.parseInt(entrada.nextLine());
            //FALTARIA VALIDAR LA OPCION QUE SE ELIGE...

            //Se elige cliente
            System.out.println("\n==>>Ingrese el Cuit del cliente: ");
            String cuitCliente = entrada.nextLine();
           
            //Se verifica si el cliente existe, de lo contrario se lo da de alta
            if (ConexionDB.existeCuitCliente(cuitCliente)) {//Busco el cliente   
                System.out.println("[ El cliente ya se encuentra registrado ]\n");
                idCliente = ConexionDB.idCliente(cuitCliente);//recupero el id del cliente que esta reportando un incidente 
            } else {
                System.out.println("\n[ El Cliente no se encuentra registrado en el sistema ]\n"
                        + "[ Se lo dara de alta continuación ]\n");
                cliente = Cliente.altaCliente();
                ConexionDB.altaClienteDB(cliente);
                idCliente = cliente.getIdCliente();//Guardo el id del cliente para instanciar el incidente(cliente nuevo)
            }

            //Se lista los soportes para el incidente
            ConexionDB.listarSoporte();
            System.out.println("\n==>> Elegir un Contrato (ID DE SOPORTE): ");
            idSoporte = Integer.parseInt(entrada.nextLine());//Guardo el id del soporte para instanciar el incidente
            //FALTARIA VALIDAR LA OPCION QUE SE ELIGE...

            //Se elije el tecnico para el incidente 
            System.out.println("\n==>>Asignar Tecnico para el contrato en cuestion:");
            ConexionDB.listarTecnico();
            System.out.println("\n==>> Elegir un Técnico:(mediante el ID): ");
            idTecnico = Integer.parseInt(entrada.nextLine());
            //FALTARIA VALIDAR LA OPCION QUE SE ELIGE...

            //*******Instancia un incidente nvo
            Incidente inc1 = Incidente.altaIncidente(idEmp, idCliente, idSoporte, idTecnico);
            ConexionDB.altaIncidenteDB(inc1);
            ConexionDB.altaContratoClienteDB(inc1);
            

            System.out.println("\n\t[ **** Registro exito.... **** ]");
            System.out.println("\n[ La fecha estimada de resolucion es:  " + inc1.getFechaResolucion() + " ]\n\n");

        } catch (Exception obj) {

            System.out.println("Error al gestionar un incidente");
            System.out.println(obj.fillInStackTrace());
        }

    }
    
}
