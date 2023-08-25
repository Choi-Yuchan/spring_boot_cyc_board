package edu.global.ex.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.global.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

//	@Test
//	void testInsertUser() {
//	      UserVO user = new UserVO();
//	      user.setUsername("user2");
//	      user.setPassword(new BCryptPasswordEncoder().encode("user2"));
//	      user.setEnabled(1);
//	      
//	      userMapper.insertUser(user);
//	      userMapper.insertAuthorities(user); 
//	}
	
	@Test
	void testGetList() {
		UserVO user = userMapper.getUser("admin");
		System.out.println(user);
	}
	
	// 암호 체크 방법
	@Test
	void testMatchUser() {
		UserVO user = new UserVO();
		user.setUsername("user2");
		user.setPassword(passwordEncoder.encode("user2"));
		user.setEnabled(1);

		System.out.println(user);
		
		boolean bool = passwordEncoder.matches("user2", user.getPassword());

		System.out.println(bool);
	}
}
