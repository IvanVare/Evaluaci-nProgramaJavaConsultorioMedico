package com.challenge.kosmos.consultorioMedico.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cita")
public class CitaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nombre_paciente")
    private String nombrePaciente;
    private LocalDate fecha;
    @Column(name = "hora_inicio")
    private LocalTime horaInicio;
    @Column(name = "hora_fin")
    private LocalTime horaFin;
    private int status;

    @ManyToOne
    @JoinColumn(name = "consultorio_id")
    private ConsultorioEntity consultorioEntity;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctorEntity;
}
