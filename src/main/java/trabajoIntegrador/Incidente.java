package trabajoIntegrador;

import java.time.LocalDate;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Incidente {
	private int idIncidente;
	private int idEmpleado;
	private int idCliente;
	private int idSoporte;
	private int idTecnico;
	private final LocalDate altaIncidente = LocalDate.now();
	private String fechaResolucion;
	private String horasColchon;
	private String estadoIncidente;
	
	public static Incidente altaIncidente(){
		
		System.out.println("*****INGRESE LOS SIGUIENTES DATOS DEL INCIDENTE*****");
	    System.out.println("***********RESPETANDO LAS INDICACIONES*************");
		Scanner entrada = new Scanner(System.in);
		System.out.println();
		System.out.println("ID Empleado: ");
		int empleado = entrada.nextInt();
		System.out.println("ID Cliente: ");
		int cliente = entrada.nextInt();
		System.out.println("ID Soporte: ");
		int soporte = entrada.nextInt();
		System.out.println("ID tecnico: ");
		int tecnico = entrada.nextInt();
		entrada.nextLine();
		System.out.println("Fecha de resolución:dd/mm/aaaa ");
		String fechaReso = entrada.nextLine();
		System.out.println("Colchon de hs en (hs): ");
		String colchon = entrada.nextLine();

		//en alta de incidente el estado por defecto será REPORTADO
		String estado = "REPORTADO";
		
		
		Incidente inc1 = new Incidente(1,empleado,cliente,soporte,tecnico,fechaReso,colchon,estado);
			
		//System.out.println(inc1.toString());

		entrada.close();
		return inc1;
	}
	
	
	
	
}
