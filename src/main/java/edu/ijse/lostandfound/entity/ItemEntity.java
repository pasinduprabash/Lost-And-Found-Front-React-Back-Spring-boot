package edu.ijse.lostandfound.entity;

import edu.ijse.lostandfound.Enum.ItemTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "item")
public class ItemEntity {

    @Id
    private int id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private ItemTypes itemTypes;


}
