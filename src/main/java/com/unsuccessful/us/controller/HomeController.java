package com.unsuccessful.us.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unsuccessful.us.entity.User;
import com.unsuccessful.us.service.UserService;
import com.unsuccessful.us.util.Validation;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	private static final int OK = org.apache.http.HttpStatus.SC_OK;

	private static final int SERVICE_UNAVILABLE = org.apache.http.HttpStatus.SC_SERVICE_UNAVAILABLE;

	private static final int NOT_FOUND = org.apache.http.HttpStatus.SC_NOT_FOUND;

	private static final int INTERNAL_SERVER = org.apache.http.HttpStatus.SC_INTERNAL_SERVER_ERROR;

	private static final int BAD_REQUEST = org.apache.http.HttpStatus.SC_BAD_REQUEST;

	private static final String SUCCESS_MESSAGE = "Success";
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Ping", notes = "Ping")
	@GetMapping("/ping")
	@ApiResponses(value = { @ApiResponse(code = OK, message = SUCCESS_MESSAGE, response = String.class),
			@ApiResponse(code = NOT_FOUND, message = "Unauthorized"),
			@ApiResponse(code = SERVICE_UNAVILABLE, message = "Service Unavailable"),
			@ApiResponse(code = INTERNAL_SERVER, message = "Internal Server") })
	public ResponseEntity<String> ping() {
		log.info("this is health ping API");
		return new ResponseEntity<>("Ok", HttpStatus.OK);
	}

	@ApiOperation(value = "registerUser", notes = "Add or create user in the system")
	@PostMapping("/registerUser")
	@ResponseBody
	@ApiResponses(value = { @ApiResponse(code = OK, message = "Success", response = String.class),
			@ApiResponse(code = NOT_FOUND, message = "Not Found"),
			@ApiResponse(code = SERVICE_UNAVILABLE, message = "Service Unavailable"),
			@ApiResponse(code = INTERNAL_SERVER, message = "Internal Server"),
			@ApiResponse(code = BAD_REQUEST, message = "Bad Request") })
	public ResponseEntity<User> addUser(@RequestBody User userRequest) {
		Validation.validatRequest(userRequest);
		return new ResponseEntity<User>(userService.addUser(userRequest), HttpStatus.OK);
	}
	
	@ApiOperation(value = "users", notes = "Find all users from the system")
	@GetMapping("/users")
	@ApiResponses(value = { @ApiResponse(code = OK, message = "Success", response = String.class),
			@ApiResponse(code = NOT_FOUND, message = "Not Found"),
			@ApiResponse(code = SERVICE_UNAVILABLE, message = "Service Unavailable"),
			@ApiResponse(code = INTERNAL_SERVER, message = "Internal Server"),
			@ApiResponse(code = BAD_REQUEST, message = "Bad Request") })
	public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
	
	@ApiOperation(value = "Users by Id", notes = "Find a user from the system by Id")
	@GetMapping("/users/{id}")
	@ApiResponses(value = { @ApiResponse(code = OK, message = "Success", response = String.class),
			@ApiResponse(code = NOT_FOUND, message = "Not Found"),
			@ApiResponse(code = SERVICE_UNAVILABLE, message = "Service Unavailable"),
			@ApiResponse(code = INTERNAL_SERVER, message = "Internal Server"),
			@ApiResponse(code = BAD_REQUEST, message = "Bad Request") })
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User userResponse = userService.getUserById(id);
		if(null == userResponse) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(userResponse, HttpStatus.OK);
		}
    }
}
