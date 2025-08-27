package edu.ijse.lostandfound.service;

import edu.ijse.lostandfound.dto.UserDto;
import java.util.ArrayList;

public interface UserService {

    void saveUser(UserDto userDto) throws Exception;
    void updateUser(String id, UserDto userDto) throws Exception;
    void deleteUser(String id) throws Exception;
    UserDto selectUser(String id) throws Exception;
    ArrayList <UserDto> getAllUsers() throws Exception;

}
