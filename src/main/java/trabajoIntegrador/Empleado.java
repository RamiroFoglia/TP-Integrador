package trabajoIntegrador;

import java.time.LocalDate;
import java.util.Scanner;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Empleado {

    int idEmpleado;
    String cuitEmpleado;
    String nomEmpleado;
    String apeEmpleado;
    String direEmpleado;
    String celEmpleado;
    String mailEmpleado;
    final LocalDate altaEmpleado = LocalDate.now();
    String areaEmpleado;

    public static Empleado altaEmpleado() {
        Scanner entrada = new Scanner(System.in);
        System.out.println();
        boolean validaEntrada = true, existeEmpleado = true;
        String cuit = " ", nom = " ", ape = "", dire = "", cel = "", mail = "", area = "";

        System.out.println("*****INGRESE LOS SIGUIENTES DATOS DEL EMPLEADO*****");
        System.out.println("***********RESPETANDO LAS INDICACIONES*************");
        while (validaEntrada) {
            System.out.println("Ingrese el CUIT: ");
            cuit = entrada.nextLine();

            if (!(cuit.isEmpty()) && (cuit.length() == 11)) {
                if ((ConexionDB.existeCuitEmpleado(cuit))) {
                    System.out.println("[El cuit ya se encuentra registrado en el sistema]");
                    existeEmpleado = false;
                }
                validaEntrada = false;
            }

        }
        if (existeEmpleado) {//SI NO EXISTE EL EMPLEADO SIGUE CON LA CARGA DEL RESTO DE LOS DATOS
            validaEntrada = true;
            while (validaEntrada) {
                System.out.println("Ingrese el NOMBRE: ");
                nom = entrada.nextLine();
                if (nom.isEmpty()) {
                    validaEntrada = true;
                } else {
                    validaEntrada = false;
                }
            }

            validaEntrada = true;
            while (validaEntrada) {
                System.out.println("Ingrese el APELLIDO: ");
                ape = entrada.nextLine();
                if (ape.isEmpty()) {
                    validaEntrada = true;
                } else {
                    validaEntrada = false;
                }
            }
            validaEntrada = true;
            while (validaEntrada) {
                System.out.println("Ingrese la DIRECCION: ");
                dire = entrada.nextLine();
                if (dire.isEmpty()) {
                    validaEntrada = true;
                } else {
                    validaEntrada = false;
                }
            }

            validaEntrada = true;
            while (validaEntrada) {
                System.out.println("Ingrese el CELULAR: ");
                cel = entrada.nextLine();
                if (cel.isEmpty() || !(cel.length() == 13)) {
                    validaEntrada = true;
                } else {
                    validaEntrada = false;
                }
            }
            validaEntrada = true;
            while (validaEntrada) {
                System.out.println("Ingrese el MAIL: ");
                mail = entrada.nextLine();
                if (mail.isEmpty()) {
                    validaEntrada = true;
                } else {
                    validaEntrada = false;
                }
            }

            validaEntrada = true;
            while (validaEntrada) {
                System.out.println("Ingrese el Area(RRHH-COMERCIAL-MATENIMIENTO-TECNICO) del Empleado: ");
                area = entrada.nextLine();
                if (area.isEmpty()) {
                    validaEntrada = true;
                } else {
                    validaEntrada = false;
                }
            }

            Empleado nuevoEmpleado = new Empleado(1, cuit, nom, ape, dire, cel, mail, area);
            return nuevoEmpleado;
        }
        return null;
    }

    //DELETE EMPLEADO
    public static void eliminarEmpleado() {
        Scanner entrada = new Scanner(System.in);
        String cuitEmpleado = "";
        boolean validar = true;

        ConexionDB.listarEmpleado();

        while (validar) {
            System.out.println("\n\t [INGRESE EL CUIT DEL EMPLEADO A ELIMINAR]");
            cuitEmpleado = entrada.nextLine();

            if (ConexionDB.existeCuitEmpleado(cuitEmpleado)) {
                ConexionDB.eliminarEmpleadoDB(cuitEmpleado);
                validar = false;
            }
        }
        // FALTARIA VALIDAR LAS TABLAS LAS CUALES TENGAN RELACION CON EL EMPLEADO A ELIMINAR
    }
}
