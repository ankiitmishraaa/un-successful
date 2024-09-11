package com.unsuccessful.us.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unsuccessful.us.dao.UserPostRepository;
import com.unsuccessful.us.entity.UsersPost;
import com.unsuccessful.us.service.UsersPostService;

@Service
public class UsersPostServiceImpl implements UsersPostService{
	
	@Autowired
	private UserPostRepository usersPostRepo;

	@Override
	public UsersPost createUsersPost(UsersPost userReq) {
		return usersPostRepo.save(userReq);
	}

}
