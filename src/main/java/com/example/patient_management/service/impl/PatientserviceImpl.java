package com.example.patient_management.service.impl;

import com.example.patient_management.exception.ResourceNotFoundException;
import com.example.patient_management.model.Patient;
import com.example.patient_management.repository.PatientRepository;
import com.example.patient_management.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class PatientserviceImpl implements PatientService {

    public final PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
//        Optional<Patient> patient = patientRepository.findById(id);
//        if (patient.isPresent()){
//            return patient.get();
//        }
//        else {
//            throw new ResourceNotFoundException("Patient","id",id);
//        }
        return patientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Patient","id",id) );
    }

    @Override
    public Patient updatePatient(Patient patient, Long id) {
        Patient patient1 = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", id));


        patient1.setName(patient.getName());
        patient1.setAddress(patient.getAddress());
        patient1.setAge(patient.getAge());
        patient1.setGender(patient.getGender());
        patient1.setDateOfBirth(patient.getDateOfBirth());
        patient1.setMobile(patient.getMobile());


        patientRepository.save(patient1);
        return patient1;
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
