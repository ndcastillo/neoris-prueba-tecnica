package neoris.ms_cuenta.controller;

import neoris.ms_cuenta.model.Cliente;
import neoris.ms_cuenta.model.Cuenta;
import neoris.ms_cuenta.model.MovimientoPorCliente;
import neoris.ms_cuenta.model.Movimiento;
import neoris.ms_cuenta.repo.MovimientoRepository;
import neoris.ms_cuenta.service.CuentaService;
import neoris.ms_cuenta.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reportes")
public class ListaMovimientoController {
    @Autowired
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaService cuentaRepository;
    @Autowired
    private MovimientoService movimientoService;

    @GetMapping(value="/{clienteId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MovimientoPorCliente>> listaMovimientos(
            @PathVariable Long clienteId,
            @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date fecha
    ) {

        /*
        * De cliente encontrar las cuentas
        * */

        String url = "http://localhost:8080/api/v1/clientes/" + clienteId;
        ResponseEntity<Cliente> response = restTemplate.getForEntity(url, Cliente.class);
        if (!response.hasBody()) {
            return ResponseEntity.notFound().build();
        }

        Cliente cliente = response.getBody();
        List<MovimientoPorCliente> movimientos = new ArrayList<>();


        cuentaRepository.findAll().forEach(cuenta -> {
            if (cuenta.getClienteId().equals(clienteId)) {

                movimientoRepository.findAll().forEach(movimiento -> {

                    if (movimiento.getNumeroCuenta().equals(cuenta.getNumeroCuenta())) {
                        MovimientoPorCliente
                    movimientoTemp = new MovimientoPorCliente(
                                movimiento.getFecha(),
                                cliente.getNombre(),
                                cuenta.getNumeroCuenta(),
                                movimiento.getTipoMovimiento(),
                                movimiento.getSaldo(),
                                movimiento.getValor(),
                                cuenta.getSaldo()
                        );

                        movimientos.add(movimientoTemp);
                    }

                });

            }
        });

        if (movimientos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<MovimientoPorCliente> movimientosPorFecha = movimientoService.encontrarMovimientosPorFecha(fecha, movimientos);

        System.out.println(movimientosPorFecha.toString());
        return ResponseEntity.ok(movimientosPorFecha);
    }

}
