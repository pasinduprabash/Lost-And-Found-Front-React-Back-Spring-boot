package edu.ijse.lostandfound.entity;

import edu.ijse.lostandfound.Enum.RequestTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "request")
public class RequestEntity {

    @Id
    private int id;
    @Enumerated(EnumType.STRING)
    private RequestTypes requestTypes;


}
