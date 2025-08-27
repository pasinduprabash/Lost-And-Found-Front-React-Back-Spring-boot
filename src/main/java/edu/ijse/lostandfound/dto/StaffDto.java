package edu.ijse.lostandfound.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StaffDto {

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private int contactNo;
    private String password;

}
