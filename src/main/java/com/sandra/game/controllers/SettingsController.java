package com.sandra.game.controllers;

import com.sandra.game.entities.HistoryText;
import com.sandra.game.entities.User;
import com.sandra.game.services.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class SettingsController {
    private UserLoginService userService;

    public SettingsController(UserLoginService userService) {
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
            HistoryText historyText = new HistoryText();

            setFormView(model, user, historyText);

        } catch (Exception e) {
            System.out.println(e + " null");
        }
        return "configuration";
    }

    private void setFormView(Model model, User user, HistoryText historyText) {
        model.addAttribute("name", user.getName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("photoProfile", user.getPhotoProfile());
        model.addAttribute("question", historyText.getQuestion());
        model.addAttribute("answerOne", historyText.getAnswerOne());
        model.addAttribute("answerTwo", historyText.getAnswerTwo());
        model.addAttribute("answerThree", historyText.getAnswerThree());
    }

    @PostMapping("/actualizado")
    public String updateProfileInformation(Model model, @RequestParam String name,
                                           @RequestParam String email,
                                           @RequestParam String password,
                                           @RequestParam String question,
                                           @RequestParam String answerOne,
                                           @RequestParam String answerTwo,
                                           @RequestParam String answerThree,
                                           HttpServletRequest request) {

        try {
            HttpSession session = request.getSession(); //recoger sesion

            String userSession = session.getAttribute("freelancer").toString();

            Optional<User> optionalUser = userService.searchUser(userSession);

            if (!optionalUser.isPresent()) {
                System.out.println("User not found");
                return "redirect:/login";
            }

            User user = optionalUser.get();
            HistoryText historyText = new HistoryText();
            historyText.setQuestion(question);
            historyText.setAnswerOne(answerOne);
            historyText.setAnswerTwo(answerTwo);
            historyText.setAnswerThree(answerThree);
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            User updatedUser = userService.update(user);

            setFormView(model, updatedUser, historyText);

        } catch (Exception e) {
            System.out.println(e + " null");
        }
        return "configuration";
    }

}
