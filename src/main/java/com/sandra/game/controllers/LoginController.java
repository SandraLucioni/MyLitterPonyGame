package com.sandra.game.controllers;

import com.sandra.game.entities.User;
import com.sandra.game.services.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final UserLoginService userLoginService;

    public LoginController(UserLoginService userLoginService){
        this.userLoginService = userLoginService;
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("mensaje", "Bienvenides");
        return "login";
    }

    @PostMapping("/registro")
    public String singUp(@RequestParam String img,
                         @RequestParam String name,
                         @RequestParam String email,
                         @RequestParam String password){
        if (img== null && email==null){
            User user = new User(img, name, email, password);
            userLoginService.update(user);
        }else{

        }
        return "login";
    }

    @PostMapping("/postlogin")
    public String enterAccount(HttpServletRequest request,
                               @RequestParam String name,
                               @RequestParam String password,
                               @RequestParam String button) {

        HttpSession session = request.getSession(); //inicia sesion

        User user = userLoginService.searchLoginUser(name, password);
        if (user != null){
            session.setAttribute("user", user.getId());
            return "redirect:/menu";
        }

        return "login";
    }
}
