package com.challenge.kosmos.consultorioMedico.controller;

import com.challenge.kosmos.consultorioMedico.controller.dto.ConsultorioDTO;
import com.challenge.kosmos.consultorioMedico.service.IConsultorioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultorio")
public class ConsultorioController {
    @Autowired
    private IConsultorioService consultorioService;

    @PostMapping("/create")
    public ResponseEntity<ConsultorioDTO> create(@RequestBody @Valid ConsultorioDTO consultorioDTO){
        return new ResponseEntity<>(consultorioService.create(consultorioDTO), HttpStatus.CREATED);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<ConsultorioDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(consultorioService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ConsultorioDTO>> findAll(){
        return new ResponseEntity<>(consultorioService.findAll(),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ConsultorioDTO> findById(@PathVariable Long id,@RequestBody @Valid ConsultorioDTO consultorioDTO){
        return new ResponseEntity<>(consultorioService.update(id,consultorioDTO),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(consultorioService.delete(id),HttpStatus.OK);
    }
}
