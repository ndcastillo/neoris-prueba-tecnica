package neoris.ms_cuenta.controller;

import neoris.ms_cuenta.model.Cliente;
import neoris.ms_cuenta.model.Cuenta;
import neoris.ms_cuenta.repo.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/cuentas/clientes")
public class CuentaClienteController {

    @Autowired
    private final RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private CuentaRepository cuentaRepository;

    // GET CUENTAS
    @GetMapping
    public List<Cuenta> obtenerCuentasPorClienteId(@RequestParam Long clienteId) {

        String url = "http://localhost:8080/api/v1/clientes/" + clienteId;
        ResponseEntity<Cliente> response = restTemplate.getForEntity(url, Cliente.class);
        Cliente cliente = response.getBody();
        List<Cuenta> cuentas = new ArrayList<>();

        cuentaRepository.findAll().forEach(cuenta -> {
            if (cuenta.getClienteId().equals(clienteId)) {
                cuentas.add(cuenta);
            }
        });

        return cuentas;
    }
}
