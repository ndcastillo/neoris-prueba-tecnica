package neoris.ms_cuenta.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cuenta")
public class Cuenta {

    @Id
    private Long numeroCuenta;
    private String tipoCuenta;
    private double saldo;
    private boolean estado;

    private Long clienteId;
}
