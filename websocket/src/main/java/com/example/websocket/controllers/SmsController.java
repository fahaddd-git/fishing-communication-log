package com.example.websocket.controllers;


import com.example.websocket.models.SendTextMessage;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class SmsController {

    @Value("${phoneNumber}")
    private String phoneNumber;

    @Value("${ACCOUNT_SID}")
    public String ACCOUNT_SID;

    @Value("${AUTH_TOKEN}")
    public String AUTH_TOKEN;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("userNumber", phoneNumber);
        model.addAttribute("message", new SendTextMessage());
        return "index";
    }


    @PostMapping
    public String processForm(@ModelAttribute SendTextMessage SendTextMessage){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber(SendTextMessage.getDestinationPhoneNumber()),
                new PhoneNumber(phoneNumber),
                SendTextMessage.getMessageText()).create();

        System.out.println("Sent message w/ sid: " +message.getSid());
        return "redirect:";
    }
}
