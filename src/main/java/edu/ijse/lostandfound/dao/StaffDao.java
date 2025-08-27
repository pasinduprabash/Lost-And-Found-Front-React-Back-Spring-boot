package edu.ijse.lostandfound.dao;

import edu.ijse.lostandfound.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffDao extends JpaRepository <StaffEntity,String> {
}
