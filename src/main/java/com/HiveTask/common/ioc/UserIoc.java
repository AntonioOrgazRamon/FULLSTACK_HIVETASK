package com.HiveTask.common.ioc;

import com.HiveTask.domain.entity.User;
import com.HiveTask.domain.services.UserService;
import com.HiveTask.domain.services.impl.UserServiceImpl;
import com.HiveTask.persistance.dao.UserDao;
import com.HiveTask.persistance.dao.impl.UserDaoImpl;
import com.HiveTask.persistance.repository.UserRepository;
import com.HiveTask.persistance.repository.impl.UserRepositoryImpl;
import org.springframework.stereotype.Service;

@Service

public class UserIoc  {

    private static UserService userService;
    private static UserRepository userRepository;
    private static UserDao userDao;

    public static UserService createService() {
        if (userService == null) {
            UserRepository userRepository = createRepository();
            userService = new UserServiceImpl(userRepository);

        }
        return  userService;
    }


    public static UserRepository createRepository() {
        if (userRepository == null) {
            UserDao userDao = createDao();
            userRepository = new UserRepositoryImpl(userDao);
        }
        return  userRepository;
    }

    public static UserDao createDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }

        return  userDao;
    }



}
