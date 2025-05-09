package com.challenge.kosmos.consultorioMedico.service;

import com.challenge.kosmos.consultorioMedico.controller.dto.ConsultorioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IConsultorioService {

    ConsultorioDTO create(ConsultorioDTO consultorioDTO);

    ConsultorioDTO findById(Long id);

    List<ConsultorioDTO> findAll();

    ConsultorioDTO update(Long id,ConsultorioDTO consultorioDTO);

    boolean delete(Long id);
}
