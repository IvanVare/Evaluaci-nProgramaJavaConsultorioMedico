package com.challenge.kosmos.consultorioMedico.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "consultorio")
public class ConsultorioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "numero_consultorio")
    private String numeroConsultorio;
    private int piso;
    private int status;
}
