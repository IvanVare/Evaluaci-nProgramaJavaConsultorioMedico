package com.challenge.kosmos.consultorioMedico.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CitaDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @NotNull
    @NotBlank
    private String nombrePaciente;
    @NotNull(message = "La fecha no puede ser nula")
    private LocalDate fecha;
    @NotNull(message = "La hora de Inicio no puede ser nula")
    private LocalTime horaInicio;
    @NotNull(message = "La hora de Fin no puede ser nula")
    private LocalTime horaFin;
    @NotNull
    @NotBlank
    private String numeroConsultorio;
    @NotNull
    @NotBlank
    private String nombreDoctor;
}
