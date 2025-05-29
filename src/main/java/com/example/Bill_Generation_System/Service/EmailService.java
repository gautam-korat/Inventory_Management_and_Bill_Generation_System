package com.example.Bill_Generation_System.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

import java.io.File;

@Service
public class EmailService
{
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmailTOAdminStockReportWithCSVFile(String toEmail, String subject, String body, String CSVFilePath)
    {
        try
        {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("abxyz1517@gmail.com");
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(body);

            File file = new File(CSVFilePath);
            helper.addAttachment(file.getName(), file);

            javaMailSender.send(message);
            System.out.println("Email sent successfully with CSVFile");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}