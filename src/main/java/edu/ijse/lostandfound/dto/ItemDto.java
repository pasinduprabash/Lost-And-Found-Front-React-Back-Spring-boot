package edu.ijse.lostandfound.dto;

import edu.ijse.lostandfound.Enum.ItemTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDto {

        private int id;
        private String name;
        private String description;
        private ItemTypes itemTypes;

}
