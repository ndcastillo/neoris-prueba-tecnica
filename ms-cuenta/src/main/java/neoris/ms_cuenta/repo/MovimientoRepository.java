package neoris.ms_cuenta.repo;

import neoris.ms_cuenta.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
}
