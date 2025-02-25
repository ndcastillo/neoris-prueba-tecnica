package neoris.ms_cuenta.model;

import java.util.Date;

public class MovimientoPorCliente {

    private Date fecha;
    private String nombre;
    private Long numeroCuenta;
    private String tipo;
    private Double saldo;
    private Double valormovimiento;
    private Double saldoTotal;

    // Constructor vacío necesario para Jackson
    public MovimientoPorCliente() {}

    // Constructor con parámetros
    public MovimientoPorCliente(
            Date fecha,
            String nombre,
            Long numeroCuenta,
            String tipo,
            Double saldo,
            Double valormovimiento,
            Double saldoTotal
    ) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.saldo = saldo;
        this.valormovimiento = valormovimiento;
        this.saldoTotal = saldoTotal;
    }

    // Getters deben ser públicos para que Jackson pueda serializar el JSON
    public Double getSaldoTotal() {
        return saldoTotal;
    }

    public Double getSaldo() {
        return saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    // Setters también pueden ser necesarios si Jackson debe deserializar objetos JSON
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumeroCuenta(Long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void setValormovimiento(Double valormovimiento) {
        this.valormovimiento = valormovimiento;
    }

    public void setSaldoTotal(Double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }
}