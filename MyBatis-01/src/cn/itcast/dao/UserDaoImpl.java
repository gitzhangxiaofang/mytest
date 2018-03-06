package cn.itcast.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.pojo.User;

public class UserDaoImpl implements  UserDao{
	
	private   SqlSessionFactory   sqlSessionFactory;

	
	 
    public  UserDaoImpl(SqlSessionFactory   sqlSessionFactory){
    	super();
    	this.sqlSessionFactory=sqlSessionFactory;
    	
    	
    }





	// 根据id传一个用户
	public  User findUserById(Integer id){
		
		//操作mysql数据库   pojo就是javabean 
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectOne("test.findUserById",24);
		
		
		
	}

}
