package com.example.patient_management.repository;

import com.example.patient_management.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient ,Long> {
}
