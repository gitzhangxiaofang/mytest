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

import cn.itcast.pojo.User;

/**
 * 
 * 
 * MaBatis入门程序开发
 * @author liuxin
 *
 */
public class MyBatisTest {
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
		
	
		//操作mysql数据库   pojo就是javabean 
		SqlSession session = sqlSessionFactory.openSession();
		User user = session.selectOne("test.findUserById",24);
		
		System.out.println(user);
	}
    //模糊查询
	@Test
	public void testFindUserByUsername() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		
		//
		List<User> users = session.selectList("test.findUserByUsername", "明");
		for (User user : users) {
			System.out.println(user);
		}
		
	}
	
	//添加用户
	@Test
	public void testAddUser() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		
		User user =new  User();
		user.setUsername("用户1");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("中国");
		//返回为影响的行数
		session.insert("test.addUser",user);
	
		//需要手动提交
		session.commit();
		
	}
	
	//更新用户
	@Test
	public void testUpdateById() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		
		User user =new  User();
		user.setId(26);
		
		user.setUsername("用户2");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("中国");
		
		
		//返回为影响的行数
		session.update("test.updateById",user);
	
		//需要手动提交
		session.commit();
		
	}
	//删除
	@Test
	public void testDeleteUserById() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("test.deleteUserById",26);
		
		
		
		//需要手动提交
		session.commit();
		
	}
	
	
	
	
	
	
}
