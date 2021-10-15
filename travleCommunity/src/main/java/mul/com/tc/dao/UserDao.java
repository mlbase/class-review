package mul.com.tc.dao;

import mul.com.tc.dto.UserDto;

public interface UserDao {

	boolean emailCheck(String email);
	boolean nickCheck(String nickname);
	boolean addUser(UserDto user);
	UserDto login(UserDto user);
}
