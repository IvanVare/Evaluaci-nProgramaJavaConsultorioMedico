package com.challenge.kosmos.consultorioMedico;

import com.challenge.kosmos.consultorioMedico.controller.dto.CitaDTO;
import com.challenge.kosmos.consultorioMedico.model.CitaEntity;
import com.challenge.kosmos.consultorioMedico.model.ConsultorioEntity;
import com.challenge.kosmos.consultorioMedico.model.DoctorEntity;
import com.challenge.kosmos.consultorioMedico.repository.ICitaRepository;
import com.challenge.kosmos.consultorioMedico.repository.IConsultorioRepository;
import com.challenge.kosmos.consultorioMedico.repository.IDoctorRepository;
import com.challenge.kosmos.consultorioMedico.service.ICitaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ConsultorioMedicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultorioMedicoApplication.class, args);
	}
	/*
	@Bean
	CommandLineRunner initDoctors(IDoctorRepository doctorRepository) {
		return args -> {
			// Create Doctors
			DoctorEntity doctor1 = DoctorEntity.builder()
					.nombre("Juan")
					.apellidoPaterno("Perez")
					.apellidoMaterno("Hernandez")
					.especialidad("Clinico")
					.status(1)
					.build();

			DoctorEntity doctor2 = DoctorEntity.builder()
					.nombre("Fernanda")
					.apellidoPaterno("Armas")
					.apellidoMaterno("Lopez")
					.especialidad("Pediatría")
					.status(1)
					.build();

			DoctorEntity doctor3 = DoctorEntity.builder()
					.nombre("Gerardo")
					.apellidoPaterno("Moral")
					.apellidoMaterno("Cordova")
					.especialidad("Cardiólogo")
					.status(1)
					.build();

			doctorRepository.saveAll(List.of(doctor1, doctor2, doctor3));
		};
	}

	@Bean
	CommandLineRunner initConsultorios(IConsultorioRepository consultorioRespository) {
		return args -> {
			// Create Consultorios
			ConsultorioEntity consultorio1 = ConsultorioEntity.builder()
					.numeroConsultorio("A1")
					.piso(1)
					.status(1)
					.build();

			ConsultorioEntity consultorio2 = ConsultorioEntity.builder()
					.numeroConsultorio("A2")
					.piso(1)
					.status(1)
					.build();

			ConsultorioEntity consultorio3 = ConsultorioEntity.builder()
					.numeroConsultorio("A3")
					.piso(1)
					.status(1)
					.build();

			consultorioRespository.saveAll(List.of(consultorio1, consultorio2, consultorio3));
		};
	}

	@Bean
	CommandLineRunner initCitas(ICitaService citaService) {
		return args -> {
			// Create Citas
			CitaDTO citaDTO1 = CitaDTO.builder()
					.nombrePaciente("John moral juarez")
					.fecha(LocalDate.parse("2025-05-10"))
					.horaInicio(LocalTime.parse("18:00"))
					.horaFin(LocalTime.parse("19:00"))
					.numeroConsultorio("A1")
					.nombreDoctor("Juan")
					.build();

			CitaDTO citaDTO2 = CitaDTO.builder()
					.nombrePaciente("Maria rosa Hernandez")
					.fecha(LocalDate.parse("2025-05-11"))
					.horaInicio(LocalTime.parse("18:00"))
					.horaFin(LocalTime.parse("19:00"))
					.numeroConsultorio("A1")
					.nombreDoctor("Fernanda")
					.build();

			CitaDTO citaDTO3 = CitaDTO.builder()
					.nombrePaciente("Antonio lopez garza")
					.fecha(LocalDate.parse("2025-05-12"))
					.horaInicio(LocalTime.parse("18:00"))
					.horaFin(LocalTime.parse("19:00"))
					.numeroConsultorio("A1")
					.nombreDoctor("Gerardo")
					.build();

			citaService.create(citaDTO1);
			citaService.create(citaDTO2);
			citaService.create(citaDTO3);
		};

	}*/
}


