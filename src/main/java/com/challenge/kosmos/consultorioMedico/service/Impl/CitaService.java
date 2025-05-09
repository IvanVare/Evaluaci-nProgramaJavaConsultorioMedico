package com.challenge.kosmos.consultorioMedico.service.Impl;

import com.challenge.kosmos.consultorioMedico.controller.dto.CitaDTO;
import com.challenge.kosmos.consultorioMedico.exception.ServiceException;
import com.challenge.kosmos.consultorioMedico.model.CitaEntity;
import com.challenge.kosmos.consultorioMedico.model.ConsultorioEntity;
import com.challenge.kosmos.consultorioMedico.model.DoctorEntity;
import com.challenge.kosmos.consultorioMedico.repository.ICitaRepository;
import com.challenge.kosmos.consultorioMedico.repository.IConsultorioRepository;
import com.challenge.kosmos.consultorioMedico.repository.IDoctorRepository;
import com.challenge.kosmos.consultorioMedico.service.ICitaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class CitaService implements ICitaService {

    private final ICitaRepository citaRepository;
    private final IDoctorRepository doctorRepository;
    private final IConsultorioRepository consultorioRepository;
    private static final String DOCTOR_NOTFOUND = "Doctor no encontrado";  // Compliant
    private static final String CONSULTORIO_NOTFOUND = "Consultorio no encontrado";  // Compliant


    /**
     * Agendar cita
     * */
    @Override
    public CitaDTO create(CitaDTO citaDTO) {
        CitaDTO citaDTOValidate = validateRegistrationRules(citaDTO);
        DoctorEntity doctorEntity = doctorRepository.findByNombre(citaDTOValidate.getNombreDoctor()).orElseThrow(()-> new ServiceException(HttpStatus.NOT_FOUND,DOCTOR_NOTFOUND));
        ConsultorioEntity consultorioEntity = consultorioRepository.findByNumeroConsultorio(citaDTOValidate.getNumeroConsultorio()).orElseThrow(()-> new ServiceException(HttpStatus.NOT_FOUND,CONSULTORIO_NOTFOUND));
        CitaEntity citaEntity = CitaEntity
                .builder()
                .nombrePaciente(citaDTOValidate.getNombrePaciente())
                .fecha(citaDTOValidate.getFecha())
                .horaInicio(citaDTOValidate.getHoraInicio())
                .horaFin(citaDTOValidate.getHoraFin())
                .doctorEntity(doctorEntity)
                .consultorioEntity(consultorioEntity)
                .status(1)
                .build();
        citaRepository.save(citaEntity);
        return citaDTO;
    }

    /**
     * Consultar cita por nombre de doctor y fecha
     * */
    @Override
    public List<CitaDTO> findByNombreDoctorAndFecha(String nombreDoctor, LocalDate fecha) {
        List<CitaEntity> citaEntityList = citaRepository.findByDoctorEntityNombreAndFecha(nombreDoctor,fecha);
        List<CitaDTO> citaDTOList =  citaEntityList
                .stream()
                .filter(ciE -> ciE.getStatus()!=0)
                .map(ciE -> new CitaDTO(
                        ciE.getId(),
                        ciE.getNombrePaciente(),
                        ciE.getFecha(),
                        ciE.getHoraInicio(),
                        ciE.getHoraFin(),
                        ciE.getConsultorioEntity().getNumeroConsultorio(),
                        ciE.getDoctorEntity().getNombre()+" "+ciE.getDoctorEntity().getApellidoPaterno()))
                .toList();
        return citaDTOList;
    }

    /**
     * Consultar cita por numero de consultorio y fecha
     * */
    @Override
    public List<CitaDTO> findByNumeroConsultorioAndFecha(String numeroConsultorio, LocalDate fecha) {
        List<CitaEntity> citaEntityList = citaRepository.findByConsultorioEntityNumeroConsultorioAndFecha(numeroConsultorio,fecha);
        List<CitaDTO> citaDTOList =  citaEntityList
                .stream()
                .filter(ciE -> ciE.getStatus()!=0)
                .map(ciE -> new CitaDTO(
                        ciE.getId(),
                        ciE.getNombrePaciente(),
                        ciE.getFecha(),
                        ciE.getHoraInicio(),
                        ciE.getHoraFin(),
                        ciE.getConsultorioEntity().getNumeroConsultorio(),
                        ciE.getDoctorEntity().getNombre()+" "+ciE.getDoctorEntity().getApellidoPaterno()))
                .toList();
        return citaDTOList;
    }

    /**
     * Consultar cita por fecha
     * */
    @Override
    public List<CitaDTO> findByFecha(LocalDate fecha) {
        List<CitaEntity> citaEntityList = citaRepository.findByFecha(fecha);
        List<CitaDTO> citaDTOList =  citaEntityList
                .stream()
                .filter(ciE -> ciE.getStatus()!=0)
                .map(ciE -> new CitaDTO(
                        ciE.getId(),
                        ciE.getNombrePaciente(),
                        ciE.getFecha(),
                        ciE.getHoraInicio(),
                        ciE.getHoraFin(),
                        ciE.getConsultorioEntity().getNumeroConsultorio(),
                        ciE.getDoctorEntity().getNombre()+" "+ciE.getDoctorEntity().getApellidoPaterno()))
                .toList();
        return citaDTOList;
    }

    @Override
    public List<CitaDTO> findAll() {
        List<CitaEntity> citaEntityList = citaRepository.findAll();
        List<CitaDTO> citaDTOList =  citaEntityList
                .stream()
                .filter(ciE -> ciE.getStatus()!=0)
                .map(ciE -> new CitaDTO(
                        ciE.getId(),
                        ciE.getNombrePaciente(),
                        ciE.getFecha(),
                        ciE.getHoraInicio(),
                        ciE.getHoraFin(),
                        ciE.getConsultorioEntity().getNumeroConsultorio(),
                        ciE.getDoctorEntity().getNombre()+" "+ciE.getDoctorEntity().getApellidoPaterno()))
                .toList();
        return citaDTOList;
    }

    /**
     * Editar una cita tomando en cuenta las reglas de alta
     * */
    @Override
    public CitaDTO update(Long id, CitaDTO citaDTO) {
        CitaEntity citaEntity = citaRepository.findById(id).orElseThrow(()-> new ServiceException(HttpStatus.NOT_FOUND,"Cita no encontrada"));
        CitaDTO citaDTOValidate = validateRegistrationRules(citaDTO);
        DoctorEntity doctorEntity = doctorRepository.findByNombre(citaDTOValidate.getNombreDoctor()).orElseThrow(()-> new ServiceException(HttpStatus.NOT_FOUND,DOCTOR_NOTFOUND));
        ConsultorioEntity consultorioEntity = consultorioRepository.findByNumeroConsultorio(citaDTOValidate.getNumeroConsultorio()).orElseThrow(()-> new ServiceException(HttpStatus.NOT_FOUND,CONSULTORIO_NOTFOUND));

        citaEntity.setNombrePaciente(citaDTOValidate.getNombrePaciente());
        citaEntity.setFecha(citaDTOValidate.getFecha());
        citaEntity.setHoraInicio(citaDTOValidate.getHoraInicio());
        citaEntity.setHoraFin(citaDTOValidate.getHoraFin());
        citaEntity.setConsultorioEntity(consultorioEntity);
        citaEntity.setDoctorEntity(doctorEntity);
        return citaDTO;
    } //revisar

    /**
     * Cancelar una cita que aun este pendiente de realizarse según su horario.
     * */
    @Override
    public boolean delete(Long id) {
        CitaEntity citaEntity = citaRepository.findById(id).orElseThrow(()-> new ServiceException(HttpStatus.NOT_FOUND,"Cita no encontrada"));
        citaEntity.setStatus(0);
        citaRepository.save(citaEntity);
        return true;
    }

    /**
     * Metodo para validar el registro de las citas
     * */
    private CitaDTO validateRegistrationRules(CitaDTO citaDTO){
        DoctorEntity doctorEntity = doctorRepository.findByNombre(citaDTO.getNombreDoctor()).orElseThrow(()-> new ServiceException(HttpStatus.NOT_FOUND,DOCTOR_NOTFOUND));
        ConsultorioEntity consultorioEntity = consultorioRepository.findByNumeroConsultorio(citaDTO.getNumeroConsultorio()).orElseThrow(()-> new ServiceException(HttpStatus.NOT_FOUND,CONSULTORIO_NOTFOUND));
        //No se puede agendar cita en un mismo consultorio a la misma hora.
        if (citaRepository.findByConsultorioEntityNumeroConsultorioAndHoraInicio(citaDTO.getNumeroConsultorio(),citaDTO.getHoraInicio())
                .stream()
                .anyMatch(cita -> cita.getConsultorioEntity()==consultorioEntity && cita.getHoraInicio() == citaDTO.getHoraInicio())){
            throw new ServiceException(HttpStatus.CONFLICT,"Horario y consultorio ocupados");
        }
        //No se puede agendar cita para un mismo Dr. a la misma hora.
        if (citaRepository.findByDoctorEntityNombreAndHoraInicio(citaDTO.getNombreDoctor(),citaDTO.getHoraInicio())
                .stream()
                .anyMatch(cita -> cita.getDoctorEntity()==doctorEntity && cita.getHoraInicio() == citaDTO.getHoraInicio())){
            throw new ServiceException(HttpStatus.CONFLICT,"Doctor y consultorio ocupados");
        }
        /*No se puede agendar cita para un paciente a la una misma hora ni con menos de 2 horas
        de diferencia para el mismo día
        */

        if (citaRepository.findByNombrePaciente(citaDTO.getNombrePaciente())!=null && citaRepository.findByNombrePaciente(citaDTO.getNombrePaciente())
                .getHoraFin().plusHours(2).isBefore(citaDTO.getHoraInicio())){
            throw new ServiceException(HttpStatus.CONFLICT,"No se pudo agendar cita para el paciente por tiempo de espera minimo de 2 horas");
        }
        //Un mismo doctor no puede tener más de 8 citas en el día
        if (citaRepository.findByDoctorEntityNombreAndFecha(citaDTO.getNombreDoctor(),citaDTO.getFecha())
                .stream().count()>8){
            throw new ServiceException(HttpStatus.CONFLICT,"Doctor con 8 citas en un dia");
        }
        return citaDTO;
    }
}
