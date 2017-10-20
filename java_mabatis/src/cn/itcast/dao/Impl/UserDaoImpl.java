package cn.itcast.dao.Impl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.dao.UserDao;
import cn.itcast.pojo.User;

public class UserDaoImpl implements UserDao {

	/**
	 * 根据id查询对象
	 * @throws Exception
	 */
	public User selectById() throws Exception{
		
		//读取配置文件
		InputStream inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
		//根据主配置文件创建会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//根据会话工厂创建会话连接
		SqlSession sqlSession = sessionFactory.openSession();
		//查询单条数据
		User user = sqlSession.selectOne("user.selectById", 1001);
		sqlSession.close();
		return user;
	}
	/**
	 * 根据name查询对象
	 * @throws Exception
	 */
	
	public List<User> selectByName() throws Exception{
		
		//读取配置文件
		InputStream inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
		//根据主配置文件创建会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//根据会话工厂创建会话连接
		SqlSession sqlSession = sessionFactory.openSession();
		//查询多条数据
		List<User> userList = sqlSession.selectList("user.selectByName", "王");
		sqlSession.close();
		
		return userList;
	}

}
