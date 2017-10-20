package cn.itcast.mapper2;

import java.util.List;

import cn.itcast.pojo.User;

public interface UserDao3 {

	public User selectById(Integer id) throws Exception;
	
	public List<User> selectByName(String name) throws Exception;
}
