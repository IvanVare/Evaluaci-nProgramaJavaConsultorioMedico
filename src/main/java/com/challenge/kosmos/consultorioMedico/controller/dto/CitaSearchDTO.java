package com.challenge.kosmos.consultorioMedico.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CitaSearchDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull
    @NotBlank
    private String nombreDoctor;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull
    @NotBlank
    private LocalDate fecha;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull
    @NotBlank
    private String numeroConsultorio;
}
