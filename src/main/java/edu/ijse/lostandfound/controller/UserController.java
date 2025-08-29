package edu.ijse.lostandfound.controller;

import edu.ijse.lostandfound.dto.UserDto;
import edu.ijse.lostandfound.entity.UserEntity;
import edu.ijse.lostandfound.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value = "user")
@NoArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity <Void> saveUser(@RequestBody UserDto userDto) {
        try {
            userService.saveUser(userDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping (value = {"/id"})
    public ResponseEntity <Void> updateUser(@PathVariable String id, @RequestBody UserDto newDto){
        try {
            userService.updateUser(id,newDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping (value = {"/id"})
    public ResponseEntity <Void> deleteUser(@PathVariable String id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (value = {"/id"})
    public ResponseEntity <UserDto> searchItem(@PathVariable String id) {
        try {
            UserDto userDto = userService.selectUser(id);
            if(userDto == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
                return new ResponseEntity<>(userDto,HttpStatus.OK);
        } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
