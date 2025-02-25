package neoris.ms_cliente.controller;


import neoris.ms_cliente.model.Cliente;
import neoris.ms_cliente.repo.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    private ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    @PostMapping
    private ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente) {
        Cliente clienteSaved = clienteRepository.save(cliente);
        return ResponseEntity.ok(clienteSaved);
    }

    @GetMapping(value="/{clienteId}", produces= MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> findById(@PathVariable Long clienteId) {
        Optional<Cliente> clienteSaved = clienteRepository.findById(clienteId);

        if (!clienteSaved.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }else{
            return ResponseEntity.ok(clienteSaved.get());
        }
    }


}
