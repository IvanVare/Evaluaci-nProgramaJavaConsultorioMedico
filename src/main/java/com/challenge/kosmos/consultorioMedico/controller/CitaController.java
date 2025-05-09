package com.challenge.kosmos.consultorioMedico.controller;

import com.challenge.kosmos.consultorioMedico.controller.dto.CitaDTO;
import com.challenge.kosmos.consultorioMedico.controller.dto.CitaSearchDTO;
import com.challenge.kosmos.consultorioMedico.service.ICitaService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cita")
public class CitaController {
    @Autowired
    private ICitaService citaService;

    @PostMapping("/create")
    public ResponseEntity<CitaDTO> create(@RequestBody @Valid CitaDTO citaDTO){
        return new ResponseEntity<>(citaService.create(citaDTO), HttpStatus.CREATED);
    }

    @GetMapping("/findByNombreDoctorAndFecha")
    public ResponseEntity<List<CitaDTO>> findByNombreDoctorAndFecha(@RequestBody @Valid CitaSearchDTO citaSearchDTO){
        return new ResponseEntity<>(citaService.findByNombreDoctorAndFecha(citaSearchDTO.getNombreDoctor(),citaSearchDTO.getFecha()),HttpStatus.OK);
    }

    @GetMapping("/findByNumeroConsultorioAndFecha")
    public ResponseEntity<List<CitaDTO>> findByNumeroConsultorioAndFecha(@RequestBody @Valid CitaSearchDTO citaSearchDTO){
        return new ResponseEntity<>(citaService.findByNumeroConsultorioAndFecha(citaSearchDTO.getNumeroConsultorio(),citaSearchDTO.getFecha()),HttpStatus.OK);
    }

    @GetMapping("/findByFecha")
    public ResponseEntity<List<CitaDTO>> findByFecha(@RequestBody @Valid CitaSearchDTO citaSearchDTO){
        return new ResponseEntity<>(citaService.findByFecha(citaSearchDTO.getFecha()),HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<CitaDTO>> findAll(){
        return new ResponseEntity<>(citaService.findAll(),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CitaDTO> findById(@PathVariable Long id,@RequestBody @Valid CitaDTO citaDTO){
        return new ResponseEntity<>(citaService.update(id,citaDTO),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(citaService.delete(id),HttpStatus.OK);
    }
}
