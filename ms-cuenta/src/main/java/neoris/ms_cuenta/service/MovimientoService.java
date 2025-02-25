package neoris.ms_cuenta.service;

import neoris.ms_cuenta.model.Movimiento;
import neoris.ms_cuenta.model.MovimientoPorCliente;
import neoris.ms_cuenta.repo.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class MovimientoService implements JpaRepository<Movimiento, Long> {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    public void flush() {

    }

    @Override
    public <S extends Movimiento> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Movimiento> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Movimiento> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Movimiento getOne(Long aLong) {
        return null;
    }

    @Override
    public Movimiento getById(Long aLong) {
        return null;
    }

    @Override
    public Movimiento getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Movimiento> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Movimiento> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Movimiento> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Movimiento> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Movimiento> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Movimiento> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Movimiento, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Movimiento> S save(S entity) {
        return movimientoRepository.save(entity);
    }

    @Override
    public <S extends Movimiento> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Movimiento> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Movimiento> findAll() {
        return movimientoRepository.findAll();
    }

    @Override
    public List<Movimiento> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Movimiento entity) {
        movimientoRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Movimiento> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Movimiento> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Movimiento> findAll(Pageable pageable) {
        return null;
    }

    public List<MovimientoPorCliente> encontrarMovimientosPorFecha(Date fecha, List<MovimientoPorCliente> movimientos){


        List<MovimientoPorCliente> movimientosFiltrados = new ArrayList<>();
        movimientos.forEach(m -> {
            if (m.getFecha().equals(fecha)) {
                movimientosFiltrados.add(m);
            }
        });

        

        return movimientosFiltrados;
    }
}
