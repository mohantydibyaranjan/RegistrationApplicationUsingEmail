package com.nt.service;

import com.nt.entity.User;

public interface UserService {
	//user registration/save the user record
	public boolean 	saveUser(User user);
	
	//it is used to given user id pwd correct or not
	public User getUser(String email,String pwd);
	

}
