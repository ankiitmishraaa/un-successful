package com.unsuccessful.us.controller;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unsuccessful.us.entity.UsersPost;
import com.unsuccessful.us.service.UsersPostService;

@RestController
@RequestMapping("/home/userspost")
public class UsersPostController {
	
	private static final int OK = org.apache.http.HttpStatus.SC_OK;

	private static final int SERVICE_UNAVILABLE = org.apache.http.HttpStatus.SC_SERVICE_UNAVAILABLE;

	private static final int NOT_FOUND = org.apache.http.HttpStatus.SC_NOT_FOUND;

	private static final int INTERNAL_SERVER = org.apache.http.HttpStatus.SC_INTERNAL_SERVER_ERROR;

	private static final int BAD_REQUEST = org.apache.http.HttpStatus.SC_BAD_REQUEST;

	private static final String SUCCESS_MESSAGE = "Success";
	
	@Autowired
	private UsersPostService usersPostService;
	
	@PostMapping("/createPost")
	public ResponseEntity<UsersPost> createPost(@RequestBody UsersPost userReq){
		prepareUsersPost(userReq);
		UsersPost usersPostResponse = usersPostService.createUsersPost(userReq);
		return new ResponseEntity<>(usersPostResponse, HttpStatus.OK);
	}

	private void prepareUsersPost(UsersPost userReq) {
		userReq.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
		userReq.setActive(true);
		userReq.setLikes(0);
	}

}
