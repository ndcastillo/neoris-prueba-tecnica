package neoris.ms_cuenta.controller;

import neoris.ms_cuenta.model.Cliente;
import neoris.ms_cuenta.model.Cuenta;
import neoris.ms_cuenta.repo.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cuentas")
public class CuentaController {
    @Autowired
    private CuentaRepository cuentaRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    // GET Cuentas
    @GetMapping
    private ResponseEntity<List<Cuenta>> findAll() {
        return ResponseEntity.ok(cuentaRepository.findAll());
    }

    @GetMapping(value="/{numeroCuenta}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Cuenta>> encontrarCuentaPorNumeroCuenta(@RequestParam Long numeroCuenta) {
        return ResponseEntity.ok(cuentaRepository.findById(numeroCuenta));
    }

    // POST Cuentas -> Añadir cuenta a clienteId por url/clienteId
    @PostMapping(value="/{clienteId}", produces= MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Cuenta> saveCuenta(
                        @RequestBody Cuenta cuenta,
                        @PathVariable Long clienteId) {

        String url = "http://localhost:8080/api/v1/clientes/" + clienteId;
        ResponseEntity<Cliente> response = restTemplate.getForEntity(url, Cliente.class);
        Cliente cliente = response.getBody();

        cuenta.setClienteId(clienteId);
        Cuenta cuentaSaved = cuentaRepository.save(cuenta);

        return ResponseEntity.ok(cuentaSaved);
    }

}
