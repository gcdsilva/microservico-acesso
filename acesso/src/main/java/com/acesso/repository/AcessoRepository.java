package com.acesso.repository;


import com.acesso.entity.Acesso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessoRepository extends CrudRepository<Acesso, Long> {


    @Query("from Acesso c WHERE c.portaId = :portaId and c.clienteId = :clienteId")
    public Acesso buscar(@Param("clienteId") Long clienteId, @Param("portaId") Long portaId);
}
