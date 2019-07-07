package com.jbonu.action;

import com.jbonu.model.User;
import com.jbonu.service.ServiceFacade;
import no.hackeriet.struts1Spring.struts.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private List<User> users;

    @Autowired
    private ServiceFacade userService;

    @SuppressWarnings("unchecked")
    public String execute() throws Exception {
        users = (List<User>) userService.doService("get");
        return "SUCCESS";
    }

    public List<User> getUsers(){
        return users;
    }
}