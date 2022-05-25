package com.example.newspringboot.Service;



import com.example.newspringboot.model.User;

import java.util.List;

public interface UserServiceInt {
    public void save(User user);
    public void updateUser(User user, int id);
    public void deleteUser(int id);

    public User findUser(int id);
    public List<User> allUsers();
}
