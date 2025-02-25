package neoris.ms_cuenta.model;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class MovimientoTest {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date fecha;
    {
        try {
            fecha = formatter.parse("2022-02-02");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testMovimiento() {
        Movimiento movimiento = new Movimiento(
                123L,
                fecha,
                "Retiro de -10",
                10,
                2000,
                123L
        );
    }
}