package com.hmsystem.test;

import com.hmsystem.RequestHttpMain;
import com.hmsystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * TEST CLASS
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RequestHttpMain.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public  void testAddUser(){
        userService.addUser();
    }
}
