package trabajoIntegrador;

/**
 *
 * @author Ramiro Foglia
 */
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Persona {
    String cuit;
    String nombre;
    String apellido;
    String direccion;
    String celular;
    String email;

}
