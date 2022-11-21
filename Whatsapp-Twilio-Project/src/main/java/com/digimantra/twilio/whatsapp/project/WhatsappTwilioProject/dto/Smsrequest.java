package com.digimantra.twilio.whatsapp.project.WhatsappTwilioProject.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Smsrequest {

    private String number;
    private String message;


}