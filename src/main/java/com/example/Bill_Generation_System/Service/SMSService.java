package com.example.Bill_Generation_System.Service;

import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SMSService
{
    private final String smsFrom;
    @Autowired

    public SMSService(TwilioConfigService twilioConfigService)
    {
        this.smsFrom = twilioConfigService.getSmsFrom();
    }

    public void sendSms(String toPhoneNumber, String messageBody)
    {
        try
        {
            Message message = Message.creator(
                    new com.twilio.type.PhoneNumber(toPhoneNumber),
                    new com.twilio.type.PhoneNumber(smsFrom),
                    messageBody).create();

            System.out.println("SMS sent successfully: " + message.getSid());
        }
        catch (Exception e)
        {
            System.err.println("Error sending SMS: " + e.getMessage());
        }
    }
}
