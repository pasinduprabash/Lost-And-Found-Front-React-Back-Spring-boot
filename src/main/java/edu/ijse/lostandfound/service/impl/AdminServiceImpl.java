package edu.ijse.lostandfound.service.impl;

import edu.ijse.lostandfound.dao.AdminDao;
import edu.ijse.lostandfound.dto.AdminDto;
import edu.ijse.lostandfound.entity.AdminEntity;
import edu.ijse.lostandfound.service.AdminService;

import java.util.ArrayList;
import java.util.Optional;

public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao;

    @Override
    public void saveAdmin(AdminDto adminDto) throws Exception {

        AdminEntity adminEntity = new AdminEntity(
          adminDto.getId(),
          adminDto.getFirstName(),
          adminDto.getLastName(),
          adminDto.getAddress(),
          adminDto.getEmail(),
          adminDto.getContactNo(),
          adminDto.getPassword()
        );

        adminDao.save(adminEntity);
    }

    @Override
    public void updateAdmin(String id, AdminDto newDto) throws Exception {

        Optional <AdminEntity> foundedAdmin = adminDao.findById(id);
        if(!foundedAdmin.isPresent()){
            throw new Exception("Admin not Found");
        }

        AdminEntity adminEntity = foundedAdmin.get();
        adminEntity.setFirstName(newDto.getFirstName());
        adminEntity.setLastName(newDto.getLastName());
        adminEntity.setAddress(newDto.getAddress());
        adminEntity.setEmail(newDto.getEmail());
        adminEntity.setContactNo(newDto.getContactNo());
        adminEntity.setPassword(newDto.getPassword());

        adminDao.save(adminEntity);

    }

    @Override
    public void deleteAdmin(String id) throws Exception {

        Optional <AdminEntity> foundedAdmin = adminDao.findById(id);
        if(!foundedAdmin.isPresent()){
            throw new Exception("Admin not Found");
        }

        adminDao.deleteById(id);

    }

    @Override
    public AdminDto searchAdmin(String id) throws Exception {

        Optional <AdminEntity> foundedAdmin = adminDao.findById(id);
        if(!foundedAdmin.isPresent()){
            throw new Exception("Admin not found");
        }

        AdminEntity adminEntity = foundedAdmin.get();
        AdminDto adminDto = new AdminDto(
                adminEntity.getId(),
                adminEntity.getFirstName(),
                adminEntity.getLastName(),
                adminEntity.getAddress(),
                adminEntity.getEmail(),
                adminEntity.getContactNo(),
                adminEntity.getPassword()
        );

        return adminDto;

    }

    @Override
    public ArrayList<AdminDto> getAllAdmins() throws Exception {
        return null;
    }
}
