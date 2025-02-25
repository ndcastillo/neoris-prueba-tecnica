package neoris.ms_cuenta.controller;

import neoris.ms_cuenta.model.Cuenta;
import neoris.ms_cuenta.model.Movimiento;
import neoris.ms_cuenta.repo.CuentaRepository;
import neoris.ms_cuenta.repo.MovimientoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping
    private List<Movimiento> findAll() {
        return movimientoRepository.findAll();
    }

    @GetMapping(value="/{numeroCuenta}", produces= MediaType.APPLICATION_JSON_VALUE)
    private List<Movimiento> encontrarMovimientosPorNumeroCuenta(@PathVariable String numeroCuenta) {
        List<Movimiento> movimientos = new ArrayList<>();

        movimientoRepository.findAll().forEach(movimiento -> {
            if (movimiento.getNumeroCuenta().equals(numeroCuenta)) {
                movimientos.add(movimiento);
            }
        });
        return movimientos;
    }

    @PostMapping(value="/{numerocuenta}", produces= MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> crearMovimiento(
            @RequestBody Movimiento movimiento,
            @PathVariable Long numerocuenta
        ) {

        Optional<Cuenta> cuentaTemp = cuentaRepository.findById(numerocuenta);
        Cuenta cuenta = cuentaTemp.get();
        double saldo = cuenta.getSaldo() + movimiento.getValor();

        if(saldo<0){
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Saldo no disponible");
        }

        cuenta.setSaldo(saldo);
        cuentaRepository.save(cuenta);

        movimiento.setNumeroCuenta(numerocuenta);
//        movimiento.setFecha(new Date());

        if (movimiento.getValor()<0){
            movimiento.setTipoMovimiento("Retiro de " + movimiento.getValor());
        }else{
            movimiento.setTipoMovimiento("Deposito de " + movimiento.getValor());
        }

        movimiento.setSaldo(saldo);

        Movimiento movimientoSaved = movimientoRepository.save(movimiento);
        return ResponseEntity.ok(movimientoSaved);
    }

}
