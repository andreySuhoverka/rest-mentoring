package com.sukhoverka.dao;

import com.sukhoverka.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDao {

    private Map<Integer, User> users = new HashMap<Integer, User>();
    private int idGenerator = 0;

    public List<User> getUsers(){
        return new ArrayList<User>(users.values());
    }

    public void createUser(User user){
        user.setId(idGenerator++);
        users.put(user.getId(), user);
    }

    public void updateUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(Integer id) {
        return users.get(id);
    }

    public void deleteUser(Integer id) {
        users.remove(id);
    }
}
