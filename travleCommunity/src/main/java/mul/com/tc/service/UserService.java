package mul.com.tc.service;

import mul.com.tc.dto.UserDto;

public interface UserService {

	boolean emailCheck(String email);
	boolean nickCheck(String nickname);
	boolean addUser(UserDto user);
	UserDto login(UserDto user);
}
