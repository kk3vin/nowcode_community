package com.wenkai.nowcode_community;

import com.wenkai.nowcode_community.dao.DiscussPostMapper;
import com.wenkai.nowcode_community.dao.UserMapper;
import com.wenkai.nowcode_community.entity.DiscussPost;
import com.wenkai.nowcode_community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = NowcodeCommunityApplication.class)
class NowcodeCommunityApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testSelectUser(){
		User user = userMapper.selectById(101);
		System.out.println(user);

		user = userMapper.selectByName("liubei");
		System.out.println(user);

		user=userMapper.selectByEmail("nowcoder101@sina.com");
		System.out.println(user);
	}

	@Test
	public void testInsertUser(){
		User user = new User();
		user.setUsername("test");
		user.setPassword("123456");
		user.setSalt("abc");
		user.setEmail("test@qq.com");
		user.setHeaderUrl("http://www.nowcoder.com/101.png");
		user.setCreateTime(new Date());

		int rows = userMapper.insertUser(user);
		System.out.println(rows);
		System.out.println(user.getId());
	}

	@Test
	public void testUpdateUser(){
		int rows = userMapper.updateStatus(150, 1);
		System.out.println(rows);

		rows= userMapper.updateHeader(150, "http://www.nowcoder.com/102.png");
		System.out.println(rows);

		rows = userMapper.updatePassword(150, "hello");
		System.out.println(rows);
	}

	@Autowired
	private DiscussPostMapper discussPostMapper;
	@Test
	public void testSelectPost(){
		List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149, 0, 10);
		for(DiscussPost d:list){
			System.out.println(d);
		}

		int rows = discussPostMapper.selectDiscussPostRows(149);
		System.out.println(rows);
	}

//	@Test
//	void contextLoads() {
//	}


}
