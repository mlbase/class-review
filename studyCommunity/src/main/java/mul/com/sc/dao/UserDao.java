package mul.com.sc.dao;

import mul.com.sc.dto.UserDto;

public interface UserDao {

	boolean emailCheck(String email);
	boolean nickCheck(String nickname);
	boolean addUser(UserDto user);
	boolean updateUser(UserDto user);
	UserDto login(UserDto user);
	UserDto getUser(String id);
	boolean deleteUser(String id);
}
