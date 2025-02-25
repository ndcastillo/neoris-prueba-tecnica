package neoris.ms_cuenta.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="movimiento")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movimientoId;

    @Temporal(TemporalType.DATE)
    @Column(name="fecha", columnDefinition = "DATE")
    private Date fecha;

    private String tipoMovimiento;
    private double valor;
    private double saldo;

    private Long numeroCuenta;
}
