package edu.ijse.lostandfound.controller;

import edu.ijse.lostandfound.dto.StaffDto;
import edu.ijse.lostandfound.service.StaffService;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value = "staff")
@NoArgsConstructor

public class StaffController {

    private StaffService staffService;

    @PostMapping
    public ResponseEntity <Void> saveStaff(@RequestBody StaffDto staffDto){
        try {
            staffService.saveStaff(staffDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping (value = {"/id"})
    public ResponseEntity <Void> updateStaff(@PathVariable String id, @RequestBody StaffDto newDto){
        try {
            staffService.updateStaff(id, newDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping (value = {"/id"})
    public ResponseEntity <Void> deleteStaff(@PathVariable String id){
        try {
            staffService.deleteStaff(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (value = {"/id"})
    public ResponseEntity <StaffDto> searchStaff(@PathVariable String id){
        try {
            StaffDto staffDto = staffService.searchStaff(id);
            if (staffDto == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
                return new ResponseEntity<>(staffDto, HttpStatus.OK);
        } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
