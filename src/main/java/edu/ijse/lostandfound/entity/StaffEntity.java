package edu.ijse.lostandfound.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "staff")
public class StaffEntity implements Serializable {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private int contactNo;
    private String password;

}
