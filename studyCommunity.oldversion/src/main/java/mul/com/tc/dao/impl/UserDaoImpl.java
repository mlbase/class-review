package mul.com.tc.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.com.tc.dao.UserDao;
import mul.com.tc.dto.UserDto;

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

	
}
