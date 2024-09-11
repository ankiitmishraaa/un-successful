package com.unsuccessful.us.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unsuccessful.us.dao.UserRepository;
import com.unsuccessful.us.entity.User;
import com.unsuccessful.us.exception.InvalidRequestException;
import com.unsuccessful.us.exception.UnSuccessfulRestException;
import com.unsuccessful.us.model.UserResponse;
import com.unsuccessful.us.service.UserService;
import com.unsuccessful.us.util.Validation;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	public Object getUser(String id) {
		// fetch user details
		UserResponse response = new UserResponse();
		response.setFullName("John " + "Doe");
		response.setUserName("1");

		return response;
	}

	@Override
	public User addUser(User userReq) {
		try {
			return userRepo.save(prepareUser(userReq));
		} catch(InvalidRequestException exp) {
			throw new InvalidRequestException(exp.getMessage(), exp);
		} catch (Exception e) {
			throw new UnSuccessfulRestException(e.getMessage(), e);
		}
	}

	private User prepareUser(User userReq) {
		User user = new User();
		if(null != userReq.getSex()) {
			user.setSex(userReq.getSex());
		} else {
			throw new InvalidRequestException(userReq.getSex(), userReq);
		}
		if (null != userReq.getFirstName()) {
			user.setFirstName(userReq.getFirstName());
		} else {
			throw new InvalidRequestException(userReq.getFirstName(), userReq);
		}
		if (null != userReq.getLastName()) {
			user.setLastName(userReq.getLastName());
		} else {
			throw new InvalidRequestException(userReq.getLastName(), userReq);
		}
		if (Validation.isValidEmail(userReq.getEmail())) {
			user.setEmail(userReq.getEmail());
		} else {
			throw new InvalidRequestException(userReq.getEmail(), userReq);
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepo.findById(id).orElse(null);
	}

}
