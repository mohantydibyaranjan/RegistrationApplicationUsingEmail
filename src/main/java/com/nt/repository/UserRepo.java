package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	public  User findByEmailAndPwd(String email,String pwd);

}

