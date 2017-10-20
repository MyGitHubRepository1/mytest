package cn.itcast.test;


import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.pojo.User;

public class MyBatisTest1 {

	/**
	 * 检测Mybaits环境是否配置成功
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception{
		
		//读取配置文件
		InputStream inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
		//根据主配置文件创建会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//根据会话工厂创建会话连接
		SqlSession sqlSession = sessionFactory.openSession();
		sqlSession.close();
	}
	/**
	 * 根据id查询对象
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception{
		
		//读取配置文件
		InputStream inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
		//根据主配置文件创建会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//根据会话工厂创建会话连接
		SqlSession sqlSession = sessionFactory.openSession();
		//查询单条数据
		User user = sqlSession.selectOne("user.selectById", 1001);
		System.out.println(user);
		sqlSession.close();
	}
	/**
	 * 根据name查询对象
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception{
		
		//读取配置文件
		InputStream inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
		//根据主配置文件创建会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//根据会话工厂创建会话连接
		SqlSession sqlSession = sessionFactory.openSession();
		//查询多条数据
		List<User> user = sqlSession.selectList("user.selectByName", "王");
		System.out.println(user);
		sqlSession.close();
	}
	/**
	 * 插入对象
	 * @throws Exception
	 */
	@Test
	public void test4() throws Exception{
		
		//读取配置文件
		InputStream inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
		//根据主配置文件创建会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//根据会话工厂创建会话连接
		SqlSession sqlSession = sessionFactory.openSession();
		User user = new User();
		user.setAddress("北京");
		user.setAge(13);
		user.setMobile("15754901667");
		user.setName("小三");
		user.setSex("男");
		System.out.println(user.getUserId());
		sqlSession.insert("user.insertInto", user);
		sqlSession.commit();
		System.out.println(user.getUserId());
		sqlSession.close();
	}
	/**
	 * 更改对象
	 * @throws Exception
	 */
	@Test
	public void test5() throws Exception{
		
		//读取配置文件
		InputStream inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
		//根据主配置文件创建会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//根据会话工厂创建会话连接
		SqlSession sqlSession = sessionFactory.openSession();
		User user = new User();
		user.setName("小红");
		user.setUserId(1013);
		sqlSession.update("user.updateUserById", user);
		sqlSession.commit();
		sqlSession.close();
	}
	/**
	 * 更改对象
	 * @throws Exception
	 */
	@Test
	public void test6() throws Exception{
		
		//读取配置文件
		InputStream inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
		//根据主配置文件创建会话工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//根据会话工厂创建会话连接
		SqlSession sqlSession = sessionFactory.openSession();
		User user = new User();
		user.setUserId(1011);
		sqlSession.delete("user.deleteUserById", user);
		sqlSession.commit();
		sqlSession.close();
	}
}
