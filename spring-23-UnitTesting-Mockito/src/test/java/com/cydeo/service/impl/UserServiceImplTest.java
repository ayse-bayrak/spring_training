package com.cydeo.service.impl;

import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    // we want to only findBuUserName method inside the UserServiceImpl, we don't want to test other dependent method
    //(userRepository.findByUserName... and userMapper.convertToDto inside impl class)

    // we create Mock for these dependent method
    // there is some injection in class which we want to test method inside it
    //private final UserRepository userRepository; we have to mock this, because we don't connect database and we want to only test service layer for example in here.
    @Mock
    UserRepository userRepository;

    @Mock
    UserMapper userMapper;

    // we use inject our mock object,

    @InjectMocks
    UserServiceImpl userService;
    //in testing we use class itself, we don't use interface
    // if want to do some testing userServiceImp
    // InjectMock is not working with class

    @Test
    void findByUserName_Test(){

        // I am calling the real method inside the main, which is the method I want to test
        userService.findByUserName("harold@manager.com");

        // I am checking if this method is ran or not.
        verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com", false);
        // this is the method that I am trying to Mock

        verify(userRepository, times(1)).findByUserNameAndIsDeleted("harold@manager.com", false);
        // if we put 2 times, we give failed. because only one call for this method

        verify(userRepository, atLeast(2)).findByUserNameAndIsDeleted("harold@manager.com", false);
        verify(userRepository, atLeastOnce()).findByUserNameAndIsDeleted("harold@manager.com", false);
        verify(userRepository, atMostOnce()).findByUserNameAndIsDeleted("harold@manager.com", false);
        verify(userRepository, atMost(10)).findByUserNameAndIsDeleted("harold@manager.com", false);

        InOrder inOrder = inOrder(userRepository, userMapper);
        inOrder.verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com", false);
        inOrder.verify(userMapper).convertToDto(null);



    }




}