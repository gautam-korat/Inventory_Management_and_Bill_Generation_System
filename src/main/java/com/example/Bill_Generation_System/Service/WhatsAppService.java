package com.example.Bill_Generation_System.Service;

import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WhatsAppService
{
    private final String whatsappFrom;

    @Autowired
    public WhatsAppService(TwilioConfigService twilioConfigService)
    {
        this.whatsappFrom = twilioConfigService.getWhatsappFrom();
    }

    public void sendWhatsAppMessage(String toPhoneNumber, String messageBody)
    {
        try
        {
            Message message = Message.creator(
                    new com.twilio.type.PhoneNumber("whatsapp:" + toPhoneNumber),
                    new com.twilio.type.PhoneNumber(whatsappFrom),
                    messageBody).create();

            System.out.println("WhatsApp Message sent successfully: " + message.getSid());
        }
        catch (Exception e)
        {
            System.err.println("Error sending WhatsApp message: " + e.getMessage());
        }
    }
}