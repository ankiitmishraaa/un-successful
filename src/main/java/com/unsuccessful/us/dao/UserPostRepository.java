package com.unsuccessful.us.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unsuccessful.us.entity.UsersPost;


@Repository
public interface UserPostRepository extends JpaRepository<UsersPost, Long>{

}
