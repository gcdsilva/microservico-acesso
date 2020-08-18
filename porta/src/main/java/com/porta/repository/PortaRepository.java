package com.porta.repository;

import com.porta.entity.Porta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortaRepository extends CrudRepository<Porta, Long> {
}
