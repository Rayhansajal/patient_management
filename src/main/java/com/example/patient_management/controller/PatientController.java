package com.example.patient_management.controller;

import com.example.patient_management.model.Patient;
import com.example.patient_management.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientController {

public PatientService patientService;



    // create patient
    @PostMapping
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
        return new ResponseEntity<Patient>(patientService.savePatient(patient), HttpStatus.CREATED);
    }
    // get all patient information
    @GetMapping
    public List<Patient> getAllPatient(){
        return patientService.getAllPatient();
    }

    // get patient by Id
    @GetMapping("{id}")
    public ResponseEntity<Patient> getPatientBYId(@PathVariable("id") Long patientid){
        return new ResponseEntity<>(patientService.getPatientById(patientid),HttpStatus.OK);
    }
    // update patient
    @PutMapping("{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") Long id,@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.updatePatient(patient,id),HttpStatus.OK);
    }

    //delete patient
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") Long id){
     patientService.deletePatient(id);
     return new ResponseEntity<>("Data deleted Successfully",HttpStatus.OK);
    }

}
