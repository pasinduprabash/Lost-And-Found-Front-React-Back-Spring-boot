package edu.ijse.lostandfound.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private int contactNo;
    private String password;
    
}
