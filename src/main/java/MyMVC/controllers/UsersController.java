package MyMVC.controllers;

import MyMVC.model.User;
import MyMVC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index (Model model){
        model.addAttribute("users", userService.listUsers());
        return "users/index";
    }

    @GetMapping ("/new")
    public String newUser (@ModelAttribute("user") User user){
        return "users/new";
    }

    @PostMapping()
    public String create (@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "users/show";
    }

    @GetMapping("/{id}/edit")
    public String edit (@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "users/edit";
    }

    @PatchMapping ("/{id}")
    public String update (@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping ("/{id}/remove")
    public String remove (@PathVariable("id") long id){
        userService.remove(id);
        return "redirect:/users";
    }
}
