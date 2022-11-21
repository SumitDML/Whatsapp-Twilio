package com.digimantra.twilio.whatsapp.project.WhatsappTwilioProject.service;

import com.digimantra.twilio.whatsapp.project.WhatsappTwilioProject.config.TwilioProperties;
import com.digimantra.twilio.whatsapp.project.WhatsappTwilioProject.dto.Smsrequest;
import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;



@Service
public class Smsservice {

    @Autowired
    private TwilioProperties twilioproperties;


    //send message to number
    public String sendsms(Smsrequest smsrequest)
    {
        Twilio.init(twilioproperties.getAccountSid(), twilioproperties.getAuthToken());

        Message message=Message.creator(new PhoneNumber("whatsapp:"+smsrequest.getNumber()),
                                        new PhoneNumber("whatsapp:"+twilioproperties.getFromNumber()),
                                        smsrequest.getMessage()).create();
        return message.getStatus().toString();


    }
}