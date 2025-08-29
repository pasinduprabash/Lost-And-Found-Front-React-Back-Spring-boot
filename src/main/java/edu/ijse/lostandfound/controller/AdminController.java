package edu.ijse.lostandfound.controller;

import edu.ijse.lostandfound.dto.AdminDto;
import edu.ijse.lostandfound.service.AdminService;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "admin")
@NoArgsConstructor
public class AdminController {

    private AdminService adminService;

    @PostMapping
    public ResponseEntity <Void> saveAdmin(@RequestBody AdminDto adminDto) {
        try {
            adminService.saveAdmin(adminDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping (value = {"/id"})
    public ResponseEntity <Void> updateAdmin(@PathVariable String id, @RequestBody AdminDto newDto){
        try {
            adminService.updateAdmin(id,newDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping (value = {"/id"})
    public ResponseEntity <Void> deleteAdmin(@PathVariable String id){
        try {
            adminService.deleteAdmin(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (value = {"/id"})
    public ResponseEntity <AdminDto> searchAdmin(@PathVariable String id){

        try {
            AdminDto adminDto = adminService.searchAdmin(id);

            if(adminDto == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
                return new ResponseEntity<>(adminDto , HttpStatus.OK);

        } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
