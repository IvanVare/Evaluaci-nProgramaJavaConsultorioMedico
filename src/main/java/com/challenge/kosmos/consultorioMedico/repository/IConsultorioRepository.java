package com.challenge.kosmos.consultorioMedico.repository;

import com.challenge.kosmos.consultorioMedico.model.ConsultorioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IConsultorioRepository extends JpaRepository<ConsultorioEntity,Long> {

    Optional<ConsultorioEntity> findByNumeroConsultorio(String numeroConsultorio);
}
