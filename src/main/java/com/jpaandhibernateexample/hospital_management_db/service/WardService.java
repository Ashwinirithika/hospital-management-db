package com.jpaandhibernateexample.hospital_management_db.service;

import com.jpaandhibernateexample.hospital_management_db.model.Ward;
import com.jpaandhibernateexample.hospital_management_db.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WardService {


        @Autowired // field injection
        WardRepository wardRepository;

        // Save ward
        public String saveWard(Ward ward) {
            wardRepository.save(ward);
            return "Ward saved successfully!";
        }

        // Find ward by ID
        public Ward findByWardId(int id) {

            Optional<Ward> wardOptional = wardRepository.findById(id);

            if (wardOptional.isPresent()) {
                return wardOptional.get();
            } else {
                return null;
            }
        }

        // Find all wards
        public List<Ward> findAllWards() {

            List<Ward> wardList = wardRepository.findAll();
            return wardList;
        }

        // Count wards
        public String countWards() {

            long totalCount = wardRepository.count();

            return "Total wards present are : " + totalCount;
        }

        // Delete ward by ID
        public String deleteWardById(int id) {

            Ward existingWard = findByWardId(id);

            if (existingWard != null) {
                wardRepository.deleteById(id);

                return "Ward with id : " + id +
                        " got deleted successfully!";
            } else {
                return "Ward with id : " + id +
                        " is not present, hence cannot delete!";
            }
        }

        // Update using PUT operation - updates complete object
        public String updateWardUsingPut(int wardId, Ward newWardRequest) {

            // Find ward with ID
            Ward existingWard = findByWardId(wardId);

            if (existingWard != null) {

                // Set existing ID to avoid inserting another record
                newWardRequest.setId(wardId);

                // Update complete ward object
                wardRepository.save(newWardRequest);

                return "Ward with id : " + wardId +
                        " updated successfully!";
            } else {
                return "Ward with id : " + wardId +
                        " not present, hence cannot update!";
            }
        }

        // Update using PATCH operation - updates specific fields
        public String updateWardUsingPatch(
                int wardId,
                int newAvailableBeds,
                String newNurseInCharge,
                String newContactNumber) {

            // Find ward with ID
            Ward existingWard = findByWardId(wardId);

            if (existingWard != null) {

                // Update specific fields
                existingWard.setAvailableBeds(newAvailableBeds);
                existingWard.setNurseInCharge(newNurseInCharge);
                existingWard.setContactNumber(newContactNumber);

                wardRepository.save(existingWard);

                return "Ward with id : " + wardId +
                        " updated successfully!";
            } else {
                return "Ward with id : " + wardId +
                        " not present, hence cannot update!";
            }
        }
    }


