package neoris.ms_cuenta.repo;

import neoris.ms_cuenta.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

}
