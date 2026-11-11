package com.jpaandhibernateexample.hospital_management_db.service;

import com.jpaandhibernateexample.hospital_management_db.model.Doctor;
import com.jpaandhibernateexample.hospital_management_db.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // it contains business logic
public class DoctorService {

    @Autowired // field injection
    DoctorRepository doctorRepository;

    public String saveDoctor(Doctor doctor){
        doctorRepository.save(doctor);
        return "Doctor saved successfully!";
    }

    public Doctor findByDoctorId(int id){
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if(doctorOptional.isPresent()){
            return doctorOptional.get();
        } else {
            return null;
        }
    }

    public List<Doctor> findAllDoctors(){
        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList;
    }

    public String countDoctors(){
        long totalCount = doctorRepository.count();
        return "Total doctors present are : "+totalCount;
    }

    public String deleteDoctorById(int id){
        Doctor existingDoctor = findByDoctorId(id);
        if(existingDoctor!=null){
            doctorRepository.deleteById(id);
            return "Doctor with id : "+id+" got deleted successfully!";
        } else {
            return "Doctor with id : "+id+" is not present, hence cannot delete!";
        }
    }

    //update using put operation - updates complete object
    public String updateDoctorUsingPut(int doctorId, Doctor newDoctorRequest){
        // find doctor with id
        // if doctor is present, update it
        // else we cannot update
        Doctor existingDoctor = findByDoctorId(doctorId);
        if(existingDoctor!=null){
            // proceed to update
            doctorRepository.save(newDoctorRequest); // save will create a new record if id is not already present, and it will update the records if id is already present
            return "Doctor with id : "+doctorId +" updated successfully!";
        } else {
            // cannot update
            return "Doctor with id : "+doctorId +" not present, hence cannot update!";
        }
    }

    //update using patch operation - updates single specific fields
    public String updateDoctorUsingPatch(int doctorId, String newMobile, String newEmail){
        // find doctor with id
        // if doctor is present, update it
        // else we cannot update
        Doctor existingDoctor = findByDoctorId(doctorId);
        if(existingDoctor!=null){
            // proceed to update
            existingDoctor.setMobile(newMobile);
            existingDoctor.setEmail(newEmail);
            doctorRepository.save(existingDoctor); // save will create a new record if id is not already present, and it will update the records if id is already present
            return "Doctor with id : "+doctorId +" updated successfully!";
        } else {
            // cannot update
            return "Doctor with id : "+doctorId +" not present, hence cannot update!";
        }
    }
}
