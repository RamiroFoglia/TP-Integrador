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

    public static Incidente altaIncidente(int empleado, int cliente, int soporte, int tecnico) {

        Scanner entrada = new Scanner(System.in);
      
        System.out.println("\n==>>Fecha de resolución:dd/mm/aaaa ");
        String fechaReso = entrada.nextLine();
        System.out.println("\n==>>Colchon de hs en (hs): ");
        String colchon = entrada.nextLine();

        //en alta de incidente el estado por defecto será REPORTADO
        String estado = "REPORTADO";

        Incidente inc1 = new Incidente(1, empleado, cliente, soporte, tecnico, fechaReso, colchon, estado);
       
        return inc1;
    }

}
