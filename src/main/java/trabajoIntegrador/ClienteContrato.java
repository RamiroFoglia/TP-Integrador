package trabajoIntegrador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 *
 * @author Ramiro Foglia
 */

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClienteContrato {
    int idCliente;
    int idSoporte;
    Date altaContrato;
    
    
    public void mostrarContratos(List contratos){
        
    }
    
}
