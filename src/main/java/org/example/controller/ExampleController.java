package org.example.controller;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ExampleController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello";
    }

    @GetMapping("/users")
    public String users(ModelMap map) {
        List<User> users = userRepository.findAll();

//        for (User user : users) {
//            System.out.println(user.getName() + " " + user.getEmail());
//        }

        //map.addAttribute("user1", users.get(0));
        map.addAttribute("name", users.get(0).getName());
        map.addAttribute("email", users.get(0).getEmail());

        return "users";
    }
}
