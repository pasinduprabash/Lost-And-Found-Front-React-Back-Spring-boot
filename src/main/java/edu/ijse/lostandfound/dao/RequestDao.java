package edu.ijse.lostandfound.dao;

import edu.ijse.lostandfound.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestDao extends JpaRepository<RequestEntity,String> {
}
