package neoris.ms_cuenta.service;

import neoris.ms_cuenta.model.Cuenta;
import neoris.ms_cuenta.repo.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class CuentaService implements CuentaRepository {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public void flush() {

    }

    @Override
    public <S extends Cuenta> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Cuenta> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Cuenta> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Cuenta getOne(Long aLong) {
        return null;
    }

    @Override
    public Cuenta getById(Long aLong) {
        return cuentaRepository.getById(aLong);
    }

    @Override
    public Cuenta getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Cuenta> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Cuenta> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Cuenta> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Cuenta> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Cuenta> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Cuenta> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Cuenta, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Cuenta> S save(S entity) {
        return cuentaRepository.save(entity);
    }

    @Override
    public <S extends Cuenta> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Cuenta> findById(Long aLong) {
        return cuentaRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    @Override
    public List<Cuenta> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
        cuentaRepository.deleteById(aLong);
    }

    @Override
    public void delete(Cuenta entity) {
        cuentaRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Cuenta> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Cuenta> findAll(Sort sort) {
        return cuentaRepository.findAll(sort);
    }

    @Override
    public Page<Cuenta> findAll(Pageable pageable) {
        return null;
    }
}
