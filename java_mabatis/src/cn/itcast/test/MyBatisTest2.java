package cn.itcast.test;




import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.dao.UserDao2;
import cn.itcast.dao.Impl.UserDaoImpl;
import cn.itcast.pojo.User;



public class MyBatisTest2 {
	
	@Test
	public void test1() throws Exception{
		UserDaoImpl userDao2 = new UserDaoImpl();
		User user = userDao2.selectById();
		List<User> userList = userDao2.selectByName();
		System.out.println(user);
		System.out.println(userList);
	}
	@Test
	public void test2() throws Exception{
		// 读入核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
		
		// 加载核心配置文件并构建出会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		// 由会话工厂创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserDao2 userDao2 = sqlSession.getMapper(UserDao2.class);
		User user = userDao2.selectById(1001);
		List<User> userList = userDao2.selectByName("王");
		System.out.println(user);
		System.out.println(userList);
	}
	
}
