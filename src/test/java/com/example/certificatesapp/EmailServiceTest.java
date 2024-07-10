package com.example.certificatesapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.*;

public class EmailServiceTest {

    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private EmailService emailService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("test@example.com");
        message.setSubject("Test Subject");
        message.setText("Test Body");

        doNothing().when(javaMailSender).send(message);

        emailService.sendEmail(message);

        verify(javaMailSender, times(1)).send(message);
    }

    @Test
    public void testSendSimpleMessage() {
        String to = "test@example.com";
        String subject = "Test Subject";
        String text = "Test Body";

        doNothing().when(javaMailSender).send(any(SimpleMailMessage.class));

        emailService.sendSimpleMessage(to, subject, text);

        verify(javaMailSender, times(1)).send(any(SimpleMailMessage.class));
    }
}
