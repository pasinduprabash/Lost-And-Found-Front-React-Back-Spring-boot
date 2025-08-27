package edu.ijse.lostandfound.dao;

import edu.ijse.lostandfound.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository <UserEntity,String> {
}
