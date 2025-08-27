package edu.ijse.lostandfound.dto;

import edu.ijse.lostandfound.Enum.RequestTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestDto {

    private int id;
    private RequestTypes requestTypes;

}
