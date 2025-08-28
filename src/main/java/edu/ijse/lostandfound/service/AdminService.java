package edu.ijse.lostandfound.service;

import edu.ijse.lostandfound.dto.AdminDto;

import java.util.ArrayList;

public interface AdminService {

    void saveAdmin(AdminDto adminDto) throws Exception;
    void updateAdmin(String id, AdminDto newDto) throws Exception;
    void deleteAdmin(String id) throws Exception;
    AdminDto searchAdmin(String id) throws Exception;
    ArrayList <AdminDto> getAllAdmins() throws Exception;

}
