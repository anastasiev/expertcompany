package com.expert.service;

import com.expert.dto.Person;

import java.util.HashMap;

/**
 * Created by Shylov Denis on 16.03.2016.
 */
public class LoginService {

    HashMap<String, String> users = new HashMap();

    public LoginService() {
        users.put("user1", "logging as User 1");
        users.put("user2", "logging as User 2");
        users.put("user3", "logging as User 3");

    }

    public boolean authenticate(String userId, String password) {
        if (password == null || password.trim() == "") {
            return false;
        }

        return true;

    }

    public Person getUserDetails(String userId) {
        Person person = new Person();
        person.setUserName(users.get(userId));
        person.setUserId(userId);
        return person;

    }
}