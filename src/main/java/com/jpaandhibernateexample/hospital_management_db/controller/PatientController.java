package com.jpaandhibernateexample.hospital_management_db.controller;

import com.jpaandhibernateexample.hospital_management_db.model.Patient;
import com.jpaandhibernateexample.hospital_management_db.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/patient/apis")
public class PatientController {


        // Request -> API (Controller) -> Service -> Repository
        // -> Service (Response) -> API (Response) -> User / Frontend / Postman

        @Autowired
        PatientService patientService;

        // POST - Save patient
        // @RequestBody takes complete JSON input from Postman or UI
        @PostMapping("/save")
        public String savePatient(@RequestBody Patient patient) {

            String response = patientService.savePatient(patient);
            return response;
        }

        // GET - Find patient by ID
        // @PathVariable takes input from URL path
        @GetMapping("/findById/{id}")
        public Patient findPatientById(@PathVariable int id) {

            Patient patient = patientService.findByPatientId(id);
            return patient;
        }

        // GET - Find all patients
        @GetMapping("/findAll")
        public List<Patient> findAllPatients() {

            List<Patient> patientList = patientService.findAllPatients();
            return patientList;
        }

        // GET - Count patients
        @GetMapping("/count")
        public String countPatients() {

            String response = patientService.countPatients();
            return response;
        }

        // DELETE - Delete patient by ID
        @DeleteMapping("/deleteById/{id}")
        public String deletePatientById(@PathVariable int id) {

            String response = patientService.deletePatientById(id);
            return response;
        }

        // PUT - Update complete patient object
        @PutMapping("/updatePut/{id}")
        public String updatePatientUsingPut(
                @PathVariable int id,
                @RequestBody Patient newPatientRequest) {

            String response =
                    patientService.updatePatientUsingPut(id, newPatientRequest);

            return response;
        }

        // PATCH - Update specific fields
        // @RequestParam takes input as query parameters
        @PatchMapping("/updatePatch/{id}")
        public String updatePatientUsingPatch(
                @PathVariable int id,
                @RequestParam String newMobile,
                @RequestParam String newEmail) {

            String response =
                    patientService.updatePatientUsingPatch(
                            id, newMobile, newEmail);

            return response;
        }
    }


