package mul.com.tc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.com.tc.dao.UserDao;
import mul.com.tc.dto.UserDto;
import mul.com.tc.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao dao;
	
	@Override
	public boolean emailCheck(String email) {
		return dao.emailCheck(email);
	}

	@Override
	public boolean nickCheck(String nickname) {
		return dao.nickCheck(nickname);
	}

	@Override
	public boolean addUser(UserDto user) {
		return dao.addUser(user);
	}

	@Override
	public UserDto login(UserDto user) {
		return dao.login(user);
	}

	
}
