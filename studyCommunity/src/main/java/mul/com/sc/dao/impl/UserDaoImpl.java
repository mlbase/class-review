package mul.com.sc.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.com.sc.dao.UserDao;
import mul.com.sc.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	SqlSession session;
	
	String ns = "User.";

	@Override
	public boolean emailCheck(String email) {
		int n = session.selectOne(ns + "emailCheck", email);
		return n>0?true:false;
	}

	@Override
	public boolean nickCheck(String nickname) {
		int n = session.selectOne(ns + "nickCheck", nickname);
		return n>0?true:false;
	}

	@Override
	public boolean addUser(UserDto user) {
		int n = session.insert(ns + "addUser", user);
		return n>0?true:false;
	}

	@Override
	public UserDto login(UserDto user) {
		return session.selectOne(ns + "login", user);
	}

	@Override
	public UserDto getUser(String id) {
		return session.selectOne(ns + "getUser", id);
	}

	@Override
	public boolean updateUser(UserDto user) {
		int n = session.update(ns + "updateUser", user);
		return n>0?true:false;
	}

	@Override
	public boolean deleteUser(String id) {
		int n = session.delete(ns + "deleteUser", id);
		return n>0?true:false;
	}

	
}
