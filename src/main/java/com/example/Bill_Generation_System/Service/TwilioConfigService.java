package com.example.Bill_Generation_System.Service;

import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwilioConfigService {

    @Value("${twilio.account_sid}")
    private String accountSid;

    @Value("${twilio.auth_token}")
    private String authToken;

    @Value("${twilio.sms_from}")
    private String smsFrom;

    @Value("${twilio.whatsapp_from}")
    private String whatsappFrom;

    @PostConstruct
    public void initTwilio() {
        Twilio.init(accountSid, authToken);
    }

    public String getAccountSid() {
        return accountSid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public String getSmsFrom() {
        return smsFrom;
    }

    public String getWhatsappFrom() {
        return whatsappFrom;
    }
}
