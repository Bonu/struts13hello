package com.jbonu.dao;

import java.util.ArrayList;
import java.util.List;

import com.jbonu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public interface UserDAO {
    public List<User> getUsers();
    public void insertBatch();
}