package mul.com.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.com.sc.dao.UserDao;
import mul.com.sc.dto.UserDto;
import mul.com.sc.service.UserService;

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

	@Override
	public UserDto getUser(String id) {
		return dao.getUser(id);
	}

	@Override
	public boolean updateUser(UserDto user) {
		return dao.updateUser(user);
	}

	@Override
	public boolean deleteUser(String id) {
		return dao.deleteUser(id);
	}

	
}
