package cn.itcast.dao;

import java.util.List;

import cn.itcast.pojo.User;

public interface UserDao {

	public User selectById() throws Exception;
	
	public List<User> selectByName() throws Exception;
}
