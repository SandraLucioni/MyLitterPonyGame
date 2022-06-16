package com.sandra.game.controllers;

import com.sandra.game.entities.User;
import com.sandra.game.services.MenuService;
import com.sandra.game.services.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/menu")
public class MenuController {
    private MenuService menuService;
    private UserLoginService userService;

    public MenuController(MenuService menuService, UserLoginService userService) {
        this.menuService = menuService;
        this.userService = userService;
    }

    public String showMyBestScore(Model model, HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(); //recoger sesion

            String userSession = session.getAttribute("user").toString();

            Optional<User> optionalUser = userService.searchUser(userSession);

            if (!optionalUser.isPresent()) {
                System.out.println("User not found");
                return "configuration";
            }

            User user = optionalUser.get();

            setFormView(model, user);

        } catch (Exception e) {
            System.out.println(e + " null");
        }
        return "configuration";
    }

    private void setFormView(Model model, User user) {
        model.addAttribute("name", user.getName());
        model.addAttribute("name", user.getEmail());
        model.addAttribute("name", user.getPassword());
        model.addAttribute("name", user.getPhotoProfile());
    }

    @PostMapping("/actualizado")
    public String updateProfileInformation(Model model, @RequestParam String name,
                                           @RequestParam String email,
                                           @RequestParam String password,
                                           HttpServletRequest request) {

        try {
            HttpSession session = request.getSession(); //recoger sesion

            String userSession = session.getAttribute("freelancer").toString();

            Optional<User> optionalUser = userService.searchUser(userSession);

            // si user es null
            if (!optionalUser.isPresent()) {
                System.out.println("User not found");
                return "configuration";
            }

            User user = optionalUser.get();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            User updatedUser = userService.update(user);

            setFormView(model, updatedUser);

        } catch (Exception e) {
            System.out.println(e + " null");
        }
        return "configuration";
    }



}
