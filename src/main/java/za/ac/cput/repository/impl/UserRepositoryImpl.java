package za.ac.cput.repository.impl;
// User UserRepositoryImpl  class
//Author: Bonga Velem (220052379)
//Date: 27 March 2025
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;

import java.util.HashMap;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private static UserRepositoryImpl repository = null;
    private HashMap<Integer, User> userDB;

    private UserRepositoryImpl() {
        this.userDB = new HashMap<>();
    }

    public static UserRepository getRepository() {
        if (repository == null) {
            repository = new UserRepositoryImpl();
        }
        return repository;
    }


    @Override
    public User create(User user) {
        if (user == null || userDB.containsKey(user.getUserId())) {
            return null;
        }
        userDB.put(user.getUserId(), user);
        return user;
    }


    @Override
    public User read(Integer userID) {
        return userDB.get(userID);
    }


    @Override
    public User update(User user) {
        if (userDB.containsKey(user.getUserId())) {
            userDB.put(user.getUserId(), user);
            return user;
        }
        return null;
    }


    @Override
    public void delete(Integer userId) {
       userDB.remove(userId);

    }






    @Override
    public List<User> getAll() {
        return List.of();
    }
}
