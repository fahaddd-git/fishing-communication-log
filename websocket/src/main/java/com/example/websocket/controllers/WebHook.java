package com.example.websocket.controllers;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@RestController
public class WebHook extends HttpServlet {

    @GetMapping(path="/call", produces="application/xml")
    public void respondToTwilioRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String body = request.getParameter("Body");
        String message = "Message";
        if (body.equals("1")) {
           message = "Response Confirmed. See you tomorrow!";
        } else if (body.equals("2")) {

            message = "Reservation Cancelled. We look forward to seeing you next time!";
        } else{
            message="Please contact us at (xxx)xxx-xxxx or respond with either 1 or 2";
        }

        Body twimlbody = new Body
                .Builder(message)
                .build();

        Message sms = new Message
                .Builder()
                .body(twimlbody)
                .build();

        MessagingResponse twiml = new MessagingResponse
                .Builder()
                .message(sms)
                .build();

        response.setContentType("application/xml");

        try {
            response.getWriter().print(twiml.toXml());
        } catch (TwiMLException e) {
            e.printStackTrace();
        }
    }


}
