package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nt.emailUtil.EmailUtils;
import com.nt.entity.User;
import com.nt.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EmailUtils emailutil;

    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean saveUser(User user) {
        // Save user info and send email
        User savedUser = userRepo.save(user);
        if (savedUser.getId() != null) {
            String subject = "Your Account is Created Successfully";
            String body = "<h1>Congratulations</h1> " + savedUser.getName() + "!";
            emailutil.sendEmail(user.getEmail(), subject, body);
          
        }
        return true;
    }

    @Override
    public User getUser(String email, String pwd) {
        return userRepo.findByEmailAndPwd(email, pwd);
    }
}
