package com.challenge.kosmos.consultorioMedico.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ConsultorioDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @NotNull
    @NotBlank
    private String numeroConsultorio;
    @NotNull
    private int piso;
}
