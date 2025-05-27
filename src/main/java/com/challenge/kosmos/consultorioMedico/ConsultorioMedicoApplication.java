package com.challenge.kosmos.consultorioMedico;

import com.challenge.kosmos.consultorioMedico.controller.dto.CitaDTO;
import com.challenge.kosmos.consultorioMedico.controller.dto.ConsultorioDTO;
import com.challenge.kosmos.consultorioMedico.controller.dto.DoctorDTO;
import com.challenge.kosmos.consultorioMedico.model.CitaEntity;
import com.challenge.kosmos.consultorioMedico.model.ConsultorioEntity;
import com.challenge.kosmos.consultorioMedico.model.DoctorEntity;
import com.challenge.kosmos.consultorioMedico.repository.ICitaRepository;
import com.challenge.kosmos.consultorioMedico.repository.IConsultorioRepository;
import com.challenge.kosmos.consultorioMedico.repository.IDoctorRepository;
import com.challenge.kosmos.consultorioMedico.service.ICitaService;
import com.challenge.kosmos.consultorioMedico.service.IConsultorioService;
import com.challenge.kosmos.consultorioMedico.service.IDoctorService;
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
	@Bean
	CommandLineRunner initData(IDoctorService doctorService,
							   IConsultorioService consultorioService,
							   ICitaService citaService) {
		return args -> {
			//  Crear doctores
			DoctorDTO doctor1 = DoctorDTO.builder()
					.nombre("Juan")
					.apellidoPaterno("Perez")
					.apellidoMaterno("Hernandez")
					.especialidad("Clinico")
					.build();

			DoctorDTO doctor2 = DoctorDTO.builder()
					.nombre("Fernanda")
					.apellidoPaterno("Armas")
					.apellidoMaterno("Lopez")
					.especialidad("Pediatría")
					.build();

			DoctorDTO doctor3 = DoctorDTO.builder()
					.nombre("Gerardo")
					.apellidoPaterno("Moral")
					.apellidoMaterno("Cordova")
					.especialidad("Cardiólogo")
					.build();

			doctorService.create(doctor1);
			doctorService.create(doctor2);
			doctorService.create(doctor3);

			// Crear consultorios
			ConsultorioDTO consultorio1 = ConsultorioDTO.builder()
					.numeroConsultorio("A1")
					.piso(1)
					.build();

			ConsultorioDTO consultorio2 = ConsultorioDTO.builder()
					.numeroConsultorio("A2")
					.piso(1)
					.build();

			ConsultorioDTO consultorio3 = ConsultorioDTO.builder()
					.numeroConsultorio("A3")
					.piso(1)
					.build();

			consultorioService.create(consultorio1);
			consultorioService.create(consultorio2);
			consultorioService.create(consultorio3);

			//  Crear citas
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
	}
}


