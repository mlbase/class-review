package mul.com.sc.service;

import mul.com.sc.dto.UserDto;

public interface UserService {

	boolean emailCheck(String email);
	boolean nickCheck(String nickname);
	boolean addUser(UserDto user);
	boolean updateUser(UserDto user);
	UserDto login(UserDto user);
	UserDto getUser(String id);
	public boolean deleteUser(String id);
}
