package com.ty.visitor.Controller;

import com.ty.visitor.dao.UserDao;
import com.ty.visitot.dto.User;

public class TestUserIsert {
	public static void main(String[] args) {

//		User user = new User();
//		user.setId(1);
//		user.setName("suvas");
//		user.setEmail("suvas@gmail.com");
//		user.setPhone("556622884");
//		user.setPassword("suvas@5v");
//		user.setRole("founder");

		UserDao userDao = new UserDao();
		//userDao.saveUser(user);
//		if(user!=null) {
//			System.out.println("user inserted");
//		}
//		else {
//			System.out.println("not inserted");
//		}
		userDao.validateUser("suvas@gmail.com","suvas@5v");

	}

}
