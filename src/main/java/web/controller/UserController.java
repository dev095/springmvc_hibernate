package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.usermanager.model.User;
import web.usermanager.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUsers());
        return "/WEB-INF/views/users.jsp";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUpdateUser(@ModelAttribute("user") User user) {
        this.userService.addUpdateUser(user);
        return "/WEB-INF/views/users.jsp";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id) {
        this.userService.removeUser(id);

        return "/WEB-INF/views/users.jsp";
    }

    @RequestMapping("edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", this.userService.getUserById(id));
        model.addAttribute("listBooks", this.userService.listUsers());

        return "/WEB-INF/views/users.jsp";
    }

    @RequestMapping("userdata/{id}")
    public String userData(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", this.userService.getUserById(id));

        return "/WEB-INF/views/userdata.jsp";
    }


}

