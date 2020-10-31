package com.example.websocket.controllers;

import com.example.websocket.EmailService;
import com.example.websocket.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.mail.MessagingException;
import javax.validation.Valid;

@Controller
@RequestMapping("email")
public class EmailController {


    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Email Dashboard");

        return "email";
    }

    @PostMapping
    public String processEmailSend(@ModelAttribute @Valid User user, Errors errors, Model model) throws MessagingException {

        if(errors.hasErrors()){
            System.out.println("Email not sent");
            model.addAttribute("status", "email not sent!");
            return "email";
        } else{
            emailService.sendMail(user);
            model.addAttribute("status", "success!");
            model.addAttribute("title", "Email Dashboard");
            System.out.println("Email sent!");
            return "email";
        }





    }

}
