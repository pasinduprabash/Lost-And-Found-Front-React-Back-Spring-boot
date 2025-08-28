package edu.ijse.lostandfound.service.impl;

import edu.ijse.lostandfound.dao.StaffDao;
import edu.ijse.lostandfound.dto.StaffDto;
import edu.ijse.lostandfound.entity.StaffEntity;
import edu.ijse.lostandfound.service.StaffService;

import java.util.ArrayList;
import java.util.Optional;

public class StaffServiceImpl implements StaffService {

    private StaffDao staffDao;

    @Override
    public void saveStaff(StaffDto staffDto) throws Exception {

        StaffEntity staffEntity = new StaffEntity(
                staffDto.getId(),
                staffDto.getFirstName(),
                staffDto.getLastName(),
                staffDto.getAddress(),
                staffDto.getEmail(),
                staffDto.getContactNo(),
                staffDto.getPassword()

        );

        staffDao.save(staffEntity);
    }

    @Override
    public void updateStaff(String id, StaffDto newDto) throws Exception {

        Optional <StaffEntity> foundedStaff = staffDao.findById(id);
        if(!foundedStaff.isPresent()){
            throw new Exception("Staff not Found");
        }

        StaffEntity staffEntity = foundedStaff.get();
        staffEntity.setFirstName(newDto.getFirstName());
        staffEntity.setLastName(newDto.getLastName());
        staffEntity.setAddress(newDto.getAddress());
        staffEntity.setContactNo(newDto.getContactNo());
        staffEntity.setEmail(newDto.getEmail());
        staffEntity.setPassword(newDto.getPassword());

        staffDao.save(staffEntity);
    }

    @Override
    public void deleteStaff(String id) throws Exception {

        Optional <StaffEntity> foundedStaff = staffDao.findById(id);
        if(!foundedStaff.isPresent()){
            throw new Exception("Staff not Found");
        }

        staffDao.deleteById(id);
    }

    @Override
    public StaffDto searchStaff(String id) throws Exception {

        Optional <StaffEntity> foundedStaff = staffDao.findById(id);
        if(!foundedStaff.isPresent()){
            throw new Exception("Staff Not Found");
        }

        StaffEntity staffEntity = foundedStaff.get();
        StaffDto staffDto = new StaffDto(
          staffEntity.getId(),
          staffEntity.getFirstName(),
          staffEntity.getLastName(),
          staffEntity.getAddress(),
          staffEntity.getEmail(),
          staffEntity.getContactNo(),
          staffEntity.getPassword()
        );

        return staffDto;

    }

    @Override
    public ArrayList<StaffDto> getAllStaff() throws Exception {
        return null;
    }
}
