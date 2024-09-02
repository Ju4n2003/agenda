/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class ContactoTest {
    private static final Logger LOG = Logger.getLogger(ContactoTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    // Prueba para datos nulos
    @Test
    public void datosNulos() {
        LOG.info("Iniciado test datosNulos");
        assertThrows(Throwable.class, ()-> new Contacto(null, null, null, null, null));
        LOG.info("Finalizando test shouldAnswerWithTrue");
    }
    // Prueba para datos invalidos
    
    @Test
    public void datosInvalidos() {
        LOG.info("Iniciado test datosInvalidos");
        assertThrows(Throwable.class, ()-> new Contacto(" ", "  ", "  ", "  ", "  "));
        LOG.info("Finalizando test datosInvalidos");
    }
    
    // Prueba para validar el correo 
    @Test
    public void validacionCorreo() {
        LOG.info("Iniciado test validacionCorreo");
        assertThrows(Throwable.class,()-> new Contacto("Juan Perez", "Juan", "Calle 123", "123456789", "juanuq.com"));
        LOG.info("Finalizando test validacionCorreo");
    }
}
