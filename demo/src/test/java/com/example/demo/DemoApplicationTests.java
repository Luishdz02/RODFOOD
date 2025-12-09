package com.rodfood.system;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SystemApplicationTests {

    @Test
    void pruebaSimple() {
        // Prueba básica para validar que el sistema de CI funciona
        String mensaje = "Sistema RodFood";
        assertEquals("Sistema RodFood", mensaje);
        assertEquals(2, 1 + 1);
    }

}
