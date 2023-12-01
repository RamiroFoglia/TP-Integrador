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
        boolean validaEntrada = true;
        Scanner entrada = new Scanner(System.in);
        String cuit = "", razonSoc = "", nom = "", ape = "", dir = "", cel = "", mail = "";

        System.out.println("\n*****INGRESE LOS SIGUIENTES DATOS DEL CLIENTE*****");
        System.out.println("***********RESPETANDO LAS INDICACIONES*************");
        while (validaEntrada) {
            System.out.println("CUIT del Cliente: ");
            cuit = entrada.nextLine();
            if (cuit.isEmpty() || cuit.length() != 11) {
                validaEntrada = true;
            } else {
                validaEntrada = false;
            }
        }
        while (validaEntrada) {
            System.out.println("Razon social del cliente: ");
            razonSoc = entrada.nextLine();
            if (razonSoc.isEmpty()) {
                validaEntrada = true;
            } else {
                validaEntrada = false;
            }
        }
        while (validaEntrada) {
            System.out.println("Nombre del cliente: ");
            nom = entrada.nextLine();
            if (nom.isEmpty()) {
                validaEntrada = true;
            } else {
                validaEntrada = false;
            }
        }
        while (validaEntrada) {
            System.out.println("Apellido del cliente: ");
            ape = entrada.nextLine();
            if (ape.isEmpty()) {
                validaEntrada = true;
            } else {
                validaEntrada = false;
            }
        }
        while (validaEntrada) {
            System.out.println("Direccion del cliente: ");
            dir = entrada.nextLine();
            if (dir.isEmpty()) {
                validaEntrada = true;
            } else {
                validaEntrada = false;
            }
        }
        while (validaEntrada) {
            System.out.println("Numero de celular del cliente: ");
            cel = entrada.nextLine();
            if (cel.isEmpty()) {
                validaEntrada = true;
            } else {
                validaEntrada = false;
            }
        }
        while (validaEntrada) {
            System.out.println("E-mail del cliente: ");
            mail = entrada.nextLine();
            if (mail.isEmpty()) {
                validaEntrada = true;
            } else {
                validaEntrada = false;
            }
        }

        System.out.println();

        Cliente cliente1 = new Cliente(1, cuit, razonSoc, nom, ape, dir, cel, mail);

        return cliente1;
    }

    public static boolean extisteCliente() {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el Cuit del cliente: ");
        String cuitCliente = entrada.nextLine();

        return ConexionDB.extisteCuitCliente(cuitCliente);
    }

}
