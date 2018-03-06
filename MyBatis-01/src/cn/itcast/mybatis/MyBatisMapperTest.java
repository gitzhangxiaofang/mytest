package cn.itcast.mybatis;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.io.Reader;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.UserDaoImpl;
import cn.itcast.mapper.UserMapper;
import cn.itcast.pojo.User;

/**
 * 
 * 
 * MaBatis入门程序开发
 * @author liuxin
 *
 */
public class MyBatisMapperTest {
	//全局变量
	private   SqlSessionFactory   sqlSessionFactory;
	
	//运行前执行
	@Before
	public  void before()  throws Exception{
		// TODO Auto-generated method stub
		String  resources ="SqlMapConfig.xml";
		//把文件转为字节流 
		InputStream config = Resources.getResourceAsStream(resources);
		//创建sqlsession工厂
		  sqlSessionFactory =new  SqlSessionFactoryBuilder().build(config);
		
	}
	
	
	//根据id查询一个用户
	@Test
	public  void  testFindUserById() throws Exception{

              //用接口开发   只写接口
		SqlSession session = sqlSessionFactory.openSession();
		
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.findUserById(24);
		System.out.println(user);
		
		
		
		
	}
	
	//根据用户名模糊查询用户列表
	
	

}
