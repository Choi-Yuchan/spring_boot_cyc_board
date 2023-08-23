package edu.global.ex.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.global.ex.vo.UserVO;

@SpringBootTest
class UserMapperTest {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	void testInsertUser() {
	      UserVO user = new UserVO();
	      user.setUsername("user2");
	      user.setPassword(new BCryptPasswordEncoder().encode("user2"));
	      user.setEnabled(1);
	      
	      userMapper.insertUser(user);
	      userMapper.insertAuthorities(user); 
	}
	@Test
	void testGetList() {
		UserVO user = userMapper.getUser("admin");
		System.out.println(user);
	}
}
