package com.unsuccessful.us.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unsuccessful.us.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{


}
