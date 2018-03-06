package cn.itcast.mapper;

import cn.itcast.pojo.User;

public  interface  UserMapper {
	
	//四大原则  
	// 接口的入参类型   要与mapper文件的入参类型一致
	//接口的返回值类和mapper文件的返回值类型一致
	//接口的方法名要与mapper的statmentid一致
	//接口类路径名（包名+类名）要与mapper的namespace要一致
	public  User findUserById(Integer id);

}
