package com.challenge.kosmos.consultorioMedico.service;

import com.challenge.kosmos.consultorioMedico.controller.dto.CitaDTO;

import java.time.LocalDate;
import java.util.List;


public interface ICitaService {
    CitaDTO create(CitaDTO citaDTO);

    List<CitaDTO> findByNombreDoctorAndFecha(String nombreDoctor, LocalDate fecha);
    List<CitaDTO> findByNumeroConsultorioAndFecha(String numeroConsultorio, LocalDate fecha);
    List<CitaDTO> findByFecha(LocalDate fecha);
    List<CitaDTO> findAll();

    CitaDTO update(Long id, CitaDTO citaDTO);

    boolean delete(Long id);
}
