package com.example.patient_management.service;

import com.example.patient_management.model.Patient;


import java.util.List;

public interface PatientService {
    Patient savePatient(Patient patient);
    List<Patient>getAllPatient();
    Patient getPatientById(Long id);
    Patient updatePatient(Patient patient,Long id);
    void deletePatient(Long id);
}
