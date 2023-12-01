package trabajoIntegrador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Cliente {

    int idCliente;
    String cuitCliente;
    String razonSocial;
    String nomCliente;
    String apeCliente;
    String direCliente;
    String celCliente;
    String mailCliente;
    final LocalDate altaCliente = LocalDate.now();

    public static Cliente altaCliente() {
        boolean validaEntrada = true, existeCliente = true;
        Scanner entrada = new Scanner(System.in);
        String cuit = "", razonSoc = "", nom = "", ape = "", dir = "", cel = "", mail = "";

        System.out.println("\n*****INGRESE LOS SIGUIENTES DATOS DEL CLIENTE*****");
        System.out.println("***********RESPETANDO LAS INDICACIONES*************");
//        
        while (validaEntrada) {
            System.out.println("Ingrese el CUIT del Cliente: ");
            cuit = entrada.nextLine();

            if (!(cuit.isEmpty()) && (cuit.length() == 11)) {
                if ((ConexionDB.existeCuitCliente(cuit))) {
                    System.out.println("[El cuit ya se encuentra registrado en el sistema]");
                    existeCliente = false;
                }
                validaEntrada = false;
            }
        }
        if (existeCliente) {//SI NO EXISTE EL CLIENTE SIGUE CON LA CARGA DEL RESTO DE LOS DATOS
            validaEntrada = true;
            while (validaEntrada) {
                System.out.println("Ingrese la Razon Social del Cliente: ");
                razonSoc = entrada.nextLine();
                if (razonSoc.isEmpty()) {
                    validaEntrada = true;
                } else {
                    validaEntrada = false;
                }
            }

            validaEntrada = true;
            while (validaEntrada) {
                System.out.println("Ingrese el nombre: ");
                ape = entrada.nextLine();
                if (ape.isEmpty()) {
                    validaEntrada = true;
                } else {
                    validaEntrada = false;
                }
            }
            validaEntrada = true;
            while (validaEntrada) {
                System.out.println("Ingrese el apellido: ");
                ape = entrada.nextLine();
                if (ape.isEmpty()) {
                    validaEntrada = true;
                } else {
                    validaEntrada = false;
                }
            }

            validaEntrada = true;
            while (validaEntrada) {
                System.out.println("Ingrese la direccion: ");
                dir = entrada.nextLine();
                if (dir.isEmpty()) {
                    validaEntrada = true;
                } else {
                    validaEntrada = false;
                }
            }
            validaEntrada = true;
            while (validaEntrada) {
                System.out.println("Ingrese el numero de telefono: ");
                cel = entrada.nextLine();
                if (cel.isEmpty() || !(cel.length() == 13)) {
                    validaEntrada = true;
                } else {
                    validaEntrada = false;
                }
            }

            validaEntrada = true;
            while (validaEntrada) {
                System.out.println("Ingrese el E-mail: ");
                mail = entrada.nextLine();
                if (mail.isEmpty()) {
                    validaEntrada = true;
                } else {
                    validaEntrada = false;
                }
            }

            Cliente nuevoCli = new Cliente(1, cuit, razonSoc, nom, ape, dir, cel, mail);
            return nuevoCli;
        }

        return null;
    }

    public static boolean eextisteCliente() {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el Cuit del cliente: ");
        String cuitCliente = entrada.nextLine();

        return ConexionDB.existeCuitCliente(cuitCliente);
    }

}
