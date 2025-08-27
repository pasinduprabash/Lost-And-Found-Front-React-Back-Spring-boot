package edu.ijse.lostandfound.dao;

import edu.ijse.lostandfound.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<AdminEntity,String> {
}
