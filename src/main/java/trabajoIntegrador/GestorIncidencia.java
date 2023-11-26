package trabajoIntegrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class GestorIncidencia {

    public static void main(String[] args) {

        try {

            ConexionDB.conexionDB();

            System.out.println("\n======= SISTEMA DE REPORTE DE INCIDENTES =======\n");

            int opcion = 0;
            Scanner entrada = new Scanner(System.in);
            while (opcion != 5) {
                System.out.println("Para seleccionar una opcion, elija su numero correspondiente: ");
                
                System.out.println(" \n1- <<ABM cliente>>");
                System.out.println(" 5- <<Salir>>");
                opcion=entrada.nextInt();
            
            }

            //**hacer un menu con opciones para: ABM cliente -- Repotar  Incidente--listar técnicos - salir
            //*******Instancia un empleado nvo
//	       Empleado emp1 = Empleado.altaEmpleado();
//	       ConexionDB.altaEmpleadoDB(emp1);
            //*******Instancia un soporte nvo
//	       SoporteServicio sop1 = SoporteServicio.altaSoporte();
//	       ConexionDB.altaSoporteDB(sop1);
            //*******Instancia un cliente nvo
            //lista de los soportes para que el cliente elija
//		   ConexionDB.listarSoporte();
//	       
//	       Cliente cli1 = Cliente.altaCliente();
//	       ConexionDB.altaClienteDB(cli1);
            //*******Instancia un tecnico nvo
            //*******LISTA LOS EMPLEADOS
//	       ConexionDB.listarEmpleado();
            //*******BUSCA EMPELADO POR CUIT	
            //ConexionDB.buscarEmpleado();
//	       Tecnico tec1 = Tecnico.altaTecnico();
//	       ConexionDB.altaTecnicoDB(tec1);
            //*******Instancia un incidente nvo
//	       Incidente inc1 = Incidente.altaIncidente();
//	       ConexionDB.altaIncidenteDB(inc1);
        } catch (Exception obj) {

            System.out.println("Error en ABM de la base de datos MAIN");
            System.out.println(obj.fillInStackTrace());
        }

    }

}
