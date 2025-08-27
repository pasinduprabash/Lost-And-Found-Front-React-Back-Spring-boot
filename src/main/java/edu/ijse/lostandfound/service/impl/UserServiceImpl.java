package edu.ijse.lostandfound.service.impl;

import edu.ijse.lostandfound.dao.UserDao;
import edu.ijse.lostandfound.dto.UserDto;
import edu.ijse.lostandfound.entity.UserEntity;
import edu.ijse.lostandfound.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public void saveUser(UserDto userDto) throws Exception {

        UserEntity userEntity = new UserEntity(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getAddress(),
                userDto.getEmail(),
                userDto.getContactNo(),
                userDto.getPassword()
        );

        userDao.save(userEntity);
    }

    @Override
    public void updateUser(String id , UserDto newDto) throws Exception {
        Optional <UserEntity> foundUser = userDao.findById(id);
        if (!foundUser.isPresent()){
            throw new Exception("User not found");
        }

        UserEntity userEntity = foundUser.get();
        userEntity.setFirstName(newDto.getFirstName());
        userEntity.setLastName(newDto.getLastName());
        userEntity.setAddress(newDto.getAddress());
        userEntity.setEmail(newDto.getEmail());
        userEntity.setContactNo(newDto.getContactNo());
        userEntity.setPassword(newDto.getPassword());

        userDao.save(userEntity);

    }

    @Override
    public void deleteUser(String id) throws Exception {
        Optional <UserEntity> foundedUser = userDao.findById(id);
        if(!foundedUser.isPresent()){
            throw new Exception("User Not Found");
        }
        userDao.deleteById(id);
    }

    @Override
    public UserDto selectUser(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<UserDto> getAllUsers() throws Exception {
        return null;
    }
}
