package com.challenge.kosmos.consultorioMedico.service.Impl;

import com.challenge.kosmos.consultorioMedico.controller.dto.ConsultorioDTO;
import com.challenge.kosmos.consultorioMedico.exception.ServiceException;
import com.challenge.kosmos.consultorioMedico.model.ConsultorioEntity;
import com.challenge.kosmos.consultorioMedico.repository.IConsultorioRepository;
import com.challenge.kosmos.consultorioMedico.service.IConsultorioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConsultorioService implements IConsultorioService {
    private final IConsultorioRepository consultorioRepository;
    private static final String CONSULTORIO_NOTFOUND = "Consultorio no encontrado";  // Compliant

    @Override
    public ConsultorioDTO create(ConsultorioDTO consultorioDTO) {
        ConsultorioEntity consultorioEntity = ConsultorioEntity
                .builder()
                .numeroConsultorio(consultorioDTO.getNumeroConsultorio())
                .piso(consultorioDTO.getPiso())
                .status(1)
                .build();
        consultorioRepository.save(consultorioEntity);
        return consultorioDTO;
    }

    @Override
    public ConsultorioDTO findById(Long id) {
        ConsultorioEntity consultorioEntity = consultorioRepository.findById(id).orElseThrow(()-> new ServiceException(HttpStatus.NOT_FOUND,CONSULTORIO_NOTFOUND));
        return ConsultorioDTO
                .builder()
                .numeroConsultorio(consultorioEntity.getNumeroConsultorio())
                .piso(consultorioEntity.getPiso())
                .build();
    }

    @Override
    public List<ConsultorioDTO> findAll() {
        List<ConsultorioEntity> consultorioEntityList = consultorioRepository.findAll();
        List<ConsultorioDTO> consultorioDTOList =  consultorioEntityList
                .stream()
                .map(cE -> new ConsultorioDTO(
                        cE.getId(),
                        cE.getNumeroConsultorio(),
                        cE.getPiso()))
                .toList();
        return consultorioDTOList;
    }

    @Override
    public ConsultorioDTO update(Long id, ConsultorioDTO consultorioDTO) {
        ConsultorioEntity consultorioEntity = consultorioRepository.findById(id).orElseThrow(()-> new ServiceException(HttpStatus.NOT_FOUND,CONSULTORIO_NOTFOUND));
        ConsultorioEntity currentConsultorioEntity = consultorioEntity;
        currentConsultorioEntity.setNumeroConsultorio(consultorioDTO.getNumeroConsultorio());
        currentConsultorioEntity.setPiso(consultorioDTO.getPiso());
        consultorioRepository.save(currentConsultorioEntity);
        ConsultorioDTO currentConsultorioDTO = ConsultorioDTO.builder()
                .numeroConsultorio(currentConsultorioEntity.getNumeroConsultorio())
                .piso(currentConsultorioEntity.getPiso())
                .build();
        return currentConsultorioDTO;
    }

    @Override
    public boolean delete(Long id) {
        ConsultorioEntity consultorioEntity = consultorioRepository.findById(id).orElseThrow(()-> new ServiceException(HttpStatus.NOT_FOUND,CONSULTORIO_NOTFOUND));
        ConsultorioEntity currentConsultorioEntity = consultorioEntity;
        currentConsultorioEntity.setStatus(0);
        consultorioRepository.save(currentConsultorioEntity);
        return true;
    }
}
