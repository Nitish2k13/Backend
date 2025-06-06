package com.example.BackendLogin.controller;

import com.example.BackendLogin.dto.EmailEventRequest;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Adjust if your frontend runs elsewhere
public class EmailController {

    private final JavaMailSender mailSender;

    public EmailController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody EmailEventRequest emailRequest) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("smallutuber07@gmail.com");

            // ✅ Support multiple recipients
            String[] recipients = emailRequest.getToEmail().split(",");
            for (int i = 0; i < recipients.length; i++) {
                recipients[i] = recipients[i].trim(); // Remove spaces
            }

            message.setTo(recipients);
            message.setSubject("Event Details");
            message.setText("Event: " + emailRequest.getName() + "\n" +
                    "Description: " + emailRequest.getDescription() + "\n" +
                    "Start: " + emailRequest.getStartDate() + " " + emailRequest.getStartTime() + "\n" +
                    "End: " + emailRequest.getEndDate() + " " + emailRequest.getEndTime());

            mailSender.send(message);
            return "Email sent successfully";
        } catch (MailException e) {
            return "Failed to send email: " + e.getMessage();
        }
    }
}
