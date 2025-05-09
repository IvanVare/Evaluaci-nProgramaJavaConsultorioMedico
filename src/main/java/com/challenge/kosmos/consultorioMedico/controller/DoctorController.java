package com.challenge.kosmos.consultorioMedico.controller;

import com.challenge.kosmos.consultorioMedico.controller.dto.DoctorDTO;
import com.challenge.kosmos.consultorioMedico.service.IDoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private IDoctorService doctorService;

    @PostMapping("/create")
    public ResponseEntity<DoctorDTO> create(@RequestBody @Valid DoctorDTO doctorDTO){
        return new ResponseEntity<>(doctorService.create(doctorDTO), HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<DoctorDTO> findById(@PathVariable Long id){
        return new ResponseEntity<>(doctorService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<DoctorDTO>> findAll(){
        return new ResponseEntity<>(doctorService.findAll(),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DoctorDTO> findById(@PathVariable Long id,@RequestBody @Valid DoctorDTO doctorDTO){
        return new ResponseEntity<>(doctorService.update(id,doctorDTO),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(doctorService.delete(id),HttpStatus.OK);
    }
}
