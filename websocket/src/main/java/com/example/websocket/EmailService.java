package com.example.websocket;

import com.example.websocket.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;


@Service
public class EmailService {

        private final TemplateEngine templateEngine;

        private final JavaMailSender javaMailSender;

        @Autowired
        public EmailService(TemplateEngine templateEngine, JavaMailSender javaMailSender) {
            this.templateEngine = templateEngine;
            this.javaMailSender = javaMailSender;
        }

        public String sendMail(User user) throws MessagingException {
            Context context = new Context();
            context.setVariable("user", user);

            String process = templateEngine.process("welcome", context);
            javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setSubject("Hello " + user.getName());
            helper.setText(process, true);
            helper.setTo(user.getEmail());
            ClassPathResource attachmentFile= new ClassPathResource("static/fishingWaiver.pdf");
            helper.addAttachment("test.pdf", attachmentFile);
            javaMailSender.send(mimeMessage);
            return "Sent";
        }
    }

