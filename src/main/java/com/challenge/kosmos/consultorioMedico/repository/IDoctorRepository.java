package com.challenge.kosmos.consultorioMedico.repository;

import com.challenge.kosmos.consultorioMedico.model.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDoctorRepository extends JpaRepository<DoctorEntity,Long> {
    Optional<DoctorEntity> findByNombre(String nombre);
}
