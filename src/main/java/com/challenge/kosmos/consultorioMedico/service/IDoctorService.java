package com.challenge.kosmos.consultorioMedico.service;

import com.challenge.kosmos.consultorioMedico.controller.dto.DoctorDTO;

import java.util.List;

public interface IDoctorService {
    DoctorDTO create(DoctorDTO doctorDTO);

    DoctorDTO findById(Long id);

    List<DoctorDTO> findAll();

    DoctorDTO update(Long id, DoctorDTO doctorDTO);

    boolean delete(Long id);
}
