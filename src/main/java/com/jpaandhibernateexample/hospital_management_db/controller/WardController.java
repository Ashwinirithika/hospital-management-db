package com.jpaandhibernateexample.hospital_management_db.controller;

import com.jpaandhibernateexample.hospital_management_db.model.Ward;
import com.jpaandhibernateexample.hospital_management_db.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ward/apis")
public class WardController {
        // Request -> API (Controller) -> Service -> Repository
        // -> Service (Response) -> API (Response) -> User / Frontend / Postman

        @Autowired
        WardService wardService;

        // POST - Save ward
        // @RequestBody takes complete JSON input from UI or Postman
        @PostMapping("/save")
        public String saveWard(@RequestBody Ward ward) {

            String response = wardService.saveWard(ward);
            return response;
        }

        // GET - Find ward by ID
        // @PathVariable takes input from URL path
        @GetMapping("/findById/{id}")
        public Ward findWardById(@PathVariable int id) {

            Ward ward = wardService.findByWardId(id);
            return ward;
        }

        // GET - Find all wards
        @GetMapping("/findAll")
        public List<Ward> findAllWards() {

            List<Ward> wardList = wardService.findAllWards();
            return wardList;
        }

        // GET - Count wards
        @GetMapping("/count")
        public String countWards() {

            String response = wardService.countWards();
            return response;
        }

        // DELETE - Delete ward by ID
        @DeleteMapping("/deleteById/{id}")
        public String deleteWardById(@PathVariable int id) {

            String response = wardService.deleteWardById(id);
            return response;
        }

        // PUT - Update complete ward object
        @PutMapping("/updatePut/{id}")
        public String updateWardUsingPut(
                @PathVariable int id,
                @RequestBody Ward newWardRequest) {

            String response =
                    wardService.updateWardUsingPut(id, newWardRequest);

            return response;
        }

        // PATCH - Update specific ward fields
        // @RequestParam takes input as query parameters
        @PatchMapping("/updatePatch/{id}")
        public String updateWardUsingPatch(
                @PathVariable int id,
                @RequestParam int newAvailableBeds,
                @RequestParam String newNurseInCharge,
                @RequestParam String newContactNumber) {

            String response =
                    wardService.updateWardUsingPatch(
                            id,
                            newAvailableBeds,
                            newNurseInCharge,
                            newContactNumber);

            return response;
        }
    }


