package com.jpaandhibernateexample.hospital_management_db.service;

import com.jpaandhibernateexample.hospital_management_db.model.Patient;
import com.jpaandhibernateexample.hospital_management_db.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {


        @Autowired // field injection
        PatientRepository patientRepository;

        // Save patient
        public String savePatient(Patient patient) {
            patientRepository.save(patient);
            return "Patient saved successfully!";
        }

        // Find patient by ID
        public Patient findByPatientId(int id) {
            Optional<Patient> patientOptional =
                    patientRepository.findById(id);

            if (patientOptional.isPresent()) {
                return patientOptional.get();
            } else {
                return null;
            }
        }

        // Find all patients
        public List<Patient> findAllPatients() {
            List<Patient> patientList = patientRepository.findAll();
            return patientList;
        }

        // Count patients
        public String countPatients() {
            long totalCount = patientRepository.count();
            return "Total patients present are : " + totalCount;
        }

        // Delete patient by ID
        public String deletePatientById(int id) {
            Patient existingPatient = findByPatientId(id);

            if (existingPatient != null) {
                patientRepository.deleteById(id);
                return "Patient with id : " + id +
                        " got deleted successfully!";
            } else {
                return "Patient with id : " + id +
                        " is not present, hence cannot delete!";
            }
        }

        // Update using PUT operation - updates complete object
        public String updatePatientUsingPut(
                int patientId, Patient newPatientRequest) {

            // Find patient with ID
            Patient existingPatient = findByPatientId(patientId);

            if (existingPatient != null) {

                // Set the existing ID to avoid inserting another record
                newPatientRequest.setId(patientId);

                // Update complete patient object
                patientRepository.save(newPatientRequest);

                return "Patient with id : " + patientId +
                        " updated successfully!";
            } else {
                return "Patient with id : " + patientId +
                        " not present, hence cannot update!";
            }
        }

        // Update using PATCH operation - updates specific fields
        public String updatePatientUsingPatch(
                int patientId,
                String newMobile,
                String newEmail) {

            // Find patient with ID
            Patient existingPatient = findByPatientId(patientId);

            if (existingPatient != null) {

                // Update specific fields
                existingPatient.setMobile(newMobile);
                existingPatient.setEmail(newEmail);

                patientRepository.save(existingPatient);

                return "Patient with id : " + patientId +
                        " updated successfully!";
            } else {
                return "Patient with id : " + patientId +
                        " not present, hence cannot update!";
            }
        }
    }


