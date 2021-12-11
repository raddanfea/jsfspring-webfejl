package com.jsfspring.curddemo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsfspring.curddemo.entity.UserDTO;

@Repository
public interface UserRepo extends JpaRepository<UserDTO, Long> {
}