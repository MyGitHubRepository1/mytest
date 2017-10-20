package cn.itcast.dao;

import java.util.List;

import cn.itcast.pojo.User;

public interface UserDao2 {

	public User selectById(Integer id) throws Exception;
	
	public List<User> selectByName(String name) throws Exception;
}
