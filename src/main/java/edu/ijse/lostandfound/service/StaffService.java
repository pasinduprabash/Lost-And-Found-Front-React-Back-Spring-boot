package edu.ijse.lostandfound.service;

import edu.ijse.lostandfound.dto.StaffDto;

import java.util.ArrayList;

public interface StaffService {

    void saveStaff(StaffDto staffDto) throws Exception;
    void updateStaff(String id, StaffDto newDto) throws Exception;
    void deleteStaff(String id) throws Exception;
    StaffDto searchStaff(String id) throws Exception;
    ArrayList <StaffDto> getAllStaff() throws Exception;

}
