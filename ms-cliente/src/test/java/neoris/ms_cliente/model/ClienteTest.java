package neoris.ms_cliente.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    public void testSaveCliente() {
        Cliente cliente = new Cliente(
                1L,
                "1234",
                true
        );


        assertAll(
                ()-> assertEquals(1L, cliente.getClienteId()),
                ()-> assertEquals("1234", cliente.getContrasena()),
                ()-> assertEquals(true, cliente.isEstado())
        );
    }
}