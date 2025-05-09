package com.challenge.kosmos.consultorioMedico.repository;

import com.challenge.kosmos.consultorioMedico.model.CitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ICitaRepository extends JpaRepository<CitaEntity,Long> {

    List<CitaEntity> findByFecha(LocalDate fecha);
    List<CitaEntity> findByConsultorioEntityNumeroConsultorioAndHoraInicio(String NumeroConsultori, LocalTime horaInicio);
    List<CitaEntity> findByConsultorioEntityNumeroConsultorioAndFecha(String NumeroConsultori, LocalDate fecha);
    List<CitaEntity> findByDoctorEntityNombreAndHoraInicio(String nombre, LocalTime horaInicio);
    CitaEntity findByNombrePaciente(String nombrePaciente);
    List<CitaEntity> findByDoctorEntityNombreAndFecha(String nombre,LocalDate fecha);
}
