package com.digimantra.twilio.whatsapp.project.WhatsappTwilioProject.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("twilio")
public class TwilioProperties {

    private String accountSid;
    private String authToken;
    private String fromNumber;



}