package neoris.ms_cuenta.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CuentaTest {
    @Test
    public void testCuentaCliente() {
        Cuenta cuenta = new Cuenta(
                1L,
                "Ahorros",
                (double) 2000.0,
                true,
                1L
        );

        assertAll(
                () -> assertEquals(1L, cuenta.getNumeroCuenta()),
                () -> assertEquals("Ahorros", cuenta.getTipoCuenta()),
                () -> assertEquals(2000.0, cuenta.getSaldo()),
                () -> assertEquals(true, cuenta.isEstado()),
                () -> assertEquals(1L, cuenta.getNumeroCuenta())
        );

    }
}
