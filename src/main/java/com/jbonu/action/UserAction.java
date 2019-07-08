package com.jbonu.action;

import com.jbonu.form.UserForm;
import com.jbonu.model.User;
import com.jbonu.service.ServiceFacade;
import no.hackeriet.struts1Spring.struts.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private List<UserForm> users;

    @Autowired
    private ServiceFacade userService;

    public UserAction() {
        System.out.println("---User Action---");
    }

    @SuppressWarnings("unchecked")
    public String execute() throws Exception {
        List<User> lusers = (List<User>) userService.doService("get");
        for (User luser:lusers) {
            users.add(new UserForm(luser.getId(), luser.getFirstName(), luser.getLastName(), luser.getAge(),luser.getGender()));
        }
        return "SUCCESS";
    }

    public List<UserForm> getUsers(){
        return users;
    }
}