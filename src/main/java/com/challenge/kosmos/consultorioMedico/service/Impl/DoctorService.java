package com.challenge.kosmos.consultorioMedico.service.Impl;

import com.challenge.kosmos.consultorioMedico.controller.dto.DoctorDTO;
import com.challenge.kosmos.consultorioMedico.exception.ServiceException;
import com.challenge.kosmos.consultorioMedico.model.DoctorEntity;
import com.challenge.kosmos.consultorioMedico.repository.IDoctorRepository;
import com.challenge.kosmos.consultorioMedico.service.IDoctorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService implements IDoctorService {

    private final IDoctorRepository doctorRepository;
    private static final String DOCTOR_NOTFOUND = "Doctor no encontrado";  // Compliant


    @Override
    public DoctorDTO create(DoctorDTO doctorDTO) throws ServiceException {
        DoctorEntity doctorEntity = DoctorEntity
                .builder()
                .nombre(doctorDTO.getNombre())
                .apellidoPaterno(doctorDTO.getApellidoPaterno())
                .apellidoMaterno(doctorDTO.getApellidoMaterno())
                .especialidad(doctorDTO.getEspecialidad())
                .status(1)
                .build();
        doctorRepository.save(doctorEntity);
        return doctorDTO;
    }

    @Override
    public DoctorDTO findById(Long id) throws ServiceException{
        DoctorEntity doctorEntity = doctorRepository.findById(id).orElseThrow(()-> new ServiceException(HttpStatus.NOT_FOUND,DOCTOR_NOTFOUND));//Revisar error
        return DoctorDTO
                .builder()
                .nombre(doctorEntity.getNombre())
                .apellidoPaterno(doctorEntity.getApellidoPaterno())
                .apellidoMaterno(doctorEntity.getApellidoMaterno())
                .especialidad(doctorEntity.getEspecialidad())
                .build();
    }

    @Override
    public List<DoctorDTO> findAll() {
        List<DoctorEntity> doctorEntityList = doctorRepository.findAll();
        List<DoctorDTO> doctorDTOList =  doctorEntityList
                .stream()
                .map(doctorEntity -> new DoctorDTO(
                        doctorEntity.getId(),
                        doctorEntity.getNombre(),
                        doctorEntity.getApellidoPaterno(),
                        doctorEntity.getApellidoMaterno(),
                        doctorEntity.getEspecialidad()))
                .toList();
        return doctorDTOList;
    }


    @Override
    public DoctorDTO update(Long id, DoctorDTO doctorDTO) throws ServiceException{
        DoctorEntity doctorEntity = doctorRepository.findById(id).orElseThrow(()-> new ServiceException(HttpStatus.NOT_FOUND,DOCTOR_NOTFOUND));
        doctorEntity.setNombre(doctorDTO.getNombre());
        doctorEntity.setApellidoPaterno(doctorDTO.getApellidoPaterno());
        doctorEntity.setApellidoMaterno(doctorDTO.getApellidoMaterno());
        doctorEntity.setEspecialidad(doctorDTO.getEspecialidad());
        doctorRepository.save(doctorEntity);
        DoctorDTO currentDoctorDTO = DoctorDTO.builder()
                .nombre(doctorEntity.getNombre())
                .apellidoPaterno(doctorEntity.getApellidoPaterno())
                .apellidoPaterno(doctorEntity.getApellidoMaterno())
                .especialidad(doctorEntity.getEspecialidad())
                .build();
        return currentDoctorDTO;
    }

    @Override
    public boolean delete(Long id) throws ServiceException{
        DoctorEntity doctorEntity = doctorRepository.findById(id).orElseThrow(()-> new ServiceException(HttpStatus.NOT_FOUND,DOCTOR_NOTFOUND));
        doctorEntity.setStatus(0);
        doctorRepository.save(doctorEntity);
        return true;
    }
}
